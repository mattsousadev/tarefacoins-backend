package br.mattsousa.domain.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    public Resource createTempFile(byte[] birthCertificate) throws IOException{
        String tempFolder = System.getProperty("java.io.tmpdir");

        File tempFile = new File(tempFolder + "/" + System.currentTimeMillis() + ".pdf");

        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(birthCertificate);
        } catch (IOException e) { throw e; }

        return new UrlResource(tempFile.toURI());
    }
    
}
