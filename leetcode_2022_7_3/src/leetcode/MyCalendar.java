package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode_2022_7_3
 * @Package : leetcode
 * @createTime : 2022/7/5 10:00
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class MyCalendar {
    TreeSet<int[]> booked;

    public MyCalendar() {
        booked = new TreeSet<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
    }

    public boolean book(int start, int end) {
        if (booked.isEmpty()) {
            booked.add(new int[]{start, end});
            return true;
        }
        int[] right = booked.ceiling(new int[]{end, 0});
        int[] left = (right == null ? booked.last() : booked.lower(right));
        if (left == null || (left[1] <= start)) {
            booked.add(new int[]{start, end});
            return true;
        }
        return false;
    }
}

