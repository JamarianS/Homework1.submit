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


