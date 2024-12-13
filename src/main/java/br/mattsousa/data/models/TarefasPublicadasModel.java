package br.mattsousa.data.models;

import java.math.BigDecimal;
import java.time.Instant;

import org.springframework.data.annotation.Immutable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity(name = "vw_tarefas_publicadas")
@Immutable
@Data
public class TarefasPublicadasModel {
    
    @Id
    private Integer id;

    @Column
    private String idTarefa;

    @Column
    private String idPub;

    @Column
    private String nomeTarefa;

    @Column
    private String descricaoTarefa;

    @Column
    private BigDecimal recompensaTarefa;

    @Column
    @JsonIgnore
    private String listaRegrasAplicadas;

    @Column
    @JsonFormat(
        shape = Shape.STRING
        , pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
        , timezone = "UTC"
    )
    private Instant dataCriacaoTarefa;

    @Transient
    @JsonFormat(
        shape = Shape.ARRAY
    )
    public String[] regras() {
        if (listaRegrasAplicadas == null) {
            return new String[0];
        }
        return listaRegrasAplicadas.split(",");
    }
}
