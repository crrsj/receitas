package br.com.receita.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.receita.dto.AtualizarReceita;
import br.com.receita.dto.BuscarReceitas;
import br.com.receita.dto.CriarReceita;
import br.com.receita.entidade.Receita;
import br.com.receita.repositorio.ReceitaRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReceitaServico {
	
	private final ReceitaRepositorio receitaRepositorio;
	
	public Receita salvarReceita(CriarReceita criarReceita) {
		var salvar = new Receita(criarReceita);
		return receitaRepositorio.save(salvar);
	}

	public List<BuscarReceitas>buscarReceitas(){
		return receitaRepositorio.findAll().stream().map(BuscarReceitas::new).toList();
	}
	
	public Receita buscarPorId(Long id) {
		Optional<Receita>buscar = receitaRepositorio.findById(id);
		return buscar.orElseThrow();
	}
	
	public BuscarReceitas buscarPorCodigo(Integer codReceita) {
		return receitaRepositorio.findByCodReceita(codReceita);
	}
	
	public List<BuscarReceitas> buscarPorNome(String nome) {
		return receitaRepositorio.findByNome(nome.trim().toUpperCase());
	}
	
	public Receita atualizarReceitas(AtualizarReceita atualizarReceita) {		
		var atualizar = receitaRepositorio.getReferenceById(atualizarReceita.getId());
		atualizar.atualizando(atualizarReceita);
		return atualizar;
		
	}
	
	public void excluirReceita(Long id) {
		buscarPorId(id);
		receitaRepositorio.deleteById(id);
	}
}
