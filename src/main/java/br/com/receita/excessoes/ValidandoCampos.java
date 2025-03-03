package br.com.receita.excessoes;

import org.springframework.validation.FieldError;

public record ValidandoCampos(String campo,String mensagem) {
	
	public ValidandoCampos(FieldError erro) {
		this(erro.getField(),erro.getDefaultMessage());
	}

	
}