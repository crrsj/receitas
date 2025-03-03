package br.com.receita.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import br.com.receita.entidade.EtapaPreparo;
import br.com.receita.entidade.Ingredientes;
import br.com.receita.entidade.Receita;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CriarReceita {	
	
	private Integer codReceita = new Random().nextInt(1000 + 1) ;
	private String dataReceita = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String nome;	
	private List<Ingredientes>ingredientes;	
	private List<EtapaPreparo>etapaPreparo;
	
	public CriarReceita(Receita salvar) {
		this.codReceita = salvar.getCodReceita();
		this.dataReceita = salvar.getDataReceita();
		this.nome = salvar.getNome();
		this.ingredientes = salvar.getIngredientes();
		this.etapaPreparo = salvar.getEtapaPreparo();
	}
}
