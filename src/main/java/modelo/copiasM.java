package modelo;

public class copiasM implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// atributos
	 protected int n_copia;
	 protected String deteriorada;
	 protected String formato;
	 protected String precio_alquiler;


public copiasM() {}
public copiasM(String deteriorada, String formato, String precio_alquiler) {
this.deteriorada = deteriorada;
this.formato = formato;
this.precio_alquiler = precio_alquiler;
}

public copiasM(int n_copia, String deteriorada, String formato, String precio_alquiler) {
this.deteriorada = deteriorada;
this.formato = formato;
this.precio_alquiler = precio_alquiler;
}



public int getN_copia() {
	return n_copia;
}
public void setN_copia(int n_copia) {
	this.n_copia = n_copia;
}
public String getDeteriorada() {
	return deteriorada;
}
public void setDeteriorada(String deteriorada) {
	this.deteriorada = deteriorada;
}
public String getFormato() {
	return formato;
}
public void setFormato(String formato) {
	this.formato = formato;
}
public String getPrecio_alquiler() {
	return precio_alquiler;
}
public void setPrecio_alquiler(String precio_alquiler) {
	this.precio_alquiler = precio_alquiler;
}






}