package test1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : 2022_6_13_test1
 * @Package : PACKAGE_NAME
 * @createTime : 2022/6/13 10:26
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Result {
    Map<String, Integer> vehicleNum; //车型使用数量
    Double price; //总的支付金额

    public Result(Map<String, Integer> vehicleNum, Double price) {
        this.vehicleNum = vehicleNum;
        this.price = price;
    }

    public Result() {
        this.vehicleNum = new HashMap<>();
        this.price = 0.0;
    }

    public Map<String, Integer> getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String s, int i) {
        vehicleNum.put(s, i);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Result{" +
                "vehicleNum=" + vehicleNum +
                ", price=" + price +
                '}';
    }
}
