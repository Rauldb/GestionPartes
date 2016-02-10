package gestionPartes;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertaParte
 */
@WebServlet("/InsertaParte")
public class InsertaParte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertaParte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String curso = request.getParameter("curso");
		String nombreAlumno = request.getParameter("nombreAlumno");
		String nombreProfesor = request.getParameter("nombreProfesor");
		String lugar = request.getParameter("lugar");
		String conductas = request.getParameter("conductas");
		String fecha = request.getParameter("fecha");
		String detalles = request.getParameter("detalles");
		
		response.getWriter().print(curso+nombreAlumno+nombreProfesor+lugar
				+conductas+fecha+detalles);
		
		Conector conexion = null;
		
		try {
			conexion = new Conector ("admin" , "1234");
			conexion.openConnection();
			
			String sql = "insert into partes values (0, ? , ? , ? , ? , ? , ? , ?)";		
			
			
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			
			statement.setString(1, curso);
			statement.setString(2, nombreAlumno);
			statement.setString(3, nombreProfesor);
			statement.setString(4, lugar);
			statement.setString(5, conductas);
			statement.setString(6, fecha);			
			statement.setString(7, detalles);
			
			statement.executeUpdate();
			
			statement.close();
			
			
			
			
			
			
			
			
			
		}catch (SQLException ex){
			
			ex.printStackTrace();
		
		} finally {
			
			conexion.closeConnection();			
			
			
		
		} 
		
		
		
		
	}

}
