package holiday.controller.windowcontroller;

import holiday.Singleton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Task implements Initializable {

    public GridPane Window_Task_GridPane_Root;
    public Button Window_User_Button_Action;
    public Button Window_User_Button_Cancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void Window_User_Button_OnAction(ActionEvent actionEvent) {
    }

    public void Window_User_Button_Cancel_OnAction(ActionEvent actionEvent) {
        closeAfterAction(false);
    }

    private void closeAfterAction(boolean needReload) {
        Platform.runLater(() -> {
            ((Stage)Window_Task_GridPane_Root.getScene().getWindow()).close();
            if(needReload) Singleton.singleton.reloadCurrentSubscene();
        });
    }
}
