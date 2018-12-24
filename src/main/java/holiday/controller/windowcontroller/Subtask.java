package holiday.controller.windowcontroller;

import holiday.Singleton;
import io.swagger.client.model.SubtaskDetails;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Subtask implements Initializable {
    public TextField Window_Subtask_TextField_Desc;
    public Button Window_Subtask_Button_Action;
    public Button Window_Car_Button_Cancel;
    public CheckBox Window_Subtask_CheckBox_Status;
    public GridPane Window_Subtask_GridPane_Root;

    private Singleton.EActionStates actionState;

    private SubtaskDetails myData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*if(!Singleton.isActionObject(this))
            return;*/
        actionState = Singleton.getActionState();
        if(actionState == null)
            return;
        switch (actionState) {
            case Add:
                Window_Subtask_Button_Action.setText("Добавить");
                break;
            case Edit:
                Window_Subtask_Button_Action.setText("Сохранить");
                break;
            case Delete:
                Window_Subtask_Button_Action.setText("Del !allowed");
                break;
            default:
                Window_Subtask_Button_Action.setText("Unknowed Action");
                break;
        }

        SubtaskDetails subtaskDetails = (SubtaskDetails)Singleton.getActionObjectData();

        if(subtaskDetails == null) {
            System.out.println();
            new Alert(Alert.AlertType.ERROR, "Упс, объект не соответствует ожиданиям");
            return;
        }

        fillForm(subtaskDetails);

//        Stage stage = (Stage) Window_User_GridPane_Root.getScene().getWindow();
//        stage.getIcons().add(new Image("../resources/icons/archive-edit.png"));
    }

    private void fillForm(SubtaskDetails subtaskDetails) {
        myData = subtaskDetails;

        Window_Subtask_TextField_Desc.setText(subtaskDetails.getDescription());
        Window_Subtask_CheckBox_Status.setSelected(subtaskDetails.isStatus());
    }

    public void Window_Subtask_Button_OnAction(ActionEvent actionEvent) {
        switch (actionState) {
            case Add:
                //addSubtask(constructPostSubtaskDetails());
                break;
            case Edit:
                editSubtask(constructPutSubtaskDetails());
                break;
            case Delete:
                break;
        }
    }

    public void Window_Car_Button_Cancel_OnAction(ActionEvent actionEvent) {
        closeAfterAction(false);
    }

    private SubtaskDetails constructPutSubtaskDetails() {
        return null;
    }

    private void editSubtask(SubtaskDetails subtaskDetails) {
        myData.setStatus(Window_Subtask_CheckBox_Status.isSelected());
        closeAfterAction(false);
    }

    private void closeAfterAction(boolean needReload) {
        Platform.runLater(() -> {
            ((Stage)Window_Subtask_GridPane_Root.getScene().getWindow()).close();
            if(needReload) Singleton.singleton.reloadCurrentSubscene();
        });
    }
}
