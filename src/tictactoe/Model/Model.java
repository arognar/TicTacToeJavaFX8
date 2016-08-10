/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.Model;

/**
 *
 * @author hyperman
 */
public class Model {
    private int turns;
    final int PLAYER_ONE = 0;
    final int PLAYER_TWO = 1;
    private int activePlayer;
    private Boolean[][] field = new Boolean[3][3];
    private Boolean[][] P_One = new Boolean[3][3];
    private Boolean[][] P_Two = new Boolean[3][3];
    
    public Model(){
        
        init();
    }
    
    private void init(){
        turns = 0;
        activePlayer = PLAYER_ONE;
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 3;j++){
                field[i][j]=false;
                P_One[i][j]=false;
                P_Two[i][j]=false;
            }
                
        }
    }
    
    public int getactivePlayer(){
        return activePlayer;
    }
    
    public void setactivePlayer(int player){
        activePlayer = player;
    }
    
    public boolean canPlace(int x,int y){
        return !field[x][y];
    }
    
    public void setField(int x, int y){
        field[x][y] = true;
    }
    public void setPlayer(int x, int y,int player){
        if(player==PLAYER_ONE){
            P_One[x][y] = true;
        }
        else{
            P_Two[x][y] = true;
        }
    }
    
    public boolean checkWin(int player){
        boolean win = false;
        if(player==PLAYER_ONE){
           if(P_One[1][1]){ //Mitte
               if(P_One[0][1] && P_One[2][1]) win = true;
               else if(P_One[0][0] && P_One[2][2]) win =  true;
               else if(P_One[2][0] && P_One[0][2]) win =  true;
               else if(P_One[1][0] && P_One[1][2]) win =  true;
               
           }
           if(P_One[0][0]){ //Oben Links
               if(P_One[0][1] && P_One[0][2]) win = true;
               else if(P_One[1][0] && P_One[2][0]) win = true;
              
           }
           if(P_One[2][2]){ //Oben Links
               if(P_One[0][2] && P_One[1][2]) win = true;
               else if(P_One[2][0] && P_One[2][1]) win = true;
              
           }
           
           
        }
        else{
            if(P_Two[1][1]){ //Mitte
               if(P_Two[0][1] && P_Two[2][1]) win = true;
               else if(P_Two[0][0] && P_Two[2][2]) win =  true;
               else if(P_Two[2][0] && P_Two[0][2]) win =  true;
               else if(P_Two[1][0] && P_Two[1][2]) win =  true;
               
           }
           if(P_Two[0][0]){ //Oben Links
               if(P_Two[0][1] && P_Two[0][2]) win = true;
               else if(P_Two[1][0] && P_Two[2][0]) win = true;
              
           }
           if(P_Two[2][2]){ //Oben Links
               if(P_Two[0][2] && P_Two[1][2]) win = true;
               else if(P_Two[2][0] && P_Two[2][1]) win = true;
              
           }
            
        }
        
        
        return win;
   
    }
    
    public void setTurns(){
        turns++;
    }
    
    public int getTurns(){
        return turns;
    }

    public void rest() {
        init();
    }
    
    
    
    
    
}
