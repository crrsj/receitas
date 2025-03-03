package br.com.receita.entidade;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.receita.dto.AtualizarReceita;
import br.com.receita.dto.CriarReceita;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_receitas")
@Data
@NoArgsConstructor
public class Receita {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer codReceita = new Random().nextInt(1000 + 1) ;
	private String dataReceita = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String nome;
	@JsonIgnore
	@OneToMany(mappedBy = "receita",cascade = CascadeType.ALL,orphanRemoval = true)	
	private List<Ingredientes>ingredientes;
	@OneToMany(mappedBy = "receita",cascade = CascadeType.ALL,orphanRemoval = true)	
	private List<EtapaPreparo>etapaPreparo;

	public Receita(CriarReceita criarReceita) {
		this.codReceita = criarReceita.getCodReceita();
		this.dataReceita = criarReceita.getDataReceita();
		this.nome = criarReceita.getNome();
		this.ingredientes = criarReceita.getIngredientes();
		this.etapaPreparo = criarReceita.getEtapaPreparo();
	}

	public void atualizando(AtualizarReceita atualizarReceita) {
		if(atualizarReceita.getNome() != null) {
			this.nome = atualizarReceita.getNome();
		}
		
	}

	
}
