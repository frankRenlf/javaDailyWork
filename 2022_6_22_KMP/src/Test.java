import algorithm.KMP;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : 2022_6_22_KMP
 * @Package : PACKAGE_NAME
 * @createTime : 2022/6/22 10:39
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Test {

    static KMP kmp = new KMP();

    public static void main(String[] args) {
        System.out.println(kmp.kmp("abcdefg", "cdc", 0));
    }

}
