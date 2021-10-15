package com.proyecto;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class coockiesController
 */

@WebServlet(urlPatterns = {"/g", "/gg", "/google"},
initParams = {
		@WebInitParam(name="dato", value="Sofi"),
		@WebInitParam(name="id", value="dsfs879sd")
})
public class coockiesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public coockiesController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie galletita = new Cookie("idUsuario","pepenaitor");
		galletita.setMaxAge(0);//cantidad de segundos de vida
		response.addCookie(galletita);
		
		//Llamando a un parámetro de contexto
		ServletContext contexto = getServletContext();
		String valor = contexto.getInitParameter("dato");
		
		ServletConfig sConfig = getServletConfig();
		String valor2 = sConfig.getInitParameter("dato");
		
		response.getWriter().append("Served at: ").append(request.getContextPath()).append(" Par de contexto: " + valor)
		.append("; valor desde init servlet: " + valor2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
