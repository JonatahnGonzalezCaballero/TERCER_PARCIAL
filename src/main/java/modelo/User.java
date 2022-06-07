package modelo;

public class User implements java.io.Serializable{
private static final long serialVersionUID = 1L;
// atributos
 protected int id;
 protected String name;
 protected String email;
 protected String country;

 //constructor vacío
 public User() {}
 public User(String name, String email, String country) {
 this.name = name;
 this.email = email;
 this.country = country;
 }
 public User(int id, String name, String email, String country) {
 this.id = id;
 this.name = name;
 this.email = email;
 this.country = country;
 }
 public int getId() {
 return id;
 }
 public void setId(int id) {
 this.id = id;
 }
 public String getName() {
 return name;
 }
 public void setName(String name) {
 this.name = name;
 }
 public String getEmail() {
 return email;
 }
 public void setEmail(String email) {
 this.email = email;
 }
 public String getCountry() {
 return country;
 }
 public void setCountry(String country) {
	 this.country = country;
 }
}





/*
 CREATE TABLE peliculas (
    id_pelicula INT(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(80),
    año VARCHAR(20),
    critica VARCHAR(200) 
    PRIMARY KEY(id_pelicula)
);
 
  create table user(
id_pelicula INT(3) NOT NULL AUTO_INCREMENT,
name VARCHAR(120) NOT NULL,
email VARCHAR(220) NOT NULL,
country VARCHAR(120),
PRIMARY KEY(id_pelicula)
);

  
  
 */
 
