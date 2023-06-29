package br.com.dimensacrud.inteface;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dimensacrud.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

	Contato findByIdContato(Long idContato);
	
	

}

