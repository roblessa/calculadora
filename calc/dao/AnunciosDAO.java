package dao;

import connection.ConnectionFactory;
import model.AnunciosModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class AnunciosDAO {
    Connection connection = ConnectionFactory.getConnection();
    PreparedStatement statement = null;
    ResultSet result = null;
    
    public void create(AnunciosModel anuncios){
        
        try {
            statement = connection.prepareStatement("INSERT INTO Anuncios(id_cliente, nomeAnuncio, dataInicial, dataTermino, investimentoDiario) VALUES(?, ?, ?, ?, ?)");
            statement.setInt(1, anuncios.getId_Cliente());
            statement.setString(2, anuncios.getNomeAnuncio());
            statement.setDate(3, (Date) anuncios.getDataInicial());
            statement.setDate(4, (Date) anuncios.getDataTermino());
            statement.setFloat(5, anuncios.getInvestimentoDiario());
			
            statement.execute();
			
			
            JOptionPane.showMessageDialog(null,  "Cadastrado com sucesso!");
	} catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!"+ ex);
	}finally {
            ConnectionFactory.closeConnection(connection, statement);
	}
	
}
    
    public void update(AnunciosModel anuncios) {
	try {
            statement = connection.prepareStatement("UPDATE anuncios SET nomeAnuncio = ?  SET dataInicial = ? SET dataTermino = ? WHERE id = ? AND investimentoDiario = ?");
            statement.setInt(1, anuncios.getId_Cliente());
            statement.setString(2, anuncios.getNomeAnuncio());
            statement.setDate(3, (Date) anuncios.getDataInicial());
            statement.setDate(4, (Date) anuncios.getDataTermino());
            statement.setFloat(5, anuncios.getInvestimentoDiario());    
			
            statement.executeUpdate();
			
            
            JOptionPane.showMessageDialog(null, " Atualizado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!"+ ex);
        }finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
	
    }
    
    public void delete(AnunciosModel anuncios) {
		
	try {
            statement = connection.prepareStatement("DELETE FROM anunciosModel nomeAnuncio = ?");
            statement.setString(1, anuncios.getNomeAnuncio());

            statement.executeUpdate();
		
            
            JOptionPane.showMessageDialog(null, anuncios.getNomeAnuncio() + "  deletado com sucesso!");
	} catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar!"+ ex);
	}finally {
            ConnectionFactory.closeConnection(connection, statement);
	}
	
    }
    
    
    public List<AnunciosModel>  read() {
	List<AnunciosModel> listaAnuncios = new ArrayList<>();
		
	try {
            statement = connection.prepareStatement("SELECT * FROM listaAnuncios");
            result = statement.executeQuery();
			
            while (result.next()) {
		AnunciosModel anuncios = new AnunciosModel();
				
		anuncios.setId_Cliente(result.getInt("id_cliente"));
		anuncios.setNomeAnuncio(result.getString("nomeAnuncio"));
		anuncios.setDataInicial(result.getDate("dataInicial"));
                anuncios.setDataTermino(result.getDate("dataTermino"));
                anuncios.setInvestimentoDiario(result.getFloat("investimentoDiario"));
            }  
            	
	} catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar anuncios!"+ ex);
	}finally {
            ConnectionFactory.closeConnection(connection, statement, result);
	}
	
        return listaAnuncios;
        
    }

    public Iterable<AnunciosModel> readFroNomeAnuncio(AnunciosModel nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
    
    
    

