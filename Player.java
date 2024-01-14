import java.util.Random;

// Abstract base class for all types of players
public abstract class Player {
    protected String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method that subclasses must implement
    public abstract String chooseAction();
}

// Class for a human player
class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public String chooseAction() {
        return UserInterface.getUserInput("\nPlease enter your choice (Rock, Paper, or Scissors): ", new String[]{"Rock", "Paper", "Scissors"});
    }
}

// Class for a computer player
class ComputerPlayer extends Player {
    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public String chooseAction() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        return choices[new Random().nextInt(choices.length)];
    }
}
