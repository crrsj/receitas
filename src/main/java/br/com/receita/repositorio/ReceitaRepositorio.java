package br.com.receita.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.receita.dto.BuscarReceitas;
import br.com.receita.entidade.Receita;

public interface ReceitaRepositorio extends JpaRepository<Receita, Long>{

	BuscarReceitas findByCodReceita(Integer codReceita);

	@Query(value = "select r from Receita r where upper(trim(r.nome)) like %?1% ")
	List<BuscarReceitas> findByNome(String upperCase);

}
