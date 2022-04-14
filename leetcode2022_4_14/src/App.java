import leetcode.frank.Solution;


class Animal {
    int a = 10;

    public Animal(int a) {
        this.a = a;
    }
}

class cat implements Cloneable {

    int c = 20;

    Animal a1 = new Animal(15);

    public cat(int a, int c) {
        this.a1.a = a;
        this.c = c;
    }


    @Override
    public String toString() {
        return "cat{" +
                "a=" + a1.a +
                ", c=" + c +
                '}';
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        cat o = (cat) super.clone();
        o.a1 = new Animal(50);
        return o;
    }


}

public class App {

    public static void main1(String[] args) {
        Solution sol = new Solution();
        String s = "bbbab";
        System.out.println(sol.longestPalindromeSubseq(s));
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        cat c = new cat(15, 25);
        cat c2 = (cat) c.clone();
        c2.a1.a = 10;
        c2.c = 100;
        System.out.println(c + "\n" + c2);
    }

}
