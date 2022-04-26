package test.demo2;

import java.lang.reflect.Array;
import java.util.Arrays;

class calculate<T extends Comparable<T>> {
    public T[] arr;

    public calculate() {
    }

    public calculate(Class<T> clazz, int capacity) {
        this.arr = (T[]) Array.newInstance(clazz, capacity);
    }

//    public T average(T[] arr){
//        int sum = 0;
//        int n = arr.length;
//        for(T x:arr){
//            sum += x;
//        }
//        return sum/n;
//    }

    public T findMax(T[] arr) {

        T max = arr[0];
        for (T x : arr) {
            if (max.compareTo(x) < 0) {
                max = x;
            }
        }
        return max;
    }

    public static <T> void mySwap(T[] arr) {
        T tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
    }

    public T getArr(int pos) {
        return arr[pos];
    }
}

public class App {

    public static void main(String[] args) {
        calculate<Integer> cal = new calculate<>();
        Integer[] arr = new Integer[]{1, 3, 5, 7, 2};
        System.out.println(cal.findMax(arr));
        calculate.mySwap(arr);
        System.out.println(Arrays.toString(arr));

//        fun(new calculate<String>());
    }

    public static void fun(calculate<String> s) {
        System.out.println(s.getArr(0));
    }

}
