package gestionPartes;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EliminaParte
 */
@WebServlet("/EliminaParte")
public class EliminaParte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaParte() {
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
		
		String fecha = request.getParameter("fecha");
		fecha = fecha.substring(0, fecha.length() - 9);
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		
		Conector conexion = null;
		
		try {
			conexion = new Conector ("admin" , "1234");
			conexion.openConnection();
			
			String sql = "delete from partes where fecha between ? and ?";		
			
			
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			
			statement.setString(1, fecha+" 00:00:00");
			statement.setString(2, fecha+" 23:59:59");
			
			statement.executeUpdate();
			
			statement.close();
			
			response.getWriter().println("Borrado");
			
			
			
			
			
			
			
			
			
		}catch (SQLException ex){
			
			ex.printStackTrace();
		
		} finally {
			
			conexion.closeConnection();			
			
			
		
		} 
		
		
		
		
	}
	
		
	

}
