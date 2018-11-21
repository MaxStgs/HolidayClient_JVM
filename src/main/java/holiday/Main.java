package holiday;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private static boolean backdoor;
    private static String levelOfAccess;

    @Override
    public void start(Stage primaryStage) {
        if(backdoor) {
            new Singleton(primaryStage, levelOfAccess);
        } else {
            new Singleton(primaryStage);
        }
    }


    public static void main(String[] args) {
        if(args.length > 1 && args[0].equals("backdoor")) {
            backdoor = true;
            levelOfAccess = args[1];
        }
        launch(args);
    }
}
