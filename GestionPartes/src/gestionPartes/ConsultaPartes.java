package gestionPartes;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConsultaPartes
 */
@WebServlet("/ConsultaPartes")
public class ConsultaPartes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaPartes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String fechaUnica = null;
		String fechaRango1 = null;
		String fechaRango2 = null;
		String currentYear = null;
		Conector conexion = null;
		
			
		try {
			conexion = new Conector ("admin" , "1234");
			conexion.openConnection();
			
			
						
			String sql;
			PreparedStatement statement = null;
			ResultSet resultado = null;			
			
			if (request.getParameter("fechaUnica")!=null){
				
				fechaUnica = request.getParameter("fechaUnica");
				fechaUnica = fechaUnica.substring(0, fechaUnica.length() - 9);
				
				sql = "select * from partes where fecha between ? and ?";
				statement = conexion.getConnection().prepareStatement(sql);
				statement.setString(1, fechaUnica+" 00:00:00");
				statement.setString(2, fechaUnica+" 23:59:59");
				resultado = statement.executeQuery();
				
			}
			
			if (request.getParameter("fechaRango1") != null) {
				
				fechaRango1 = request.getParameter("fechaRango1");
				fechaRango2 = request.getParameter("fechaRango2");
				
				sql = "select * from partes where fecha between ? and ?";
				statement = conexion.getConnection().prepareStatement(sql);
				statement.setString(1, fechaRango1);
				statement.setString(2, fechaRango2);
				resultado = statement.executeQuery();
		}
			
			if (request.getParameter("currentYear") != null ){
				
				currentYear = request.getParameter("currentYear");
				
				sql = "select * from partes where fecha between ? and ?";
				statement = conexion.getConnection().prepareStatement(sql);
				statement.setString(1, currentYear+"-01-01 00:00:00");
				statement.setString(2, currentYear+"-12-31 23:59:59");				
				resultado = statement.executeQuery();
				
			}
		
			
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			
			
			
			
					response.getWriter().print("<table><tr><th> IDParte </th>"
							+ "<th> Curso </th>"
							+ "<th> Nombre Alumno </th>"
							+ "<th> Nombre Profesor </th>"
							+ "<th> Lugar </th>"
							+ "<th> Conducta </th>"
							+ "<th> Fecha </th>"
							+ "<th> Detalles </th>"
							+ "</tr>");
			
			while (resultado.next()) {
				
				response.getWriter().print("<tr><td>"+resultado.getString("idparte")+"</td>"+
						"<td>"+resultado.getString("curso")+"</td>"+
						"<td>"+resultado.getString("nombre_alumno")+"</td>"+
						"<td>"+resultado.getString("nombre_profesor")+"</td>"+
						"<td>"+resultado.getString("lugar")+"</td>"+
						"<td>"+resultado.getString("conducta")+"</td>"+
						"<td>"+resultado.getString("fecha")+"</td>"+
						"<td>"+resultado.getString("detalles")+"</td>"+
						"</tr>");											
				
			}
			
			response.getWriter().print("</table>");
			
			statement.close();
			
			
			
			
			
			
			
			
			
		}catch (SQLException ex){
			
			ex.printStackTrace();
		
		} finally {
			
			conexion.closeConnection();			
			
			
		
		} 
	
		
		
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
