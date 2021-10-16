package com.filtros;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class UnFiltro
 */
public class UnFiltro implements Filter {
	private FilterConfig config;
    /**
     * Default constructor. 
     */
    public UnFiltro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		double tiempo1 = System.currentTimeMillis();
		response.setContentType("text/HTML");
		//////response.getWriter().append("<br/>Llega al filtro :D<br/>");
		
		/*String nom = request.getParameter("usu");
		String pass = request.getParameter("pass");
		
		if(nom.equals("admin") && pass.equals("123"))
			chain.doFilter(request, response);
		else
			response.getWriter().append("Datos incorrectos!");
		*/
		
		String estado = config.getInitParameter("enMantenimiento");
		if(estado.equals("no")) {//coando NO está en mantenimiento
		PrintWriter out = response.getWriter();
		out.append("Estoy en pleno filtro :D ahora te paso tu servlet<br/>");
		chain.doFilter(request, response);
		double tiempo2 = System.currentTimeMillis();
		out.append("<br/>Estoy en pleno filtro :D ya te pasé tu servlet<br/><br/> Tarda este tiempo (milisegundos): "+ (tiempo2-tiempo1));
		
		
		}else {
			PrintWriter out = response.getWriter();
			out.append("Lo siento, en mantenimiento");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		config = fConfig;
	}

}
