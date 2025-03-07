package br.mattsousa.data.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "regra")
@Data
@EqualsAndHashCode(callSuper = false)
public class RegraModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, length = 128)
    private String nome;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idRegra")
    private Set<RegraAplicadaModel> aplicacoesRegra;
}
