/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.View;

import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import tictactoe.Model.Model;

/**
 *
 * @author hyperman
 */
public class View extends Region{
    ObservableList<Node> myChildren = getChildren();
    //size in pixels of the main game canvas
    private final int MENU_SIZE = 100;
    private final int SIZE_W = 600;
    private final int SIZE_H = 600;
    
    private final int NODES_H = 3; //Felder+Interface
    private final int NODES_W = 3;
    private final int TILE_HEIGHT = SIZE_H/NODES_H;
    private final int TILE_WIDTH = SIZE_W/NODES_W;
    private final int MENU_HEIGHT = MENU_SIZE;
    private final int MENU_WIDTH = SIZE_W/NODES_W;
    private Group[][] nodes = new Group[NODES_W][NODES_H];
    private Text statusLine;
    Model model;
    
    public View(Model model){
        
        super.setPrefSize(SIZE_W, SIZE_H);
        this.model = model;
        setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
        initBoard(myChildren,nodes);
        
    }

    private void initBoard(ObservableList<Node> mychildren,Group[][] nodes) {
        for(int i=0;i < NODES_W;i++){
            for(int j=0;j < NODES_H;j++){
                Group g = new Group();
                
                g.getChildren().add(0,boardNode());
                    
                
                
                nodes[i][j]= g;
                mychildren.add(nodes[i][j]);
            }
        }
        
    }
    
    private Node makePlayerGraphic(int player){
        Rectangle r2 = new Rectangle(0, 0, TILE_WIDTH-1, TILE_HEIGHT);
        if(player==0){
            r2.setFill(Color.GREEN);
            r2.setStroke(Color.BLACK);
        }
        else {
            r2.setFill(Color.BLUE);
            r2.setStroke(Color.BLACK);
        }
        
        
        return r2;
    }
    
    private Node boardNode(){
        Rectangle r2 = new Rectangle(0, 0, TILE_WIDTH-1, TILE_HEIGHT-1);
        
        r2.setFill(Color.WHITE);
        r2.setStroke(Color.BLACK);
        
        return r2;
    }
    private Node WinNode(boolean win){
        Rectangle r2 = new Rectangle(0, 0, TILE_WIDTH-1, TILE_HEIGHT-1);
        
        Text t2 = new Text(0,16,"test");
        Text reset= new Text(20,32,null);
        
        
        if(win){
            if(model.getactivePlayer()==1){
                t2.setText("Player one won !");
            }
            else{
                t2.setText("Player two won !");
            }
        }
        else{
            t2.setText("DRAW");
        }
        
        t2.setFill(Color.BLACK);
        t2.setFont(Font.font("System", FontWeight.BOLD, 16));
        
        reset.setText("Rightclick to reset");
        reset.setFill(Color.BLACK);
        reset.setFont(Font.font("System", FontWeight.BOLD, 16));
        
        r2.setFill(Color.WHITE);
        r2.setStroke(Color.BLACK);
        
        return new Group(r2,t2,reset);
    }
    
    protected void layoutChildren(){
        super.layoutChildren();
        for(int i=0;i<NODES_W;i++){
            for(int j=0;j<NODES_H;j++){
                System.out.println(j);
                Group g = nodes[i][j];
                
                g.relocate(i*TILE_HEIGHT, j*TILE_WIDTH);
                
            }
            
        }
    }
    
    public void setCursor(int player){
        Image image = new Image("PlayerOne.jpg");
        Image image2 = new Image("PlayerTwo.jpg");
        if(player==0){
            super.setCursor(new ImageCursor(image));
        }else{
            super.setCursor(new ImageCursor(image2));
        }
        
    }
    
    public void updateMark(int rowNr, int colNr,int player) {
        ObservableList<Node> layers = nodes[rowNr][colNr].getChildren();
        //if (model.isPlayerAt(rowNr, colNr)) {
        layers.remove(0);
        layers.add(0, makePlayerGraphic(player));
        //} else {
            //
        //}

    }
    
    public void announceLevelComplete(boolean win) {
        for(int i=0;i < NODES_H;i++){
            for(int j=0;j < NODES_W;j++){
                  ObservableList<Node> layers = nodes[i][j].getChildren();
                  layers.remove(0);
                  layers.add(0, WinNode(win));
            }
        }
  
    }
    
    public void reset() {
        for(int i=0;i < NODES_H;i++){
            for(int j=0;j < NODES_W;j++){
                  ObservableList<Node> layers = nodes[i][j].getChildren();
                  layers.remove(0);
                  layers.add(0, boardNode());
            }
        }
  
    }

    public double getTileW() {
        return TILE_WIDTH;
    }

    public double getTileH() {
        return TILE_HEIGHT;
    }
}
