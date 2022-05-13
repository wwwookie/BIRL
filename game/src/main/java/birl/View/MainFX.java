package birl.View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainFX extends Application{

    String gameName = "Brawl in Real Life";
    private Stage primaryStage = new Stage();
    private BorderPane primaryPane = new BorderPane();

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        startScreen();
    }

    private void startScreen(){

        primaryStage.setTitle(gameName);

        Button playButton = new Button("PLAY");
        playButton.setPrefSize(240, 75);
        playButton.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){
                System.out.println("PLAY button pressed.");
                mainMenu();
            }
        });

        primaryPane.setPrefSize(1000, 750);
        primaryPane.setCenter(playButton);
        primaryStage.setScene(new Scene(primaryPane));
        primaryStage.show();
    }

    private void mainMenu(){

        primaryPane.setTop(makeHBox());
        primaryPane.setCenter(null);
        primaryPane.setLeft(makeGridPane());
        primaryPane.setRight(makeGridPane());
        primaryStage.setScene(new Scene(primaryPane));
        primaryStage.show();
    }

    private HBox makeHBox(){
        HBox hbox = new HBox();
        hbox.setPrefSize(primaryPane.getPrefWidth()/3, primaryPane.getPrefHeight()/3);

        // TODO: insert buttons here
        Button backButton = new Button("<- BACK");
        backButton.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){
                clearPrimaryPane();
                startScreen();
            }
        });

        hbox.getChildren().add(backButton);

        return hbox;
    }

    private GridPane makeGridPane(){
        GridPane gridPane = new GridPane();

        gridPane.setPadding(new Insets(10, 10 , 10, 10));

        Button addFighterButton1 = new Button("+");
        Button addFighterButton2 = new Button("+");
        Button addFighterButton3 = new Button("+");
        Button addFighterButton4 = new Button("+");
        Button addFighterButton5 = new Button("+");
        Button addFighterButton6 = new Button("+");

        addFighterButton1.setPrefSize(100, 100);
        addFighterButton2.setPrefSize(100, 100);
        addFighterButton3.setPrefSize(100, 100);
        addFighterButton4.setPrefSize(100, 100);
        addFighterButton5.setPrefSize(100, 100);
        addFighterButton6.setPrefSize(100, 100);

        // TODO: add functionality to buttons here

        gridPane.add(addFighterButton1, 0, 0);
        gridPane.add(addFighterButton2, 1, 0);
        gridPane.add(addFighterButton3, 0, 1);
        gridPane.add(addFighterButton4, 1, 1);
        gridPane.add(addFighterButton5, 0, 2);
        gridPane.add(addFighterButton6, 1, 2);

        return gridPane;
    }

    // this is really messy, find other way for cleaning pane
    private void clearPrimaryPane(){
        primaryPane.setTop(null);
        primaryPane.setRight(null);
        primaryPane.setBottom(null);
        primaryPane.setLeft(null);
        primaryPane.setCenter(null);
    }
}
