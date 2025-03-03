package br.com.receita.dto;

import br.com.receita.entidade.Receita;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtualizarReceita {

	Long id;
	String nome;
	

	public AtualizarReceita(Receita atualizar) {
		this.id = atualizar.getId();
		this.nome = atualizar.getNome();
	}
}
