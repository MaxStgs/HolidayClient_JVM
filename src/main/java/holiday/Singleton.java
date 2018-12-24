package holiday;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Singleton {

    public static Singleton singleton;

    Singleton(Stage primaryStage) {
        primaryStageSettings(primaryStage);

        loadSceneByName("Auth");

        try {
            this.primaryStage.getIcons().add(new Image("icons/icon-holiday.png"));

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        primaryStage.show();
    }

    Singleton(Stage primaryStage, String levelOfAccess) {
        primaryStageSettings(primaryStage);

        Singleton.levelOfAccess = levelOfAccess;
        loadSceneByName("General");

        try {
            this.primaryStage.getIcons().add(new Image("icons/icon-holiday.png"));

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        primaryStage.show();
    }

    // Global application data

    private static boolean debugLevelOfAccess = false;
    public static String levelOfAccess;

    // Actions data

    private static Object ActionObject;
    private static EActionStates ActionState;
    private static Object ActionObjectData;

    public enum EActionStates {
        Add,
        Edit,
        Delete
    }

    public static EActionStates getActionState() {
        return ActionState;
    }
    public static Object getActionObjectData() { return ActionObjectData; }
    public static boolean isActionObject(Object obj) {
        return obj.equals(ActionObject);
    }


    // Windows

    private Stage primaryStage;
    public SubScene subscene;
    private String currentSubscene;
    private String currentWindow;
    private String currentWindowParentSubscene;

    private static Map<String, String> namePages = new HashMap<String, String>() {{
        put("Cars", "Автомобили");
        put("Combinations", "Комбинации");
        put("Equipments", "Оборудование");
        put("Orders", "Заказы");
        put("Settings", "Настройки");
        put("Starter", "Стартовая страница");
        put("Statements", "Ведомости");
        put("Tasks", "Задачи");
        put("Users", "Пользователи");
        put("About", "О программе");
        put("Car", "Авто");
        //put("Coming", "Приходы");
        put("Coming", "Прихода");
        //put("Oil", "Бензин");
        put("Oil", "Бензина");
        //put("Order", "Заказ");
        put("Order", "Заказа");
        //put("Out", "Расход");
        put("Out", "Расходы");
        //put("Subtask", "Подзадача");
        put("Subtask", "Подзадачи");
        //put("Task", "Задача");
        put("Task", "Задачи");
        //put("User", "Пользователь");
        put("User", "Пользователя");
        put("Auth", "Авторизация");
        put("General", "Главная");
        put("Equipment", "Оборудования");

    }};

    public static String getRusName(String engName) {
        String newName = namePages.get(engName);
        if(newName == null)
            return engName;
        return newName;
    }

    private boolean setTitleName(Stage window, String name, String preName) {
        if(preName == null)
            preName = "";
        window.setTitle(preName + getRusName(name) + (debugLevelOfAccess ? " with levelOfAccess: " + levelOfAccess : ""));
        return true;
    }

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

    public boolean loadSceneByName(final String name) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("../view/subform/" + name + ".fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                setTitleName(primaryStage, name, null);
                primaryStage.setScene(new Scene(root, 1280, 720));
                if(name.equals("Auth")) {
                    primaryStage.resizableProperty().setValue(Boolean.FALSE);
                } else {
                    primaryStage.resizableProperty().setValue(Boolean.TRUE);
                }
            }
        });
        return true;
    }

    public boolean loadSubsceneByName(String name) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../view/subform/" + name + ".fxml"));
//            primaryStage.setTitle("Page " + name +
//                    (debugLevelOfAccess ? " with levelOfAccess: " + levelOfAccess : ""));
            setTitleName(primaryStage, name, null);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        currentSubscene = name;
        subscene.setRoot(root);

        return true;
    }

    public boolean reloadCurrentSubscene() {
        if(!currentSubscene.equals(currentWindowParentSubscene))
            return false;

        //subscene.setRoot(new Parent(){});
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return loadSubsceneByName(currentSubscene);
    }

    public boolean loadWindowByName(String name, String parentSubscene, EActionStates state, Object data) {
        try {
            ActionObjectData = data;
            ActionState = state;

            String title = "Окно ";
            switch (ActionState) {
                case Add:
                    title += "создания ";
                    break;
                case Edit:
                    title += "редактирования ";
                    break;
                case Delete:
                    title += "удаления ";
                    break;
                default:
                    System.out.println("Singleton.loadWindowByName empty switch");
            }

            currentWindowParentSubscene = parentSubscene;

            Parent root = FXMLLoader.load(getClass().getResource("../view/window/" + name + ".fxml"));

            double width = ((GridPane) root).getPrefWidth();
            double height = ((GridPane) root).getPrefHeight();

            Scene scene = new Scene(root, width, height);
            Stage stage = new Stage();

            ActionObject = scene;

//            stage.setTitle(title);
            setTitleName(stage, name, title);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static void handleWindowAction(boolean isSuccess) {
        System.out.println("Singleton.handleWindowAction");
    }

    public boolean loadConfirmDialog(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setWidth(400.0);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("../resources/icons/archive-delete.png"));

        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        Optional<ButtonType> result = alert.showAndWait();
        ButtonType buttonType = result.orElse(null);
        if (buttonType == ButtonType.OK) {
            return true;
        } else if (buttonType == ButtonType.CANCEL) {
            return false;
        }
        System.out.println("Singleton.loadConfirmDialog is not OK/Cancel got " + buttonType);
        return false;
    }

    public boolean LoadInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("О Програмном обеспечении");
//        setTitleName(alert, "О програмном обеспечении");
        alert.setHeaderText("Муксем Петерс");
        alert.setContentText("With Love From Java");

        alert.showAndWait();
        return true;
    }

    public void callErrorDialog(String Title, String Header, String Content) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(Title);
            alert.setHeaderText(Header);
            alert.setContentText(Content);

            alert.showAndWait();
        });
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
