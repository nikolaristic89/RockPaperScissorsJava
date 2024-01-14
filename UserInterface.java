import java.util.Scanner;
public class UserInterface {
    public static String getUserInput(String text, String[] validOptions) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(text);
                String userInput = scanner.nextLine().trim();
                for (String option : validOptions) {
                    if (userInput.equalsIgnoreCase(option)) {
                        return option;
                    }
                }
                System.out.println("Invalid input. Please choose from " + String.join(", ", validOptions));
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage() + ". Please try again.");
            }
        }
    }
}

