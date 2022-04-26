package test.demo4;

class Food {
}

class Fruit extends Food {
}

class Apple extends Fruit {
}

class Banana extends Fruit {
}

class Message<T> {
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message=" + message +
                '}';
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Message<Apple> message = new Message<>();
        message.setMessage(new Apple());
        fun1(message);


        Message<Food> message2 = new Message<>();
        message2.setMessage(new Apple());
        fun2(message2);
    }//temp 接收Fruit及其子类的一个Message

    public static void fun1(Message<? extends Fruit> temp) {
//        temp.setMessage(new Apple());//这个是Fruit的子类
//        temp.setMessage(new Fruit());//这个是Fruit的本身
        Fruit fruit = temp.getMessage();
        System.out.println(fruit);
    }

    public static void fun2(Message<? super Fruit> temp) { // 此时可以修改！！添加的是Fruit 或者Fruit的子类
        temp.setMessage(new Apple());//这个是Fruit的子类
        temp.setMessage(new Fruit());//这个是Fruit的本身
        temp.setMessage(new Banana());
//        Fruit fruit = temp.getMessage();//不能接收，这里无法确定是哪个父类
        System.out.println(temp.getMessage());
    }
}
