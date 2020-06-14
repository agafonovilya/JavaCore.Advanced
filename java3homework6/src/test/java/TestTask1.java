import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTask1 {
    private Task1 task1;

    @Before
    public void prepare(){
        task1 = new Task1();
    }

    @Test
    public void testTask1ArrayNormal() {
        int[] data = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        Assert.assertArrayEquals(new int[]{1, 7}, task1.elementsOfArrayAfterFour(data));
    }

    @Test
    public void testTask1ArrayWithLastFour() {
        int[] data = {1, 2, 4, 4, 2, 3, 4, 1, 4};
        Assert.assertArrayEquals(new int[0], task1.elementsOfArrayAfterFour(data));
    }

    @Test(expected = RuntimeException.class)
    public void testTask1ArrayWithoutFour() {
        int[] data = {1, 2, 2, 3, 1, 10};
        task1.elementsOfArrayAfterFour(data);
    }

    @Test(expected = RuntimeException.class)
    public void testTask1EmptyArray() {
        int[] data = {1, 2, 2, 3, 1, 10};
        task1.elementsOfArrayAfterFour(data);
    }

}
