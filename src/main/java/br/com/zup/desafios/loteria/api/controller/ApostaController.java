package br.com.zup.desafios.loteria.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.desafios.loteria.api.contract.input.GeracaoNumerosInput;
import br.com.zup.desafios.loteria.api.contract.model.ApostaModel;
import br.com.zup.desafios.loteria.domain.model.Aposta;
import br.com.zup.desafios.loteria.domain.model.Pessoa;
import br.com.zup.desafios.loteria.domain.service.ApostaService;

@RestController
@RequestMapping("/api/apostas")
public class ApostaController {

	
	@Autowired
	private ApostaService apostaServico;
	
	@GetMapping
	public List<ApostaModel> listar(){
		return apostaServico.listar().stream()
				.map(p -> new ApostaModel(p)).collect(Collectors.toList());
	}
	
	@GetMapping("/filtro")
	public List<ApostaModel> listarFiltrandoEmail(String email){
		return apostaServico.listarFiltrandoEmail(email).stream()
				.map(p -> new ApostaModel(p)).collect(Collectors.toList());
	}
	
	@PostMapping
	public ApostaModel geraNumeros(@RequestBody @Valid GeracaoNumerosInput input){
		Pessoa pessoa = input.toModel();
		Aposta apostaGerada = apostaServico.gerarApostaPara(pessoa);
		return new ApostaModel(apostaGerada);
	}
	
}
