package homework5;

import java.util.Arrays;

public class Homework5 {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) {
        System.out.println("Равенство массивов после обработки первым и вторым методом: " + Arrays.equals(method1(), method2()));
    }

    /**
     * Перый метод считает в 1 поток
     * @return
     */
    public static float[] method1(){
        float[] arr = new float[SIZE];

        for (int i = 1; i < arr.length; i++){
            arr[i] = 1;
        }

        long a = System.currentTimeMillis(); //Засекаем время выполнения

        counting(arr, 0);

        System.out.println("Время выполнения метода 1: " + (System.currentTimeMillis() - a));


        return arr;
    }

    /**
     * Второй метод считает в 2 потока
     * @return
     */
    public static float[] method2(){
        float[] arr = new float[SIZE];
        for (int i = 1; i < arr.length; i++){
            arr[i] = 1;
        }

        long a = System.currentTimeMillis(); //Засекаем время выполнения

        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        class runnable1 implements Runnable{
            private float[] arr;
            private runnable1(float[] a1){
                this.arr = a1;
            }
            @Override
            public void run() {
                counting(arr, 0);
            }
        }
        class runnable2 implements Runnable{
            private float[] arr;
            private runnable2(float[] a2) {
                this.arr = a2;
            }
            @Override
            public void run() {
                counting(arr, HALF);
            }
        }

        Thread thread1 = new Thread(new runnable1(a1));
        Thread thread2 = new Thread(new runnable2(a2));
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);

        System.out.println("Время выполнения метода 2: " + (System.currentTimeMillis() - a));

        return arr;
    }

    /**
     * Метод математического подсчета элементов массива
     * @param arr
     * @param pos
     */
    public static void counting(float[] arr, int pos){
        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (float) (i+pos) / 5) * Math.cos(0.2f + (float) (i+pos) / 5) * Math.cos(0.4f + (float) (i+pos) / 2));
        }
    }


}