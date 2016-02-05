package gestionPartes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class ListaAlumnos
 */
@WebServlet("/ListaAlumnos")
public class ListaAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaAlumnos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Conector conexion = null;
		
		
		String curso = request.getParameter("curso");
		
	    ArrayList<String> listaalumnos = new ArrayList<String>(); 
	    String respuestaJson = null;
	            
			
		try {
			conexion = new Conector ("admin" , "1234");
			conexion.openConnection();
			
			String sql = "select * from alumnos where curso = ?";
			
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			
			statement.setString(1, curso);
			ResultSet resultado = statement.executeQuery();			
			
			while (resultado.next()) {
				
				listaalumnos.add(resultado.getString("nombre"));	
				
			}
			
			statement.close();
			
			
			
			
			
			
			
			
			
		}catch (SQLException ex){
			
			ex.printStackTrace();
		
		} finally {
			
			conexion.closeConnection();			
			
			
		
		} 
	    
		
	    PrintWriter out = response.getWriter();
	    response.setContentType("text/html");
	    for (int i=0 ; i<listaalumnos.size() ; i++ ) out.println("<option>"+listaalumnos.get(i)+
	    		"</option>)");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		
		
	}

}
