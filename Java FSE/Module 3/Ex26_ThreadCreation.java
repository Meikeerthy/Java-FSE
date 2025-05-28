public class Ex26_ThreadCreation {
    
    static class MyThread1 extends Thread {
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("MyThread1 is running... " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("MyThread1 interrupted.");
                }
            }
        }
    }

    static class MyRunnable implements Runnable {
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("MyRunnable is running... " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("MyRunnable interrupted.");
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        
        Thread t2 = new Thread(new MyRunnable());

        t1.start();
        t2.start();
    }
}
