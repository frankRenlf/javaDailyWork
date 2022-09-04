package success;

import test1.Vehicles;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : 2022_6_13_test1
 * @Package : success
 * @createTime : 2022/6/16 15:37
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class settle_recall {
    static Vehicles vehicles = new Vehicles();
    static List<String> lists = new ArrayList<>();
    static List<Double> prices = new ArrayList<>();

    public static void single(double tw, StringBuffer path, double total, int index) {
//        if (tw <= 0) {
//            lists.add(new String(path));
//            prices.add(total);
//            return;
//        }
        for (int i = index; i < vehicles.getVehicleList().size(); i++) {
            path.append(vehicles.getVehicleList().get(i).getName());
            total += vehicles.getVehicleList().get(i).getPrice();
            if (tw - vehicles.getVehicleList().get(i).getWeight() < 0) {
                lists.add(new String(path));
                prices.add(total);
                break;
            } else {
                single(tw - vehicles.getVehicleList().get(i).getWeight(),
                        path,
                        total,
                        i);
                path.deleteCharAt(index);
                total -= vehicles.getVehicleList().get(i).getPrice();
            }
        }

    }

    public static void main(String[] args) {
        vehicles.getVehicleList().sort(new Comparator<Vehicles.Vehicle>() {
            @Override
            public int compare(Vehicles.Vehicle o1, Vehicles.Vehicle o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        single(vehicles.getTotalWeight(), new StringBuffer(), 0.0, 0);
//        System.out.println(single(vehicles.getTotalWeight()));
        System.out.println(vehicles.getVehicleList());
        System.out.println(lists);
        System.out.println(prices);
    }

}
