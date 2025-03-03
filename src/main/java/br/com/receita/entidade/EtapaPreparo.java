package br.com.receita.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.receita.dto.AtualizarEtapa;
import br.com.receita.dto.CriarEtapa;
import jakarta.persistence.Column;
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
@Table(name = "tb_etapas")
@Data
@NoArgsConstructor
public class EtapaPreparo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private Integer ordem;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	@ManyToOne
	@JoinColumn(name = "receita_id")
	@JsonIgnore
	private Receita receita;

	public EtapaPreparo(CriarEtapa criarEtapa) {
		this.ordem = criarEtapa.getOrdem();
		this.descricao = criarEtapa.getDescricao();
		this.receita = criarEtapa.getReceita();
	}

	public void atualizando(AtualizarEtapa atualizarEtapa) {
		if(atualizarEtapa.getOrdem() != null) {
			this.ordem = atualizarEtapa.getOrdem();
		}
		if(this.getDescricao()!= null) {
			this.descricao = atualizarEtapa.getDescricao();
		}
		
				
		
	}
}
