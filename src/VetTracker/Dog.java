/**Class: Dog
 * @author Jah St.Aimee
 * @version 1.0
 * Course: ITEC 2150 Spring 2024
 * Written: Jan 23, 2024
 *
 * This class –  represents a dog as a type of pet.
 * Similar to the Cat class, it extends another class named Pet,
 * indicating that it inherits or specializes the behavior of the Pet class.
 * It also creates two of its own attributes breed that represents the breed of the dog
 * And color which represents the color of the dog.
 */
package VetTracker;

public class Dog extends Pet {
    // Additional attributes for dogs
    String breed;
    String color;

    // Constructor
    public Dog(String name, String ownerName, int age, String breed, String color) {
        super(name, ownerName, age, "dog");
        this.breed = breed;
        this.color = color;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed: " + breed + ", Color: " + color);
    }
}

