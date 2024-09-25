package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import metodoUsuario.MetodoUsuario;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginControlador implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUser;


    @FXML
    void eventAction(ActionEvent event) {
        MetodoUsuario metodoUsuario = new MetodoUsuario();
        Object evt = event.getSource();

        if (evt == btnLogin) {
            String usuario = txtUser.getText();
            String clave = txtPassword.getText();


            if (!usuario.isEmpty() && !clave.isEmpty()) {

                boolean isValid = metodoUsuario.validarUsuario(usuario, clave);

                if (isValid) {
                    JOptionPane.showMessageDialog(null, "¡Bienvenido!", "Acceso permitido", JOptionPane.INFORMATION_MESSAGE);
                    abrirListaUsuarios();
                } else {

                    JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese usuario y contraseña", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void abrirListaUsuarios(){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(LoginControlador.class.getResource("ventanaListaUsuarios.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        txtUser.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.contains(" ")) {
                System.out.println("Espacio detectado en txtUser, eliminando espacio.");
                txtUser.setText(newValue.replace(" ", ""));
            }
        });


        txtPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.contains(" ")) {
                System.out.println("Espacio detectado en txtPassword, eliminando espacio.");
                txtPassword.setText(newValue.replace(" ", ""));
            }
        });
    }
}