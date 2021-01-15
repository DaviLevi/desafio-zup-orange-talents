package br.com.zup.desafios.loteria.api.contract.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zup.desafios.loteria.domain.model.Pessoa;

public class GeracaoNumerosInput {

	@Email
	@NotBlank
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Pessoa toModel() {
		Pessoa model = new Pessoa();
		model.setEmail(email);
		return model;
	}
	
}
