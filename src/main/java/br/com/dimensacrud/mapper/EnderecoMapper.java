package br.com.dimensacrud.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.dimensacrud.dto.EnderecoDTO;
import br.com.dimensacrud.entity.Contato;
import br.com.dimensacrud.entity.Endereco;

@Mapper
public abstract class EnderecoMapper {
	
	public static final EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);
	
	@Mapping(target = "contato", ignore = true)
	@Mapping(target = "idEndereco", ignore = true)
	protected abstract Endereco dtoToDomain(EnderecoDTO dto, Contato domain);
	
	@AfterMapping
	public void bindCliente(EnderecoDTO enderecoDTO,Contato contato, @MappingTarget Endereco endereco) {		
		if(endereco != null && contato != null && enderecoDTO != null) {
			endereco.setContato(contato);
			
		}
	}

	@Mapping(target = "idEndereco", ignore = true)
	public List<Endereco> listDtoToListDomain(List<EnderecoDTO> listDTO, Contato domain) {
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		if(listDTO != null && domain != null) {
			listaEndereco = listDTO.stream().map(dto -> EnderecoMapper.INSTANCE.dtoToDomain(dto, domain)).collect(Collectors.toList());
		}
		return listaEndereco;
	}
	

}
