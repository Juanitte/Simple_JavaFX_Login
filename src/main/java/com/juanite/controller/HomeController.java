package com.juanite.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

public class HomeController {

    @FXML
    public Label lbl_title;
    @FXML
    public Button btn_login;
    @FXML
    public Button btn_signup;
    @FXML
    public Label lbl_username;
    @FXML
    public TextField txtfld_username;
    @FXML
    public Label lbl_password;
    @FXML
    public TextField txtfld_password;
    @FXML
    public Rectangle shp_header;
    @FXML
    public Separator separator;

    @FXML
    private void btnLoginValidate() throws IOException{



    }

}
