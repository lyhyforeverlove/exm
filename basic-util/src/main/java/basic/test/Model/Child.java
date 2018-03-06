package basic.test.Model;

public class Child extends Person {

    private int gender;

    public Child() {
    }

    public Child(int gender) {
        this.gender = gender;
    }

    @Override
    public String getAgeName(int i) {
        return gender + super.getAgeName(i);
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public static void main(String[] args) {
        Person person1 = new Person(1,"test",15);
        Person person2 = new Child(1);
        Child child = new Child();

        System.out.println(person1.getAgeName(0));
        System.out.println(person2.getAgeName(0));
        System.out.println(child.getAgeName(0));


    }

}
