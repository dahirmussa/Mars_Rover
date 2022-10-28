import java.util.Scanner; // import the Scanner class 
import java.util.*;
import java.lang.*;
import java.io.*;


public class  Rover_onMars {

// set all directions north west east south
public static final int North = 1; 
public static final int East = 2; 
public static final int South = 3; 
public static final int West = 4; 

// set the grid to 5 x 5 public static final String[][] plateau_grid = new String [5][5];

// emply construction 
public Rover_onMars(){}

// set rows and columns 

// all them variables uses int
int x = 1;
int y = 1;
int facing = North;


// set the Position 
public  Rover_onMars(int x , int y){
    this.x = x; 
    this.y = y; 
}




 // Enter the series of commands
 
public void process(String commands){
   
    for (int i = 0; i < commands.length(); i++) {
        process(commands.charAt(i));
    }

  
}


private void process(Character command) {
    if (command.equals('L')) {
        turnLeft();
    } else if (command.equals('R')) {
        turnRight();
    } else if (command.equals('F')) {
        move();
    } else {
        throw new IllegalArgumentException(
                "This is incorrect Enter the command again, please!");
    }
}

/* Locations */
public void Locations(){
    String directions = ""; 
    if(facing == 1){
        directions = "North"; 
    }else if(facing == 2){
        directions = "East"; 
    }else if(facing == 3){
        directions = "South"; 
    }else if(facing == 4){
        directions = "West"; 
    }
    System.out.println("Results: " + x  + " " +  y  + " " +  directions);
}



// move robot
private void move() {
    if (facing == North) {
        this.y++;
    } else if (facing == East) {
        this.x++;
    } else if (facing == South) {
        this.y--;
    } else if (facing == West) {
        this.x--;
    }
}


private void turnLeft() {
    facing = (facing - 1) < North ? West : facing - 1;
}


private void turnRight() {
    facing = (facing  + 1) > West ? North : facing  + 1;
}

public static void main(String[] args) {
    Rover_onMars Rovers = new Rover_onMars();
    Scanner mys = new Scanner(System.in);
 
    System.out.println("Enter sample series of commands to move the robot such as LFLRFLFF");
    
    String commands  = mys.nextLine();
    
    if(commands.isEmpty()){
      System.out.print("Enter sample command:  FFRFLFLF ");
    }else{
         Rovers.process(commands);
         Rovers.Locations();
    }
} 
}