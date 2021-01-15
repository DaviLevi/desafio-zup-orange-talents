package br.com.zup.desafios.loteria.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.desafios.loteria.api.contract.model.PessoaModel;
import br.com.zup.desafios.loteria.domain.repository.PessoaRepository;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<PessoaModel> listar(){
		return pessoaRepository.findAll().stream()
				.map(p -> new PessoaModel(p)).collect(Collectors.toList());
	}
	
}
