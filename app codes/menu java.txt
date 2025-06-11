
import java.util.Scanner;

public class Menu {
    public void appMenu() {
        User user = new User();
        Collection collection = new Collection();
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the collection application");
        System.out.println("exit - 0\n add item to collection - 1\n delete added item - 2\n view collection - 3\n");

        boolean repeat = true;
        try {
            while (repeat) {
                String userChoice = InputHelper.getText("your choice => ");
                switch (userChoice) {
                    case "0":
                        user.logout();
                        repeat = false;
                        break;
                    case "1":
                        collection.createCollection();
                        repeat = false;
                        break;
                    case "2":
                        collection.deleteItem();
                        repeat = false;
                        break;
                    case "3":
                        collection.showUserCollection();
                        repeat = false;
                        break;
                    default:
                        System.out.println("please enter a valid option...");
                        repeat = true;
                        break;
                }
            }

        } catch (Exception error) {
            System.out.println("error, please try again. error message: " + error.getMessage());
        }
    }
}
