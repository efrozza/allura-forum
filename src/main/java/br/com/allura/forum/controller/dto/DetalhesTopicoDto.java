package br.com.allura.forum.controller.dto;

import java.time.LocalDateTime;

import br.com.allura.forum.modelo.StatusTopico;

public class DetalhesTopicoDto {
	
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String nomeAutor;
	private StatusTopico status;
	
	

}
