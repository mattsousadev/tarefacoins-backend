package br.mattsousa.data.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = false)
public class UsersModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private Boolean isActive = true;

    @Column(nullable = false)
    private Integer serialNumber;

    @Column(nullable = false)
    private LocalDate birthDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_files", referencedColumnName = "id")
    @JsonIgnore
    private FilesModel birthCertificate;
}
