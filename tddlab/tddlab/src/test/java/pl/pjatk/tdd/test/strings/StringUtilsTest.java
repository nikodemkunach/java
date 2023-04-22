package pl.pjatk.tdd.test.strings;

import org.junit.Test;
import pl.pjatk.tdd.strings.StringUtils;

import static junit.framework.TestCase.assertEquals;

public class StringUtilsTest {
    @Test
    public void sumOfStrings(){
        String expected = "7";
        String result = String.valueOf(StringUtils.sumOfString("52"));
        assertEquals(expected, result);
    }

    @Test
    public void palindromeTest1(){
        boolean expected = true;
        boolean result = StringUtils.isPalindrome("aga");
        assertEquals(expected, result);
    }

    @Test
    public void palindromeTest2(){
        boolean expected = true;
        boolean result = StringUtils.isPalindrome("A kilku tu klika");
        assertEquals(expected, result);
    }

    @Test
    public void palindromeTest3(){
        boolean expected = false;
        boolean result = StringUtils.isPalindrome("nikodem");
        assertEquals(expected, result);
    }
}
