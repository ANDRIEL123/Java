package modelDAO;

import ConnectionFactory.conexao;
import Model.Competencia;
import Model.Contas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContasDAO {
    Connection con = conexao.getconexao();
    
    public boolean saveConta(Contas contas) throws SQLException{
        Connection con = conexao.getconexao();
        String sql = "INSERT INTO contas(descricao,valor,dataHora,competencia,pago) VALUES (?,?,?,?,?)";

        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, contas.getDescricao());
            stmt.setDouble(2, contas.getValor());
            stmt.setString(3, contas.getDataHora());
            stmt.setString(4, contas.getData());
            stmt.setString(5, contas.getPago());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro de inclusão: " + ex);
            return false;
        }finally{
            conexao c = new conexao();
            c.getClose(con, stmt);
        }
    }
    
    public void trazDadosDoBancoParaoSistemaContas(ArrayList<Contas> ListaContas) throws SQLException{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM CONTAS";
        
        stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            Contas C = new Contas(rs.getString(1),rs.getFloat(2),rs.getString(3),rs.getString(4),rs.getString(5));
            ListaContas.add(C);   
        }
    }
    
    
    
}
