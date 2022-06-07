package modelo;

public class peliculasM implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	// atributos
	 protected int id_pelicula;
	 protected String titulo;
	 protected String anio;
	 protected String critica;

	 //constructor vacío
	 public peliculasM() {}
	 public peliculasM(String titulo, String anio, String critica) {
	 this.titulo = titulo;
	 this.anio = anio;
	 this.critica = critica;
	 }
	 
	 public peliculasM(int id_pelicula, String titulo, String anio, String critica) {
		 this.titulo = titulo;
		 this.anio = anio;
		 this.critica = critica;
	}
	public int getId_pelicula() {
		return id_pelicula;
	}
	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getCritica() {
		return critica;
	}
	public void setCritica(String critica) {
		this.critica = critica;
	}
	 
	 
	 
	

}
