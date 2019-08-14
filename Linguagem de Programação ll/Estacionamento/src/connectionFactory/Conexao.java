package connectionFactory;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {
    
    public Conexao() {
    }   
    
    public static java.sql.Connection getconexao(){
        java.sql.Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/estacionamento?useTimezone=true&serverTimezone=UTC","root","root");
            System.out.println("Conectado com sucesso!");
        }catch(SQLException e){
            System.out.println("Erro de conexão: " + e);
        }
        return conn;
    }
    
    public void getClose(java.sql.Connection con, PreparedStatement stmt) throws SQLException{
        con.close();
        stmt.close();
        
    }
    
}
