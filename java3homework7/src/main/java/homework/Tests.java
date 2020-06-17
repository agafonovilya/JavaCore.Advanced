package homework;

import homework.tester.annotations.AfterSuite;
import homework.tester.annotations.BeforeSuite;
import homework.tester.annotations.Test;

public class Tests {

    @BeforeSuite
    public void before() {
        System.out.println("Before");
    }

    @Test(priority = Test.Priority.TWO)
    public void test1() {
        System.out.println("Priority: 2");
    }

    @Test(priority = Test.Priority.THREE)
    public void test2() {
        System.out.println("Priority: 3");
    }

    @Test(priority = Test.Priority.TEN)
    public void test3() {
        System.out.println("Priority: 10");
    }

    @Test(priority = Test.Priority.NINE)
    public void test4() {
        System.out.println("Priority: 9");
    }

    @Test
    public void test5() {
        System.out.println("Default priority: 5");
    }

    @AfterSuite
    public void after() {
        System.out.println("After");
    }

}