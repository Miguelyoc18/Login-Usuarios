package Modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class ModeloUsuario {

    private IntegerProperty id;
    private StringProperty usuario;
    private StringProperty clave;

    public ModeloUsuario(){
    }

    public ModeloUsuario(IntegerProperty id, StringProperty usuario, StringProperty clave) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getUsuario() {
        return usuario.get();
    }

    public StringProperty usuarioProperty() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario.set(usuario);
    }

    public String getClave() {
        return clave.get();
    }

    public StringProperty claveProperty() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave.set(clave);
    }
}
