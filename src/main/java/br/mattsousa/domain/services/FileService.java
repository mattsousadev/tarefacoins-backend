package br.mattsousa.domain.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.mattsousa.data.models.FilesModel;
import br.mattsousa.data.repository.FilesRepository;

@Service
public class FileService {

    @Autowired
    private FilesRepository filesRepository;

    public Resource createTempFile(FilesModel fileModel) throws IOException {
        byte[] birthCertificate = fileModel.getContent();
        String tempFolder = System.getProperty("java.io.tmpdir");
        String separator = System.getProperty("file.separator");
        String tempPath = String.join(separator, tempFolder, fileModel.getFilename());

        File tempFile = new File(tempPath);

        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(birthCertificate);
        } catch (IOException e) { throw e; }

        return new UrlResource(tempFile.toURI());
    }

    public FilesModel createFile(MultipartFile file) throws IOException {
        FilesModel output = new FilesModel();
        byte[] fileBytes = file.getBytes();
        output.setFilename(file.getOriginalFilename());
        output.setSizeBytes(file.getSize());
        output.setContent(fileBytes);
        filesRepository.save(output);
        return output;
    }
    
}
