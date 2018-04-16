//Blake Crowther
//03/27/2018
import java.util.Random;
public class DiceSolver {


    public static int playGame(int[] d) {
        Boolean gameEnd = false;
        int win = 0;

        while(gameEnd != true) {                                //loop until lose or win
            int sixCount = 0;
            for(int i = 0; i < d.length; i++) {
                Random rand = new Random();
                d[i] = rand.nextInt((6 - 1) + 1) + 1;           //generate number from 1 to 6
                if(d[i] == 6) {                                 //add up amount of 6's in roll
                    sixCount++;
                }
            }
            if(sixCount == 1) {                                 //if only one 6 then win
                win = 1;
                gameEnd = true;
            }
            if(sixCount == 0) {                                 //if no 6's then lose
                win = 0;
                gameEnd = true;
            }
        }
        return win;
    }

    public static void main (String[] args) {
        int numberOfDice;
        if(args.length != 1) {                                  // if invalid input default 5
            numberOfDice = 5;
        } else {
            numberOfDice = Integer.parseInt(args[0]);
        }
        int[] dice = new int[numberOfDice];
        double wins = 0.0;
        for(int i = 0; i < 1000000; i++) {                      // play 1000000 games adding up wins
            wins += playGame(dice);
        }
        double probability = wins / 1000000;                    //find probability by dividing wins by total games
        System.out.println(probability);
    }
}
