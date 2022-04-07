class A{
    int a = 1;
}

class B extends A{
    int b = 2;

}

class C extends B{
    int c = 3;
}




public class Test {

    public static void main(String[] args) {
        A a = new C();
        B b = (B) new A();
    }

}