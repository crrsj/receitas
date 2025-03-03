package br.com.receita.dto;

import br.com.receita.entidade.Ingredientes;
import br.com.receita.entidade.Receita;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class BuscarIngredientes {

	private Long id;
	private String nome;
	private String quantidade;	
	private Receita receita;
	
	public BuscarIngredientes(Ingredientes ingredientes) {
		this.id = ingredientes.getId();
		this.nome = ingredientes.getNome();
		this.quantidade = ingredientes.getQuantidade();
		this.receita = ingredientes.getReceita();
	}
}
