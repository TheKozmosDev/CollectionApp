
import java.io.IOException;
import java.util.ArrayList;

public class Collection {
    private String collectionName;

    ArrayList<String> userCollection = new ArrayList<>();
    Menu menu = new Menu();

    public void createCollection() {
        try {
            System.out.println("Please enter the name of the collection to be created...");
            String newCollection = InputHelper.getText("=> ");
            System.out.println("Do you want to add items to " + newCollection + " collection? (Y/n)");
            String userChoice = InputHelper.getText("=> ").toLowerCase();
            switch (userChoice) {
                case "y":
                    addCollectionItem();
                    break;
                case "n":
                    System.out.println("Your collection has been created but it's empty.");
                    System.out.println("Redirecting to the main menu...");
                    Thread.sleep(2000);
                    menu.appMenu();
                    break;
                default:
                    System.out.println("Error, please try again...");
                    break;
            }
        } catch (Exception error) {
            System.out.println("Error, please try again. Error message: " + error.getMessage());
        }
    }

    public void addCollectionItem() {
        boolean control = true;
        while (control) {
            System.out.println("Enter the name of the item to add:");
            String itemName = InputHelper.getText("=> ").toLowerCase();
            userCollection.add(itemName);

            System.out.println("Do you want to add something else? (Y/n)");
            String userChoice = InputHelper.getText("=> ").toLowerCase();

            switch (userChoice) {
                case "y":
                    addCollectionItem();
                    break;

                case "n":
                    System.out.println("What would you like to do now?\n View collection - 0\n Return to main menu - 1\n");
                    String nextChoice = InputHelper.getText("=> ");
                    switch (nextChoice) {
                        case "0":
                            control = false;
                            showUserCollection();
                            break;
                        case "1":
                            menu.appMenu();
                            control = false;
                            break;
                        default:
                            control = true;
                            System.out.println("Error, please try again...");
                    }
                    break;
                default:
                    control = true;
                    System.out.println("Error, please try again...");
            }
        }
    }

    public void showUserCollection() {
        if (!collectionControl()) return;

        for (String item : userCollection) {
            System.out.println(item);
        }
        System.out.println("Items in your collection have been listed.");
        System.out.println("Total items in the collection: " + userCollection.stream().count());

        System.out.println("What would you like to do now?\n Add item to collection - 0\n Delete item from collection - 1\n Return to main menu - 2\n");
        String userChoice = InputHelper.getText("=> ");
        switch (userChoice) {
            case "0":
                addCollectionItem();
                break;
            case "1":
                deleteItem();
                break;
            case "2":
                menu.appMenu();
                break;
            default:
                System.out.println("Error, please try again...");
                break;
        }
    }

    public void deleteItem() {
        if (!collectionControl()) return;

        System.out.println("Enter the name of the item you want to delete...");
        String itemToDelete = InputHelper.getText("=> ").toLowerCase();

        if (userCollection.contains(itemToDelete)) {
            userCollection.remove(itemToDelete);
            System.out.println(itemToDelete + " was found and deleted from the collection.");
        } else {
            System.out.println(itemToDelete + " was not found in the collection. Would you like to try again? (Y/n)");
            String userChoice = InputHelper.getText("=> ").toLowerCase();
            switch (userChoice) {
                case "y":
                    deleteItem();
                    break;
                case "n":
                    System.out.println("Action cancelled.");
                    menu.appMenu();
                    break;
                default:
                    System.out.println("Error, please try again...");
                    break;
            }
        }
    }

    public void saveCollection() {
        String fileName = InputHelper.getText("Please enter the file name: ");
        try {
            java.io.FileWriter writer = new java.io.FileWriter(fileName);
            for (String item : userCollection) {
                writer.write(item + "\n");
            }
            writer.close();
            System.out.println("Collection successfully saved to file: " + fileName);
            System.out.println("Redirecting to the main menu...");
            Thread.sleep(2000);
            menu.appMenu();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error while saving file: " + e.getMessage());
        }
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String name) {
        this.collectionName = name;
    }

    private boolean collectionControl() {
        if (userCollection.isEmpty()) {
            System.out.println("You currently have no collection or your collection is empty.");
            createCollection();
            return false;
        }
        return true;
    }
}

