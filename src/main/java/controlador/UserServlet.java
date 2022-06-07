package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDAO;
import modelo.User;
import dao.PeliculasDAO;
import modelo.peliculasM;
import dao.CopiasDAO;
import modelo.copiasM;



@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private PeliculasDAO peliculasDAO; 
	private CopiasDAO copiasDAO;
	
	public void init() {
		userDAO = new UserDAO();
		peliculasDAO = new PeliculasDAO();
		copiasDAO = new CopiasDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			
			
			//Tabla Peliculas	
		
			case "/new_peliculas":
			showNewFormPeliculas(request, response);
				break;
			case "/insertPeliculas":
				insertPeliculas(request, response);
				break;
			case "/deletePeliculas":
				deletePeliculas(request, response);
				break;
			case "/editPeliculas":
				showEditFormPeliculas(request, response);
				break;
			case "/updatePeliculas":
				updatePeliculas(request, response);
				break;	
				
				
			//Tabla Copias
				
				case "/new_copias":
				showNewFormCopias(request, response);
					break;
				case "/insertCopias":
					insertCopias(request, response);
					break;
				case "/deleteCopias":
					deleteCopias(request, response);
					break;
				case "/editCopias":
					showEditFormCopias(request, response);
					break;
				case "/updateCopias":
					updateCopias(request, response);
					break;	
				
				
			case "/listUser":
				listUser(request, response);
				break;
			case "/listPeliculas":
				listPeliculas(request, response);
				break;
			case "/listCopias":
				listCopias(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	
	
	
	private void listCopias(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<copiasM> listCopias = copiasDAO.selectAllUsers();
		request.setAttribute("listCopias", listCopias);
		RequestDispatcher dispatcher = request.getRequestDispatcher("copias-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormCopias(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("copias-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormCopias(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int n_copia = Integer.parseInt(request.getParameter("n_copia"));
		copiasM existingUser = copiasDAO.selectUser(n_copia);
		RequestDispatcher dispatcher = request.getRequestDispatcher("copias-form.jsp");
		request.setAttribute("copias", existingUser);
		dispatcher.forward(request, response);
	}

	private void insertCopias(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		String deteriorada = request.getParameter("deteriorada");
		String formato = request.getParameter("formato");
		String precio_alquiler = request.getParameter("precio_alquiler");
		copiasM newCopias = new copiasM(deteriorada, formato, precio_alquiler);
		copiasDAO.insertCopias(newCopias);
		response.sendRedirect("listCopias");

	}

	private void updateCopias(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		int n_copia = Integer.parseInt(request.getParameter("n_copia"));
		String deteriorada = request.getParameter("deteriorada");
		String formato = request.getParameter("formato");
		String precio_alquiler = request.getParameter("precio_alquiler");
		copiasM book = new copiasM(n_copia, deteriorada, formato, precio_alquiler);
		copiasDAO.updateCopias(book);
		response.sendRedirect("listCopias");

	}

	private void deleteCopias(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int n_copia = Integer.parseInt(request.getParameter("n_copia"));
		copiasDAO.deleteCopias(n_copia);
		response.sendRedirect("listCopias");
	}
	

	
	

	
	
	
	
//-------------------------------------------------------------------------------------------------------------
//PELICULAS	
	private void listPeliculas(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<peliculasM> listPeliculas = peliculasDAO.selectAllUsers();
		request.setAttribute("listPeliculas", listPeliculas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("peliculas-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormPeliculas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("peliculas-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormPeliculas(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id_pelicula = Integer.parseInt(request.getParameter("id_pelicula"));
		peliculasM existingUser = peliculasDAO.selectUser(id_pelicula);
		RequestDispatcher dispatcher = request.getRequestDispatcher("peliculas-form.jsp");
		request.setAttribute("Peliculas", existingUser);
		dispatcher.forward(request, response);
	}

	private void insertPeliculas(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		String titulo = request.getParameter("Titulo");
		String anio = request.getParameter("Año");
		String critica = request.getParameter("Critica");
		peliculasM newPelicula = new peliculasM(titulo,anio,critica);
		peliculasDAO.insertPeliculas(newPelicula);
		response.sendRedirect("listPeliculas");
	}

	private void updatePeliculas(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		int id_pelicula = Integer.parseInt(request.getParameter("id_pelicula"));
		String titulo = request.getParameter("Titulo");
		String anio = request.getParameter("Año");
		String critica = request.getParameter("Critica");
		peliculasM book = new peliculasM(id_pelicula, titulo, anio, critica);
		peliculasDAO.updatePeliculas(book);
		response.sendRedirect("listPeliculas");
	}

	private void deletePeliculas(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id_pelicula = Integer.parseInt(request.getParameter("id_pelicula"));
		peliculasDAO.deletePeliculas(id_pelicula);
		response.sendRedirect("listPeliculas");
	}

	
	
	//----------------------------------------------------------------------------------------------

//	CLIENTES
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		User newUser = new User(name, email, country);
		userDAO.insertUser(newUser);
		response.sendRedirect("listUser");

	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		User book = new User(id, name, email, country);
		userDAO.updateUser(book);
		response.sendRedirect("listUser");

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("listUser");
	}
	
}











































































/*package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDAO;
import modelo.User;
import dao.PeliculasDAO;
import modelo.peliculasM;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private PeliculasDAO peliculasDAO;

	public void init() {
		userDAO = new UserDAO();
		peliculasDAO = new PeliculasDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			
				
				
				
			case "/new_pelicula":
				showNewForm_peliculas(request, response);
					break;
				case "/insertPeliculas":
					insertPeliculas(request, response);
					break;
				case "/deletePeliculas":
					deletePeliculas(request, response);
					break;
				case "/edit_Peliculas":
					showEditForm_peliculas(request, response);
					break;
				case "/updatePeliculas":
					updatePeliculas(request, response);
					break;	
					
					
					
				case "/listUser":
					listUser(request, response);
					break;
				case "/listUser_estudiante":
					listUser_estudiante(request, response);
					break;
				}
			}
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listPeliculas(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<PeliculasM> listPeliculas = userDAO.selectAllUsers();
		request.setAttribute("listPeliculas", listPeliculas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}
	

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		User newUser = new User(name, email, country);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		User book = new User(id, name, email, country);
		userDAO.updateUser(book);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("list");
	}
	
	

}







/*package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PeliculasDAO;
import modelo.peliculasM;


@WebServlet("/")
public class PeliculasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PeliculasDAO peliculasDAO;

	public void init() {
		peliculasDAO = new PeliculasDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listPeliculas(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listPeliculas(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<peliculasM> listPeliculas = peliculasDAO.selectAllUsers();
		request.setAttribute("listPeliculas", listPeliculas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("peliculas_list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("peliculas-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id_peliculas = Integer.parseInt(request.getParameter("id_peliculas"));
		peliculasM existingUser = peliculasDAO.selectUser(id_peliculas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("peliculas-form.jsp");
		request.setAttribute("peliculas", existingUser);
		dispatcher.forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		String titulo = request.getParameter("titulo");
		String anio = request.getParameter("anio");
		String critica = request.getParameter("critica");
		peliculasM newPelicula = new peliculasM(titulo,anio,critica);
		peliculasDAO.insertUser(newPelicula);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		int id_pelicula = Integer.parseInt(request.getParameter("id_pelicula"));
		String titulo = request.getParameter("titulo");
		String anio = request.getParameter("anio");
		String critica = request.getParameter("critica");
		peliculasM book = new peliculasM(id_pelicula, titulo,anio,critica);
		peliculasDAO.updateUser(book);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id_pelicula = Integer.parseInt(request.getParameter("id_pelicula"));
		peliculasDAO.deleteUser(id_pelicula);
		response.sendRedirect("list");
	}

}

*/
