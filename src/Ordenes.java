import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ordenes {
    
    int folio, mesas_numero, alimentos_id;
    String fecha_hora, observaciones, silla, estadoo, clientes_codigoc, empleados_mesero, empleados_cocinero;

    public Ordenes(int folio, String fecha_hora, String observaciones, String silla, String estadoo, String clientes_codigoc, int mesas_numero, int alimentos_id, String empleados_mesero, String empleados_cocinero) {
        this.folio = folio;
        this.fecha_hora = fecha_hora;
        this.observaciones = observaciones;
        this.silla = silla;
        this.estadoo = estadoo;
        this.clientes_codigoc = clientes_codigoc;
        this.mesas_numero = mesas_numero;
        this.alimentos_id = alimentos_id;
        this.empleados_mesero = empleados_mesero;
        this.empleados_cocinero = empleados_cocinero;
    }
    
    //CRUD
    
    //INSERT-- CREATE  --C
    public int insertar(Connection con){
        int resultado = 0;
        try {
            String sql = "INSERT INTO ordenes (fecha_hora, observaciones, silla, estadoo, clientes_codigoc, mesas_numero, alimentos_id, empleados_mesero, empleados_cocinero) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fecha_hora);
            ps.setString(2, observaciones);
            ps.setString(3, silla);
            ps.setString(4, estadoo);
            ps.setString(5, clientes_codigoc);
            ps.setInt(6, mesas_numero);
            ps.setInt(7, alimentos_id);
            ps.setString(8, empleados_mesero);
            ps.setString(9, empleados_cocinero);
            
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
            String sql = "UPDATE ordenes SET fecha_hora = ?, observaciones = ?, silla = ?, estadoo = ?, clientes_codigoc = ?, mesas_numero = ?, alimentos_id = ?, empleados_mesero = ?, empleados_cocinero = ? WHERE folio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fecha_hora);
            ps.setString(2, observaciones);
            ps.setString(3, silla);
            ps.setString(4, estadoo);
            ps.setString(5, clientes_codigoc);
            ps.setInt(6, mesas_numero);
            ps.setInt(7, alimentos_id);
            ps.setString(8, empleados_mesero);
            ps.setString(9, empleados_cocinero);
            ps.setInt(10, folio);
            
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
            String sql = "DELETE FROM ordenes WHERE folio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, folio);
            
            return ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
}
