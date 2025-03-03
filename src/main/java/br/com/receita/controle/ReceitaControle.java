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

import br.com.receita.dto.AtualizarReceita;
import br.com.receita.dto.BuscarReceitas;
import br.com.receita.dto.CriarReceita;
import br.com.receita.servico.ReceitaServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/receita")
@RequiredArgsConstructor
public class ReceitaControle {

	private final ReceitaServico receitaServico;
	
	
	@PostMapping
	@Operation(summary = "Endpoint responsável por cadastrar receita.")
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
	public ResponseEntity<CriarReceita>salvarReceita(@RequestBody @Valid CriarReceita criarReceita){
		var salvar = receitaServico.salvarReceita(criarReceita);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(salvar.getId()).toUri();
		return ResponseEntity.created(uri).body(new CriarReceita(salvar));
	}
	
	
	@GetMapping
	@Operation(summary = "Endpoint responsável por buscar todas as receitas.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
	public ResponseEntity<List<BuscarReceitas>>buscarReceitas(){
		var listar = receitaServico.buscarReceitas();
		return ResponseEntity.ok().body(listar);
	}
	
	
	@GetMapping("/{id}")
	@Operation(summary = "Endpoint responsável por buscar receita pelo id.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
	
	public ResponseEntity<BuscarReceitas>buscarPorId(@PathVariable Long id){
		var buscar = receitaServico.buscarPorId(id);
		return ResponseEntity.ok().body(new BuscarReceitas(buscar));
	}
	
	
	@GetMapping("/buscarCodigo")
	 @Operation(summary = "Endpoint responsável por buscar receitas pelo código.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
	public ResponseEntity<BuscarReceitas>buscarPorCodigo(@PathParam("codReceita") Integer codReceita){
		var buscarReceita = receitaServico.buscarPorCodigo(codReceita);
		return ResponseEntity.ok().body(buscarReceita);
	}
	
	@PutMapping
	@Operation(summary = "Endpoint responsável por atualizar receitas.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
	public ResponseEntity<AtualizarReceita>atualizarReceitas(@RequestBody @Valid AtualizarReceita atualizarReceita){
		var atualizar = receitaServico.atualizarReceitas(atualizarReceita);
		return ResponseEntity.ok().body(new AtualizarReceita(atualizar));
	}
	
	
	
	@GetMapping("/buscarNome")
	@Operation(summary = "Endpoint responsável por buscar receitas pelo nome.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
	public ResponseEntity<List<BuscarReceitas>>buscarPorNome(@PathParam( "nome")  String nome){
		var buscarNome = receitaServico.buscarPorNome(nome);
		return ResponseEntity.ok().body(buscarNome);
		
	}
	
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Endpoint responsável por excluir receitas.")
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
	public ResponseEntity<Void>excluirReceita(@PathVariable Long id){
		receitaServico.excluirReceita(id);
		return ResponseEntity.noContent().build();
	}
}
