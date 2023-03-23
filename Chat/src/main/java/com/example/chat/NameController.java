package com.example.chat;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class NameController
{
    @FXML
    private TextField txtName;

    @FXML
    private void setName() throws IOException {
        ApplicationClient.setName(txtName.getText());
        ApplicationClient.switchScene();
    }
}
