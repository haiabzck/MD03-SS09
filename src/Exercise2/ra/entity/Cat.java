package Exercise2.ra.entity;

public class Cat extends Pet{
    public Cat(String id, String name, int age) {
        super(id, name, age);
    }

    public Cat() {
    }
    @Override
    public void speak(){
        System.out.println(" Meo meo");
    }
}
