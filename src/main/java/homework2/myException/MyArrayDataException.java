package homework2.myException;

public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(int i, int j) {
        super("Ошибка в ячейке [" + i + "][" + j + "]");
    }
}
