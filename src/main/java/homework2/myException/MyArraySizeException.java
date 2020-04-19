package homework2.myException;

public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException(String message) {
        super("Неверный размер массива");
    }
}
