
public class Ex18_InheritanceExample {

    static class Animal {
        void makeSound() {
            System.out.println("Some generic animal sound");
        }
    }

    static class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Bark");
        }
    }

    public static void main(String[] args) {
        Animal genericAnimal = new Animal();
        Dog dog = new Dog();

        System.out.println("Animal makes sound:");
        genericAnimal.makeSound();

        System.out.println("Dog makes sound:");
        dog.makeSound();
    }
}
