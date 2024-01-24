/**Class: VetOfficeTracker
 * @author Jah St.Aimee
 * @version 1.0
 * Course: ITEC 2150 Spring 2024
 * Written: Jan 23, 2024
 *
 * This class – reperesnts a veterinary office tracker system
 * that allows the user the manage information about pets
 * like adding,finding, and deleting certain pets information.
 */
package VetTracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VetOfficeTracker {
    // Existing code...
    private List<Pet> petList;

    public VetOfficeTracker() {
        this.petList = new ArrayList<>();
    }

    private void addNewPet() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the new pet: ");
        String name = scanner.nextLine();

        System.out.print("Enter the owner's name of the new pet: ");
        String ownerName = scanner.nextLine();

        System.out.print("Enter the age of the new pet: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the type of the new pet: ");
        String petType = scanner.nextLine();

        Pet newPet = new Pet(name, ownerName, age, petType);
        petList.add(newPet);

        System.out.println("New pet added:");
        newPet.displayInfo();
    }

    /** Method: addNewPet
     * Prompts the user to enter to information
     */



    public void findAndDeletePets() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nDo you want to find, delete, add a pet, or exit? ");
            String choice = scanner.nextLine().toLowerCase();

            if ("find".equals(choice)) {
                System.out.print("Enter the name of the pet you want to find: ");
                String nameToFind = scanner.nextLine();
                Pet foundPet = findPetByName(nameToFind);
                if (foundPet != null) {
                    foundPet.displayInfo();
                } else {
                    System.out.println("Pet with name " + nameToFind + " not found.");
                }

            } else if ("delete".equals(choice)) {
                System.out.print("Enter the name of the pet you want to delete: ");
                String nameToDelete = scanner.nextLine();
                deletePetByName(nameToDelete);

            } else if ("add".equals(choice)) {
                addNewPet();

            } else if ("exit".equals(choice)) {
                saveChangesToFile();
                System.out.println("Changes saved. Exiting the program.");
                break;

            } else {
                System.out.println("Invalid choice. Please enter 'find', 'delete', 'add', or 'exit'.");
            }
        }
    }

    /** Method: findAndDeletePets
     * Ask the user to pick between finding,deleting,
     * adding a pet, or exiting
     * @return The corresponding methods based on the user's choice
     *
     */

    private Pet findPetByName(String name) {
        for (Pet pet : petList) {
            if (pet.getName().trim().equalsIgnoreCase(name.trim()) || pet.getName().trim().equalsIgnoreCase("\"" + name.trim() + "\"")) {
                return pet;
            }
        }
        return null;
    }
    /** Method: findPetByName
     * Searches for a pet by name in the petList
     * @return The first match
     */


    private void deletePetByName(String name) {
        Pet petToDelete = findPetByName(name);
        if (petToDelete != null) {
            petList.remove(petToDelete);
            System.out.println(name + " has been deleted.");
        } else {
            System.out.println("Pet with name " + name + " not found.");
        }
    }

    /** Method: deletePetByName
     * Deletes a pet by name from the petList
     */


    private void saveChangesToFile() {
        try (FileWriter writer = new FileWriter("clientsForPet.txt")) {
            for (Pet pet : petList) {
                writer.write(pet.getName() + "," + pet.getOwnerName() + "," + pet.getAge() + "," + pet.getPetType() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error saving changes to file: " + e.getMessage());
        }
        System.out.println("Changes saved to clientsForPet.txt");
    }

    /** Method: saveChangesToFile
     * Writes the information of all pets in the petList
     * to a file("clientsForPet.txt")
          */



    private void printClientsFileContent() {
        try (Scanner fileScanner = new Scanner(new File("clientsForPet.txt"))) {
            System.out.println("\nContent of the clientsForPet.txt file:");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
    /** Method: printClientsFileContent
     * Read and prints the context in the "clientsForPet.txt" File
     * @return The context within the file clientsForPet.txt
     */




    private void displayPetList() {
        for (Pet pet : petList) {
            pet.displayInfo();
            System.out.println();  // Add a newline for better readability
        }
    }
    /** Method: displayPetList
     * Displays information for each pet in petList
     * @return petList information
     */


    private void readPetsFromFile() {
        try (Scanner fileScanner = new Scanner(new File("clientsForPet.txt"))) {
            System.out.println("List of Pets:");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();  // Trim to remove leading and trailing spaces
                if (line.isEmpty()) {
                    continue;  // Skip empty lines
                }

                System.out.println(line);

                String[] parts = line.split(",");
                String name = parts[0].trim().replaceAll("^\"|\"$", "");
                String ownerName = parts[1].trim();
                int age;
                try {
                    age = Integer.parseInt(parts[2].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing age for pet: " + name);
                    continue;  // Skip this pet if age is not an integer
                }
                String petType = parts[3].trim();
                // Add the pet to the list, ignoring additional attributes for now
                petList.add(new Pet(name, ownerName, age, petType));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
    /** Method: readPetsFromFile
     * Read pet information from the "clientsForPet.txt" file and adds
     * pet to petList
     * @return Pets from the file "contextForPets.txt"
     */



    public static void main(String[] args) {
        VetOfficeTracker vetOfficeTracker = new VetOfficeTracker();
        vetOfficeTracker.readPetsFromFile();
        vetOfficeTracker.displayPetList();
        vetOfficeTracker.findAndDeletePets();
        vetOfficeTracker.printClientsFileContent();

        /** Method: main
         * Creates an instance of VetOfficeTracker, reads pet info from file
         * , displayes pet list, allows uer to find and delete pets
         * @return Updated content of file
         */
    }
}

