package holiday.controller.subcontroller;

import holiday.Singleton;
import io.swagger.client.ApiCallback;
import io.swagger.client.ApiException;
import io.swagger.client.api.EquipmentsApi;
import io.swagger.client.model.EquipmentDetails;
import io.swagger.client.model.ListOfEquipments;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Equipments implements Initializable {
    public GridPane Root;
    public VBox List;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clearWindow();
        loadAllEquipments();
    }

    private void clearWindow() {
        List.getChildren().remove(0, List.getChildren().size());
    }

    private void loadAllEquipments() {
        EquipmentsApi equipmentsApi = new EquipmentsApi();
        try {
            equipmentsApi.equipmentGetAsync(new ApiCallback<ListOfEquipments>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Equipments.loadAllEquipments onFailure Code:" + statusCode);
                    Singleton.singleton.callErrorDialog("Ошибка",
                            "Произошла ошибка во время загрузки списка оборудования",
                            "Код ошибки: " + statusCode);
                }

                @Override
                public void onSuccess(ListOfEquipments result, int statusCode, Map<String, List<String>> responseHeaders) {
                    List<EquipmentDetails> list = result.getList();
                    System.out.println("Equipments.loadAllEquipments " + list.size() + " equipments loaded");
                    for (EquipmentDetails details : list) {
                        Platform.runLater(() -> addEquipmentToScreen(details));
                    }
                }

                @Override
                public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {

                }

                @Override
                public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {

                }
            });
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    private void addEquipmentToScreen(EquipmentDetails details) {
        HBox hBox = new HBox();

        Label labelName = new Label();
        //labelName.setText(details)

        Label labelAmount = new Label();
        labelAmount.setText(details.getPrice().toString());
        labelAmount.setStyle(".label-middle");

        Button editButton = new Button();
        editButton.setText("Редактировать");
        editButton.setStyle(".button-middle");

        editButton.setOnAction(event ->
                Singleton.singleton.loadWindowByName(
                        "Equipment",
                        "Equipments",
                        Singleton.EActionStates.Edit,
                        details));

        hBox.getChildren().addAll(labelAmount, editButton);
        List.getChildren().add(hBox);
    }
}
