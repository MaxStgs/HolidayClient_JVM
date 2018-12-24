package holiday.controller.windowcontroller;

import holiday.Singleton;
import io.swagger.client.ApiCallback;
import io.swagger.client.ApiException;
import io.swagger.client.api.WorkersApi;
import io.swagger.client.model.PostWorkerDetails;
import io.swagger.client.model.PutWorkerDetails;
import io.swagger.client.model.WorkerDetails;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class User implements Initializable {

    public Button Window_User_Button_Action;
    public TextField Window_User_TextField_FullName;
    public TextField Window_User_TextField_Login;
    public TextField Window_User_TextField_Password;
    public TextField Window_User_TextField_Phone;
    public ColorPicker Window_User_ColorPicker_Color;
    public Button Window_User_Button_Cancel;
    public TextArea Window_User_TextArea_PassData;
    public TextField Window_User_TextField_Role;
    public GridPane Window_User_GridPane_Root;

    private Singleton.EActionStates actionState;

    private WorkerDetails myData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*if(!Singleton.isActionObject(this))
            return;*/
        actionState = Singleton.getActionState();
        if(actionState == null)
            return;
        switch (actionState) {
            case Add:
                Window_User_Button_Action.setText("Добавить");
                break;
            case Edit:
                Window_User_Button_Action.setText("Сохранить");
                break;
            case Delete:
                Window_User_Button_Action.setText("Del !allowed");
                break;
            default:
                Window_User_Button_Action.setText("Unknowed Action");
                break;
        }

        WorkerDetails workerDetails = (WorkerDetails)Singleton.getActionObjectData();

        if(workerDetails == null) {
            System.out.println();
            new Alert(Alert.AlertType.ERROR, "Упс, объект не соответствует ожиданиям");
            return;
        }

        fillForm(workerDetails);

//        Stage stage = (Stage) Window_User_GridPane_Root.getScene().getWindow();
//        stage.getIcons().add(new Image("../resources/icons/archive-edit.png"));
    }

    public void Window_User_Button_OnAction(ActionEvent actionEvent) {
        switch (actionState) {
            case Add:
                addUser(constructPostWorkerDetails());
                break;
            case Edit:
                editUser(constructPutWorkerDetails());
                break;
            case Delete:
                break;
        }
    }

    public void Window_User_Button_Cancel_OnAction(ActionEvent actionEvent) {
        ((Stage)((Node) actionEvent.getTarget()).getScene().getWindow()).close();
    }

    private void fillForm(WorkerDetails details) {
        myData = details;

        Window_User_TextField_FullName.setText(details.getName());
        Window_User_TextField_Login.setText(details.getLogin());
        Window_User_TextField_Password.setText(details.getPassword());
        Window_User_TextField_Phone.setText(details.getPhone());
        try {
            Window_User_ColorPicker_Color.setValue(Color.valueOf(details.getColor()));
        } catch (Exception ignored) {

        }
        Window_User_TextField_Role.setText(details.getRole());
        Window_User_TextArea_PassData.setText(details.getPassportData());
    }

    private PostWorkerDetails constructPostWorkerDetails() {
        PostWorkerDetails postWorkerDetails = new PostWorkerDetails();
        postWorkerDetails.setName(Window_User_TextField_FullName.getText());
        postWorkerDetails.setColor(
                Integer.toHexString(Window_User_ColorPicker_Color.getValue().hashCode()).substring(0, 6)
        );
        postWorkerDetails.setLogin(Window_User_TextField_Login.getText());
        postWorkerDetails.setPassword(Window_User_TextField_Password.getText());
        postWorkerDetails.setPassportData(Window_User_TextArea_PassData.getText());
        postWorkerDetails.setPhone(Window_User_TextField_Phone.getText());
        postWorkerDetails.setRating(0.0f);
        postWorkerDetails.setRole(Window_User_TextField_Role.getText());
        postWorkerDetails.setPhoto(null);
        return postWorkerDetails;
    }

    private PutWorkerDetails constructPutWorkerDetails() {
        PutWorkerDetails putWorkerDetails = new PutWorkerDetails();
        putWorkerDetails.setName(Window_User_TextField_FullName.getText());
        putWorkerDetails.setColor(
                Integer.toHexString(Window_User_ColorPicker_Color.getValue().hashCode()).substring(0, 6)
        );
        putWorkerDetails.setLogin(Window_User_TextField_Login.getText());
        putWorkerDetails.setPassword(Window_User_TextField_Password.getText());
        putWorkerDetails.setPassportData(Window_User_TextArea_PassData.getText());
        putWorkerDetails.setPhone(Window_User_TextField_Phone.getText());
        putWorkerDetails.setRating(0.0f);
        putWorkerDetails.setRole(Window_User_TextField_Role.getText());
        putWorkerDetails.setPhoto(null);
        return putWorkerDetails;
    }

    private void addUser(PostWorkerDetails postWorkerDetails) {
        WorkersApi api = new WorkersApi();
        try {
            api.workersPostAsync(postWorkerDetails, new ApiCallback<Void>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("User.addUser onFailure Code: " + statusCode);
                }

                @Override
                public void onSuccess(Void result, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("User.addUser Code: " + statusCode);
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

    private void editUser(PutWorkerDetails putWorkerDetails) {
        WorkersApi api = new WorkersApi();
        try {
            api.workersWorkerIdPutAsync(myData.getId(), putWorkerDetails, new ApiCallback<Void>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("User.editUser onFailure Code: " + statusCode);
                }

                @Override
                public void onSuccess(Void result, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("User.editUser Code: " + statusCode);
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

    private void closeAfterAction(boolean needReload) {
        Platform.runLater(() -> {
            ((Stage)Window_User_GridPane_Root.getScene().getWindow()).close();
            if(needReload) Singleton.singleton.reloadCurrentSubscene();
        });
    }
}
