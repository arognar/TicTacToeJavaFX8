/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.Controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import tictactoe.Model.Model;
import tictactoe.View.View;

/**
 *
 * @author hyperman
 */
public class Controller {
    boolean reset = false;
    boolean active = true;
    final int PLAYER_ONE = 0;
    final int PLAYER_TWO = 1;
    
    Model model;
    View view;
    
    public Controller(Model model,View view){
        this.model = model;
        this.view = view;
        MouseClickHandler myMouseClickHandler = new MouseClickHandler();
        this.view.setOnMouseClicked(myMouseClickHandler);
    }
    
    private class MouseClickHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            
            
            if(event.getButton() == MouseButton.SECONDARY && reset){
                model.rest();
                view.reset();
                reset=false;
                active = true;
                
                
            }
            
            if(active && event.getButton() == MouseButton.PRIMARY){
                int x =(int)(event.getX()/view.getTileW());
                int y = (int)(event.getY()/view.getTileH());
                if(model.canPlace(x, y)){
                    view.updateMark(x, y, model.getactivePlayer());
                    model.setField(x, y);
                    if(model.getactivePlayer()==PLAYER_ONE){
                        model.setTurns();
                        model.setPlayer(x, y, PLAYER_ONE);
                        if(model.checkWin(model.getactivePlayer()) || model.getTurns()==9){
                            view.announceLevelComplete(model.checkWin(model.getactivePlayer()));
                            reset=true;
                            active = false;
                        }
                        model.setactivePlayer(PLAYER_TWO);
                        
                    }
                    else{
                        model.setTurns();
                        model.setPlayer(x, y, PLAYER_TWO);
                        if(model.checkWin(model.getactivePlayer())|| model.getTurns()==9){
                            view.announceLevelComplete(model.checkWin(model.getactivePlayer()));
                            reset=true;
                            active = false;
                        }
                        model.setactivePlayer(PLAYER_ONE); 
                        
                    }  
                    
                }
                
            }
        
            
        
            
        }
    }
    
}
