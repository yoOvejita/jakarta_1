package com.proyecto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class nombreController
 */
public class nombreController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public nombreController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Servidor en: ").append(request.getContextPath());
		PrintWriter salida = response.getWriter();
		List<String> lista = new LinkedList<>();
		lista.add("A");
		lista.add("B");
		lista.add("Z");
		
		salida.append("<table border=\"1\">");
		//for(int i = 0; i < lista.size(); i++)
		for(String cad : lista) {
			salida.append("<tr><td>" + cad + "</td></tr>");
		}
		salida.append("</table>");
		
		//agregar a la "salida" una tabla (  <table> ) mostrando
		//todos los elementos de la lista
		
		salida.append("<br/><center>");
		salida.append("<h1>Hola</h1>");
		salida.append("</center>");
		
		//Tratamiento de parámetros
		int num1 = Integer.parseInt(request.getParameter("n1"));
		int num2 = Integer.parseInt(request.getParameter("n2"));
		int respuesta = num1 + num2;
		salida.append("<br/>La suma es: " + (num1 + num2));
		
		//Usando sesion
		HttpSession session = request.getSession();
		session.setAttribute("respuesta", respuesta);
		
		
		//Ejemplo de cookies
		String dato = "";
		Cookie[] galletitas = request.getCookies();
		for(Cookie galleta : galletitas)
			if(galleta.getName().equals("idUsuario"))
				dato = galleta.getValue();
		
		salida.append("La cookie rescatada tenía el valor: " + dato);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//String valor1 = "Pepex";
		/*
		request.setAttribute("nombre", valor1);
		RequestDispatcher var = request.getRequestDispatcher("segundo");
		var.forward(request, response);
		*/
		
		
		//response.sendRedirect("segundo");
		String dato = "";
		Cookie[] galletitas = request.getCookies();
		for(Cookie galleta : galletitas)
			if(galleta.getName().equals("idUsuario"))
				dato = galleta.getValue();
		
		response.getWriter().append("La cookie rescatada tenía el valor: " + dato);
	}

}
