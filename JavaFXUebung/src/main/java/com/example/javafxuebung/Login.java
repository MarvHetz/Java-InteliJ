package com.example.javafxuebung;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class Login implements Initializable
{
    @FXML
    private Label lblWelcome;

    @FXML
    private Label lblLanguage;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private ComboBox comboBoxLanguage;

    private int tries;

    @FXML
    private void onLogin()
    {
        System.out.println("Test");
        if (tries < 3)
        {
            if (loginPruefen(txtUsername.getText(), txtPassword.getText()))
            {
                DialogPane dialogPane = new DialogPane();
                dialogPane.setContentText("Login erfolgreich!");
                dialogPane.setVisible(true);
                System.out.println("Login erfolgreich!");

                Uebung.getStage().setScene(Uebung.getKontoUebersichtScene());
            }
            else
            {
                DialogPane dialogPane = new DialogPane();
                dialogPane.setContentText("Login fehlgeschlagen!");
                dialogPane.setVisible(true);
                System.out.println("Login fehlgeschlagen!");
                tries++;
            }
        }
        else
        {
            System.out.println("Zu viele Loginversuche!");
        }
    }

    @FXML
    private void languageSelection()
    {
        if (comboBoxLanguage.getValue().equals("Deutsch"))
        {
            Language.setLocale(new Locale("de", "DE"));
            ResourceBundle.getBundle("Language", Language.getLocale());

        }
        else if (comboBoxLanguage.getValue().equals("English"))
        {
            Language.setLocale(new Locale("en", "US"));
            ResourceBundle.getBundle("Language", Language.getLocale());
        }
        changeLanguage();

    }

    @FXML
    private void changeLanguage()
    {
        ResourceBundle bundle = ResourceBundle.getBundle("Language", Language.getLocale());
        lblWelcome.setText(bundle.getString("lblWelcome"));
        lblLanguage.setText(bundle.getString("lblLanguage"));
        lblUsername.setText(bundle.getString("lblUsername"));
        lblPassword.setText(bundle.getString("lblPassword"));
        btnLogin.setText(bundle.getString("btnLogin"));
    }

    private boolean loginPruefen(String username, String password)
    {
        return username.equals("admin") && password.equals("admin");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ObservableList<String> languages = FXCollections.observableArrayList("Deutsch", "English");
        comboBoxLanguage.setItems(languages);
        Language.setLocale(new Locale("de", "DE"));
        ResourceBundle.getBundle("Language", Language.getLocale());
        changeLanguage();
        tries = 0;
    }
}