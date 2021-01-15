package br.com.zup.desafios.loteria.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.desafios.loteria.domain.model.Aposta;
import br.com.zup.desafios.loteria.domain.model.Pessoa;
import br.com.zup.desafios.loteria.domain.repository.ApostaRepository;
import br.com.zup.desafios.loteria.domain.repository.PessoaRepository;

@Service
public class ApostaService {

	@Autowired
	private ApostaRepository apostaRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private GeradorNumerosLoteria gerador;
	
	public List<Aposta> listar(){
		return apostaRepository.findAll();
	}
	
	public List<Aposta> listarFiltrandoEmail(String email){
		return apostaRepository.listarFiltradoPorEmailOrdenadoPorDataCriacao(email);
	}
	
	public Aposta gerarApostaPara(Pessoa pessoa) {
		
		Pessoa pessoaBuscada = pessoaRepository.findByEmail(pessoa.getEmail())
				.orElseGet(() -> pessoaRepository.save(pessoa));
		
		Aposta aposta = new Aposta();
		
		aposta.setPessoa(pessoaBuscada);
		
		List<Integer> numerosGerados = gerador.geraNumerosLoteria();
		
		List<Aposta> apostasAnteriores = pessoaBuscada.getApostas();
		
		while(isCombinacaoRepetida(apostasAnteriores, numerosGerados)) {
			numerosGerados = gerador.geraNumerosLoteria();
		}
		
		aposta.setNumeros(numerosGerados);
		
		return apostaRepository.save(aposta);
	}
	
	private boolean isCombinacaoRepetida(List<Aposta> apostasAnteriores, List<Integer> numeros) {
		for(Aposta aposta : apostasAnteriores) {
			List<Integer> numerosAposta = aposta.getNumeros();
			int numerosIguais = 0;
			for(Integer numero : numeros) {
				if(numerosAposta.contains(numero)) numerosIguais++;
			}
			if(numerosIguais == 6) return true;
		}
		return false;
	}
}
