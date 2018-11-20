package holiday;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Singleton {

    private Stage primaryStage;
    public Pane Workspace;

    public static Singleton singleton;

    Singleton(Stage primaryStage) {
        singleton = this;
        this.primaryStage = primaryStage;

        try {
            LoadSceneByName("Auth");
            this.primaryStage.getIcons().add(new Image("icons/icon-holiday.png"));

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        primaryStage.show();
    }

    public boolean LoadSceneByName(String name) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../view/" + name + ".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        primaryStage.setScene(new Scene(root, 1280, 720));
        return true;
    }

    public boolean LoadSubsceneByName(String name) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../view/subform/" + name + ".fxml"));
            primaryStage.setTitle("Page" + name);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        // Here is hidden is some problem which can't be fixed by GC
        Workspace.getChildren().remove(0, Workspace.getChildren().size());
        Workspace.getChildren().addAll(root);
        // This don't want work too :c
        // System.gc();
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
