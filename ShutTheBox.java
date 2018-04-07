/**
 * Shut The Box
 * 
 * @Eric Sauer 
 * @1/21/2018
 */

import java.util.*;
public class ShutTheBox {
    public ArrayList<Integer> nums = new ArrayList<Integer>(9);
    public int roll;
    //creates Shut the Box Object
    public ShutTheBox(){
        for(int i = 1; i <= 9; i++){
            nums.add(i);
        }
    }
    
    //lists the contents of the arraylist
    public void List(ArrayList l){
        System.out.print("Remaining Numbers: ");
        for(int i = 0; i < l.size(); i++){
              System.out.print(l.get(i) + " ");
        }
        System.out.println();
    }
    
    //prints score and game over message
    public void EndGame(){
        int score = 0;
        
        System.out.println("You lose! Recompile to play again");
        for(int i = 0; i < nums.size(); i++){
            score =  nums.get(i) + score;
        }
        System.out.println("Score: " + score);
     }
    
     //prints victory message if all numbers are flipped down
     public void WinGame(){
        System.out.println("You win! Recompile to play again");   
    }
    
    //runs the game
    public boolean Run(){
        boolean run = true;
        while(run){//rolls dice and reads input everytime numbers are flipped
            int sum = 0;
            
            Random rand = new Random();
            Scanner sc = new Scanner(System.in);
            roll = rand.nextInt(12) + 2;  //rolls the dice
            ArrayList in = new ArrayList();
            
            System.out.println("Your dice roll is " + roll);
            List(nums); //lists unflipped numbers
            
            System.out.println("Enter the numbers that you would like to flip");
            String input = sc.nextLine(); //reads in numbers that will be flipped
        
            String temp[] = input.split(" "); //splits the input at each blank space and puts them in an array
            
            for(int j = 0; j < temp.length; j++){
                sum = Integer.parseInt(temp[j]) + sum; //parses and adds up the sum of the numbers entered
            }
            for(int i = 0; i < temp.length; i++){
                in.add(Integer.parseInt(temp[i])); //parses and enters numbers into an array list
                
                if(nums.isEmpty()){ //if all numbers are flipped, win the game
                    WinGame();
                    return false;
                }
                if(nums.contains(in.get(i)) && sum == roll){
                    nums.remove(in.get(i)); //if the numbers that were entered are not flipped and the entered numbers sum == the roll, then flip the numbers entered
                }
                else {//if the entered numbers have already been flipped, lose the game
                    run = false;
                }
            }
        }
        EndGame();
        return false;
    }
    /**
     * if a number is rolled and there is no way to get that number then end the game
     * can put this method in run
     * 
     */
    // public boolean Contains(){  
        
        // if( roll == 2  && !nums.contains(2)){ return false;}
        // if( roll == 3 && (!nums.contains(1) && !nums.contains(2)) || nums.contains(3)){ return false;}
        // if(roll == 4 && !nums.contains(1) && !nums.contains(3){return false;}
        // if(roll == 5 && !nums.contains(1) && !nums.contains(4) || !nums.contains(2) && !nums.contains(3){return false;}
        // if(roll == 6 && !nums.contains(1) && !nums.contains(5) || !nums.contains(2) && !nums.contains(4) || !nums.contains(1) && !nums.contains(2) && !nums.contains(3){return false;}
        
        // if(roll == 7 && !nums.contains(1) && !nums.contains(6) || !nums.contains(2) && !nums.contains(5) || !nums.contains(3) && !nums.contains(4) || !nums.contains(){return false;}
        
        // if(roll == 8 && !nums.contains(1) && !nums.contains(5) || !nums.contains(2) && !nums.contains(4) || !nums.contains(1) && !nums.contains(2) && !nums.contains(3){return false;}
        
        // if(roll == 9 && !nums.contains(1) && !nums.contains(5) || !nums.contains(2) && !nums.contains(4) || !nums.contains(1) && !nums.contains(2) && !nums.contains(3){return false;}
        
        // if(roll == 10 && !nums.contains(1) && !nums.contains(5) || !nums.contains(2) && !nums.contains(4) || !nums.contains(1) && !nums.contains(2) && !nums.contains(3){return false;}
        
        // if(roll == 11 && !nums.contains(1) && !nums.contains(5) || !nums.contains(2) && !nums.contains(4) || !nums.contains(1) && !nums.contains(2) && !nums.contains(3){return false;}
        
        // if(roll == 12 && !nums.contains(1) && !nums.contains(5) || !nums.contains(2) && !nums.contains(4) || !nums.contains(1) && !nums.contains(2) && !nums.contains(3){return false;}
    // }
    
    //runs the game
    public void RunSimulation(){
        Run();
    }
    
    public static void main (String [] args){
        System.out.println("Welcome to Shut the Box!");
        
        ShutTheBox game = new ShutTheBox();
        game.RunSimulation();
    }
}