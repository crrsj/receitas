package br.com.receita.dto;

import br.com.receita.entidade.EtapaPreparo;
import br.com.receita.entidade.Receita;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CriarEtapa {
	
	
	private Integer ordem;	
	private String descricao;
	private Receita receita;

	
	public CriarEtapa(EtapaPreparo salvar) {
		this.ordem = salvar.getOrdem();
		this.descricao = salvar.getDescricao();
		this.receita = salvar.getReceita();
	}
}
