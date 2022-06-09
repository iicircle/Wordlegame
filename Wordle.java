/*
Wordle class - simple word guessing game

In this game, one person tries to guess a word and the program gives them clues to help them guess the word. (Wordle Type Game)

Author - Arvin Pouresfandiary Cham, Evan Wangelin

Change history:
5/16: Created

Planning:

Method info:
Wordle class (intro to game and rules) - public Worlde () - constructor
guess class (guess that is the input from player)
giveclue class (changes String and adds *)

State info:
String word; (word that the player must guess)
String input; (the word that the players guesses)
int turnsnum; (number of turns that the player has/ 6 turns)
*/

import java.util.HashMap;
import java.util.Scanner;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Wordle {
  private String input;
  private String wordguess;
  private String name;
  private static String[] words = {"above", "tesla", "lucid", "speed", "apple", "spice","among", "piano", "dough", "melon"};
  private String answer; 
  private String pattern = "";
  private static Scanner scan = new Scanner (System.in);
 private HashMap<String, Integer> scorechart = new HashMap<String, Integer>();

  // this begins the game and gives the person the choice to play (calling the guess class) or see their score (calling the score class)
  public void begin() {
    System.out.println("Hello! Welcome to Wordle Light! In this game, you try to guess a word and the program gives you clues to help you guess the word. The way you try to guess the word is by inputing 5 letter words and the program will give you clues based on your input in order to help you guess the word.");
  System.out.println("What is your name?");
    name = scan.nextLine();
System.out.println("Hi " + name + "!");
    while(true){
  System.out.println("What would you like to do?");
  System.out.println("p to play \ns to view score\nq to quit");
    input = scan.nextLine();
      switch (input){
      case "p":
      guess();
      break;
      case "s":
      score();
      break;
        case "q":
          return;
        default:
          System.out.println("Please input a valid response.");
          break;
  }
    }
    
  }

  // this is the main code for the game that checks the users input and gives them clues based on their input in order for them to guess the word
  public String guess() {
    System.out.println("Guess");
    answer = Utils.randChoice(words);
    int scorecounter = 1;
    boolean x = true;
    boolean y = true;
     System.out.println("■ means correct letter and location \n◪ means correct letter but wrong location \n□ means wrong letter and location");
    for (int tries = 1; tries <= 6; tries++){
      System.out.println("Try " + tries + " of 6");
    System.out.println("What is your guess? (5 letter words only)");
      try {
        wordguess = scan.nextLine();
        if (wordguess.length() == 5) {
        System.out.print("");
      }
        else {
          System.out.println("Invalid Input.");
          tries--;
          continue;
        }
      } catch(Exception e) {
        System.out.println("Something went wrong.");
      } 

      for (int letter = 0; letter < 5; letter++){
        if(wordguess.substring(letter, letter+1).equals(answer.substring(letter, letter+1))){
        pattern = pattern + "■";
        }
      else{
        
      for(int i = 0; i < 5; i++){
        if(wordguess.substring(letter, letter+1).equals(answer.substring(i, i+1))){
          pattern = pattern +"◪";
          x = false;
          break;
        } 
      }
        if(x){
         for(int j = 5; j > 0; j--){
          if(wordguess.substring(letter, letter+1).equals(answer.substring(j-1, j))){
            pattern = pattern +"◪";
            x = false;
            break;
          } 
         }
          }
        if (x){
        pattern = pattern + "□";
          }
          }
          x = true;
      }
    
    System.out.print(pattern);
       if(wordguess.equals(answer)){
         scorechart.put(name, scorecounter);
        System.out.println("\nYou got the correct word! \nYou got the word in " + scorecounter + "."); 
         pattern = "";
         y = false;
         break;
      }
      scorecounter++;
      System.out.println("");
      pattern = "";
    
      }
      if (y){
       System.out.println("You've lost, the word was " + answer + ".");
        scorecounter = 0;
        scorechart.put(name, scorecounter);
      
      }
    
    return "";
    
      } 
  
//this method returns the score of the user by using their name to get their score from the scorechart HashMap
public int score() { 
  System.out.println("Latest Score: " + scorechart.get(name));
  return 1;
}
}

 