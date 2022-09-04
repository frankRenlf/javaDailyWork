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
 * @createTime : 2022/6/16 15:37
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class settle_recall {
    static Vehicles vehicles = new Vehicles();
    static List<String> lists = new ArrayList<>();
    static List<Double> prices = new ArrayList<>();

    public static void single(double tw, String path, double total, int index) {
//        if (tw <= 0) {
//            lists.add(new String(path));
//            prices.add(total);
//            return;
//        }
        for (int i = index; i < vehicles.getVehicleList().size(); i++) {

            if (tw - vehicles.getVehicleList().get(i).getWeight() <= 0) {
                lists.add(path + vehicles.getVehicleList().get(i).getName());
                prices.add(total + vehicles.getVehicleList().get(i).getPrice());
                break;
            } else {
                single(tw - vehicles.getVehicleList().get(i).getWeight(),
                        path + vehicles.getVehicleList().get(i).getName(),
                        total + vehicles.getVehicleList().get(i).getPrice(),
                        i);
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
        single(vehicles.getTotalWeight(), "", 0.0, 0);
//        System.out.println(single(vehicles.getTotalWeight()));
//        System.out.println(vehicles.getVehicleList());
//        System.out.println(vehicles.getTotalWeight());
//        System.out.println(lists);
        System.out.println(prices);
        int index = 0;
        for (int i = 1; i < lists.size(); i++) {
            if (prices.get(i) < prices.get(index)) {
                index = i;
            }
        }
        Result result = new Result();
        result.setPrice(prices.get(index));
        for (char x : lists.get(index).toCharArray()) {
            result.setVehicleNum(String.valueOf(x), result.getVehicleNum().getOrDefault(String.valueOf(x), 0) + 1);
        }

        System.out.println(result);

    }

}
