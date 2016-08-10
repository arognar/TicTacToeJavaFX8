/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import tictactoe.Controller.Controller;
import tictactoe.Model.Model;
import tictactoe.View.View;

/**
 *
 * @author hyperman
 */
public class TicTacToe extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Model model = new Model();
      View root = new View(model);
      Controller controller = new Controller(model, root);
      
      //initialize all objects of the main loop
      
      //main scene
      Scene scene = new Scene(root);
      
      //the main window
      primaryStage.setScene(scene);
      primaryStage.setResizable(true);
      primaryStage.setOnCloseRequest(event -> {
         
         System.exit(0);
      });
      primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
