package br.com.dimensacrud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.dimensacrud.dto.ContatoDTO;

@Service
@Transactional
public interface ContatoService {

	ContatoDTO save(ContatoDTO contatoDTO);

	List<ContatoDTO> findAll();

	Optional<ContatoDTO> findById(Long idContato);

	void delete(Long idContato);

	ContatoDTO update(ContatoDTO contatoDTO, Long idContato);

	ContatoDTO updateTelefone(Long idContato, String telefone);

}
