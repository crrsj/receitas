package br.com.receita.dto;

import br.com.receita.entidade.EtapaPreparo;
import br.com.receita.entidade.Receita;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CriarEtapa {
	
	
	private Integer ordem;	
	@NotBlank(message = "não pode estar em branco")
	private String descricao;
	private Receita receita;

	
	public CriarEtapa(EtapaPreparo salvar) {
		this.ordem = salvar.getOrdem();
		this.descricao = salvar.getDescricao();
		this.receita = salvar.getReceita();
	}
}
