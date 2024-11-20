package br.mattsousa.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "files")
@Data
@EqualsAndHashCode(callSuper = false)
public class FilesModel extends BaseEntity {
    

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private Long sizeBytes;

    @Column
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @JsonIgnore
    private byte[] content;
}
