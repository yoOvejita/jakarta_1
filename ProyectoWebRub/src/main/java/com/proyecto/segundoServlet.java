package com.proyecto;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class segundoServlet
 */
public class segundoServlet extends HttpServlet {
	
	String valorSesion, valorContexto;
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public segundoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Llega por get");
		HttpSession session = request.getSession();
		
		/*
		int resGlobal = (int) session.getAttribute("respuesta");
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("--> " + resGlobal);
		*/
		
		//Análisis del alcance de los valores
		//(request VS sesion VS contexto)
		String nomUsuario = request.getParameter("usuario");//dato que viene por GET
		
		//mostrar con writer
		response.getWriter().append("<br/><br/>Nombre: " + nomUsuario);

		//HttpSession session = request.getSession();
		if(valorSesion == null)
			session.setAttribute("username", nomUsuario);
		valorSesion = (String) session.getAttribute("username");
		//mostrar con writer
		response.getWriter().append("<br/>Nombre: " + valorSesion);
		
		ServletContext contexto = request.getSession().getServletContext();
		if(valorContexto == null)
			contexto.setAttribute("username", nomUsuario);
		valorContexto = (String)contexto.getAttribute("username");
		//mostrar con writer
		response.getWriter().append("<br/>Nombre: " + valorContexto);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = (String) request.getAttribute("nombre");
		System.out.println("Llega por post");
		doGet(request, response);
	}

}
