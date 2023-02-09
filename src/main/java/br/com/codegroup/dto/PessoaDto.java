package br.com.codegroup.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PessoaDto {
    private Long id;

    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    private String cpf;

    private boolean funcionario;

    private String cargo;
}
