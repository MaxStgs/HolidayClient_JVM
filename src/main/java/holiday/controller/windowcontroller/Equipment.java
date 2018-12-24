package holiday.controller.windowcontroller;

import holiday.Singleton;
import io.swagger.client.model.EquipmentDetails;
import io.swagger.client.model.WorkerDetails;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.PrimitiveIterator;
import java.util.ResourceBundle;

public class Equipment implements Initializable {

    public Button Action;
    public TextField Name;
    public TextField Amount;
    public GridPane Root;
    private Singleton.EActionStates actionState;

    private EquipmentDetails myData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*if(!Singleton.isActionObject(this))
            return;*/
        actionState = Singleton.getActionState();
        if(actionState == null)
            return;
        switch (actionState) {
            case Add:
                Action.setText("Добавить");
                break;
            case Edit:
                Action.setText("Сохранить");
                break;
            case Delete:
                Action.setText("Del !allowed");
                break;
            default:
                Action.setText("Unknowed Action");
                break;
        }

        EquipmentDetails equipmentDetails = (EquipmentDetails) Singleton.getActionObjectData();

        if(equipmentDetails == null) {
            System.out.println();
            new Alert(Alert.AlertType.ERROR, "Упс, объект не соответствует ожиданиям");
            return;
        }

        fillForm(equipmentDetails);

//        Stage stage = (Stage) Window_User_GridPane_Root.getScene().getWindow();
//        stage.getIcons().add(new Image("../resources/icons/archive-edit.png"));
    }

    private void fillForm(EquipmentDetails equipmentDetails) {
        //Name.setText(equipmentDetails.getName());
        Amount.setText(equipmentDetails.getPrice().toString());
    }

    public void Action_OnAction(ActionEvent actionEvent) {
    }

    public void Cancel_OnAction(ActionEvent actionEvent) {
        closeAfterAction(false);
    }

    private void closeAfterAction(boolean needReload) {
        Platform.runLater(() -> {
            ((Stage)Root.getScene().getWindow()).close();
            if(needReload) Singleton.singleton.reloadCurrentSubscene();
        });
    }
}
