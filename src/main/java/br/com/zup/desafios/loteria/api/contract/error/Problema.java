package br.com.zup.desafios.loteria.api.contract.error;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Problema {
	
	private Integer status;

	private String tipo = "https://api.loteria.com.br";
	
	private String titulo;
	
	private String detalhe;
	
	private LocalDateTime timestamp;
	
	@JsonProperty("parametros-invalidos")
	private List<ParametroInvalido> parametrosInvalidos;
	
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTipo() {
		return tipo;
	}

	public void expandirTipo(String tipo) {
		this.tipo = this.tipo + tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public List<ParametroInvalido> getParametrosInvalidos() {
		return parametrosInvalidos;
	}

	public void setParametrosInvalidos(List<ParametroInvalido> parametrosInvalidos) {
		this.parametrosInvalidos = parametrosInvalidos;
	}


	public static class ParametroInvalido {
		
		private String nome;
		
		private String razao;

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getRazao() {
			return razao;
		}

		public void setRazao(String razao) {
			this.razao = razao;
		}
	}
}
