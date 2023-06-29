package br.com.dimensacrud.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dimensacrud.dto.ContatoDTO;
import br.com.dimensacrud.entity.Contato;
import br.com.dimensacrud.inteface.ContatoRepository;
import br.com.dimensacrud.mapper.ContatoMapper;
import br.com.dimensacrud.service.ContatoService;

@Service
@Transactional
public class ContatoServiceImpl implements ContatoService{
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Override
	public ContatoDTO save(ContatoDTO contatoDTO) {
	Contato c =  contatoRepository.save(ContatoMapper.INSTANCE.dtoDoDomains(contatoDTO));
	ContatoDTO contato = ContatoMapper.INSTANCE.domainToDto(c);
	return contato;
	}
	
	@Override
	public List<ContatoDTO> findAll() {
	return ContatoMapper.INSTANCE.listDomainToListDto(contatoRepository.findAll());
	}

	@Override
	public Optional<ContatoDTO> findById(Long idContato) {
	return Optional.ofNullable(ContatoMapper.INSTANCE.domainToDto(contatoRepository.findByIdContato(idContato)));
	}

	@Override
	public void delete(Long idContato) {
		contatoRepository.deleteById(idContato);
	}

	@Override
	public ContatoDTO update(ContatoDTO contatoDTO, Long idContato) {
		ContatoDTO dtoSave = null;
		Contato c = contatoRepository.findByIdContato(idContato);
		c.setNomeContato(contatoDTO.getNomeContato());
		c.setTelefone(contatoDTO.getTelefone());
		c.setEmail(contatoDTO.getEmail());
		c.setDtNascimento(contatoDTO.getDtNascimento());
		dtoSave = ContatoMapper.INSTANCE.domainToDto(c);
	return dtoSave;
	}
	

	@Override
	public ContatoDTO updateTelefone(Long idContato, String telefone) {
		Contato c = contatoRepository.findByIdContato(idContato);
		c.setTelefone(telefone);
		c =  contatoRepository.save(c);
	return ContatoMapper.INSTANCE.domainToDto(c);
	}

}
