package br.com.dimensacrud.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

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
@Table(name = "tb_contato")
public class Contato implements Serializable {

	private static final long serialVersionUID = 642010624137547001L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contato")
	private Long idContato;

	@Column(name = "nm_cliente")
	@NotNull(message = "O campo nome deve ser informado!")
	private String nomeContato;

	@Column(name = "email")
	@NotNull(message = "O campo nome deve ser informado!")
	private String email;

	@Column(name = "telefone")
	private String telefone;

	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@Column(name = "dtNascimento")
	private LocalDate dtNascimento;

	@ToString.Exclude
	@OneToMany(mappedBy = "contato", cascade = CascadeType.ALL)
	private List<Endereco> enderecos;


}
