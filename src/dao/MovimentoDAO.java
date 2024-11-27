/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Movimento;

/**
 *
 * @author IGORSANTOS
 */
public class MovimentoDAO {
    
public List<Movimento> ler() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Movimento> movimentos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM movimentos");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Movimento movimento = new Movimento();

            movimento.setId(rs.getInt("id")); // Define o ID
            movimento.setDataMovimento(rs.getTimestamp("data_movimento")); // Define a data do movimento
            movimento.setUsuarioId(rs.getInt("usuario_id")); // Define o ID do usuário
            movimento.setProdutoId(rs.getInt("produto_id")); // Define o ID do produto
            movimento.setQuantidade(rs.getInt("quantidade")); // Define a quantidade
            movimento.setValorTotal(rs.getDouble("valor_total")); // Define o valor total
            movimento.setTipo(rs.getString("tipo")); // Define o tipo de movimento
            
            movimentos.add(movimento); // Adiciona o objeto à lista
        }                     

        } catch (SQLException ex) {
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return movimentos;

    }
}
