package br.com.zup.desafios.loteria.api.contract.model;

import br.com.zup.desafios.loteria.domain.model.Pessoa;

public class PessoaModel {

	private String email;

	public PessoaModel(Pessoa pessoa) {
		this.email = pessoa.getEmail();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
