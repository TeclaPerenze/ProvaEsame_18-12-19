package ENTITY;

import java.time.LocalDate;

public class Data_appello {
	private Tipo_luogo luogo;
	private Tipo_appello tipo;
	private LocalDate data_appello;
	
	public Data_appello() {
		this.luogo= null;
		this.tipo= null;
		this.data_appello= LocalDate.of(0, null,0);
	}
	
	public Data_appello(Tipo_luogo luogo, Tipo_appello tipo, LocalDate data_appello) {
		this.luogo= luogo;
		this.tipo= tipo;
		this.data_appello= data_appello;
	}

	public void setTipoLuogo(Tipo_luogo luogo) {
		this.luogo=luogo;
	}
	public Tipo_luogo getTipoLuogo() {
		return luogo;
		}
	public void setTipoAppello(Tipo_appello tipo) {
		this.tipo= tipo;
	}
	public Tipo_appello getTipoAppello() {
		return tipo;
	}
	public void setDataAppello(LocalDate data_appello) {
		this.data_appello= data_appello;
	}
	public LocalDate getDataAppello() {
		return data_appello;
	}
	public String toString() {
		return("\n data: " +this.data_appello+"\n"+ " tipologia: "+this.tipo + "\n"+" luogo: " +this.luogo+"\n");
	}
}
