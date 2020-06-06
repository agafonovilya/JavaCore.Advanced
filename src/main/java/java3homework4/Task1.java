package java3homework4;

public class Task1 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        Thread threadA = new Thread(new Print('A', 'B')::printSymbol);
        Thread threadB = new Thread(new Print('B', 'C')::printSymbol);
        Thread threadC = new Thread(new Print('C', 'A')::printSymbol);

        threadA.start();
        threadB.start();
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("\nFinish");
    }
}
