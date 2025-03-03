package br.com.receita.entidade;



import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.receita.dto.AtualizarIng;
import br.com.receita.dto.CadastrarIngredientes;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_ingredientes")
@Data
@NoArgsConstructor
public class Ingredientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String quantidade;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "receita_id")
	private Receita receita;


	public Ingredientes(CadastrarIngredientes cadastrarIngredientes) {
		this.nome = cadastrarIngredientes.getNome();
		this.quantidade = cadastrarIngredientes.getQuantidade();
		this.receita = cadastrarIngredientes.getReceita();
	}


	public void atualizando(AtualizarIng atualizarIng) {
		if(atualizarIng.getNome() != null) {
			this.nome = atualizarIng.getNome();
		}
		
		if(atualizarIng.getQuantidade() != null) {
			this.quantidade = atualizarIng.getQuantidade();
		}
		
	}
}
