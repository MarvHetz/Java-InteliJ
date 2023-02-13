package com.example.fx1;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class HelloController implements Initializable
{
    @FXML
    private TextField txtZahl1;
    @FXML
    private TextField txtZahl2;
    @FXML
    private Label lblErgebnis;
    @FXML
    private ComboBox comboBoxOperatoren;
    @FXML
    private ListView listRechnungen;

    @FXML
    public void berechnen()
    {
        double zahl1 = Double.valueOf(txtZahl1.getText());
        double zahl2 = Double.valueOf(txtZahl2.getText());
        double ergebnis = 0;
        if ((char) comboBoxOperatoren.getValue() == '+')
        {
            ergebnis = zahl1 + zahl2;
        }
        else if ((char) comboBoxOperatoren.getValue() == '-')
        {
            ergebnis = zahl1 - zahl2;
        }
        else if ((char) comboBoxOperatoren.getValue() == '*')
        {
            ergebnis = zahl1 * zahl2;
        }
        else if ((char) comboBoxOperatoren.getValue() == '/')
        {
            ergebnis = zahl1 / zahl2;
        }

        DecimalFormat df = new DecimalFormat("0.00");

        lblErgebnis.setText(String.valueOf(df.format(ergebnis)));

        listRechnungen.getItems().add(String.valueOf(zahl1) +' ' + comboBoxOperatoren.getValue() + ' ' + zahl2 + " = " + df.format(ergebnis));
    }

    @FXML
    public void loeschen()
    {
        listRechnungen.getItems().remove(listRechnungen.getSelectionModel().getSelectedIndex());
    }

    @FXML
    public void loescheAlles()
    {
        listRechnungen.getItems().clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Character [] operatoren = {'+', '-', '*','/'};
        comboBoxOperatoren.getItems().addAll(operatoren);
    }
}