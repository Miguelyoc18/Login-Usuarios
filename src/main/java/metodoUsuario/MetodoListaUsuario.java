package metodoUsuario;

import Modelo.ModeloUsuario;
import conexion.ConexionDB;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MetodoListaUsuario {

   public List<ModeloUsuario> listaUsuarios(){
       List<ModeloUsuario> listaUsuarios = new ArrayList<>();

       try{
           Connection conexion = ConexionDB.obtenerConexion();
           Statement statement = conexion.createStatement();
           ResultSet rs = statement.executeQuery("SELECT * FROM usuarios");

           while (rs.next()){
                ModeloUsuario usuario = dameEntidadResultSet(rs);
                if (usuario != null){
                    listaUsuarios.add(usuario);
                }
           }
       } catch (SQLException e) {
           System.out.println("Error al obtener lista usuarios: " + e.getMessage());
       }
       return listaUsuarios;
   }





    private ModeloUsuario dameEntidadResultSet(ResultSet rs){
        try{
                IntegerProperty id = new SimpleIntegerProperty(rs.getInt("id"));
                StringProperty usuario = new SimpleStringProperty(rs.getString("usuario"));
                StringProperty clave = new SimpleStringProperty(rs.getString("clave"));
                return new ModeloUsuario(id, usuario, clave);
        } catch (SQLException e){
            System.out.println("Error al crear el resultset: " + e.getMessage());
        }
        return null;
    }
}
