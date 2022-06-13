package test1;

import java.util.List;

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
public class Problem {
    List<String> vehicleNames; //车型名称
    List<Double> vehicleWeight; //车型能装载的重量
    List<Double> vehiclePrice; //车型需支付价格
    Double weight; //货量，此票货的重量

    public Problem(List<String> vehicleNames, List<Double> vehicleWeight, List<Double> vehiclePrice, Double weight) {
        this.vehicleNames = vehicleNames;
        this.vehicleWeight = vehicleWeight;
        this.vehiclePrice = vehiclePrice;
        this.weight = weight;
    }

    public List<String> getVehicleNames() {
        return vehicleNames;
    }

    public List<Double> getVehicleWeight() {
        return vehicleWeight;
    }

    public List<Double> getVehiclePrice() {
        return vehiclePrice;
    }

    public Double getWeight() {
        return weight;
    }
}
