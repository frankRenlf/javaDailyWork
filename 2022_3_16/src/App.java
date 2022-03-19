public class App {

    public static void main(String[] args) {
        // strTOChar();
        // strToBytes();
        // testEqual();
        // containsString();
        // replaceString();
        // subToString();
        // splitString();
        // linkString();
        // getToCh();
        // testString();
        bufferToString();
    }

    public static void bufferToString() {
        StringBuffer str1 = new StringBuffer("Hello Frank");
        StringBuffer str2 = new StringBuffer(", I'm Ren");
        str2.insert(0, str1);
        System.out.println(str2);
        str1.append(str2, 11, 15);
        System.out.println(str1);
    }

    public static void testString() {
        int i = 10;
        System.out.println(String.valueOf(i));
    }

    public static void getToCh() {
        String str = " abcdefghijklmn ";
        char[] chr = new char[10];
        for (int i = 0; i < chr.length; i++) {
            chr[i] = ' ';
        }
        str.getChars(5, 12, chr, 1); // chr= fghijkl
        System.out.println(chr);
        str = str.trim();
        System.out.println(str);
    }

    public static void linkString() {
        String str1 = "Hello";
        String str2 = " Frank ";
        String str3 = "Ren";
        System.out.println(str1 + str2);
        System.out.println(str1.concat(str2));
        System.out.println(str1.concat(str2.concat(str3)));
    }

    public static void splitString() {
        String str = "I'm Frank and you?";
        String[] strList1 = str.split(" ", 3);

        for (int i = 0; i < strList1.length; i++) {
            System.out.println(strList1[i]);
        }

    }

    public static void subToString() {
        String str = "Hello World .";
        System.out.println(str.substring(6));
        System.out.println(str.substring(0, 1));
    }

    public static void replaceString() {
        String str1 = "Hello World .";
        String str2 = "wellllcome";
        System.out.println(str1.replace("l", "_"));
        System.out.println(str2.replaceFirst("l", "_"));
    }

    public static void containsString() {
        String str = "helloWorld";
        System.out.println(str.contains("hello"));
        System.out.println(str.contains("xx"));
    }

    public static void testEqual() {
        String str1 = "HalloWorld";
        String str2 = "HbLLOWORLD";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str1.compareTo(str2));
    }

    public static void strToBytes() {
        String str = "helloworld";
        byte[] data = str.getBytes(); // 字符串变为字节数组
        for (int x = 0; x < data.length; x++) {
            System.out.print(data[x] + "、");
            data[x] -= 32; // 变大写
        }
        System.out.println();
        for (int x = 0; x < data.length; x++) {
            System.out.print(data[x] + "、");
            // data[x] -= 32; // 变大写
        }
        System.out.println();
        System.out.println("全部字节数组变为字符串：" + new String(data));
        System.out.println("部分字节数组变为字符串：" + new String(data, 0, 5));
    }

    public static void strTOChar() {
        String str = "helloworld";
        char[] data = str.toCharArray(); // 字符串变为字符数组
        for (int x = 0; x < data.length; x++) {
            data[x] -= 32; // 变大写
            System.out.print(data[x] + "、");
        }
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            System.out.print(str.charAt(i) + ". ");
        }
        System.out.println();
        System.out.println("全部字符数组变为字符串：" + new String(data));
        System.out.println("部分字符数组变为字符串：" + new String(data, 0, 5));
    }

}