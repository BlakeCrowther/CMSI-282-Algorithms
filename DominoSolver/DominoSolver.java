//Blake Crowther
//02/22/2018
public class DominoSolver {


    public static int findMaxPoints(int[][] scoreTable, int[] sequence, int i, int j) {
        if(scoreTable[i][j] > 0) {                                             //Checks if position is filled
            return scoreTable[i][j];
        }
        if(i == j) {                                                           //fills with 0 if matrix multiplying by itself
            return 0;
        }
        for(int k = i; k < j; k++) {                                           //loops through recursively filling the scoretable with the various orders of multiplication
            int possibleScore = findMaxPoints(scoreTable, sequence, i, k)  + findMaxPoints(scoreTable, sequence, k+1, j) + sequence[i-1] * sequence[k] * sequence[j];
            if(possibleScore > scoreTable[i][j]) {                             //If possible score is greater than score in scoreTable position then replaces that score
                scoreTable[i][j] = possibleScore;
            }
        }
        return scoreTable[i][j];                                               //returns the upper leftmost score which will result in the highest score
    }


    public static void main (String[] args) {
        if(args.length < 4 || args.length % 2 != 0) {                          //Checks for invalid sequence if odd length or too few dominos
            throw new IllegalArgumentException("Invalid Sequence");
        }

        int[] dominoSequence = new int[(args.length / 2) + 1];
        int subtract = 0;

        for(int i = 1; i < args.length - 1; i+=2) {                         //Creates sequence array without duplicates
            if(Integer.parseInt(args[i]) < 0 || Integer.parseInt(args[i]) != Integer.parseInt(args[i+1])) {         //checks if middle numbers are less than 0 or not equal to next number
                throw new IllegalArgumentException("Invalid Sequence");
            } else {
                dominoSequence[i - subtract] = Integer.parseInt(args[i]);
                subtract++;
            }
        }

        dominoSequence[0] = Integer.parseInt(args[0]);
        dominoSequence[dominoSequence.length - 1] = Integer.parseInt(args[args.length - 1]);

        int[][] scoreTable = new int[dominoSequence.length][dominoSequence.length];
        System.out.println(findMaxPoints(scoreTable, dominoSequence, 1, dominoSequence.length - 1));
    }
}
