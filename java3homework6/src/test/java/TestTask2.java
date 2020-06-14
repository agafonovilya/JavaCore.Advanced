import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTask2 {
    private Task2 task2;

    @Before
    public void prepare(){
        task2 = new Task2();
    }

    @Test
    public void test1() {
        if(task2.hasOneOrFour(new int[]{1, 1, 1, 4, 4, 1, 4, 4})){
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void test2() {
        Assert.assertThat(task2.hasOneOrFour(new int[]{1, 1, 1, 1, 1, 1}), Is.is(false));
    }

    @Test
    public void test3() {
        Assert.assertThat(task2.hasOneOrFour(new int[]{4, 4, 4, 4}), Is.is(false));
    }

    @Test
    public void test4() {
        Assert.assertThat(task2.hasOneOrFour(new int[]{4, 4, 1, 1, 4, 3}), Is.is(false));
    }


}
