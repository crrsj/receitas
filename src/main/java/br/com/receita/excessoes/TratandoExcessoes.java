package br.com.receita.excessoes;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.receita.dto.MensagemDeErro;

@ControllerAdvice
public class TratandoExcessoes {
	
	@ExceptionHandler(NoSuchElementException.class )
	public ResponseEntity<MensagemDeErro>objetoNãoEncontr(){
		var erros = new MensagemDeErro(HttpStatus.BAD_REQUEST, "Não foi possível; exeultar a ação desejada !");
		return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<?>ValidarCampos(MethodArgumentNotValidException ex){
		var erros = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(ValidandoCampos::new).toList());
	}
}
