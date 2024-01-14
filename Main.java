public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("\n\n--- Welcome to the ultimate Rock, Paper, Scissors experience! ---\n");

            if (Game.askToStartGame()) {
                Game.runGame();
            } else {
                System.out.println("Maybe next time! Goodbye!\n");
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}

