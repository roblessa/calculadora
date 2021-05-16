package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ConnectionFactory {
	
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/gerenciador_de_anuncios";
    private static String USER = "root";
    private static String PASS = "";
	
    public static Connection getConnection() {
		
	//Faz com que a conexao seja carregada pela jvm
	try {
            Class.forName(DRIVER);
			
            //Cria conexao com o bd
            return DriverManager.getConnection(URL, USER, PASS);
			
	} catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro ao conectar: ", ex);
	}
	
    }
	
    public static void closeConnection(Connection connection) {
            try {
		if(connection != null) {
                    connection.close();
		}
            } catch (Exception ex) {
		throw new RuntimeException("Erro ao fechar conex�o: ", ex);
            }
		
	}
	
    public static void closeConnection(Connection connection, PreparedStatement statement) {
            try {
                if(statement != null) {
                    statement.close();
		}
            } catch (Exception ex) {
		throw new RuntimeException("Erro ao fechar conex�o: ", ex);
            }
		
	}
	
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
            try {
		if(resultSet != null) {
                    resultSet.close();
                    }
            } catch (Exception ex) {
		throw new RuntimeException("Erro ao fechar conex�o: ", ex);
            }
		
	}
	
}


