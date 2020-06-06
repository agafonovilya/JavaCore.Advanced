package java3homework4;

public class Task1 {

    private static Object lock = new Object();

    private static volatile Character currentLetter = 'A';

    public static void main(String[] args) throws InterruptedException {


        Thread threadA = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                synchronized (lock){
                    while (currentLetter != 'A'){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    lock.notifyAll();

                }

            }
        });
        Thread threadB = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                synchronized (lock){
                    while (currentLetter != 'B'){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    lock.notifyAll();

                }

            }
        });
        Thread threadC = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                synchronized (lock){
                    while (currentLetter != 'C'){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("C" + " ");
                    currentLetter = 'A';
                    lock.notifyAll();

                }

            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();


        System.out.print("Finish");
    }
}
