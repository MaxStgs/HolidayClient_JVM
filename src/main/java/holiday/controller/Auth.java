package holiday.controller;

import holiday.Singleton;
import io.swagger.client.ApiException;
import io.swagger.client.api.SecurityApi;
import io.swagger.client.model.LoginDetails;
import io.swagger.client.model.PostLoginDetails;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Auth {
    public Button AuthButtonAuth;
    public Label Auth_Label_Output;
    public PasswordField Auth_TextField_Password;
    public TextField Auth_TextField_Login;

    public void AuthButtonAuth_Clicked(MouseEvent mouseEvent) {
        SecurityApi securityApi = new SecurityApi();
        LoginDetails loginDetails = null;
        try {
            PostLoginDetails postLoginDetails = new PostLoginDetails();
            postLoginDetails.setLogin(Auth_TextField_Login.getText());
            postLoginDetails.setPassword(Auth_TextField_Password.getText());
            loginDetails = securityApi.loginPost(postLoginDetails);
        } catch (ApiException e) {
            switch (e.getCode()) {
                case 401:
                case 403:
                case 404:
                    Auth_Label_Output.setText("Not correct email/password or not found");
                    return;
                case 500:
                    Auth_Label_Output.setText("Server Error 500");
                    System.out.print(e.getResponseBody());
            }
        }
        if(loginDetails != null) {
            Singleton.singleton.LoadSceneByName("General");
        }
    }
}
