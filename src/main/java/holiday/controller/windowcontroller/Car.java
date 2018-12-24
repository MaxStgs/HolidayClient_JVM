package holiday.controller.windowcontroller;

import holiday.Singleton;
import io.swagger.client.ApiCallback;
import io.swagger.client.ApiException;
import io.swagger.client.api.CarsApi;
import io.swagger.client.model.CarDetails;
import io.swagger.client.model.PostCarDetails;
import io.swagger.client.model.PutCarDetails;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Car implements Initializable {

    public Button Window_Car_Button_Action;
    public TextField Window_Car_TextField_RefMap;
    public TextField Window_Car_TextField_Brand;
    public TextField Window_Car_TextField_Model;
    public TextField Window_Car_TextField_GovNumber;
    public Button Window_Car_Button_Cancel;
    public GridPane Window_Car_GridPane_Root;
    private Singleton.EActionStates actionState;

    private CarDetails myData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*if(!Singleton.isActionObject(this))
            return;*/
        actionState = Singleton.getActionState();
        if(actionState == null)
            return;
        switch (actionState) {
            case Add:
                Window_Car_Button_Action.setText("Добавить");
                break;
            case Edit:
                Window_Car_Button_Action.setText("Сохранить");
                break;
            case Delete:
                Window_Car_Button_Action.setText("Del !allowed");
                break;
            default:
                Window_Car_Button_Action.setText("Unknowed Action");
                break;
        }

        CarDetails carDetails = (CarDetails)Singleton.getActionObjectData();

        if(carDetails == null) {
            System.out.println();
            new Alert(Alert.AlertType.ERROR, "Упс, объект не соответствует ожиданиям");
            return;
        }

        fillForm(carDetails);

//        Stage stage = (Stage) Window_User_GridPane_Root.getScene().getWindow();
//        stage.getIcons().add(new Image("../resources/icons/archive-edit.png"));
    }

    private void fillForm(CarDetails carDetails) {
        myData = carDetails;

        Window_Car_TextField_Brand.setText(carDetails.getMark());
        Window_Car_TextField_Model.setText(carDetails.getModel());
        Window_Car_TextField_GovNumber.setText(carDetails.getGovNumber());
        Window_Car_TextField_RefMap.setText(carDetails.getLinkToChip());
    }

    public void Window_Car_Button_OnAction(ActionEvent actionEvent) {
        switch (actionState) {
            case Add:
                addCar(constructPostCarDetails(constructCarDetails()));
                break;
            case Edit:
                editCar(constructPutCarDetails(constructCarDetails()));
                break;
            case Delete:
                break;
        }
    }

    private void addCar(PostCarDetails postCarDetails) {
        CarsApi carsApi = new CarsApi();
        try {
            carsApi.carsPostAsync(postCarDetails, new ApiCallback<Void>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Car.addCar onFailure Code: " + statusCode);
                }

                @Override
                public void onSuccess(Void result, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Car.addCar Code: " + statusCode);
                    closeAfterAction(true);
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

    private void editCar(PutCarDetails putCarDetails) {
        CarsApi carsApi = new CarsApi();
        try {
            carsApi.carsCarIdPutAsync(myData.getId(), putCarDetails, new ApiCallback<Void>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Car.editCar onFailure Code: " + statusCode);
                }

                @Override
                public void onSuccess(Void result, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Car.editCar Code: " + statusCode);
                    closeAfterAction(true);
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

    public void Window_Car_Button_Cancel_OnAction(ActionEvent actionEvent) {
        ((Stage)((Node) actionEvent.getTarget()).getScene().getWindow()).close();
    }

    private CarDetails constructCarDetails() {
        CarDetails carDetails = new CarDetails();

//        carDetails.setId(myData.getId());
        carDetails.setMark(Window_Car_TextField_Brand.getText());
        carDetails.setModel(Window_Car_TextField_Model.getText());
        carDetails.setGovNumber(Window_Car_TextField_GovNumber.getText());
        carDetails.setLinkToChip(Window_Car_TextField_RefMap.getText());

        return carDetails;
    }

    private PostCarDetails constructPostCarDetails(CarDetails carDetails) {
        PostCarDetails postCarDetails = new PostCarDetails();

        postCarDetails.setMark(carDetails.getMark());
        postCarDetails.setModel(carDetails.getModel());
        postCarDetails.setGovNumber(carDetails.getGovNumber());
        postCarDetails.setLinkToChip(carDetails.getLinkToChip());

        return postCarDetails;
    }

    private PutCarDetails constructPutCarDetails(CarDetails carDetails) {
        PutCarDetails putCarDetails = new PutCarDetails();

        putCarDetails.setMark(carDetails.getMark());
        putCarDetails.setModel(carDetails.getModel());
        putCarDetails.setGovNumber(carDetails.getGovNumber());
        putCarDetails.setLinkToChip(carDetails.getLinkToChip());

        return putCarDetails;
    }

    private void closeAfterAction(boolean needReload) {
        Platform.runLater(() -> {
            ((Stage)Window_Car_GridPane_Root.getScene().getWindow()).close();
            if(needReload) Singleton.singleton.reloadCurrentSubscene();
        });
    }
}
