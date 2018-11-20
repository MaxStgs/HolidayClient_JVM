package holiday.controller;

import holiday.Singleton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class General implements Initializable {
    public Pane MainSubscene;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Singleton.singleton.Workspace = MainSubscene;
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

}
