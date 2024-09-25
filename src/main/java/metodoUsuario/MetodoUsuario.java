package metodoUsuario;

import Modelo.ModeloUsuario;
import conexion.ConexionDB;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetodoUsuario {


    public ModeloUsuario obtenerUsuario(String usuario) {
        String sql = "SELECT * FROM usuarios WHERE BINARY usuario = ?";
        ModeloUsuario user = null;

        try (Connection connection = ConexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new ModeloUsuario(
                        new SimpleIntegerProperty(resultSet.getInt("id")),
                        new SimpleStringProperty(resultSet.getString("usuario")),
                        new SimpleStringProperty(resultSet.getString("clave"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }


    public boolean validarUsuario(String usuario, String clave) {
        ModeloUsuario user = obtenerUsuario(usuario);

        if (user != null) {
            return user.getClave().equals(clave);
        }

        return false;
    }
}

