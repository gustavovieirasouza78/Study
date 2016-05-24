package br.com.alura.gerenciador.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.web.Cookies;

@WebServlet(urlPatterns = "/logout")
public class Logout  implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().removeAttribute("usuarioLogado");
		req.getSession().invalidate();
		return "WEB-INF/paginas/logout.html";
	}

/*	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		
		req.getSession().removeAttribute("usuarioLogado");
		req.getSession().invalidate();
		
		//redirect no servidor
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/paginas/logout.html");
		requestDispatcher.forward(req, resp);
		
		//redirect no cliente
		//resp.sendRedirect("WEB-INF/paginas/logout.html");
	}
*/	
}
