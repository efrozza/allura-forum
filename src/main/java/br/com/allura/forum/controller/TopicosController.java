package br.com.allura.forum.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.allura.forum.controller.dto.DetalhesTopicoDto;
import br.com.allura.forum.controller.dto.TopicoDto;
import br.com.allura.forum.controller.form.TopicoForm;
import br.com.allura.forum.modelo.Topico;
import br.com.allura.forum.repository.CursoRepository;
import br.com.allura.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;

	// o eclipse uma o jackson que converte retorno em json automaticamente
	@GetMapping
	public List<TopicoDto> lista(String nomeCurso) {

		if (nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);
		} else {
			List<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso);
			return TopicoDto.converter(topicos);
		}

	}
	
	//@Valid chama as validações que foram anotadas no TopicoForm
	//@RequestBody informa que os dados vem no corpo da requisição
	//o springBoot usa o Jackson para converter

	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
	
	//entre chaves define dinamicidade
	//@PathVariable define que eh um pathParam que vira diretamente na url
	@GetMapping("/{id}")
	public DetalhesTopicoDto detalhar(@PathVariable Long id) {
		
		Topico topico = topicoRepository.getOne(id);
		return new DetalhesTopicoDto();
		
	}

}
