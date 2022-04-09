package Frank.Test.Demo1;


interface IA {

    int a = 1;

    int retA(int a);

}


class B1 implements IA {

    @Override
    public int retA(int a) {
        return a * 2;
    }
}

class B2 implements IA {

    @Override
    public int retA(int a) {
        return a * 3;
    }
}


abstract class C {
    int c = 0;

    abstract void printC(int c);
}

class D extends C {

    @Override
    void printC(int c) {
        System.out.println("C: " + (c * c));
    }
}

public class TestDemo1 {

    public static void main(String[] args) {
//        A b = new B1();
//        System.out.println(b.retA(2));
//
//        C d = new D();
//        d.printC(b.retA(2));


        IA[] ab = new IA[]{new B1(),new B2()};
        for(int i =0;i<2;i++){
            System.out.println(ab[i].retA(i));
        }

    }

}
