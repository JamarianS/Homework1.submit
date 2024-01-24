/**Class: Cat
 * @author Jah St.Aimee
 * @version 1.0
 * Course: ITEC 2150 Spring 2024
 * Written: Jan 23, 2024
 *
 * This class – represents a cat as a type of pet.
 * It extends another class named Pet, indicating that it inherits or specializes the behavior of the Pet class.
 * It also creates its own attribute hairLength that represents the length of the cats hair
 * Clawed and DeClawed that indicates if the has claws or not
 * And Lastly color
 */
package VetTracker;

public class Cat extends Pet {
    String hairLength;
    boolean clawed;
    boolean declawed;
    String color;

    public Cat(String name, String ownerName, int age, String hairLength, boolean clawed, boolean declawed, String color) {
        super(name, ownerName, age, "cat");
        this.hairLength = hairLength;
        this.clawed = clawed;
        this.declawed = declawed;
        this.color = color;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Hair Length: " + hairLength);
    }
}

