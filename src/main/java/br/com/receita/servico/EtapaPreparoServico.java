package br.com.receita.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.receita.dto.AtualizarEtapa;
import br.com.receita.dto.BuscarEtapaPreparo;
import br.com.receita.dto.CriarEtapa;
import br.com.receita.entidade.EtapaPreparo;
import br.com.receita.repositorio.EtapaPreparoRepositorio;
import br.com.receita.repositorio.ReceitaRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EtapaPreparoServico {
	
	private final EtapaPreparoRepositorio etapaPreparoRepositorio;
	private final ReceitaRepositorio receitaRepositorio;
	
	public EtapaPreparo salvarEtapa(CriarEtapa criarEtapa,Long receitaId) {
		var etapa = new EtapaPreparo(criarEtapa);		
		var receita = receitaRepositorio.findById(receitaId).orElseThrow();
		etapa.setReceita(receita);
		return etapaPreparoRepositorio.save(etapa);
	}
	
	public List<BuscarEtapaPreparo> buscarEtapas() {
		return etapaPreparoRepositorio.findAll().stream().map(BuscarEtapaPreparo::new).toList();
	}

	public EtapaPreparo buscarPorId(Long id) {
		Optional<EtapaPreparo>buscar = etapaPreparoRepositorio.findById(id);
		return buscar.orElseThrow();
	}
	
	public EtapaPreparo atualizarEtapa(AtualizarEtapa atualizarEtapa) {
		var atualizar = etapaPreparoRepositorio.getReferenceById(atualizarEtapa.getId());
		atualizar.atualizando(atualizarEtapa);
		return etapaPreparoRepositorio.save(atualizar);
	}
	
	public void excluirEtapa(Long id) {
		buscarPorId(id);
		etapaPreparoRepositorio.deleteById(id);
	}
}
