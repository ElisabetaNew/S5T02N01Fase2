package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t02.n01.model.domain;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;



@Document(collection = "usuarios")
public class Usuario{

	@Id
	@Field(value = "id_usuario")
	private Integer usuarioID;

	@Field(value = "nombre_usuario")
	@Indexed //marca un campo como indice aumentando la eficiencia en la busqueda y nombre lo vamos a utilizar mucho
	private String nombreUsuario;

	@Field(value = "fecha_registro")
	@DateTimeFormat(iso=ISO.DATE) 
	private LocalDate fechaRegistro;

	@Field(value = "porcetage_Exito")
	@Transient //no es persistente ya que es un atributo que calculamos
	private float porcentageExito;

	//@OneToMany(mappedBy = "usuarioID", cascade = CascadeType.ALL, orphanRemoval = true)
	@DBRef
	private List<Partida> partidas;

	// Constructores
	public Usuario() {

	}

	public Usuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	

	public Usuario(Integer usuarioID, String nombreUsuario, LocalDate fechaRegistro) {
		super();
		this.usuarioID = usuarioID;
		this.nombreUsuario = nombreUsuario;
		this.fechaRegistro = fechaRegistro;
	}


	public Usuario(Integer usuarioID, String nombreUsuario, LocalDate fechaRegistro, float porcentageExito) {
		super();
		this.usuarioID = usuarioID;
		this.nombreUsuario = nombreUsuario;
		this.fechaRegistro = fechaRegistro;
		this.porcentageExito = porcentageExito;
		this.partidas = new ArrayList<Partida>();
	}

	// getters y setters

	public Integer getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(Integer usuarioID) {
		this.usuarioID = usuarioID;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	// retornar las partidas de ese usuario en concreto
	public List<Partida> getPartidas() {
		List<Partida> lista = new ArrayList<Partida>();
		for (Partida partida : partidas) {
			if (partida.getUsuarioID().equals(this.usuarioID)) {
				lista.add(partida);
			}
		}
		return lista;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public Usuario addPartida(Partida partida) {
		this.partidas.add(partida);
		partida.setUsuarioID(this.usuarioID);
		return this;
	}

	public float getPorcentageExito() {
		return porcentageExito;
	}

//	public void setPorcentageExito(float porcentageExito) {
//		this.porcentageExito = porcentageExito;
//	}

	@Override
	public String toString() {
		return "Usuario [usuarioID=" + usuarioID + ", nombreUsuario=" + nombreUsuario + ", fechaRegistro="
				+ fechaRegistro + ", porcentageExito=" + porcentageExito + ", partidas=" + partidas + "]";
	}

	//para obtener el percentatge contar partidas ganadas y dividirlas por total partidas
	public void setPorcentageExito() {
		if(this.partidas.size()==0) {
			this.porcentageExito = 0;
		} else {
		List<Partida> lista = new ArrayList<Partida>();
		for (Partida partida : partidas) {
			if (partida.isResultado()== true) {
				lista.add(partida);
			}
		}
		this.partidas.size();
		this.porcentageExito = (100*lista.size())/this.partidas.size();
	}
	}
}
