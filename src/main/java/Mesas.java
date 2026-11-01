import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Mesas {
    
    int numero, capacidad;
    String estado;

    public Mesas(int numero, String estado, int capacidad) {
        this.numero = numero;
        this.estado = estado;
        this.capacidad = capacidad;
    }
    
    //CRUD
    
    //INSERT-- CREATE  --C
    public int insertar(Connection con){
        int resultado = 0;
        try {
            String sql = "INSERT INTO mesas VALUES(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numero);
            ps.setString(2, estado);
            ps.setInt(3, capacidad);
            
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
            String sql = "UPDATE mesas SET estado = ?, capacidad = ? WHERE numero = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, capacidad);
            ps.setInt(3, numero);
            
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
            String sql = "DELETE FROM mesas WHERE numero = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numero);
            
            return ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
}