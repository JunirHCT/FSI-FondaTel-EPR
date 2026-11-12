import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class Alimentos {
    
    int id; //para UPDATE Y DELETE
    String nombre, descripcion, categoria, estadoa;
    float precio;
   ImageIcon foto;

    public Alimentos(String nombre, String descripcion, float precio, ImageIcon foto, String categoria, String estadoa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
        this.categoria = categoria;
        this.estadoa = estadoa;
    }
    
    //Constructor para UPDATE Y DELATE
    public Alimentos(int id, String nombre, String descripcion, float precio, ImageIcon foto, String categoria, String estadoa) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
        this.categoria = categoria;
        this.estadoa = estadoa;
    }
    //CRUD
    
    //INSERT-- CREATE  --C
    public int insertar(Conexion cnx){
        try {
            // No insertamos el ID porque es AUTO_INCREMENT
            String sql = "INSERT INTO alimentos (nombre, descripcion, precio, foto, categoria, estadoa) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cnx.con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setFloat(3, precio);
            ps.setBinaryStream(4, cnx.ImagenBytes(foto));
            ps.setString(5, categoria);
            ps.setString(6, estadoa);
            
            return ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }
    
    //UPDATE
    public int actualizar(Conexion cnx){
        try { 
            String sql = "UPDATE alimentos SET nombre = ?, descripcion = ?, precio = ?, foto = ?, categoria = ?, estadoa = ? WHERE id = ?";
            PreparedStatement ps = cnx.con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setFloat(3, precio);
            ps.setBinaryStream(4, cnx.ImagenBytes(foto)); // Reutilizando tu método de conversión
            ps.setString(5, categoria);
            ps.setString(6, estadoa);
            ps.setInt(7, id); // Usamos el ID del objeto
            
            return ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return 0;
        }
    }
    
    //DELETE
    public int borrar(Conexion cnx, int idABorrar){
        try {
            String sql = "DELETE FROM alimentos WHERE id = ?";
            PreparedStatement ps = cnx.con.prepareStatement(sql);
            ps.setInt(1, idABorrar);
            
            return ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error al borrar: " + e.getMessage());
            return 0;
        }
    }
    
}