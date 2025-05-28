public class Ex19_InterfaceExample {

    interface Playable {
        void play();
    }

    static class Guitar implements Playable {
        public void play() {
            System.out.println("Playing the guitar 🎸");
        }
    }

    static class Piano implements Playable {
        public void play() {
            System.out.println("Playing the piano 🎹");
        }
    }

     public static void main(String[] args) {
        Playable guitar = new Guitar();
        Playable piano = new Piano();

        guitar.play();
        piano.play();
    }
}
