package br.com.receita.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.receita.dto.AtualizarIng;
import br.com.receita.dto.BuscarIngredientes;
import br.com.receita.dto.CadastrarIngredientes;
import br.com.receita.entidade.Ingredientes;
import br.com.receita.repositorio.IngredientesRepositorio;
import br.com.receita.repositorio.ReceitaRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IngredientesServico {

	private final IngredientesRepositorio ingredientesRepositorio;
	private final ReceitaRepositorio receitaRepositorio;
	
	public Ingredientes salvarIngredientes(CadastrarIngredientes cadastrarIngredientes,Long receitaId) {
		var ingredientes = new Ingredientes(cadastrarIngredientes);
		var receita = receitaRepositorio.findById(receitaId).orElseThrow();
		ingredientes.setReceita(receita);
		return ingredientesRepositorio.save(ingredientes);
	}
	
	public List<BuscarIngredientes>buscarIngredientes(){
		return ingredientesRepositorio.findAll().stream().map(BuscarIngredientes::new).toList();
				
   }
	
	public Ingredientes buscarPorId(Long id) {
		Optional<Ingredientes>buscar = ingredientesRepositorio.findById(id);
		return buscar.orElseThrow();
	}
	
	public Ingredientes atualizarIngredientes(AtualizarIng atualizarIng) {
		var atualizar = ingredientesRepositorio.getReferenceById(atualizarIng.getId());
		atualizar.atualizando(atualizarIng);
		return atualizar;
	}
	
	public void excluir(Long id) {
		buscarPorId(id);
		ingredientesRepositorio.deleteById(id);
	}
}