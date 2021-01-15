package br.com.zup.desafios.loteria.api.contract.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.zup.desafios.loteria.domain.model.Aposta;

@JsonInclude(value = Include.NON_NULL)
public class ApostaModel {

	private List<Integer> numeros;

	private LocalDateTime dataCriacao;
	
	public ApostaModel(Aposta aposta) {
		this.numeros = aposta.getNumeros();
		this.dataCriacao = aposta.getDataCriacao();
	}
	
	public List<Integer> getNumeros() {
		return numeros;
	}
	
	public LocalDateTime getDataCriacao() {
		return this.dataCriacao;
	}
}
