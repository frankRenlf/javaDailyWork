package success;

import test1.Result;
import test1.Vehicles;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : 2022_6_13_test1
 * @Package : success
 * @createTime : 2022/6/16 15:16
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class settle_rec2 {


    static Map<Double, String> map = new HashMap<>();

    public static double single(double tw, String s) {
        if (tw <= 0) {

            return 0;
        }
        List<Double> tmp = new ArrayList<>();
        for (int i = 0; i < vehicles.getVehicleList().size(); i++) {
            String ts = s + vehicles.getVehicleList().get(i).getName() + " ";
            tmp.add(vehicles.getVehicleList().get(i).getPrice()
                    + single(tw - vehicles.getVehicleList().get(i).getWeight(),
                    ts));
            map.put(tmp.get(i), ts);
        }
        tmp.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return Double.compare(o1, o2);
            }
        });
        return tmp.get(0);
    }


    static Vehicles vehicles = new Vehicles();

    public static void main(String[] args) {
        Result result = new Result();
        for (int i = 0; i < vehicles.getVehicleList().size(); i++) {
            result.setVehicleNum(vehicles.getVehicleList().get(i).getName(), 0);
        }
        result.setPrice(single(vehicles.getTotalWeight(), ""));
        String[] s = map.get(single(vehicles.getTotalWeight(), "")).split(" ");

        for (String x : s) {
//            System.out.println(x);
            result.setVehicleNum(x, result.getVehicleNum().get(x) + 1);
        }
        System.out.println(result);
    }

}
