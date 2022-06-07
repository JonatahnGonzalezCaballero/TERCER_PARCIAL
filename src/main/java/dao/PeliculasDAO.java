package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.peliculasM;

public class PeliculasDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcUsername = "crud_guia16";
	private String jdbcPassword = "clave123";
	private static final String INSERT_USERS_SQL = "INSERT INTO peliculas" + "(titulo, anio, critica) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select id_pelicula,titulo,anio,critica from peliculas where id_pelicula =?";
	private static final String SELECT_ALL_USERS = "select * from peliculas";
	private static final String DELETE_USERS_SQL = "delete from peliculas where id_pelicula = ?;";
	private static final String UPDATE_USERS_SQL = "update peliculas set titulo =?,anio= ?, critica =? where id_pelicula = ?;";

	public PeliculasDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
//registra el driver de conexión para la base de datos
//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void insertPeliculas(peliculasM peliculasm) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
// Se conecta a la base de datos
		try (Connection connection = getConnection();
// Prepara la sentencia sql a ejecutar con el objeto

				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, peliculasm.getTitulo());
			preparedStatement.setString(2, peliculasm.getAnio());
			preparedStatement.setString(3, peliculasm.getCritica());
//System.out.println(preparedStatement);
// Ejecuta la consulta
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

// METODO PARA BUSCAR POR USUARIO (ID)
	public peliculasM selectUser(int id_pelicula) {
		peliculasM peliculasm = null;
//Se conecta a la base de datos
		try (Connection connection = getConnection();
//Prepara la sentencia sql a ejecutar con el objeto
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id_pelicula);
//System.out.println(preparedStatement);
//Ejecuta la consulta
			ResultSet rs = preparedStatement.executeQuery();
//Recorre los resultados y los devuelve en el objeto user
			while (rs.next()) {
				String titulo = rs.getString("titulo");
				String anio = rs.getString("anio");
				String critica = rs.getString("critica");
				peliculasm = new peliculasM(id_pelicula, titulo,anio,critica);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return peliculasm;
	}

//METODO PARA MOSTRAR TODA LA LISTA DE USUARIOS
	public List<peliculasM> selectAllUsers() {
//crea el array para mostrar los resultados
		List<peliculasM> peliculas = new ArrayList<>();
//Conecta con la bd
		try (Connection connection = getConnection();
//Prepara la consulta sql
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
//System.out.println(preparedStatement);
//Ejecuta la consulta y la almacena en un objeto ResultSet
			ResultSet rs = preparedStatement.executeQuery();
//Recorre el resultado y lo almacena en el objeto users
			while (rs.next()) {
				int id_pelicula = rs.getInt("id_pelicula");
				String titulo = rs.getString("titulo");
				String anio = rs.getString("anio");
				String critica = rs.getString("critica");
				peliculas.add(new peliculasM(id_pelicula, titulo,anio,critica));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return peliculas;
	}

//METODO PARA BORRAR UN USUARIO DE LA BD
	public boolean deletePeliculas(int id_pelicula) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id_pelicula);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	

	// METODO PARA ACTUALIZAR DATOS DE UN USUARIO GUARDADO EN BD
	public boolean updatePeliculas(peliculasM peliculasm) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, peliculasm.getTitulo());
			statement.setString(2, peliculasm.getAnio());
			statement.setString(3, peliculasm.getCritica());
			statement.setInt(4, peliculasm.getId_pelicula());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
}
