package success;

import test1.Vehicles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
    public static double single(double tw) {
        if (tw <= 0) {
            return 0;
        }
        List<Double> tmp = new ArrayList<>();
        for (int i = 0; i < vehicles.getVehicleList().size(); i++) {
            tmp.add(vehicles.getVehicleList().get(i).getPrice()
                    + single(tw - vehicles.getVehicleList().get(i).getWeight()));
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
        System.out.println(single(vehicles.getTotalWeight()));
    }

}
