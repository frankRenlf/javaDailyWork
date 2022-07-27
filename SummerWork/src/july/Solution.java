package july;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : july
 * @createTime : 2022/7/27 13:18
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    public String fractionAddition(String expression) {
        long denominator = 0, numerator = 1; // 分子，分母
        int index = 0, n = expression.length();
        while (index < n) {
            // 读取分子
            long denominator1 = 0, sign = 1;
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index) == '-' ? -1 : 1;
                index++;
            }
            while (index < n && Character.isDigit(expression.charAt(index))) {
                denominator1 = denominator1 * 10 + expression.charAt(index) - '0';
                index++;
            }
            denominator1 = sign * denominator1;
            index++;

            // 读取分母
            long numerator1 = 0;
            while (index < n && Character.isDigit(expression.charAt(index))) {
                numerator1 = numerator1 * 10 + expression.charAt(index) - '0';
                index++;
            }

            denominator = denominator * numerator1 + denominator1 * numerator;
            numerator *= numerator1;
        }
        if (denominator == 0) {
            return "0/1";
        }
        long g = gcd(Math.abs(denominator), numerator); // 获取最大公约数
        return Long.toString(denominator / g) + "/" + Long.toString(numerator / g);
    }

    public long gcd(long a, long b) {
        long remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }

    // well, find it : the chars don't deal with all words
    // each word corresponds to all chars, when turn to next word, the chars are return to the initial state
    // the question is flawed, and we can see the true regular in the instance 1.
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (char x : chars.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int len = 0;
        for (String s : words) {
            Map<Character, Integer> tmp = new HashMap<>();
            for (char x : s.toCharArray()) {
                tmp.put(x, tmp.getOrDefault(x, 0) + 1);
            }
            boolean key = true;
            for (char x : s.toCharArray()) {
                if (tmp.getOrDefault(x, 0) > map.getOrDefault(x, 0)) {
                    key = false;
                    break;
                }
            }
            if (key) {
                len += s.length();
            }
        }
        return len;
    }


    public int dayOfYear(String date) {
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));

        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            months[1]++;
        }
        int ret = 0;
        for (int i = 0; i < month - 1; i++) {
            ret += months[i];
        }
        return ret + day;
    }



}
