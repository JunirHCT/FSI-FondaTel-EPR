import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Clientes {
    
    String codigoc, nombrec, rfc;

    public Clientes(String codigoc, String nombrec, String rfc) {
        this.codigoc = codigoc;
        this.nombrec = nombrec;
        this.rfc = rfc;
    }
    
    //CRUD
    
    //INSERT-- CREATE  --C
    public int insertar(Connection con){
        int resultado = 0;
        try {
            String sql = "INSERT INTO clientes VALUES(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigoc);
            ps.setString(2, nombrec);
            ps.setString(3, rfc);
            
            return ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
    
    //READ, No Necesario --R
    
    //UPDATE             --U
    public int actualizar(Connection con){
        int resultado = 0;
        try { 
            String sql = "UPDATE clientes SET nombrec = ?, rfc = ? WHERE codigoc = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombrec);
            ps.setString(2, rfc);
            ps.setString(3, codigoc);
            
            return ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
    
    //DELETE             --D
    public int borrar(Connection con){
        int resultado = 0;
        try {
            String sql = "DELETE FROM clientes WHERE codigoc = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigoc);
            
            return ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
}
