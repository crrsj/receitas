package br.com.receita.dto;

import br.com.receita.entidade.EtapaPreparo;
import br.com.receita.entidade.Receita;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class AtualizarEtapa {
	
	
	private Long id;
	private Integer ordem;	
	@NotBlank(message = "não pode estar em branco")
	private String descricao;
	private Receita receita;

	public AtualizarEtapa(EtapaPreparo atualizar) {
		this.id = atualizar.getId();
		this.ordem = atualizar.getOrdem();
		this.descricao = atualizar.getDescricao();
		this.receita = atualizar.getReceita();
	}
}
