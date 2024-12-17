package br.mattsousa.data.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "residente")
@Data
@EqualsAndHashCode(callSuper = false)
public class ResidenteModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, length = 16)
    private String telefone;

    @Column(nullable = false, length = 32)
    private String senha;

    @Column(nullable = false)
    private BigDecimal saldo;

    @Column(nullable = false)
    private Boolean ativo;
}
