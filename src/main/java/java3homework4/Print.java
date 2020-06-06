package java3homework4;

public class Print {

    private static final Object lock = new Object();
    private static volatile Character currentSymbol = 'A';

    private final Character symbol;
    private final Character nextSymbol;

    public Print(Character symbol, Character nextSymbol) {
        this.symbol = symbol;
        this.nextSymbol = nextSymbol;
    }

    void printSymbol(){
        for (int i = 0; i < 5; i++) {
            synchronized (lock){
                while (currentSymbol != symbol){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(symbol);
                currentSymbol = nextSymbol;
                lock.notifyAll();

            }

        }


    }
}
