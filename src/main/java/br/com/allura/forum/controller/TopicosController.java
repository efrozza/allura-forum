package br.com.allura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.allura.forum.controller.dto.TopicoDto;
import br.com.allura.forum.modelo.Curso;
import br.com.allura.forum.modelo.Topico;

@RestController
public class TopicosController {
	
	@RequestMapping("/topicos")
	// o eclipse uma o jackson que converte retorno em json automaticamente
	public List <TopicoDto> lista() {
		
		Topico topico = new Topico("dúvida", "conteudo da dúvida spring", new Curso("Curso Spring", "Programação"));
		//Array.asList devolve um array fixo como um List do tipo que está sendo passado ao array
		return TopicoDto.converter(Arrays.asList(topico, topico, topico));
		
	}

}
