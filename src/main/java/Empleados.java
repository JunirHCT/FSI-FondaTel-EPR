import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Lalo_p
public class Empleados {
    
    String codigo, nombre, puesto, turno, nom_user, nip, estado;

    public Empleados(String codigo, String nombre, String puesto, String turno, String nom_user, String nip, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.puesto = puesto;
        this.turno = turno;
        this.nom_user = nom_user;
        this.nip = nip;
        this.estado = estado;
    }
    
    //CRUD
    
    //INSERT-- CREATE  --C
    public int insertar(Connection con){
        int resulato = 0;
        try {
            String sql = "INSERT INTO usuarios VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.setString(2, nombre);
            ps.setString(3, puesto);
            ps.setString(4, turno);
            ps.setString(5, nom_user);
            ps.setString(6, nip);
            ps.setString(7, estado);
            
            return ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return resulato;
        }
        
    }
    
    //READ, No Nesesario --R
    
    //UPDATE             --U
    public int actualizar(Connection con){
        int resultado = 0;
        try { 
            String sql = "UPDATE empleados SET nombree = ?, puesto = ?, turno = ?, nom_usr = ?, nip = ?, estadoe = ? WHERE codigo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, puesto);
            ps.setString(3, turno);
            ps.setString(4, nom_user);
            ps.setString(5, nip);
            ps.setString(6, estado);
            ps.setString(7, codigo);
            
            return ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
    
    //DELETE            --D
    public int borrar(Connection con){
        int resultado = 0;
        try {
            String sql = "DELETE FROM empleados WHERE codigo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            
            return ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
    
}
