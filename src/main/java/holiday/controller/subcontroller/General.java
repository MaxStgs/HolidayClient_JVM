package holiday.controller.subcontroller;

import holiday.Singleton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.SubScene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class General implements Initializable {
    public SubScene General_Subscene;
    public MenuBar General_MenuBar;
    public Menu MenuBar_Generals;
    public Menu MenuBar_Orders;
    public Menu MenuBar_Statements;
    public Menu MenuBar_Tasks;
    public Menu MenuBar_Cars;
    public Menu MenuBar_Users;
    public Menu MenuBar_Helps;
    public Menu MenuBar_Equipments;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Singleton.singleton.subscene = General_Subscene;
        Singleton.singleton.primaryStageUpdate();
        Singleton.singleton.loadSubsceneByName("Starter");



        Platform.runLater(() -> {
            hideAllMenus();
            showMenuBarByRole(Singleton.levelOfAccess);
        });

        System.out.println("General initialized");
    }

    private void hideAllMenus() {
//        for (Node node : ((HBox) General_MenuBar.getChildrenUnmodifiable().get(0)).getChildren()) {
//            node.setVisible(false);
//        }
        MenuBar_Generals.setVisible(false);
        MenuBar_Orders.setVisible(false);
        MenuBar_Statements.setVisible(false);
        MenuBar_Tasks.setVisible(false);
        MenuBar_Cars.setVisible(false);
        MenuBar_Users.setVisible(false);
        MenuBar_Helps.setVisible(false);
        System.out.println("General MenuBar hided");
    }

    private void showMenuBarByRole(String role) {
        switch (role) {
            case "admin":
                showMenuBarAdmin();
                break;
            case "user":
                showMenuBarUser();
                break;
            default:
                System.out.println("General.showMenubarByRole : Role not found, current Role : " + role);
                return;
        }
    }

    private void showMenuBarAdmin() {
        MenuBar_Generals.setVisible(true);
        MenuBar_Orders.setVisible(true);
        MenuBar_Statements.setVisible(true);
        MenuBar_Tasks.setVisible(true);
        MenuBar_Cars.setVisible(true);
        MenuBar_Users.setVisible(true);
        MenuBar_Helps.setVisible(true);
        System.out.println("Show MenuBar admin");
    }

    private void showMenuBarUser() {
        MenuBar_Generals.setVisible(true);
        MenuBar_Statements.setVisible(true);
        MenuBar_Helps.setVisible(true);
        System.out.println("Show MenuBar user");
    }

    public void MenuBar_Task_OpenWindow_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadSubsceneByName("Tasks");
    }

    public void MenuBar_Settings_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadSubsceneByName("Settings");
    }

    public void MenuBar_Combination_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadSubsceneByName("Combinations");
    }

    public void MenuBar_About_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.LoadInfo();
    }

    public void MenuBar_Exit_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadSceneByName("Auth");
    }

    public void MenuBar_Task_AddTask_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadWindowByName("Task", "Tasks", Singleton.EActionStates.Add, null);
    }

    public void MenuBar_Cars_OpenWindow_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadSubsceneByName("Cars");
    }

    public void MenuBar_Cars_AddCar_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadWindowByName("Car", "Cars", Singleton.EActionStates.Add, null);
    }

    public void MenuBar_Users_OpenWindow_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadSubsceneByName("Users");
    }

    public void MenuBar_Users_AddUser_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadWindowByName("User", "Users", Singleton.EActionStates.Add, null);
    }

    public void MenuBar_MakeOrder_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadWindowByName("Order", "Orders", Singleton.EActionStates.Add, null);
    }

    public void MenuBar_Orders_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadSubsceneByName("Orders");
    }

    public void MenuBar_MakeComing_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadWindowByName("Coming", "Statements", Singleton.EActionStates.Add, null);
    }

    public void MenuBar_MakeOut_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadWindowByName("Out", "Statements", Singleton.EActionStates.Add, null);
    }

    public void MenuBar_MakeOil_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadWindowByName("Oil", "Statements", Singleton.EActionStates.Add, null);
    }

    public void MenuBar_OpenStatement_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadSubsceneByName("Statements");
    }

    public void MenuBar_OpenEquipments_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadSubsceneByName("Equipments");
    }

    public void MenuBar_AddEquipment_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadWindowByName("Equipment", "Equipments", Singleton.EActionStates.Add, null);
    }
}
