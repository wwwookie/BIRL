package birl.View;

import org.postgresql.shaded.com.ongres.scram.common.exception.ScramParseException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainFX extends Application{

    int screenWidth = 1000;
    int screenHeight = 800;
    String gameName = "Brawl in Real Life";

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane rootPane = new AnchorPane();

        startScreen(primaryStage, rootPane);
    }

    private void startScreen(Stage stage, AnchorPane pane){

        stage.setTitle(gameName);
        
        Text gameNamePlaceholder = new Text("BIRL");
        gameNamePlaceholder.setFont(Font.font("Verdana", 100));
        gameNamePlaceholder.setFill(Color.ORANGE);
        Group rootGroup = new Group(gameNamePlaceholder);
        rootGroup.setLayoutX(screenWidth / 2 - 100);
        rootGroup.setLayoutY(screenHeight / 2); 

        Button localGameButton = new Button("PLAY LOCAL GAME");
        localGameButton.setPrefSize(240, 75);
        localGameButton.setLayoutX(screenWidth / 4);
        localGameButton.setLayoutY(screenHeight - screenHeight / 3);
        localGameButton.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){
                System.out.println("START button does not work yet...");    // TODO: open actual game GUI
            }
        });

        Button globalGameButton = new Button("PLAY GLOBAL GAME");
        globalGameButton.setPrefSize(240, 75);
        globalGameButton.setLayoutX(2 * screenWidth / 4 + 10);
        globalGameButton.setLayoutY(screenHeight - screenHeight / 3);
        globalGameButton.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){
                System.out.println("START button does not work yet...");    // TODO: open actual game GUI
            }
        });

        pane.getChildren().addAll(localGameButton, globalGameButton, rootGroup);
        stage.setScene(new Scene(pane, screenWidth, screenHeight));
        stage.show();
    }
    
}
