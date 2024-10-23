//HRRAKR001
//25/09/2024
//Akram Harris

public class CowsAndBulls { // CowsAndBulls class made for the Game.java
    public static final int NUM_DIGITS = 4; // Initializing the necessary instance variables
    public static final int MAX_VALUE = 9876;
    public static final int MIN_VALUE = 1234;
    public static final int MAX_GUESSES = 10;

    private int secretNumber;
    private int guessesLeft;
    
    public CowsAndBulls(int seed) { // This is used to generate a random number based on the seed value inputted which as NUM_DIGITS length
        NumberPicker picker = new NumberPicker(seed, 1, 9);
        secretNumber = 0;
        for (int i = 0; i < NUM_DIGITS; i++) {
            secretNumber = secretNumber * 10 + picker.nextInt();
        }
        guessesLeft = MAX_GUESSES; // Gives the user 10 guesses
    }

    public int guessesRemaining() { // Returns the guesses left
        return guessesLeft;
    }

    public Result guess(int guessNumber) { // The method used to guess the secret number
    guessesLeft--; // Takes one of your guesses away
    int bulls = NumberUtils.countMatches(secretNumber, guessNumber);
    int cows = NumberUtils.countIntersect(secretNumber, guessNumber) - bulls;
    
    lastResult = new Result(cows, bulls);
    return lastResult;
}
    private boolean hasGivenUp = false;
    public int giveUp() { // When the user wants to give up and see the number
        hasGivenUp = true;
        return secretNumber;
    }

   private boolean gameOver;
   private Result lastResult;

   public boolean gameOver() { // Checks if the game is over
    return hasGivenUp || lastResult != null && lastResult.isCorrect() || guessesLeft == 0;
}
}
