package birl.View;

import birl.Controller.Controller;
import birl.Model.Fighter;
import birl.Model.Character;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainFX extends Application{

    Controller controller = new Controller();

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

        primaryPane.setPrefSize(1500, 1000);
        primaryPane.setCenter(playButton);
        primaryStage.setScene(new Scene(primaryPane));
        primaryStage.show();
    }

    private void mainMenu(){

        Button fightButton = new Button("FIGHT!");
        fightButton.setPrefSize(240, 75);
        fightButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                System.out.println("FIGHT button pressed.");
                // TODO: start the fight
            }
        });

        primaryPane.setTop(makeHBox());
        primaryPane.setCenter(fightButton);
        primaryPane.setLeft(makeGridPane());
        primaryPane.setRight(makeGridPane());
        primaryStage.setScene(new Scene(primaryPane));
        primaryStage.show();
    }

    /**
     * Sets up the HBox used for upper controll bar in fighter selection.
     * @return the created HBox
     */
    private HBox makeHBox(){
        HBox hbox = new HBox();
        hbox.setPrefSize(primaryPane.getPrefWidth()/5, primaryPane.getPrefHeight()/5);

        // TODO: other button utilities here
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

    /**
     * Sets up the GridPane for fighter selection.
     * @return the created GridPane
     */
    private GridPane makeGridPane(){
        GridPane gridPane = new GridPane();

        gridPane.setPadding(new Insets(10, 10 , 10, 10));

        // do we need that many buttons? can work with one per piece?

        Button addFighterButton1 = makeButton("+", 150, 150);
        Button addFighterButton2 = makeButton("+", 150, 150);
        Button addFighterButton3 = makeButton("+", 150, 150);
        Button addFighterButton4 = makeButton("+", 150, 150);
        Button addFighterButton5 = makeButton("+", 150, 150);
        Button addFighterButton6 = makeButton("+", 150, 150);

        addFighterButton1.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){

                final ListView<String> characterListView = new ListView<>();
                characterListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
     
                    @Override
                    public void handle(MouseEvent click) {
                 
                        if (click.getClickCount() == 2) {
                            String characterSelected = characterListView.getSelectionModel().getSelectedItem();
                            primaryPane.getChildren().remove(characterListView);
                            primaryPane.setCenter(makeFightButton());
                        }
                    }
                });
            
            

                ObservableList<String> characterList = FXCollections.observableArrayList();
                
                for (Character character : controller.getCharacters()) {
                    characterList.add(character.getName());
                }

                characterListView.setItems(characterList);
                primaryPane.setCenter(characterListView);
            }
        });

        // TODO: add functionality to buttons here

        Button fighterInfoButton1 = makeButton("Name:\nType:\nLevel:\n", 300, 150);
        Button fighterInfoButton2 = makeButton("Name:\nType:\nLevel:\n", 300, 150);
        Button fighterInfoButton3 = makeButton("Name:\nType:\nLevel:\n", 300, 150);
        Button fighterInfoButton4 = makeButton("Name:\nType:\nLevel:\n", 300, 150);
        Button fighterInfoButton5 = makeButton("Name:\nType:\nLevel:\n", 300, 150);
        Button fighterInfoButton6 = makeButton("Name:\nType:\nLevel:\n", 300, 150);

        gridPane.add(addFighterButton1, 0, 0);
        gridPane.add(addFighterButton2, 0, 1);
        gridPane.add(addFighterButton3, 0, 2);
        gridPane.add(addFighterButton4, 0, 3);
        gridPane.add(addFighterButton5, 0, 4);
        gridPane.add(addFighterButton6, 0, 5);

        gridPane.add(fighterInfoButton1, 1, 0);
        gridPane.add(fighterInfoButton2, 1, 1);
        gridPane.add(fighterInfoButton3, 1, 2);
        gridPane.add(fighterInfoButton4, 1, 3);
        gridPane.add(fighterInfoButton5, 1, 4);
        gridPane.add(fighterInfoButton6, 1, 5);


        return gridPane;
    }

    // this is really messy, find other way for cleaning pane
    private void clearPrimaryPane(){

        primaryPane.setTop(null);
        primaryPane.setRight(null);
        primaryPane.setBottom(null);
        primaryPane.setLeft(null);
        primaryPane.setCenter(null);

        // primaryPane.getChildren().removeAll(); // didnt work, figure out why
    }

    /**
     * Sets up a button.
     * @param text - which is displayed by the button
     * @param prefWidth - prefered width
     * @param prefHeight - prefered height
     * @return button with given parameters
     */
    private Button makeButton(String text, int prefWidth, int prefHeight){

        Button button = new Button(text);
        button.setPrefSize(prefWidth, prefHeight);

        return button;
    }

    private Button makeFightButton(){

        Button fightButton = makeButton("FIGHT!", 240, 75);
        fightButton.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){
                // TODO: start fight
            }
        });

        return fightButton;
    }

    private void playLocalGame(Fighter[] teamRed, Fighter[] teamBlue){

        // random number between 0 and 1
        int startingPlayer = (int)Math.floor(Math.random() * 2 + 0);
        boolean running = true;
        Fighter[] teamActive;
        Fighter[] teamPassive;

        if(startingPlayer == 0){
            teamActive = teamRed;
            teamPassive = teamBlue;
        }
        else {
            teamActive = teamBlue;
            teamPassive = teamRed;
        }

        while(running){

            // TODO: implement game loop here, need game ui first...
        }
    }
}
