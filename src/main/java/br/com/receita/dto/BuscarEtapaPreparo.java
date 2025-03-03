package br.com.receita.dto;

import br.com.receita.entidade.EtapaPreparo;
import br.com.receita.entidade.Receita;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BuscarEtapaPreparo {

	private Long id;
	private Integer ordem;	
	private String descricao;
	private Receita receita;
	
	public BuscarEtapaPreparo(EtapaPreparo etapa) {
		this.id = etapa.getId();
		this.ordem = etapa.getOrdem();
		this.descricao = etapa.getDescricao();
		this.receita = etapa.getReceita();
	}
	
}
