import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : dailyTrain2022_6_1
 * @Package : PACKAGE_NAME
 * @createTime : 2022/6/1 16:14
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */

class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }
}

public class App {

    public static void main(String[] args) {
        List<Person> linkList = new ArrayList<>();
        Person person1 = new Person("frank", 2);
        Person person2 = new Person("frank", 3);
        Person person3 = new Person("frank", 1);
        linkList.add(person1);
        linkList.add(person2);
        linkList.add(person3);
        linkList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });
        System.out.println();
    }

}
