package pl.pjatk.tdd.test.arrays;

import org.junit.Assert;
import org.junit.Test;
import pl.pjatk.tdd.arrays.ArraysStatistics;

public class ArraysStatisticsTest {
    @Test
    public void maximumShouldBePositiveNumber() {
        Assert.assertEquals(1, ArraysStatistics.max(new int[]{-10, -5, 1, -2, -13}));
    }

    @Test
    public void maximumShouldBeNegativeNumber() {
        Assert.assertEquals(-10, ArraysStatistics.max(new int[]{-20, -13, -10, -11, -12}));
    }

    @Test
    public void minimumShouldBePositive() {
        Assert.assertEquals(2, ArraysStatistics.min(new int[]{3, 4, 5, 2, 7, 10}));
    }

    @Test
    public void minimumShouldBeNegative() {
        Assert.assertEquals(-99, ArraysStatistics.min(new int[]{-5, -50, 75, -75, -99, 0}));
    }

    @Test
    public void sumShouldBe100(){
        Assert.assertEquals(100, ArraysStatistics.sum(new int[]{10,20,30,40}));
    }

    @Test
    public void sumShouldBeMinus100(){
        Assert.assertEquals(-100, ArraysStatistics.sum(new int[]{-10,-20,-30,-40}));
    }

    @Test
    public void avgTest1(){
        Assert.assertEquals(3.8, ArraysStatistics.avg(new int[]{1,2,3,9,4}), 0.01);
    }
    @Test
    public void avgTest2(){
        Assert.assertEquals(10, ArraysStatistics.avg(new int[]{10,10,10,10}), 0.01);
    }
}
