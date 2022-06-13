import test1.Result;
import test1.Vehicles;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : 2022_6_13_test1
 * @Package : PACKAGE_NAME
 * @createTime : 2022/6/13 13:10
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */


public class settle2 {

    public static void main(String[] args) {
        Vehicles vehicles = new Vehicles();
        System.out.println(vehicles);
        vehicles.getVehicleList().sort(new Comparator<Vehicles.Vehicle>() {
            @Override
            public int compare(Vehicles.Vehicle o1, Vehicles.Vehicle o2) {
                return -Double.compare(o1.getWeight() / o1.getPrice(), o2.getWeight() / o2.getPrice());
            }
        });
        System.out.println(vehicles);

        Result result = new Result();
        double totalWeight = vehicles.getTotalWeight();
        int len = vehicles.getVehicleList().size();
        int count = (int) ((int) totalWeight / vehicles.getVehicleList().get(0).getWeight());
        double pre = count * vehicles.getVehicleList().get(0).getPrice();
        double small = (count + 1) * vehicles.getVehicleList().get(0).getPrice();
        result.getVehicleNum().put(vehicles.getVehicleList().get(0).getName(), count + 1);
        result.setPrice(small);
        totalWeight %= vehicles.getVehicleList().get(0).getWeight();
        for (int i = 1; i < len; i++) {
            count = (int) (totalWeight / vehicles.getVehicleList().get(i).getWeight());
            if (totalWeight % vehicles.getVehicleList().get(i).getWeight() == 0) {
                count--;
            }
            double tmpSmall = pre + (count + 1) * vehicles.getVehicleList().get(i).getPrice();
            if (small > tmpSmall) {
                small = tmpSmall;
                pre = tmpSmall - vehicles.getVehicleList().get(i).getPrice();

                result.getVehicleNum().replace(vehicles.getVehicleList().get(i - 1).getName(),
                        result.getVehicleNum().get(vehicles.getVehicleList().get(i - 1).getName()) - 1);
                result.getVehicleNum().put(vehicles.getVehicleList().get(i).getName(), count + 1);
                result.setPrice(small);
                totalWeight %= vehicles.getVehicleList().get(i).getWeight();
            }
        }

        System.out.println(result);
    }

}
