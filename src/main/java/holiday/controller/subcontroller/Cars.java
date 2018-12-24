package holiday.controller.subcontroller;

import holiday.Singleton;
import io.swagger.client.ApiCallback;
import io.swagger.client.ApiException;
import io.swagger.client.api.CarsApi;
import io.swagger.client.model.CarDetails;
import io.swagger.client.model.ListOfCars;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Cars implements Initializable {
    public HBox Cars_HBox_HorizontalList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clearAllCars();
        loadAllCars();
        System.out.println("Cars initialized");
    }

    private void clearAllCars() {
        Cars_HBox_HorizontalList.getChildren().remove(0, Cars_HBox_HorizontalList.getChildren().size());
    }

    private void loadAllCars() {
        CarsApi carsApi = new CarsApi();
        try {
            carsApi.carsGetAsync(new ApiCallback<ListOfCars>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Cars.initialize.workersGetAsync onFailure");
                }

                @Override
                public void onSuccess(ListOfCars result, int statusCode, Map<String, List<String>> responseHeaders) {
                    List<CarDetails> carDetailsList = result.getList();
                    System.out.println("Cars.initialize.carsGetAsync " + carDetailsList.size() + " users loaded");
                    for(CarDetails carDetails: carDetailsList) {
                        Platform.runLater(() -> AddCarToScreen(carDetails));
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

    private void AddCarToScreen(CarDetails carDetails) {
        VBox vBox = new VBox();

        Label label = new Label();
        label.setText(carDetails.getMark() + " '" + carDetails.getModel() + "' " + carDetails.getGovNumber());
        label.setFont(Font.font(18));

        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();

        webView.setPrefHeight(Cars_HBox_HorizontalList.getHeight() * 0.9f);

        Button buttonEdit = new Button();
        buttonEdit.setText("Редактировать");
        buttonEdit.setOnAction(event -> handleEditOnAction(carDetails));

        Button buttonDelete = new Button();
        buttonDelete.setText("Удалить");
        buttonDelete.setOnAction(event -> handleDeleteOnAction(carDetails));

        engine.load("http://livegpstracks.com/aptracker.php?f=" + carDetails.getLinkToChip());

        vBox.getChildren().addAll(webView, label, buttonEdit, buttonDelete);

        Cars_HBox_HorizontalList.getChildren().add(vBox);
    }

    public void Cars_Button_AddCar_OnClicked(ActionEvent actionEvent) {
        Singleton.singleton.loadWindowByName("Car", "Cars", Singleton.EActionStates.Add, null);
    }

    public void Cars_Button_Update_OnClicked(ActionEvent actionEvent) {
        Singleton.singleton.loadSubsceneByName("Cars");
    }

    private void handleEditOnAction(CarDetails carDetails) {
        Singleton.singleton.loadWindowByName("Car", "Cars", Singleton.EActionStates.Edit, carDetails);
    }

    private void handleDeleteOnAction(CarDetails carDetails) {
        boolean result = Singleton.singleton.loadConfirmDialog("Подтверждение перехода",
                "Вы не сможете отменить это действие",
                "Я не придумал сюда контента");
    }
}
