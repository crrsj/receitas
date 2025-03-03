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

import br.com.receita.dto.AtualizarEtapa;
import br.com.receita.dto.BuscarEtapaPreparo;
import br.com.receita.dto.CriarEtapa;
import br.com.receita.servico.EtapaPreparoServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/etapa")
@RequiredArgsConstructor
public class EtapaPreparo {

	
	private final EtapaPreparoServico etapaPreparoServico;
	
	
	@PostMapping("/{receitaId}")
	@Operation(summary = "Endpoint responsável por cadastrar etapa pelo id da receita.")
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
	public ResponseEntity<CriarEtapa>salvarEtapa(@RequestBody @Valid CriarEtapa criarEtapa,@PathVariable Long receitaId){
		var salvar = etapaPreparoServico.salvarEtapa(criarEtapa, receitaId);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(salvar.getId()).toUri();
		return ResponseEntity.created(uri).body(new CriarEtapa(salvar));
	}
	
	
	@GetMapping
	@Operation(summary = "Endpoint responsável por buscar todas as etapas.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
	public ResponseEntity<List<BuscarEtapaPreparo>>buscarEtapas(){
		var listar = etapaPreparoServico.buscarEtapas();
		return ResponseEntity.ok().body(listar);
	}
	
	
	@GetMapping("/{id}")
	@Operation(summary = "Endpoint responsável por buscar etapa pelo id")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
	public ResponseEntity<BuscarEtapaPreparo>buscarPorId(@PathVariable Long id){
		var buscar = etapaPreparoServico.buscarPorId(id);
		return ResponseEntity.ok().body(new BuscarEtapaPreparo(buscar));
	}
	
	
	@PutMapping
	@Operation(summary = "Endpoint responsável por atualizar etapas.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
	public ResponseEntity<AtualizarEtapa>atualizarEtapas(@RequestBody @Valid AtualizarEtapa atualizarEtapa){
		var atualizar = etapaPreparoServico.atualizarEtapa(atualizarEtapa);
		return ResponseEntity.ok().body(new AtualizarEtapa(atualizar));
	}
	
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Endpoint responsável por excluir etapas.")
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
	public ResponseEntity<Void>excluirEtapa(@PathVariable Long id){
		etapaPreparoServico.excluirEtapa(id);
		return ResponseEntity.noContent().build();
	}
			                                              
}
