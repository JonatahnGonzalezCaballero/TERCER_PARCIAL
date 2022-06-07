package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.copiasM;

public class CopiasDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcUsername = "crud_guia16";
	private String jdbcPassword = "clave123";
	private static final String INSERT_USERS_SQL = "INSERT INTO copias" + "(deteriorada, formato, precio_alquiler) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select n_copia,deteriorada,formato,precio_alquiler from copias where n_copia =?";
	private static final String SELECT_ALL_USERS = "select * from copias";
	private static final String DELETE_USERS_SQL = "delete from copias where n_copia = ?;";
	private static final String UPDATE_USERS_SQL = "update copisd set deteriorada =?,formato= ?, precio_alquiler =? where n_copia = ?;";

	public CopiasDAO() {
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

	public void insertCopias(copiasM copiasm) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
// Se conecta a la base de datos
		try (Connection connection = getConnection();
// Prepara la sentencia sql a ejecutar con el objeto

				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, copiasm.getDeteriorada());
			preparedStatement.setString(2, copiasm.getFormato());
			preparedStatement.setString(3, copiasm.getPrecio_alquiler());
//System.out.println(preparedStatement);
// Ejecuta la consulta
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

// METODO PARA BUSCAR POR USUARIO (ID)
	public copiasM selectUser(int n_copia) {
		copiasM copiasm = null;
//Se conecta a la base de datos
		try (Connection connection = getConnection();
//Prepara la sentencia sql a ejecutar con el objeto
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, n_copia);
//System.out.println(preparedStatement);
//Ejecuta la consulta
			ResultSet rs = preparedStatement.executeQuery();
//Recorre los resultados y los devuelve en el objeto user
			while (rs.next()) {
				String deteriorada = rs.getString("Deteriorada");
				String formato = rs.getString("formato");
				String precio_alquiler = rs.getString("precio_alquiler");
				copiasm = new copiasM(n_copia,deteriorada, formato, precio_alquiler);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return copiasm;
	}

//METODO PARA MOSTRAR TODA LA LISTA DE USUARIOS
	public List<copiasM> selectAllUsers() {
//crea el array para mostrar los resultados
		List<copiasM> copias = new ArrayList<>();
//Conecta con la bd
		try (Connection connection = getConnection();
//Prepara la consulta sql
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
//System.out.println(preparedStatement);
//Ejecuta la consulta y la almacena en un objeto ResultSet
			ResultSet rs = preparedStatement.executeQuery();
//Recorre el resultado y lo almacena en el objeto users
			while (rs.next()) {
				int n_copia = rs.getInt("n_copia");
				String deteriorada = rs.getString("deteriorada");
				String formato = rs.getString("formato");
				String precio_alquiler = rs.getString("precio_alquiler");
				copias.add(new copiasM(n_copia,deteriorada, formato, precio_alquiler));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return copias;
	}

//METODO PARA BORRAR UN USUARIO DE LA BD
	public boolean deleteCopias(int n_copia) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, n_copia);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	

	// METODO PARA ACTUALIZAR DATOS DE UN USUARIO GUARDADO EN BD
	public boolean updateCopias(copiasM copiasm) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, copiasm.getDeteriorada());
			statement.setString(2, copiasm.getFormato());
			statement.setString(3, copiasm.getPrecio_alquiler());
			statement.setInt(4, copiasm.getN_copia());
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
