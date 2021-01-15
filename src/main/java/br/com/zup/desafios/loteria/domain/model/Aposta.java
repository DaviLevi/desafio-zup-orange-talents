package br.com.zup.desafios.loteria.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;


@Entity
public class Aposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aposta_id")
	private Long id;
	
	private Integer primeiroNumero;
	
	private Integer segundoNumero;
	
	private Integer terceiroNumero;
	
	private Integer quartoNumero;
	
	private Integer quintoNumero;
	
	private Integer sextoNumero;
	
	@CreationTimestamp
	private LocalDateTime dataCriacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "pessoa_id")
	private Pessoa pessoa;
	
	public List<Integer> getNumeros() {
		return List.of(primeiroNumero, segundoNumero, terceiroNumero, 
				quartoNumero, quintoNumero, sextoNumero);
	}
	
	public void setNumeros(List<Integer> numeros) {
		this.primeiroNumero = numeros.get(0);
		this.segundoNumero = numeros.get(1);
		this.terceiroNumero = numeros.get(2);
		this.quartoNumero = numeros.get(3);
		this.quintoNumero = numeros.get(4);
		this.sextoNumero = numeros.get(5);
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
