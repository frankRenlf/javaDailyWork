
class Book {

    private String title;
    private double price;
    private char ch;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public char getCh() {
        return ch;
    }

    public void getInfo() {
        System.out.println("图书的名称：" + title + " 图书的价格：" + price + " Ch: " + ch);
    }
}

public class App {
    public static void main(String[] args) {
        Book book = new Book();
        book.setTitle("Java开发");
        book.setPrice(-89.9);
        book.setCh('A');
        book.getInfo();
    }
}