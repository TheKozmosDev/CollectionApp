
import java.util.Scanner;

// Simplifies user input operations
public class InputHelper {
    static Scanner input = new Scanner(System.in);

    public static int getInt(String message) {
        while (true) {
            System.out.print(message);
            String inputLine = input.nextLine();

            try {
                return Integer.parseInt(inputLine);
            } catch (Exception e) {
                System.out.println("You must enter a valid number.");
            }
        }
    }

    public static String getText(String message) {
        while (true) {
            System.out.print(message);
            String inputLine = input.nextLine();

            if (!inputLine.trim().isEmpty()) {
                return inputLine;
            }

            System.out.println("This field cannot be left empty.");
        }
    }
}

