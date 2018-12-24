package holiday.controller.windowcontroller;

import holiday.Singleton;
import io.swagger.client.ApiCallback;
import io.swagger.client.ApiException;
import io.swagger.client.api.OutsApi;
import io.swagger.client.model.OutDetails;
import io.swagger.client.model.PostOutDetails;
import io.swagger.client.model.PutOutDetails;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneOffset;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.time.chrono.Chronology;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Out implements Initializable {
    public GridPane Window_Out_GridPane_Root;
    public DatePicker Window_Out_DatePicker_DateRecord;
    public TextArea Window_Out_TextArea_Comment;
    public TextField Window_Out_TextField_Amount;
    public Button Window_Out_Button_SelectFile;
    public Button Window_Out_Button_Action;
    public Button Window_Out_Button_Cancel;

    private Singleton.EActionStates actionState;

    private OutDetails myData;

    private final FileChooser fileChooser = new FileChooser();
    private File checkPhoto;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*if(!Singleton.isActionObject(this))
            return;*/
        actionState = Singleton.getActionState();
        if(actionState == null)
            return;
        switch (actionState) {
            case Add:
                Window_Out_Button_Action.setText("Добавить");
                break;
            case Edit:
                Window_Out_Button_Action.setText("Сохранить");
                break;
            case Delete:
                Window_Out_Button_Action.setText("Del !allowed");
                break;
            default:
                Window_Out_Button_Action.setText("Unknowed Action");
                break;
        }

        OutDetails outDetails = (OutDetails)Singleton.getActionObjectData();

        if(outDetails == null) {
            System.out.println();
            new Alert(Alert.AlertType.ERROR, "Упс, объект не соответствует ожиданиям");
            return;
        }

        fillForm(outDetails);

//        Stage stage = (Stage) Window_User_GridPane_Root.getScene().getWindow();
//        stage.getIcons().add(new Image("../resources/icons/archive-edit.png"));


    }

    private void fillForm(OutDetails outDetails) {
        Window_Out_DatePicker_DateRecord.setChronology(Chronology.of(outDetails.getDate().toString()));
        Window_Out_TextArea_Comment.setText(outDetails.getComments());
        Window_Out_TextField_Amount.setText(outDetails.getTotal().toString());
        // About file?
    }

    public void Window_Out_Button_SelectFile_OnAction(ActionEvent actionEvent) {
        configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(((Button)actionEvent.getSource()).getScene().getWindow());
        if (file != null) {
            System.out.println(file.getPath());
            checkPhoto = file;
        }
    }

    public void Window_Out_Button_Action_OnAction(ActionEvent actionEvent) {
        switch (actionState) {
            case Add:
                addOut(constructPostOutDetails());
                break;
            case Edit:
                editOut(constructPutOutDetails());
                break;
            case Delete:
                break;
        }
    }

    private void addOut(PostOutDetails postOutDetails) {
        OutsApi outsApi = new OutsApi();
        String comments = "comments_example";
        OffsetDateTime date = OffsetDateTime.now();
        Float total = 3.4F;
        File photo = new File("photo_example");
        Integer idStatement = 56;
        //comments, date, total, photo, idStatement
        PostOutDetails body = new PostOutDetails();
        body.setTotal(total);
        body.setIdStatement(idStatement);
        body.setComments(comments);
        body.setDate(date);
        body.setPhoto(photo);
        try {
            outsApi.outsPostAsync(body, new ApiCallback<Void>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Out.addOut onFailure Code: " + statusCode);
                }

                @Override
                public void onSuccess(Void result, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Out.addOut onSuccess Code: " + statusCode);
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

    private void editOut(PutOutDetails putOutDetails) {
        OutsApi outsApi = new OutsApi();
        try {
            outsApi.outsOutIdPutAsync(myData.getId(), putOutDetails, new ApiCallback<Void>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Out.editOut onFailure Code: " + statusCode);
                }

                @Override
                public void onSuccess(Void result, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Out.editOut OnSuccess Code: " + statusCode);
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

    private PostOutDetails constructPostOutDetails() {
        PostOutDetails postOutDetails = new PostOutDetails();

        postOutDetails.setIdStatement(1);
        if(Window_Out_DatePicker_DateRecord.getValue() != null)
            postOutDetails.setDate(
                    OffsetDateTime.of(
                            Window_Out_DatePicker_DateRecord.getValue().getYear(),
                            Window_Out_DatePicker_DateRecord.getValue().getMonthValue(),
                            Window_Out_DatePicker_DateRecord.getValue().getDayOfMonth(),
                            0, 0, 0, 0, ZoneOffset.MIN)
            );
        else {
            System.out.println("Out.constructPostOutDetails null value on DatePicker");
            return null;
        }
        postOutDetails.setComments(Window_Out_TextArea_Comment.getText());
        try {
            postOutDetails.setTotal(Float.valueOf(Window_Out_TextField_Amount.getText()));
        } catch (NumberFormatException exception) {
            System.out.println("Out.constructPostOutDetails can't parse Amount");
        }
        postOutDetails.setPhoto(new File("photo_example"));

        return postOutDetails;
    }

    private PutOutDetails constructPutOutDetails() {
        PutOutDetails putOutDetails = new PutOutDetails();

        putOutDetails.setIdStatement(1);
        putOutDetails.setDate(
                OffsetDateTime.of(
                        Window_Out_DatePicker_DateRecord.getValue().getYear(),
                        Window_Out_DatePicker_DateRecord.getValue().getMonthValue(),
                        Window_Out_DatePicker_DateRecord.getValue().getDayOfMonth(),
                        0, 0, 0, 0, ZoneOffset.MIN)
        );
        putOutDetails.setComments(Window_Out_TextArea_Comment.getText());
        putOutDetails.setTotal(BigDecimal.valueOf(Double.valueOf(Window_Out_TextField_Amount.getText())));
        //putOutDetails.setPhoto();

        return putOutDetails;
    }

    public void Window_Out_Button_Cancel_OnAction(ActionEvent actionEvent) {
        closeAfterAction(false);
    }

    private void closeAfterAction(boolean needReload) {
        Platform.runLater(() -> {
            ((Stage)Window_Out_GridPane_Root.getScene().getWindow()).close();
            if(needReload) Singleton.singleton.reloadCurrentSubscene();
        });
    }

    private static void configureFileChooser(final FileChooser fileChooser) {
        fileChooser.setTitle("Выбор фотографии для расхода");
//        fileChooser.setInitialDirectory(
//                new File(System.getProperty("user.home"))
//        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Изображения", "*.jpg", "*.png", "*.bmp")
        );
    }
}
