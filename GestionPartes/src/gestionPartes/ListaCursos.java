package gestionPartes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaCursos
 */
@WebServlet("/ListaCursos")
public class ListaCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaCursos() {
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
		
	    ArrayList<String> listaCursos = new ArrayList<String>(); 
	    response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
	    
	            
			
		try {
			conexion = new Conector ("admin" , "1234");
			conexion.openConnection();
			
			String sql = "select * from cursos";
			
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			
			
			ResultSet resultado = statement.executeQuery();			
			
			while (resultado.next()) {
				
				listaCursos.add(resultado.getString("nombre_curso"));	
				
			}
			
			statement.close();
			
			
			
			
			
			
			
			
			
		}catch (SQLException ex){
			
			ex.printStackTrace();
		
		} finally {
			
			conexion.closeConnection();			
			
			
		
		} 
	    
		
	    PrintWriter out = response.getWriter();
	    response.setContentType("text/html");
	    for (int i=0 ; i<listaCursos.size() ; i++ ) out.println("<option>"+listaCursos.get(i)+
	    		"</option>)");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
