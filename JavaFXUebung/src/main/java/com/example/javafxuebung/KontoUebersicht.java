package com.example.javafxuebung;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ResourceBundle;

public class KontoUebersicht
{
    private static KontoUebersicht instance;
    @FXML
    private Label lblAccountOverview;

    @FXML
    private Label lblAccountNow;

    @FXML
    private Label lblCreditInterest;

    @FXML
    private Label lblAccountNowNumber;

    @FXML
    private Label lblCreditInterestNumber;

    @FXML
    private Button btnDeposit;

    @FXML
    private Button btnPayout;

    @FXML
    private TextField txtDeposit;

    @FXML
    private TextField txtPayout;


    public static KontoUebersicht getInstance()
    {
        return instance;
    }

    public void setLanguage()
    {
        ResourceBundle bundle = ResourceBundle.getBundle("Language", Language.getLocale());
    }
}
