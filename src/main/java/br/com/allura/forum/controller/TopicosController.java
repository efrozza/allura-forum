package br.com.allura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.allura.forum.controller.dto.TopicoDto;
import br.com.allura.forum.modelo.Curso;
import br.com.allura.forum.modelo.Topico;
import br.com.allura.forum.repository.TopicoRepository;

@RestController
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@RequestMapping("/topicos")
	// o eclipse uma o jackson que converte retorno em json automaticamente
	public List <TopicoDto> lista() {
		
		List<Topico> topicos = topicoRepository.findAll();		
		return TopicoDto.converter(topicos);
		
	}

}
