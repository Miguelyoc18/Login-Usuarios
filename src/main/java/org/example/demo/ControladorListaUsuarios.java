package org.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import metodoUsuario.MetodoListaUsuario;
import Modelo.ModeloUsuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControladorListaUsuarios implements Initializable {

    ModeloUsuario modeloUsuario = new ModeloUsuario();

    @FXML
    private TableColumn<ModeloUsuario, String> TCClave;

    @FXML
    private TableColumn<ModeloUsuario, String> TCUsuarios;

    @FXML
    private TableView<ModeloUsuario> TVUsuarios;

    MetodoListaUsuario metodoListaUsuario = new MetodoListaUsuario();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<ModeloUsuario> usuarios = metodoListaUsuario.listaUsuarios();

        ObservableList<ModeloUsuario> listaObservable = FXCollections.observableArrayList(usuarios);

        TCUsuarios.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        TCClave.setCellValueFactory(new PropertyValueFactory<>("clave"));

        TVUsuarios.setItems(listaObservable);

    }
}
