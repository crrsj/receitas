package br.com.receita.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.receita.entidade.EtapaPreparo;

public interface EtapaPreparoRepositorio extends JpaRepository<EtapaPreparo, Long> {

}
