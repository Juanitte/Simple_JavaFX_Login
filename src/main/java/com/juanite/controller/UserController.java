package com.juanite.controller;

import com.juanite.App;
import com.juanite.model.Account;
import com.juanite.model.RepoAccount;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class UserController {

    @FXML
    public Button btn_edit;
    @FXML
    public Button btn_delete;
    @FXML
    public Button btn_submit;
    @FXML
    public Button btn_cancel;
    @FXML
    public Label lbl_username;
    @FXML
    public Label lbl_password;
    @FXML
    public Label lbl_email;
    @FXML
    public Label lbl_name;
    @FXML
    public Label lbl_surname;
    @FXML
    public Label lbl_country;
    @FXML
    public Label lbl_city;
    @FXML
    public Label lbl_bio;
    @FXML
    public TextField txtfld_username;
    @FXML
    public PasswordField txtfld_password;
    @FXML
    public TextField txtfld_email;
    @FXML
    public TextField txtfld_name;
    @FXML
    public TextField txtfld_surname;
    @FXML
    public TextField txtfld_country;
    @FXML
    public TextField txtfld_city;
    @FXML
    public TextArea txtfld_bio;
    @FXML
    public Separator separator;
    @FXML
    public Rectangle shp_header;
    @FXML
    public Label lbl_title;
    @FXML
    public Label lbl_usernameContent;
    @FXML
    public Label lbl_passwordContent;
    @FXML
    public Label lbl_emailContent;
    @FXML
    public Label lbl_nameContent;
    @FXML
    public Label lbl_surnameContent;
    @FXML
    public Label lbl_countryContent;
    @FXML
    public Label lbl_cityContent;
    @FXML
    public Label lbl_bioContent;
    public static Account account;

    public static void setAccount(Account account) {
        UserController.account = account;
    }
    public void initialize(){
        lbl_usernameContent.setText(account.getUsername());
        lbl_passwordContent.setText(account.getPassword());
        lbl_emailContent.setText(account.getEmail());
        lbl_nameContent.setText(account.getName());
        lbl_surnameContent.setText(account.getSurname());
        lbl_countryContent.setText(account.getCountry());
        lbl_cityContent.setText(account.getCity());
        lbl_bioContent.setText(account.getBio());
        txtfld_username.setText(account.getUsername());
        txtfld_password.setText(account.getPassword());
        txtfld_email.setText(account.getEmail());
        txtfld_name.setText(account.getName());
        txtfld_surname.setText(account.getSurname());
        txtfld_country.setText(account.getCountry());
        txtfld_city.setText(account.getCity());
        txtfld_bio.setText(account.getBio());
    }
    @FXML
    private void btnEditValidate() throws IOException{
        lbl_usernameContent.setVisible(false);
        txtfld_username.setVisible(true);
        lbl_passwordContent.setVisible(false);
        txtfld_password.setVisible(true);
        lbl_emailContent.setVisible(false);
        txtfld_email.setVisible(true);
        lbl_nameContent.setVisible(false);
        txtfld_name.setVisible(true);
        lbl_surnameContent.setVisible(false);
        txtfld_surname.setVisible(true);
        lbl_countryContent.setVisible(false);
        txtfld_country.setVisible(true);
        lbl_cityContent.setVisible(false);
        txtfld_city.setVisible(true);
        lbl_bioContent.setVisible(false);
        txtfld_bio.setVisible(true);
        btn_edit.setVisible(false);
        btn_delete.setVisible(false);
        btn_submit.setVisible(true);
        btn_cancel.setVisible(true);
    }
    @FXML
    private void btnDeleteValidate() throws IOException{
            App.setRoot("home");
            RepoAccount.getInstance().removeAccount(account);
    }
    @FXML
    private void btnCancelValidate() throws IOException{
        lbl_usernameContent.setVisible(true);
        txtfld_username.setVisible(false);
        lbl_passwordContent.setVisible(true);
        txtfld_password.setVisible(false);
        lbl_emailContent.setVisible(true);
        txtfld_email.setVisible(false);
        lbl_nameContent.setVisible(true);
        txtfld_name.setVisible(false);
        lbl_surnameContent.setVisible(true);
        txtfld_surname.setVisible(false);
        lbl_countryContent.setVisible(true);
        txtfld_country.setVisible(false);
        lbl_cityContent.setVisible(true);
        txtfld_city.setVisible(false);
        lbl_bioContent.setVisible(true);
        txtfld_bio.setVisible(false);
        btn_edit.setVisible(true);
        btn_delete.setVisible(true);
        btn_submit.setVisible(false);
        btn_cancel.setVisible(false);
    }
    @FXML
    private void btnSubmitValidate() throws IOException{
        if(txtfld_username.getText() != null && !txtfld_username.getText().equalsIgnoreCase("") && !txtfld_username.getText().equalsIgnoreCase(lbl_usernameContent.getText())){

        }
    }
}
