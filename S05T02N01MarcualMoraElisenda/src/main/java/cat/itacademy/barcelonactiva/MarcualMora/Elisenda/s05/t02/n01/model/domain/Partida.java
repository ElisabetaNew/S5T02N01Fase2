package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t02.n01.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection = "partidas")
public class Partida {

	@Id //Si no se define, se autogenera
	@Field(value = "id_partida")
	private Integer partidaID;

	@Field(value = "dado1")
	private int dado1;

	@Field(value = "dado2")
	private int dado2;

	@Field(value = "partida_ganada")
	private boolean resultado;

	// relacion bidireccional por ser la más optima en recursos
	//@DBRef
	//@JoinColumn(name = "usuarioID", referencedColumnName = "usuarioID", nullable = false, updatable = false)
	private Integer usuarioID;

	// constructores
	public Partida(Integer partidaID, int dado1, int dado2, boolean resultado, Integer usuarioID) {
		super();
		this.partidaID = partidaID;
		this.dado1 = dado1;
		this.dado2 = dado2;
		this.resultado = resultado;
		this.usuarioID = usuarioID;
	}

	public Partida(int dado1, int dado2, Integer usuarioID) {
		this.dado1 = dado1;
		this.dado2 = dado2;
		this.usuarioID = usuarioID;
	}

	public Partida() {

	}

	// Getters y setters
	public Integer getPartidaID() {
		return partidaID;
	}

	public void setPartidaID(Integer partidaID) {
		this.partidaID = partidaID;
	}

	public int getDado1() {
		return dado1;
	}

	public void setDado1(int dado1) {
		this.dado1 = dado1;
	}

	public int getDado2() {
		return dado2;
	}

	public void setDado2(int dado2) {
		this.dado2 = dado2;
	}

	public boolean isResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}

	public Integer getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(Integer usuarioID) {
		this.usuarioID = usuarioID;
	}

	@Override
	public String toString() {
		return "Partida [partidaID=" + partidaID + ", dado1=" + dado1 + ", dado2=" + dado2 + ", resultado=" + resultado
				+ ", usuarioID=" + usuarioID + "]";
	}

}
