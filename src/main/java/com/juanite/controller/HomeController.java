package com.juanite.controller;

import com.juanite.App;
import com.juanite.model.Account;
import com.juanite.model.RepoAccount;
import com.juanite.util.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.Objects;

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
    private static Account account;

    public static void setAccount(Account account) {
        HomeController.account = account;
    }

    @FXML
    private void btnLoginValidate() throws IOException{

        if(txtfld_username.getText() != null && !Objects.equals(txtfld_username.getText(), "")){
            if(txtfld_password.getText() != null && !Objects.equals(txtfld_password.getText(), "")){
                account = RepoAccount.getInstance().searchAccount(txtfld_username.getText());
                if(account != null){
                    UserController.setAccount(account);
                    App.setRoot("user");
                }
            }
        }

    }
    @FXML
    private void btnSignupValidate() throws IOException{

        if(txtfld_username.getText() != null && Utils.validateUsername(txtfld_username.getText())){
            if(txtfld_password.getText() != null && Utils.validatePassword(txtfld_password.getText())){
                account = new Account(txtfld_username.getText(), txtfld_password.getText());
                if(!RepoAccount.getInstance().usedUsername(txtfld_username.getText())) {
                    if(RepoAccount.getInstance().getAccounts() != null) {
                        if (RepoAccount.getInstance().getAccounts().add(account)) {
                            UserController.setAccount(account);
                            App.setRoot("user");
                        }
                    }
                }
            }
        }

    }

}
