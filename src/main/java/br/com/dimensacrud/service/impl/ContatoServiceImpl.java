package br.com.dimensacrud.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.dimensacrud.dto.ContatoDTO;
import br.com.dimensacrud.entity.Contato;
import br.com.dimensacrud.inteface.ContatoRepository;
import br.com.dimensacrud.mapper.ContatoMapper;
import br.com.dimensacrud.service.ContatoService;

@Service
@Transactional
public class ContatoServiceImpl implements ContatoService{
	
	
	private final ContatoRepository contatoRepository;
	private final ContatoMapper contatoMapper;

	public ContatoServiceImpl(ContatoRepository contatoRepository, ContatoMapper contatoMapper) {
        this.contatoRepository = contatoRepository;
        this.contatoMapper = contatoMapper;
    }
	
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
		Contato contato = contatoRepository.findById(idContato)
                .orElseThrow(() -> new NoSuchElementException("Contato não encontrado"));
        contatoMapper.updateContatoFromDTO(contatoDTO, contato);
        contatoRepository.save(contato);
    return ContatoMapper.INSTANCE.domainToDto(contato);
    }
	
	@Override
	public ContatoDTO updateTelefone(Long idContato, String telefone) {
		Contato contato = contatoRepository.findById(idContato)
                .orElseThrow(() -> new NoSuchElementException("Contato não encontrado"));
		contato.setTelefone(telefone);
        //contatoMapper.update ContatoFromDTO(contatoDTO, contato);		contato.setTelefone(telefone);
		contato = contatoRepository.save(contato);
	return ContatoMapper.INSTANCE.domainToDto(contato);
	}

}
