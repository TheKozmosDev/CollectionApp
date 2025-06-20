
import java.util.Scanner;

public class User {

    Scanner input = new Scanner(System.in);
    public static String userName;
    private int userPassword;
    Menu menu = new Menu();

    public void login() {
        try {
            System.out.println("Welcome to the application, please fill in the required information...");
            userName = InputHelper.getText("Enter your username: ");
            userPassword = InputHelper.getNumber("Please enter your password: ");
            System.out.println("Thank you, redirecting to the main menu...");
            Thread.sleep(2000);
            menu.appMenu();
        } catch (Exception error) {
            System.out.println("Error, please try again. Error message: " + error.getMessage());
        }
    }

    public void logout() {
        try {
            String userChoice = InputHelper.getText("Are you sure you want to exit the application? (Y/n): ").toLowerCase();
            switch (userChoice) {
                case "y":
                    System.out.println("Exiting the system, see you again " + userName);
                    break;
                case "n":
                    System.out.println("Action cancelled, you can continue where you left off...");
                    Thread.sleep(2000);
                    menu.appMenu();
                    break;
            }
        } catch (Exception error) {
            System.out.println("Error, please try again. Error message: " + error.getMessage());
        }
    }
}
