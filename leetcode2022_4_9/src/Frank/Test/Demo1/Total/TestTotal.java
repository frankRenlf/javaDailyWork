package Frank.Test.Demo1.Total;

class Animal{

    int age;
    String name;

    public Animal(int age,String name){
        this.age = age;
        this.name = name;
    }

}


interface IVoice{

    void voice();

}

interface IWalk{

    void walk();

}

class Cat extends Animal implements IVoice,IWalk{


    public Cat(int age, String name) {
        super(age, name);
    }

    @Override
    public void voice() {
        System.out.println(this.name + " mio");
    }

    @Override
    public void walk() {
        System.out.println(this.name + " walk");
    }
}


class Dog extends Animal implements IVoice,IWalk{


    public Dog(int age, String name) {
        super(age, name);
    }

    @Override
    public void voice() {
        System.out.println(this.name + " bark");
    }

    @Override
    public void walk() {
        System.out.println(this.name + " run");
    }
}


public class TestTotal {

    public static void TVoice(IVoice iVoice){
        iVoice.voice();
    }

    public static void main(String[] args) {
        Cat cat = new Cat(1,"Kate");
        TVoice(cat);
    }

}
