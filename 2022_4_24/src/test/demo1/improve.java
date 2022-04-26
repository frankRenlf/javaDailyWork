package test.demo1;

import java.lang.reflect.Array;
import java.util.Arrays;

class MyArray<T> {
    public T[] array;

    public MyArray() {
    }

    /**
     * 通过反射创建，指定类型的数组
     *
     * @param clazz
     * @param capacity
     */
    public MyArray(Class<T> clazz, int capacity) {
        array = (T[]) Array.newInstance(clazz, capacity);
    }

    public T getPos(int pos) {
        return this.array[pos];
    }

    public void setVal(int pos, T val) {
        this.array[pos] = val;
    }

    public T[] getArray() {
        return array;
    }
}

public class improve {
    public static void main(String[] args) {
        MyArray<Integer> myArray1 = new MyArray<>(Integer.class, 10);
        Integer[] integers = myArray1.getArray();
        integers[0] = 1;
        System.out.println(Arrays.toString(integers));

        MyArray<String> myArray2 = new MyArray<>(String.class, 20);
        String[] strings = myArray2.getArray();
        strings[0] = "frank";
        strings[1] = "linda";
        System.out.println(Arrays.toString(strings));

    }
}


