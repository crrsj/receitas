package br.com.receita.dto;

import br.com.receita.entidade.Ingredientes;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtualizarIng {
	
	private Long id;
	private String nome;
	private String quantidade;
	
	public AtualizarIng(Ingredientes atualizar) {
		this.id = atualizar.getId();
		this.nome = atualizar.getNome();
		this.quantidade = atualizar.getQuantidade();
	}
}
