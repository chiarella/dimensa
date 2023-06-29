package br.com.dimensacrud.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class EnderecoDTO implements Serializable{
	
	private static final long serialVersionUID = 6663093986260788562L;
	
	private Long idEndereco;
	private String rua;
	private Long numero;
	private Long cep;
	
	

}
