package br.com.receita.controle;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.receita.dto.AtualizarIng;
import br.com.receita.dto.BuscarIngredientes;
import br.com.receita.dto.CadastrarIngredientes;
import br.com.receita.servico.IngredientesServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ingredientes")
@RequiredArgsConstructor
public class IngredientesControle {
	
	private final IngredientesServico ingredientesServico;

	@PostMapping("/{receitaId}")
	@Operation(summary = "Endpoint responsável por cadastrar ingrediente pelo id da receita.")
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
	public ResponseEntity<CadastrarIngredientes>salvarIngredientes(@RequestBody @Valid CadastrarIngredientes cadastrarIngredientes,
			                                                       @PathVariable Long receitaId){
		var salvar = ingredientesServico.salvarIngredientes(cadastrarIngredientes, receitaId);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(salvar.getId()).toUri();
		return ResponseEntity.created(uri).body(new CadastrarIngredientes(salvar));
	}
	
	@GetMapping
	@Operation(summary = "Endpoint responsável por buscar Todas os ingredientes.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
	public ResponseEntity<List<BuscarIngredientes>>buscarIngredientes(){
		var listar = ingredientesServico.buscarIngredientes();
		return ResponseEntity.ok().body(listar);
	}
	
	
	@GetMapping("{id}")
	@Operation(summary = "Endpoint responsável por buscar ingrediente pelo id.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
	public ResponseEntity<BuscarIngredientes>buscarPorId(@PathVariable Long id){
		var buscar = ingredientesServico.buscarPorId(id);
		return ResponseEntity.ok().body(new BuscarIngredientes(buscar));
	}
	
	@PutMapping
	@Operation(summary = "Endpoint responsável por atualizar os ingredientes.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
	public ResponseEntity<AtualizarIng>atualizaqrIngredientes(@RequestBody @Valid AtualizarIng atualizarIng){
		var atualizar = ingredientesServico.atualizarIngredientes(atualizarIng);
		return ResponseEntity.ok().body(new AtualizarIng(atualizar));
	}
	
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Endpoint responsável por excluir ingredientes pelo id.")
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
	public ResponseEntity<Void>excluirIngrediente(@PathVariable Long id){
	    ingredientesServico.excluir(id);
	    return ResponseEntity.noContent().build();
	}
}
