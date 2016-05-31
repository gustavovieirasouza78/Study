package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.model.Categoria;
import br.com.caelum.jdbc.model.Produto;

public class CategoriaDAO {
	
	private final Connection con;

	public CategoriaDAO(Connection con) {
		this.con = con;
	}

	public List<Categoria> lista() throws SQLException {
		String sql = "select * from categoria";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			ResultSet resultSet = stmt.getResultSet();
			ArrayList<Categoria> categorias = new ArrayList<>();
			while(resultSet.next()) {
				int id = resultSet.getInt("idcategoria");
				String nome = resultSet.getString("nome");
				
				Categoria c = new Categoria(id, nome);
				
				categorias.add(c);
			}
			return categorias;
		}
	}

	public List<Categoria> listaComProdutos() throws SQLException {
		String sql = "select * from categoria as c join produto as p on c.idcategoria = p.idcategoria";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			
			ResultSet resultSet = stmt.getResultSet();
			ArrayList<Categoria> categorias = new ArrayList<>();
			
			Categoria categoriaUltima = null;
			
			while(resultSet.next()) {
				
				int id = resultSet.getInt("idcategoria");
				String nome = resultSet.getString("nome");
				
				if(categoriaUltima==null || categoriaUltima.getId()!=id){
					Categoria c = new Categoria(id, nome);
					categorias.add(c);
					categoriaUltima = c;
				}
				
				String nomeProduto = resultSet.getString("nomeProduto");
				String descricao = resultSet.getString("descricao");
				int idPRoduto = resultSet.getInt("idProduto");
				Produto p = new Produto(nomeProduto, descricao);
				p.setId(idPRoduto);
				categoriaUltima.add(p);
				

			}
			return categorias;
		}
	}

}
