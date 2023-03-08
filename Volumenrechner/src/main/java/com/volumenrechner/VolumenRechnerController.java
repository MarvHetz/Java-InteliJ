package com.volumenrechner;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class VolumenRechnerController implements Initializable
{

    @FXML
    private TextField txtHoehe;

    @FXML
    private TextField txtBriete;

    @FXML
    private TextField txtTiefe;

    @FXML
    private Slider sliderHoehe;

    @FXML
    private Slider sliderBreite;

    @FXML
    private Slider sliderTiefe;

    @FXML
    private TextField txtErgebnis;

    @FXML
    private Button btnPaketS;

    @FXML
    private Button btnPaketM;

    @FXML
    private Button btnPaketL;

    @FXML
    private Button btnPaketXL;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        StringConverter<? extends Number> converter = new DoubleStringConverter();
        Bindings.bindBidirectional(txtHoehe.textProperty(),sliderHoehe.valueProperty(),(StringConverter<Number>) converter);
        Bindings.bindBidirectional(txtTiefe.textProperty(),sliderTiefe.valueProperty(),(StringConverter<Number>) converter);
        Bindings.bindBidirectional(txtBriete.textProperty(),sliderBreite.valueProperty(),(StringConverter<Number>) converter);

        txtErgebnis.textProperty().bind(sliderHoehe.valueProperty().multiply(sliderBreite.valueProperty()).multiply(sliderTiefe.valueProperty()).asString("%.2f"));
    }
}