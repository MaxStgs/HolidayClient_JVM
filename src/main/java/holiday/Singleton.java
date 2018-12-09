package holiday;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Singleton {

    private static boolean debugLevelOfAccess = true;
    public static String levelOfAccess;

    private Stage primaryStage;
    public Pane Workspace;
    public SubScene subscene;

    public static Singleton singleton;

    private void primaryStageSettings(Stage primaryStage) {
        singleton = this;
        this.primaryStage = primaryStage;

        this.primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
    }

    public void primaryStageUpdate() {
        this.primaryStage.widthProperty().addListener((observable, oldValue, newValue) -> {
            subscene.setWidth(newValue.intValue());
        });

        this.primaryStage.heightProperty().addListener((observable, oldValue, newValue) -> {
            subscene.setHeight(newValue.intValue());
        });
    }

    Singleton(Stage primaryStage, String levelOfAccess) {
        primaryStageSettings(primaryStage);

        Singleton.levelOfAccess = levelOfAccess;
        LoadSceneByName("General");

        try {
            this.primaryStage.getIcons().add(new Image("icons/icon-holiday.png"));

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        primaryStage.show();
    }

    Singleton(Stage primaryStage) {
        primaryStageSettings(primaryStage);

        LoadSceneByName("Auth");

        try {
            this.primaryStage.getIcons().add(new Image("icons/icon-holiday.png"));

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        primaryStage.show();
    }

    public boolean LoadSceneByName(final String name) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("../view/" + name + ".fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                primaryStage.setScene(new Scene(root, 1280, 720));
            }
        });
        return true;
    }

    public boolean LoadSubsceneByName(String name) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../view/subform/" + name + ".fxml"));
            primaryStage.setTitle("Page " + name +
                    (debugLevelOfAccess ? " with levelOfAccess: " + levelOfAccess : ""));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        // Here is hidden is some problem which can't be fixed by GC
        //Workspace.getChildren().remove(0, Workspace.getChildren().size());
        //Workspace.getChildren().addAll(root);

        subscene.setRoot(root);

        // This don't want work too :c
        // System.gc();
        return true;
    }

    public boolean LoadWindowByName(String name) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/window/" + name + ".fxml"));
            Scene scene = new Scene(root, 600, 400);
            Stage stage = new Stage();
            /*stage.setTitle("Page" + name +
                    (debugLevelOfAccess ? " with levelOfAccess: " + levelOfAccess : ""));*/
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean LoadInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("О Програмном обеспечении");
        alert.setHeaderText("Муксем Петерс");
        alert.setContentText("With Love From Java");

        alert.showAndWait();
        return true;
    }

    public boolean TestLoadScene(String name) {
        try {
            FXMLLoader.load(getClass().getResource("view/" + name + ".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
