import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class Alimentos {
    
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
    
    //READ, No Necesario --R
    
//    //UPDATE             --U
//    public int actualizar(Connection con){
//        int resultado = 0;
//        try { 
//            String sql = "UPDATE alimentos SET nombre = ?, descripcion = ?, precio = ?, foto = ?, categoria = ?, estadoa = ? WHERE id = ?";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, nombre);
//            ps.setString(2, descripcion);
//            ps.setFloat(3, precio);
//            ps.setBytes(4, foto);
//            ps.setString(5, categoria);
//            ps.setString(6, estadoa);
//            ps.setInt(7, id);
//            
//            return ps.executeUpdate();
//            
//        } catch (SQLException e) {
//            System.out.println("Error: " + e.getMessage());
//            return resultado;
//        }
//    }
//    
//    //DELETE             --D
//    public int borrar(Connection con){
//        int resultado = 0;
//        try {
//            String sql = "DELETE FROM alimentos WHERE id = ?";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            
//            return ps.executeUpdate();
//            
//        } catch (SQLException e) {
//            System.out.println("Error: " + e.getMessage());
//            return resultado;
//        }
//    }
}