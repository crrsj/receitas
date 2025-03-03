package br.com.receita.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.receita.entidade.Ingredientes;

public interface IngredientesRepositorio extends JpaRepository<Ingredientes, Long> {

}
