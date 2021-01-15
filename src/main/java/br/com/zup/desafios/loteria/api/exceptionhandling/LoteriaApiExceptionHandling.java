package br.com.zup.desafios.loteria.api.exceptionhandling;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import br.com.zup.desafios.loteria.api.contract.error.Problema;
import br.com.zup.desafios.loteria.api.contract.error.Problema.ParametroInvalido;

@ControllerAdvice
public class LoteriaApiExceptionHandling {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exc, WebRequest request){
		
		Problema problema = new Problema();
		problema.expandirTipo("/dados-incorretos");
		problema.setTitulo("Dados incorretos");
		problema.setDetalhe("Um ou mais parametros no corpo da requisicao estao invalidos. Por favor, corrija e envie novamente");
		problema.setStatus(400);
		problema.setTimestamp(LocalDateTime.now());
		
		List<ParametroInvalido> parametrosInvalidos = exc.getFieldErrors().stream()
				.map(fe -> {
					ParametroInvalido pi = new ParametroInvalido();
					pi.setNome(fe.getField());
					pi.setRazao(fe.getDefaultMessage());
					return pi;
				}).collect(Collectors.toList());
		
		problema.setParametrosInvalidos(parametrosInvalidos);
		
		return ResponseEntity.badRequest().body(problema);
	}
}
