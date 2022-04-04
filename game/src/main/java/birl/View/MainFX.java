package birl.View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainFX extends Application{

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Brawl In Real Life");
        Button button = new Button("START");
        button.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){
                System.out.println("START button does not work yet...");    // TODO: open actual game GUI
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(button);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
}
