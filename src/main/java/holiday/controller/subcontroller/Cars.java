package holiday.controller.subcontroller;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.CarsApi;
import io.swagger.client.model.CarDetails;
import io.swagger.client.model.ListOfCars;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

        loadCars();
    }

    private void addCarInfo(CarDetails details) {
        VBox vBox = new VBox();

        Label label = new Label();
        label.setText(details.getMark() + details.getModel() + details.getGovNumber());

        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();

        engine.load("http://livegpstracks.com/aptracker.php?f=" + details.getLinkToChip());

        vBox.getChildren().addAll(webView, label);

        Cars_HBox_HorizontalList.getChildren().add(vBox);
    }

    private void loadCars() {
        CarsApi api = new CarsApi();
        try {
            api.carsGetAsync(new ApiCallback<ListOfCars>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Cars.loadCars.onFailure Code:" + String.valueOf(statusCode));
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
        }
    }
}
