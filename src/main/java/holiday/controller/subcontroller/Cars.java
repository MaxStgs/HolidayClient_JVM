package holiday.controller.subcontroller;

import holiday.Singleton;
import io.swagger.client.ApiCallback;
import io.swagger.client.ApiException;
import io.swagger.client.api.CarsApi;
import io.swagger.client.model.CarDetails;
import io.swagger.client.model.ListOfCars;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    public WebView Cars_WebView_Test;
    public HBox Cars_HBox_HorizontalList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(loadCars() == 1) {
            testCar();
        }
    }

    private void testCar() {
        CarDetails car1, car2;

        car1 = new CarDetails();
        car1.setId(12);
        car1.setLinkToChip("test");
        car1.setMark("Nissan");
        car1.setModel("Hello");
        car1.setGovNumber("PARA333");
        Platform.runLater(() -> addCarInfo(car1));

        car2 = new CarDetails();
        car2.setId(99);
        car2.setLinkToChip("test2");
        car2.setMark("BMW");
        car2.setModel("Witcher");
        car2.setGovNumber("Witch999");
        Platform.runLater(() -> addCarInfo(car2));
    }

    private void addCarInfo(CarDetails details) {
        VBox vBox = new VBox();

        Label label = new Label();
        label.setText(details.getMark() + " '" + details.getModel() + "' " + details.getGovNumber());
        label.setFont(Font.font(18));

        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();

        webView.setPrefHeight(Cars_HBox_HorizontalList.getHeight() * 0.9f);

        Button button = new Button();
        button.setText("Редактировать");
        button.setOnAction(event -> {
            handleEditCar(details.getId());
        });

        engine.load("http://livegpstracks.com/aptracker.php?f=" + details.getLinkToChip());

        vBox.getChildren().addAll(webView, label, button);

        Cars_HBox_HorizontalList.getChildren().add(vBox);
    }

    private int loadCars() {
        CarsApi api = new CarsApi();
        try {
            api.carsGetAsync(new ApiCallback<ListOfCars>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Cars.loadCars.onFailure Code:" + String.valueOf(statusCode));
                    testCar();
                }

                @Override
                public void onSuccess(ListOfCars result, int statusCode, Map<String, List<String>> responseHeaders) {
                    List<CarDetails> list = result.getList();
                    System.out.println("Cars.loadCars.onSuccess Count:" + list.size());
                    for (CarDetails aList : list) {
                        Platform.runLater(() -> addCarInfo(aList));
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
            //e.printStackTrace();
            System.out.println("Cars.loadCars Exception: " + e.getMessage());
            return 1;
        }
        return 0;
    }

    private void handleEditCar(int carId) {
        System.out.println("Hello, it is Cars.handleEditCar(" + carId + ")");
    }

    public void Cars_Button_AddCar_OnClicked(ActionEvent actionEvent) {

    }

    public void Cars_Button_Update_OnClicked(ActionEvent actionEvent) {
        Singleton.singleton.LoadSubsceneByName("Cars");
    }
}
