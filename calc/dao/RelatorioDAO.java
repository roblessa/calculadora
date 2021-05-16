
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import model.RelatorioModel;


public class RelatorioDAO {
    Connection connection = ConnectionFactory.getConnection();
    PreparedStatement statement = null;

    public void create(RelatorioModel relatorio) {


        try {
            statement = connection.prepareStatement("INSERT INTO Anuncio (totalInvestido, maximoViews, maximoCLiques, maximoShares, id_cliente)VALUES(?, ?, ?, ?, ?)");

            statement.setFloat(1, relatorio.getTotalInvestido());
            statement.setInt(2, relatorio.getMaximoViews());
            statement.setInt(3, relatorio.getMaximoCliques());
            statement.setInt(4, relatorio.getMaximoShares());
            statement.setInt(5, relatorio.getId_Cliente());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    
    public List<Relatorio> read() {

        Connection connection = null;

        PreparedStatement statement = null;

        ResultSet rs = null;

        List<Relatorio> mostrarRelatorio = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement("SELECT * FROM Relatorio");
            rs = statement.executeQuery();

            while (ResultSet.next()) {

                Relatorio relatorio = new Relatorio();

                relatorio.setTotalInvestido(rs.getFloat("TotalInvestido"));
                relatorio.setMaximoViews(rs.getInt("maximoViews"));
                relatorio.setMaximoCliques(rs.getInt("maximoCliques"));
                relatorio.setMaximoShares(rs.getInt("MaximoShares"));
                //relatorio.setNomeAnuncio(rs.getInt("anuncioNomeAnuncio"));
                mostrarRelatorio.add(relatorio);

            }
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, rs);
        }

        return mostrarRelatorio;

    }
}

