package gestionPartes;

import java.io.IOException;
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
		
		if (request.getParameter("fechaUnica")!=null){
			
			fechaUnica = request.getParameter("fechaUnica");
			
		}
		
		if (request.getParameter("fechaRango1") != null) {
			
			fechaRango1 = request.getParameter("fechaRango1");
			fechaRango2 = request.getParameter("fechaRango2");
	}
		
		if (request.getParameter("currentYear") != null ){
			
			currentYear = request.getParameter("currentYear");
		}
		
		response.getWriter().println(fechaUnica+fechaRango1+fechaRango2+currentYear);
	
		
		
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
