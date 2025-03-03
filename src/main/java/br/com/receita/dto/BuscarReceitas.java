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
public class BuscarReceitas {
	private Long id;
	private Integer codReceita = new Random().nextInt(1000 + 1) ;
	private String dataReceita = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String nome;	
	private List<Ingredientes>ingredientes;
	private List<EtapaPreparo>etapaPreparo;
	
	public BuscarReceitas(Receita receita) {
		this.id = receita.getId();
		this.codReceita = receita.getCodReceita();
		this.dataReceita = receita.getDataReceita();
		this.nome = receita.getNome();
		this.ingredientes = receita.getIngredientes();
		this.etapaPreparo = receita.getEtapaPreparo();
	}
	
}
