package br.mattsousa.data.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tarefa")
@Data
@EqualsAndHashCode(callSuper = false)
public class TarefaModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false, length = 128)
    private String nome;

    @Column(nullable = false, length = 256)
    private String descricao;

    @Column(nullable = false)
    private Boolean ativo;

}
