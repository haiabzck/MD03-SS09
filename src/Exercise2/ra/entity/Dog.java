package Exercise2.ra.entity;

public class Dog extends Pet{

    public Dog(String id, String name, int age) {
        super(id, name, age);
    }

    public Dog() {
    }

    @Override
    public void speak(){
        System.out.println("Gâu gâu");
    }
}
