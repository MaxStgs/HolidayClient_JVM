package holiday.controller;

import holiday.Singleton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.SubScene;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class General implements Initializable {
    public Pane MainSubscene;
    public SubScene General_Subscene;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Singleton.singleton.Workspace = MainSubscene;
        Singleton.singleton.subscene = General_Subscene;
        Singleton.singleton.primaryStageUpdate();
        Singleton.singleton.LoadSubsceneByName("Starter");
    }

    public void General_Button_Starter_OnClicked(ActionEvent actionEvent) {
        Singleton.singleton.LoadSubsceneByName("Starter");
    }

    public void General_Button_Task_OnClicked(ActionEvent actionEvent) {
        Singleton.singleton.LoadSubsceneByName("Task");
    }

    public void General_Button_Test_OnClicked(ActionEvent actionEvent) {
        Singleton.singleton.LoadSubsceneByName("Statement");
    }

    public void General_Button_Cars_OnClicked(ActionEvent actionEvent) {
        Singleton.singleton.LoadSubsceneByName("Cars");
    }

    public void MenuBar_Auto_OpenWindow(ActionEvent actionEvent) {
        Singleton.singleton.LoadSubsceneByName("Cars");
    }

    public void MenuBar_Task_OpenWindow(ActionEvent actionEvent) {
        Singleton.singleton.LoadSubsceneByName("Task");
    }

    public void MenuBar_Settings(ActionEvent actionEvent) {
        Singleton.singleton.LoadSubsceneByName("Settings");
    }

    public void MenuBar_Combination(ActionEvent actionEvent) {
        Singleton.singleton.LoadSubsceneByName("Combinations");
    }

    public void MenuBar_About(ActionEvent actionEvent) {
        Singleton.singleton.LoadInfo();
    }

    public void MenuBar_Exit(ActionEvent actionEvent) {
        Singleton.singleton.LoadSceneByName("Auth");
    }
}
