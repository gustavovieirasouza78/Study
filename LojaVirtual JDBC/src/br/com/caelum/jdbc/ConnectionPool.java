package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;


public class ConnectionPool {
	
	private final DataSource dataSource;

	public ConnectionPool() {
		System.out.print("iniciando connection pool...");	
		MysqlConnectionPoolDataSource pool = new MysqlConnectionPoolDataSource();
		pool.setUrl("jdbc:mysql://localhost/lojavirtual");
		pool.setUser("lojavirtualuser");
		pool.setPassword("123456");
		dataSource = pool;
		System.out.println(" ok");
	}
	
	public Connection getConnection() throws SQLException {
		System.out.print("adiquirindo conexão...");
		Connection connection = dataSource.getConnection();
		System.out.println(" ok");
		return connection;
	}	

}
