package br.com.codegroup.dto;

import br.com.codegroup.model.Pessoa;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProjetoDto {
    private Long id;

    private String nome;

    private Date dataInicio;

    private Date dataPrevisaoFim;

    private Date dataFim;

    private String descricao;

    private String status;

    private BigDecimal orcamento;

    private String risco;

    private Pessoa gerente;
}
