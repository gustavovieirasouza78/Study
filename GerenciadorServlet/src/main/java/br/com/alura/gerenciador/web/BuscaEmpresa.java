package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa implements Tarefa {
	
	public BuscaEmpresa(){
		System.out.println("Construindo a Servelet BuscaEmpresa " + this);
	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		String filtro = req.getParameter("filtro");
		Collection<Empresa> buscaPorSimilaridade = new EmpresaDAO().buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", buscaPorSimilaridade);
		
		return "WEB-INF/paginas/buscaEmpresa.jsp";
	}
	
	
	/*
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Inicializando a Servlet BuscaEmpresa" + this);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destruindo a Servlet BuscaEmpresa" + this);
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();		
		writer.println("<html><body>");
		writer.println("Resultado da Busca:<br/>");
		
		String filtro = req.getParameter("filtro");
		Collection<Empresa> buscaPorSimilaridade = new EmpresaDAO().buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", buscaPorSimilaridade);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/paginas/buscaEmpresa.jsp");
		requestDispatcher.forward(req, resp);
	}
	*/
}
