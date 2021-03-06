import controllers.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    public static Stage primaryStage;
    public static BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage){
        MainApp.primaryStage = primaryStage;
        initRootLayout();
    }
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            RootLayoutController rootLayoutController = RootLayoutController.getInstance();

            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setController(rootLayoutController);
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle("Farm App");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}