package br.com.dimensacrud.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_endereco")
public class Endereco implements Serializable {


	private static final long serialVersionUID = 2568589063809783116L;

	@Id
	@Column(name = "id_endereco")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEndereco;

	@Column(name = "rua")
	private String rua;

	@Column(name = "numero")
	private Long numero;

	@Column(name = "cep")
	private Long cep;

	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "id_contato")
	private Contato contato;

}
