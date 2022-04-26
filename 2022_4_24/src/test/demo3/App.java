package test.demo3;


class Message<T> {
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}

public class App {
    public static void main(String[] args) {
        Message<String> message1 = new Message<>();
        message1.setMessage("比特就业课欢迎您");
        fun(message1);

        Message<Integer> message2 = new Message<>();
        message2.setMessage(2);
        fun2(message2);
        fun(message2);

    }

    public static void fun(Message<? extends Object> temp) {
//        temp.setMessage("123");
        System.out.println(temp.getMessage());
    }

    public static void fun2(Message<? super Integer> temp) {
        temp.setMessage(100);

    }
}
