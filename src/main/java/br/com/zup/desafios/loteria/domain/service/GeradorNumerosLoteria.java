package br.com.zup.desafios.loteria.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

@Component
public class GeradorNumerosLoteria {
  
	private Random random = new Random();
	
	private final List<Integer> NUMEROS_FICHA = IntStream.rangeClosed(1, 99)
		    .boxed().collect(Collectors.toList());
	
	public List<Integer> geraNumerosLoteria(){
		
		List<Integer> numerosDisponiveisFicha = new ArrayList<>(NUMEROS_FICHA);
		
		return List.of(
				obterERemoverNumeroDaFicha(numerosDisponiveisFicha),
				
				obterERemoverNumeroDaFicha(numerosDisponiveisFicha),
				
				obterERemoverNumeroDaFicha(numerosDisponiveisFicha),
				
				obterERemoverNumeroDaFicha(numerosDisponiveisFicha),
				
				obterERemoverNumeroDaFicha(numerosDisponiveisFicha),
				
				obterERemoverNumeroDaFicha(numerosDisponiveisFicha)
		);
	}
	
	public Integer obterERemoverNumeroDaFicha(List<Integer> numerosDisponiveisFicha) {
		return numerosDisponiveisFicha.remove(
				random.nextInt(numerosDisponiveisFicha.size())) + 1;
	}
		
}
