/**Class: OtherPets
 * @author Jah St.Aimee
 * @version 1.0
 * Course: ITEC 2150 Spring 2024
 * Written: Jan 23, 2024
 *
 * This class –  represents a category of pets
 * that don't fall into the specific categories
 * of cats or dogs. It extends the class Pet so it iherits
 * that classes behavior, but also creates it own attribute called
 * specialHandle which handles requirements with the other pets
 */
package VetTracker;

public class OtherPets extends Pet{
    String specialHandle;

    public OtherPets(String name, String ownerName, int age, String type, String specialHandle) {
        super(name, ownerName, age, type);
        this.specialHandle = specialHandle;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Special Handling: " + specialHandle);
    }
}


