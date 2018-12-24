package holiday.controller.windowcontroller;

import holiday.Singleton;
import io.swagger.client.ApiCallback;
import io.swagger.client.ApiException;
import io.swagger.client.api.ComingsApi;
import io.swagger.client.model.ComingDetails;
import io.swagger.client.model.OutDetails;
import io.swagger.client.model.PostComingDetails;
import io.swagger.client.model.PutComingDetails;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.threeten.bp.*;

import java.net.URL;
import java.time.chrono.Chronology;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Coming implements Initializable {
    public GridPane Window_Coming_GridPane_Root;
    public DatePicker Window_Coming_DatePicker_DataRecord;
    public TextArea Window_Coming_TextArea_Comment;
    public TextField Window_Coming_TextField_Amount;
    public Button Window_Coming_Button_Action;
    public Button Window_Coming_Button_Cancel;

    private Singleton.EActionStates actionState;

    private ComingDetails myData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*if(!Singleton.isActionObject(this))
            return;*/
        actionState = Singleton.getActionState();
        if(actionState == null)
            return;
        switch (actionState) {
            case Add:
                Window_Coming_Button_Action.setText("Добавить");
                break;
            case Edit:
                Window_Coming_Button_Action.setText("Сохранить");
                break;
            case Delete:
                Window_Coming_Button_Action.setText("Del !allowed");
                break;
            default:
                Window_Coming_Button_Action.setText("Unknowed Action");
                break;
        }

        ComingDetails comingDetails = (ComingDetails)Singleton.getActionObjectData();

        if(comingDetails == null) {
            System.out.println();
            new Alert(Alert.AlertType.ERROR, "Упс, объект не соответствует ожиданиям");
            return;
        }

        fillForm(comingDetails);

//        Stage stage = (Stage) Window_User_GridPane_Root.getScene().getWindow();
//        stage.getIcons().add(new Image("../resources/icons/archive-edit.png"));
    }

    private void fillForm(ComingDetails comingDetails) {
        myData = comingDetails;

        Window_Coming_DatePicker_DataRecord.setChronology(Chronology.of(myData.getDate().toString()));
        Window_Coming_TextArea_Comment.setText(myData.getComments());
        Window_Coming_TextField_Amount.setText(myData.getTotal().toString());
    }

    public void Window_Coming_Button_Action_OnAction(ActionEvent actionEvent) {
        switch (actionState) {
            case Add:
                addComing(constructPostComingDetails());
                break;
            case Edit:
                editComing(constructPutComingDetails());
                break;
            case Delete:
                break;
        }
    }

    private void addComing(PostComingDetails postComingDetails) {
        ComingsApi comingsApi = new ComingsApi();
        try {
            comingsApi.comingsPostAsync(postComingDetails, new ApiCallback<Void>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Coming.addComing onFailure Code: " + statusCode);
                }

                @Override
                public void onSuccess(Void result, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Coming.addComing onSuccess Code: " + statusCode);
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

    private void editComing(PutComingDetails putComingDetails) {
        ComingsApi comingsApi = new ComingsApi();
        try {
            comingsApi.comingsComingIdPutAsync(myData.getId(), putComingDetails, new ApiCallback<Void>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Coming.editComing onFailure Code: " + statusCode);
                }

                @Override
                public void onSuccess(Void result, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Coming.editComing OnSuccess Code: " + statusCode);
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

    private PostComingDetails constructPostComingDetails() {
        PostComingDetails postComingDetails = new PostComingDetails();

        postComingDetails.setIdStatement(1);
        postComingDetails.setDate(
                OffsetDateTime.of(
                        Window_Coming_DatePicker_DataRecord.getValue().getYear(),
                        Window_Coming_DatePicker_DataRecord.getValue().getMonthValue(),
                        Window_Coming_DatePicker_DataRecord.getValue().getDayOfMonth(),
                        0, 0, 0, 0, ZoneOffset.MIN)
        );
        postComingDetails.setComments(Window_Coming_TextArea_Comment.getText());
        postComingDetails.setTotal(Float.valueOf(Window_Coming_TextField_Amount.getText()));

        return postComingDetails;
    }

    private PutComingDetails constructPutComingDetails() {
        PutComingDetails putComingDetails = new PutComingDetails();

        putComingDetails.setIdStatement(myData.getIdStatement());
        putComingDetails.setDate(OffsetDateTime.parse(Window_Coming_DatePicker_DataRecord.getChronology().toString()));
        putComingDetails.setComments(Window_Coming_TextArea_Comment.getText());
        putComingDetails.setTotal(Float.valueOf(Window_Coming_TextField_Amount.getText()));

        return putComingDetails;
    }

    public void Window_Coming_Button_Cancel_OnAction(ActionEvent actionEvent) {
        closeAfterAction(false);
    }

    private void closeAfterAction(boolean needReload) {
        Platform.runLater(() -> {
            ((Stage)Window_Coming_GridPane_Root.getScene().getWindow()).close();
            if(needReload) Singleton.singleton.reloadCurrentSubscene();
        });
    }
}
