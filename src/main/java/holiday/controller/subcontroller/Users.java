package holiday.controller.subcontroller;

import holiday.Singleton;
import io.swagger.client.ApiCallback;
import io.swagger.client.ApiException;
import io.swagger.client.api.WorkersApi;
import io.swagger.client.model.ListOfWorkers;
import io.swagger.client.model.WorkerDetails;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

public class Users implements Initializable {

    public VBox Users_VBox_List;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clearAllUsers();
        loadAllUsers();
        System.out.println("Users initialized");
    }

    private void loadAllUsers() {
        WorkersApi api = new WorkersApi();
        System.out.println("Users loading...");
        try {
            api.workersGetAsync(new ApiCallback<ListOfWorkers>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Users.initialize.workersGetAsync onFailure");
                    Singleton.singleton.callErrorDialog("Ошибка",
                            "Произошла ошибка во время загрузки списка работников",
                            "Код ошибки:" + statusCode);
                }

                @Override
                public void onSuccess(ListOfWorkers result, int statusCode, Map<String, List<String>> responseHeaders) {
                    List<WorkerDetails> list = result.getList();
                    System.out.println("Users.initialize.workersGetAsync " + list.size() + " users loaded");
                    for (WorkerDetails details : list) {
                        Platform.runLater(() -> addUserToScreen(details));
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

    private void clearAllUsers() {
        Users_VBox_List.getChildren().remove(0, Users_VBox_List.getChildren().size());
    }

    private boolean addUserToScreen(WorkerDetails workerDetails) {
        HBox hBox = new HBox();
        hBox.getStyleClass().add("list_user_hbox");

        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(30);
        rectangle.setWidth(30);
        rectangle.setFill(Color.valueOf(workerDetails.getColor()));
        rectangle.getStyleClass().add("list_user_color");

        Label nameLabel = new Label();
        nameLabel.setText(workerDetails.getName());
        nameLabel.getStyleClass().add("list_user_title");

        Label phoneLabel = new Label();
        phoneLabel.setText(workerDetails.getPhone());
        phoneLabel.getStyleClass().add("list_user_phone");

        Button buttonEdit = new Button();
        buttonEdit.setText("Редактировать");
        buttonEdit.setOnAction(event -> handleEditOnAction(workerDetails));

        Button buttonDelete = new Button();
        buttonDelete.setText("Удалить");
        buttonDelete.setOnAction(event -> handleDeleteOnAction(workerDetails));

        hBox.getChildren().addAll(rectangle, nameLabel, phoneLabel, buttonEdit, buttonDelete);
        Users_VBox_List.getChildren().add(hBox);
        return true;
    }

    public void Window_Users_Button_AddUser_OnAction(ActionEvent actionEvent) {
        Singleton.singleton.loadWindowByName("User", "Users", Singleton.EActionStates.Add, null);
    }

    private void handleEditOnAction(WorkerDetails workerDetails) {
        Singleton.singleton.loadWindowByName("User", "Users", Singleton.EActionStates.Edit, workerDetails);
    }

    private void handleDeleteOnAction(WorkerDetails workerDetails) {
        Random r = new java.util.Random ();
        String generatedString = Long.toString (r.nextLong () & Long.MAX_VALUE, 36);
        boolean result = Singleton.singleton.loadConfirmDialog("Подтверждение перехода",
                "Вы не сможете отменить это действие",
                "Вы действительно хотите изменить пароль " +
                        workerDetails.getName() + " на " + generatedString);
        if(result) {
            workerDetails.setPassword(generatedString);
            Singleton.singleton.loadWindowByName("User", "Users", Singleton.EActionStates.Edit, workerDetails);
            //SupportLibrary.convertWorkerDetailsToPutWorkerDetails(workerDetails);
        }
    }
}
