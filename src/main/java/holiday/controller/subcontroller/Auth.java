package holiday.controller.subcontroller;

import holiday.Singleton;
import io.swagger.client.ApiCallback;
import io.swagger.client.ApiException;
import io.swagger.client.api.SecurityApi;
import io.swagger.client.model.LoginDetails;
import io.swagger.client.model.PostLoginDetails;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Auth implements Initializable {
    public Button AuthButtonAuth;
    public Label Auth_Label_Output;
    public PasswordField Auth_TextField_Password;
    public TextField Auth_TextField_Login;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void AuthButtonAuth_Clicked(MouseEvent mouseEvent) {
        OnClicked();
    }

    private void SetNewOutputMessage(final String message) {
        Platform.runLater(() -> {
            Auth_Label_Output.setVisible(true);
            Auth_Label_Output.setText(message);
        });
    }

    private void DisableOutputMessage() {
        Platform.runLater(() -> {
            Auth_Label_Output.setVisible(false);
            Auth_Label_Output.setText("");
        });
    }

    private void TryLogin(String login, String password) {
        /*ApiClient apiClient = new ApiClient();
        apiClient.setBasePath("http://holidayapi.ekbpenz54.mykeenetic.ru");*/

        SecurityApi securityApi = new SecurityApi();
//        securityApi.setApiClient(apiClient);

        PostLoginDetails postLoginDetails = new PostLoginDetails();
        postLoginDetails.setLogin(login);
        postLoginDetails.setPassword(password);

        try {
            securityApi.loginPostAsync(postLoginDetails, new ApiCallback<LoginDetails>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Auth.onFailure");
                    switch (statusCode) {
                        case 0:
                            SetNewOutputMessage("Failed connect to Server");
                            break;
                        case 401:
                        case 403:
                        case 404:
                            SetNewOutputMessage("Not correct email/password or not found");
                            break;
                        case 500:
                            SetNewOutputMessage("Server Error 500");
                            System.out.print(e.getResponseBody());
                            break;
                        default:
                            SetNewOutputMessage("Unknowed server code " + statusCode);
                    }
                }

                @Override
                public void onSuccess(LoginDetails result, int statusCode, Map<String, List<String>> responseHeaders) {
                    System.out.println("Auth.onSuccess");
                    if(statusCode == 200) {
                        if(!result.getRole().equals("")) {
                            Singleton.levelOfAccess = result.getRole();
                            Singleton.singleton.loadSceneByName("General");
                            //Platform.runLater(() -> Singleton.singleton.loadSubsceneByName("General"));
                        }
                    } else {
                        System.out.println("Auth.onSuccess statusCode is not 200");
                    }
                }

                @Override
                public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
                    System.out.println("Auth.onUploadProgress");
                }

                @Override
                public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
                    System.out.println("Auth.onDownloadProgress");
                }
            });
        } catch (ApiException e) {
            e.printStackTrace();
            SetNewOutputMessage("Application Error");
        }
    }

    public void onEnter(ActionEvent actionEvent) {
        OnClicked();
    }

    private void OnClicked() {
        String login = Auth_TextField_Login.getText();
        String password = Auth_TextField_Password.getText();

        if(login.length() == 0 || password.length() == 0) {
            SetNewOutputMessage("Login or/and password is empty");
            return;
        }
        DisableOutputMessage();

        TryLogin(login, password);
        /*
        LoginDetails loginDetails = new LoginDetails();
        SecurityApi securityApi = new SecurityApi();
        try {
            PostLoginDetails postLoginDetails = new PostLoginDetails();
            postLoginDetails.setLogin(login);
            postLoginDetails.setPassword(password);
            loginDetails = securityApi.loginPost(postLoginDetails);
        } catch (ApiException e) {
            switch (e.getCode()) {
                case 401:
                case 403:
                case 404:
                    SetNewOutputMessage("Not correct email/password or not found");
                    return;
                case 500:
                    SetNewOutputMessage("Server Error 500");
                    System.out.print(e.getResponseBody());
            }
        }
        if(loginDetails != null) {
            Singleton.singleton.loadSceneByName("General");
        }
        */
    }
}
