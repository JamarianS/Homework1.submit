/**Class: Pet
 * @author Jah St.Aimee
 * @version 1.0
 * Course: ITEC 2150 Spring 2024
 * Written: Jan 23, 2024
 *
 * This class – Acts a parent class the represents generic information
 * about pets.
 */
package VetTracker;

public class Pet {
    String name;
    String petType;
    int age;
    String ownerName;

    public Pet(String name, String ownerName, int age, String petType) {
        this.name = name;
        this.ownerName = ownerName;
        this.age = age;
        this.petType = petType;
    }

    public void displayInfo(){
        System.out.println("Name: " + name + " Age: " + age + " Type: " +  petType + " Owner Name: " + ownerName);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return petType;
    }

    public int getAge() {
        return age;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getPetType() {
        return petType;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }
    @Override
    public String toString() {
        return name + "," + ownerName + "," + age + "," + petType;
    }
}
