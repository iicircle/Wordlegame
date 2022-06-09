/*
Main - this is a runner class that runs the Game class

Author - Marc Shepard
*/

class Main {
  public static void main(String[] args) {
   Wordle g = new Wordle();
    g.begin();
    HashMap<String, Integer> scores;
    Wordle state = Wordle.restore();
    if (state != null) {
      scores = state.scorechart;
    }
    else {
      scores = new HashMap<String, Integer>();
    }
  }
}