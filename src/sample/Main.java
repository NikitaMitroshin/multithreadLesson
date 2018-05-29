package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Label label;

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane root = new AnchorPane();
        primaryStage.setTitle("Hello World");

        Button btn = new Button("Sign in");
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                Platform.runLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        label.setText("clicked");
//                    }
//                });

                Platform.runLater(new Thread(new Runnable() {
                    @Override
                    public void run() {
                        label.setText("clicked");
                    }
                }));

//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        label.setText("clicked");
//                    }
//                }).start();
            }
        });
        AnchorPane.setBottomAnchor(btn, 50.0);
        AnchorPane.setRightAnchor(btn, 50.0);
        label = new Label("test");
        AnchorPane.setTopAnchor(btn, 50.0);
        AnchorPane.setLeftAnchor(btn, 50.0);

        root.getChildren().addAll(btn, label);
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
