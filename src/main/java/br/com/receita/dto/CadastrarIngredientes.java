package br.com.receita.dto;

import br.com.receita.entidade.Ingredientes;
import br.com.receita.entidade.Receita;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CadastrarIngredientes {

	
	
	private String nome;
	private String quantidade;
	private Receita receita;
	
	public CadastrarIngredientes(Ingredientes salvar) {
		this.nome = salvar.getNome();
		this.quantidade = salvar.getQuantidade();
		this.receita = salvar.getReceita();
	}
}
