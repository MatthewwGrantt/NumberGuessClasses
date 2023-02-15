import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Player {
    private String name;
    private ArrayList<NumberGuess> gamesPlayed;

    public Player(String name) {
        this.name = name;
        this.gamesPlayed = new ArrayList<>();
    }

    public void addGame(NumberGuess game) {
        this.gamesPlayed.add(game);
    }

    public ArrayList<NumberGuess> getGamesPlayed() {
        return gamesPlayed;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player name: " + name + "\n");
        sb.append("Games played: " + gamesPlayed.size() + "\n");
        int start = Math.max(0, gamesPlayed.size() - 5);
        for (int i = start; i < gamesPlayed.size(); i++) {
            sb.append("Game " + (i + 1) + ":\n" + gamesPlayed.get(i).toString());
        }
        return sb.toString();
    }
}


public class NumberGuess{
    private int min;
    private int max;
    private int number;
    private int numGuesses;
    private ArrayList<Integer> guessList;
    private String difficulty;

    public NumberGuess(int min, int max, String difficulty) {
        this.min = min;
        this.max = max;
        this.difficulty = difficulty;
        Random random = new Random();
        this.number = random.nextInt(min, max);
        this.numGuesses = 1;
        this.guessList = new ArrayList();
    }

    public NumberGuess() {
    }

    public void guess(int guess) {
        if (this.min > guess || guess > this.max) {
            System.out.println("Invalid Input Try Again");
        } else if (this.guessList.contains(guess)) {
            System.out.println("You already guessed this number, please guess again");
        } else if (this.number > guess) {
            System.out.println("guess higher");
            System.out.println("Guess Again");
            this.guessList.add(guess);
        } else if (this.number < guess) {
            System.out.println("guess lower");
            System.out.println("Guess Again");
            this.guessList.add(guess);
        } else {
            this.guessList.add(guess);
            System.out.println("You guessed correct!!!");
            System.out.println("It took you " + this.guessList.size() + " tries");
        }
    }

    public int getNumber() {
        return number;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Difficulty: " + difficulty + "\n");
        sb.append("Number: " + number + "\n");
        sb.append("Guesses: " + numGuesses + "\n");
        sb.append("Guess List: " + guessList.toString() + "\n");
        return sb.toString();
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        Player player = new Player(name);
        while (true) {
            System.out.println("Select a difficulty level:");
            System.out.println("1 - Easy (1-10)");
            System.out.println("2 - Medium (1-25)");
            System.out.println("3 - Hard (1-50)");
            int level = sc.nextInt();
            int min, max;
            String difficulty;
            switch (level) {
                case 1:
                    min = 1;
                    max = 10;
                    difficulty = "Easy";
                    break;
                case 2:
                    min = 1;
                    max = 25;
                    difficulty = "Medium";
                    break;
                case 3:
                    min = 1;
                    max = 50;
                    difficulty = "Hard";
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    continue;
            }
            NumberGuess numberGuess = new NumberGuess(min, max, difficulty);
            System.out.println("Try to guess a random number between " + min + " - " + max);
            while (sc.hasNextInt()) {
                int guess = sc.nextInt();
                numberGuess.guess(guess);
                if (numberGuess.getNumber() == guess) {
                    player.addGame(numberGuess);
                    break;
                }
            }
            Scanner mg = new Scanner(System.in);
            System.out.println("Do you want to keep playing? YES or NO");
            String playAgain = mg.nextLine();
            if (playAgain.equalsIgnoreCase("yes")) {
                NumberGuess JG  = new NumberGuess();
            } else {
                System.out.println("Thank you for playing!");
                System.exit(0);
}
        }
    }
}