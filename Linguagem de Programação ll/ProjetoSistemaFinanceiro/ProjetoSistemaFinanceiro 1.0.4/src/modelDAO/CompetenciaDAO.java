package modelDAO;

import ConnectionFactory.conexao;
import Model.Competencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompetenciaDAO {
    Connection con = conexao.getconexao();
    
    public boolean saveCompetencia(Competencia competencia) throws SQLException{
        Connection con = conexao.getconexao();
        String sql = "INSERT INTO competencia(data,gastos,saldo) VALUES (?,?,?)";

        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, competencia.getData());
            stmt.setFloat(2, competencia.getGastos());
            stmt.setFloat(3, competencia.getSaldo());
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
    public boolean atualizaCompetencia(Competencia competencia) throws SQLException{
        Connection con = conexao.getconexao();
        String sql = "UPDATE competencia SET data = ?, gastos = ?, saldo = ?";

        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, competencia.getData());
            stmt.setFloat(2, competencia.getGastos());
            stmt.setFloat(3, competencia.getSaldo());
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
    
    public void trazDadosDoBancoParaoSistema(ArrayList<Competencia> ListaCompetencia) throws SQLException{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM COMPETENCIA";
        
        stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            Competencia C = new Competencia(rs.getString(1),rs.getFloat(2),rs.getFloat(3));
            ListaCompetencia.add(C);   
        }
    }
    
}
