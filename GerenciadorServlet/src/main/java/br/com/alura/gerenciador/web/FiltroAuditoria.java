package br.com.alura.gerenciador.web;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroAuditoria implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		//HttpServletResponse res = (HttpServletResponse) response;
		
		String usuario = getUsuario(req);
		
		String uri = req.getRequestURI();
		System.out.println("Usuário " + usuario + " acessando a URI: " + uri);
		
		chain.doFilter(request, response);
	}

	private String getUsuario(HttpServletRequest req) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		
		if(usuario == null){
			return "<deslogado>";
		}else{
			return usuario.getEmail();
		}
		
		/*String usuario = "<deslogado>";
		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		if(cookie == null){ 
			return usuario;
		}else{
			usuario = cookie.getValue();
		}
		return usuario;*/
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
