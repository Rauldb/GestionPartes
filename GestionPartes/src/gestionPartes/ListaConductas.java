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
 * Servlet implementation class ListaConductas
 */
@WebServlet("/ListaConductas")
public class ListaConductas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaConductas() {
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
		
	    ArrayList<String> listaLeves = new ArrayList<String>();
	    ArrayList<String> listaGenerales = new ArrayList<String>();
	    ArrayList<String> listaGraves = new ArrayList<String>();
	    response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
	    
	            
			
		try {
			conexion = new Conector ("admin" , "1234");
			conexion.openConnection();
			
			String sql = "select * from conductas where grado=?";
			
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			statement.setString(1, "leve");
			
			ResultSet leves = statement.executeQuery();
			
			while (leves.next()) {
				
				listaLeves.add(leves.getString("descripcion"));	
				
			}
			
			leves.close();
			statement.setString(1, "general");
			
			ResultSet generales = statement.executeQuery();
			
			while (generales.next()) {
				
				listaGenerales.add(generales.getString("descripcion"));	
				
			}
			
			statement.setString(1, "grave");
			
			ResultSet graves = statement.executeQuery();			

			
			while (graves.next()) {
				
				listaGraves.add(graves.getString("descripcion"));	
				
			}
			
			statement.close();
			
			
			
			
			
			
			
			
			
		}catch (SQLException ex){
			
			ex.printStackTrace();
		
		} finally {
			
			conexion.closeConnection();			
			
			
		
		} 
	    
		
	    
	    
	    out.print("<p class='conducta'> Conductas leves <br><select class='selectcond' id='leves'>"
	    +"<option value='pordefecto'> Seleccione conducta </option>");
	    
	    for (int i=0 ; i<listaLeves.size() ; i++ ) out.println("<option>"+listaLeves.get(i)+
	    		"</option>)");
	    
	    out.print("</select></p>");
	    
	    
	    
	    out.print("<p class='conducta'> Conductas generales leves<br> <select class='selectcond'"+
	    "id='generales'>  <option value='pordefecto'> Seleccione conducta </option>");
	    
	    for (int i=0 ; i<listaGenerales.size() ; i++ ) out.println("<option>"+listaGenerales.get(i)+
	    		"</option>)");
	    
	    out.print("</select></p>");
	    
	    out.print("<p class='conducta'> Conductas graves<br> <select class='selectcond'"+
	    "id='graves'> <option value='pordefecto'> Seleccione conducta </option>");
	    
	    for (int i=0 ; i<listaGraves.size() ; i++ ) out.println("<option>"+listaGraves.get(i)+
	    		"</option>)");
	    
	    out.print("</select></p>");
	    
		
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
