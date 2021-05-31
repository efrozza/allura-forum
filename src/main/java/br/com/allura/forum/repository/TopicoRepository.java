package br.com.allura.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
