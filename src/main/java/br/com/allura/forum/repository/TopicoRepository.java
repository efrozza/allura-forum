package br.com.allura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	//O metodo vai filtrar ele atrivuto nome do Atributo Curso na entidade Topico
	List<Topico> findByCurso_Nome(String nomeCurso);

}
