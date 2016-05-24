package br.com.alura.gerenciador.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/executa")
public class Controller extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String tarefa = req.getParameter("tarefa");
		
		if (tarefa == null) 
			throw new IllegalArgumentException("Tarefa deve ser enviada!");
		
		tarefa = "br.com.alura.gerenciador.web." + tarefa;
		
		try {
			Class<?> tipo = Class.forName(tarefa);
			
			Tarefa newInstance = (Tarefa) tipo.newInstance();
			
			String pagina = newInstance.executa((HttpServletRequest)req,(HttpServletResponse)res);

			req.getRequestDispatcher(pagina).forward(req, res);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
	}

}
