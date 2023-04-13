package com.juanite.controller;

import com.juanite.App;
import com.juanite.model.Account;
import com.juanite.model.RepoAccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Optional;

public class AdminControlPanelController {

    @FXML
    public Button btn_admin;
    @FXML
    public Button btn_back;
    @FXML
    public Button btn_edit;
    @FXML
    public Button btn_show;
    @FXML
    public Button btn_ban;
    @FXML
    public Button btn_delete;
    @FXML
    public ListView lv_userList;
    private ObservableList<Account> observableList;

    @FXML
    private void initialize() {
        observableList = FXCollections.observableArrayList(RepoAccount.getInstance().getAccounts());
        lv_userList.setItems(observableList);
        lv_userList.setCellFactory(param -> new ListCell<Account>() {
            @Override
            protected void updateItem(Account account, boolean empty) {
                super.updateItem(account, empty);

                if (empty || account == null) {
                    setText(null);
                } else {
                    setText(account.getUsername());
                }
            }
        });
    }
    @FXML
    private void btnBackValidate() throws IOException {
        App.setRoot("admin");
    }
    @FXML
    private void btnEditValidate() throws IOException{
        Account selectedAccount = ((Account)lv_userList.getSelectionModel().getSelectedItem());
        if (selectedAccount != null && !selectedAccount.isAdmin()) {
            EditUserController.setAccount(selectedAccount);
            App.setRoot("edituser");
        }
    }
    @FXML
    private void btnShowValidate() throws IOException{
        Account selectedAccount = ((Account)lv_userList.getSelectionModel().getSelectedItem());
        if (selectedAccount != null && !selectedAccount.isAdmin()) {
            ShowUserController.setAccount(selectedAccount);
            App.setRoot("showuser");
        }
    }
    @FXML
    private void btnBanValidate() {
        Account selectedAccount = ((Account)lv_userList.getSelectionModel().getSelectedItem());
        if (selectedAccount != null && !selectedAccount.isAdmin()) {
            if(selectedAccount.isBanned()){
                selectedAccount.setBanned(false);
            }else{
                selectedAccount.setBanned(true);
            }
            RepoAccount.getInstance().getAccounts().add(selectedAccount);
            initialize();
        }
    }
    @FXML
    private void btnDeleteValidate() {
        Account selectedAccount = ((Account)lv_userList.getSelectionModel().getSelectedItem());
        if (selectedAccount != null && !selectedAccount.isAdmin()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm deletion");
            alert.setHeaderText("Are you sure?");
            alert.setContentText("This action cannot be reverted.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                RepoAccount.getInstance().getAccounts().remove(selectedAccount);
                ObservableList<Object> observableList = FXCollections.observableArrayList(RepoAccount.getInstance().getAccounts());
                lv_userList.setItems(observableList);
            }
        }
    }
}
