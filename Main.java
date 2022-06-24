//Aidan Weygandt 11.3.21

import java.awt.*;
import javax.swing.JFrame;

//BELOW IS A LINK THAT HAS THE NEEDED MATH
//FOR CALCULATING THE X & Y COORDINATES OF A CIRCLE
//THE SAMPLE CODE IS IN JAVASCRIPT SO YOU WILL HAVE
//TO MAKE SLIGHT MODIFICATIONS SO IT WORKS IN JAVA
//LOOK FOR THE RESPONSE WITH THE GREEN CHECKMARK. YOU DO NOT NEED THE CONSOLE.LOG CODE
//https://stackoverflow.com/questions/43641798/how-to-find-x-and-y-coordinates-on-a-flipped-circle-using-javascript-methods

//Main class holds the main method and paint and all the methods that are used in my program
public class Main extends Canvas {
  //set width and height of canvas
  private static int Cwidth = 1200;
  private static int Cheight = 500;
  
  //this is the special main method that can only exist
  //once in a java program.  Java will look for this
  //method to start the running of your program
  //you should not add or edit any code in this method.
  public static void main(String[] args) {
    JFrame frame = new JFrame("Your Name Here");
    //main method has to exist in file being run
    //code below create a jframe with a canvas on it
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Canvas canvas = new Main();//constructor must match class name
    canvas.setSize(Cwidth, Cheight);
    canvas.setBackground(Color.black);//colors:RED,GREEN,BLUE,YELLOW,MAGENTA,CYAN,WHITE,BLACK,GRAY,LIGHT_GRAY,DARK_GRAY,PINK,ORANGE    
    frame.add(canvas);
    frame.pack();
    frame.setVisible(true);
    //end canvas code, do not edit
  }

  //the paint method is like the main method
  //because the Canvas code in the main method
  //will cause this method to be called when you 
  //run your program.  The code to run your program goes here
  //like the main method your program should only have one paint method
  //anything outputting to the Canvas must have the
  //Graphics g object in order to output or affect the Canvas 
  public void paint(Graphics g){
    int x = 85;//starting point for trail and is then used to center explosion
    for (int y = Cheight; y > 110; y -= 10){//makes a trail of red dots that climbs up the screen to 110
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, Cwidth, Cheight);
      g.setColor(Color.RED);
      g.fillRect(x, y, 3, 3);
      g.fillRect(x - 10, y + 10, 3, 3);
      g.fillRect(x - 20, y + 20, 3, 3);
      g.fillRect(x - 30, y + 30, 3, 3);
      x += 10;
      delay(50);
    }
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, Cwidth, Cheight);//clears trail
    int y = 110;//center of explosion
    for (int angle = 0; angle <= 1875; angle += 25){//draws 75 randomly colored circles around (475, 110)
      randomColor(g);
      g.drawOval(x + (int)Math.round(50 * Math.sin(Math.PI * angle / 180)) - 50, y + (int)Math.round(50 * Math.cos(Math.PI * angle / 180)) - 50, 100, 100);//moves 50 pixels from x and y at angles degrees
      delay(30);
    }
    for (int angle = 0; angle <= 1875; angle += 25){//covers up the 75 circles with black circles
      g.setColor(Color.BLACK);
      g.drawOval(x + (int)Math.round(50 * Math.sin(Math.PI * angle / 180)) - 50, y + (int)Math.round(50 * Math.cos(Math.PI * angle / 180)) - 50, 100, 100);
      delay(30);
    }
  }
  
  public static int rand(int num){//returns random number from 0-(num-1)
    int rand = (int)(Math.random()*num);
    return rand;
  }

  public static void randomColor(Graphics g){//sets drawing color to random color
    int CHANCE_OF_WHITE = 10;//1 in CHANCE_OF_WHITE to get white when calling a random color
    if (CHANCE_OF_WHITE - 1 == rand(CHANCE_OF_WHITE)){
      g.setColor(Color.WHITE);
    }else{
      g.setColor(new Color(rand(256), rand(256), rand(256)));
    }
  }

  public static void delay(int delaytime){//delays by the amount of milliseconds input to it
    //int delaytime = 100;
    long startDelay = System.currentTimeMillis();
    long endDelay = 0;

    while (endDelay - startDelay < delaytime){//until the difference between end and start is greater than delaytime the code freezes
        endDelay = System.currentTimeMillis();
    }
  }
}//end class
