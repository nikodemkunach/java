package pl.pjatk.tdd.strings;


public class StringUtils {
    public static int sumOfString(String str){
        int sum = 0;
        for(int i=0; i<str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                sum += Character.getNumericValue(str.charAt(i));
            }
        }
        return sum;
    }
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while(left < right)
        {
            if(str.charAt(left) != str.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}