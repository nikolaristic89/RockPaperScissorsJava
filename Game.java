public class Game {
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public static boolean askToStartGame() {
        String userChoice = UserInterface.getUserInput("Are you ready to begin? \nPlease enter (Yes or No): ", new String[]{"Yes", "No"});
        return userChoice.equals("Yes");
    }

    public static void runGame() {
        while (true) {
            Game newGame = askGameMode();
            //String result = newGame.playRound();
            newGame.playRound();

            String playAgain = UserInterface.getUserInput("Do you want to play another round? \nPlease enter (Yes or No): ", new String[]{"Yes", "No"});
            if (playAgain.equalsIgnoreCase("no")) {
                System.out.println("Thank you for playing!\n");
                break;
            }
        }
    }

    private static Game askGameMode() {
        System.out.println("\nPlease select the game mode:");
        System.out.println("1: Human vs Computer - Test your skills against the computer!");
        System.out.println("2: Computer vs Computer - Watch two robots compete!");
        String gameMode = UserInterface.getUserInput("\nPlease enter (1 or 2): ", new String[]{"1", "2"});
        if (gameMode.equals("1")) {
            return new Game(new HumanPlayer("Human"), new ComputerPlayer("Computer"));
        } else { // gameMode.equals("2")
            return new Game(new ComputerPlayer("Computer 1"), new ComputerPlayer("Computer 2"));
        }
    }

    private String playRound() {
      String choicePlayer1 = player1.chooseAction();
      String choicePlayer2 = player2.chooseAction();
      System.out.println("\n--- New Round ---");
      System.out.println(player1.getName() + " chooses " + choicePlayer1);
      System.out.println(player2.getName() + " chooses " + choicePlayer2);
  
      String result = determineWinner(choicePlayer1, choicePlayer2);
      System.out.println("--- " + result + " ---\n");
      return result;
    }
  

    private String determineWinner(String choicePlayer1, String choicePlayer2) {
        if (choicePlayer1.equals(choicePlayer2)) {
            return "It's a tie!";
        } else if ((choicePlayer1.equals("Rock") && choicePlayer2.equals("Scissors")) ||
                   (choicePlayer1.equals("Scissors") && choicePlayer2.equals("Paper")) ||
                   (choicePlayer1.equals("Paper") && choicePlayer2.equals("Rock"))) {
            return player1.getName() + " wins!";
        } else {
            return player2.getName() + " wins!";
        }
    }
}
