package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import br.com.caelum.dao.CategoriaDAO;
import br.com.caelum.jdbc.model.Categoria;
import br.com.caelum.jdbc.model.Produto;

public class TestaCategorias {

	public static void main(String[] args) throws SQLException {
		
		try(Connection con = new ConnectionPool().getConnection()){
			List<Categoria> categoria = new CategoriaDAO(con).listaComProdutos();
			
			for (Iterator iterator = categoria.iterator(); iterator.hasNext();) {
				Categoria c = (Categoria) iterator.next();
				System.out.println(c.toString());
				
				List<Produto> produtos = c.getProdutos();
				for (Produto produto : produtos) {
					System.out.println("   " + produto.toString());
				}
				
			}
		}

	}

}
