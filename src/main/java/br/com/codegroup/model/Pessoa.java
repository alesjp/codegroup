package br.com.codegroup.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(schema = "desafio", name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Size(min = 1, max = 100)
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "datanascimento")
    private Date dataNascimento;

    @Size(max = 14)
    private String cpf;

    private boolean funcionario;

    @Transient
    private String cargo;
}
