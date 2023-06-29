package br.com.dimensacrud.mapper;

import java.util.List;
import java.util.Optional;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.dimensacrud.dto.ContatoDTO;
import br.com.dimensacrud.entity.Contato;

@Mapper
public abstract class ContatoMapper {
	
	
	public static final ContatoMapper INSTANCE = Mappers.getMapper(ContatoMapper.class);


	@Mapping(target = "idContato", ignore = true)
	@Mapping(target = "enderecos", ignore = true)
	public abstract Contato dtoDoDomains(ContatoDTO contatoDTO);
	
	@AfterMapping
	public void bindEndereco(ContatoDTO dto, @MappingTarget Contato domain) {		
		if(dto != null && dto.getEnderecos() != null && domain != null) {
			domain.setEnderecos(EnderecoMapper.INSTANCE.listDtoToListDomain(dto.getEnderecos(),domain));
		}
	}
	
	protected abstract List<Contato> listDtoToListDomain(List<ContatoDTO> listaEndereco);

	public abstract ContatoDTO domainToDto(Contato optional);
	
	public abstract List<ContatoDTO> listDomainToListDto(List<Contato> findAll);

	public abstract Object domainToDto(Optional<Contato> findById);

}
