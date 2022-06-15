package failed;

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
//        Result r1 = big(vehicles, new Comparator<Vehicles.Vehicle>() {
//            @Override
//            public int compare(Vehicles.Vehicle o1, Vehicles.Vehicle o2) {
//                return Double.compare(o1.getWeight() / o1.getPrice(), o2.getWeight() / o2.getPrice());
//            }
//        });
        Result r2 = big(vehicles, new Comparator<Vehicles.Vehicle>() {
            @Override
            public int compare(Vehicles.Vehicle o1, Vehicles.Vehicle o2) {
                return -Double.compare(o1.getWeight() / o1.getPrice(), o2.getWeight() / o2.getPrice());
            }
        });
        Result r1 = big(vehicles, new Comparator<Vehicles.Vehicle>() {
            @Override
            public int compare(Vehicles.Vehicle o1, Vehicles.Vehicle o2) {
                return -Double.compare(o1.getWeight(), o2.getWeight());
            }
        });
        System.out.println(r1.getPrice() > r2.getPrice() ? r2 : r1);
    }

    public static Result big(Vehicles vehicles, Comparator<Vehicles.Vehicle> comparator) {
//        Vehicles vehicles = new Vehicles();
        vehicles.getVehicleList().sort(comparator);
        System.out.println(vehicles.getVehicleList());
        Result result = new Result();

        double totalWeight = vehicles.getTotalWeight();
        int len = vehicles.getVehicleList().size();
        int count = (int) ((int) totalWeight / vehicles.getVehicleList().get(0).getWeight());
        if (totalWeight % vehicles.getVehicleList().get(0).getWeight() == 0) {
            double small = count * vehicles.getVehicleList().get(0).getPrice();
            result.getVehicleNum().put(vehicles.getVehicleList().get(0).getName(), count);
            result.setPrice(small);
        } else {
            for (int index = 0; index < len - 1; index++) {
                Result result1 = new Result();
                for (int j = 0; j < len; j++) {
                    result1.setVehicleNum(vehicles.getVehicleList().get(j).getName(), 0);
                }
                totalWeight = vehicles.getTotalWeight();
                count = (int) (totalWeight / vehicles.getVehicleList().get(index).getWeight());
                double pre = count * vehicles.getVehicleList().get(index).getPrice();
                double small = (count + 1) * vehicles.getVehicleList().get(index).getPrice();
                result1.getVehicleNum().put(vehicles.getVehicleList().get(index).getName(), count + 1);
                result1.setPrice(small);
                totalWeight %= vehicles.getVehicleList().get(index).getWeight();
                for (int i = index + 1; i < len; i++) {
                    count = (int) (totalWeight / vehicles.getVehicleList().get(i).getWeight());
                    if (totalWeight % vehicles.getVehicleList().get(i).getWeight() == 0) {
                        count--;
                    }
                    double tmpSmall = pre + (count + 1) * vehicles.getVehicleList().get(i).getPrice();
                    result1.getVehicleNum().put(vehicles.getVehicleList().get(i).getName(),
                            0);
//                    //
//                    double tmpWeight = totalWeight;
//                    int t = i - 1;
//                    int preNum = result1.getVehicleNum().get(vehicles.getVehicleList().get(t).getName()) - 1;
//                    while (t >= 0) {
//                        if (result1.getVehicleNum().get(vehicles.getVehicleList().get(t).getName()) > 0) {
//                            preNum = result1.getVehicleNum().get(vehicles.getVehicleList().get(t).getName());
//                            if (t == i - 1) {
//                                preNum--;
//                            }
//                            break;
//                        }
//                        t--;
//                    }
//                    double ts2 = small - vehicles.getVehicleList().get(t).getPrice();
//                    int tmp = t;
//                    while (preNum > 0) {
//                        preNum--;
//                        tmpWeight += vehicles.getVehicleList().get(tmp).getWeight();
//                        count = (int) (tmpWeight / vehicles.getVehicleList().get(i).getWeight());
//                        if (tmpWeight % vehicles.getVehicleList().get(i).getWeight() == 0) {
//                            count--;
//                        }
//                        ts2 -= vehicles.getVehicleList().get(tmp).getPrice();
//                        tmpSmall = ts2
//                                + (count + 1) * vehicles.getVehicleList().get(i).getPrice();
//                        if (small > tmpSmall) {
//                            small = tmpSmall;
//                            result1.getVehicleNum().replace(vehicles.getVehicleList().get(tmp).getName(),
//                                    preNum);
//                            result1.getVehicleNum().put(vehicles.getVehicleList().get(i).getName(), count + 1);
//                            result1.setPrice(small);
//                        }
//                        if (preNum == 0 && tmp > 0) {
//                            preNum = result1.getVehicleNum().get(vehicles.getVehicleList().get(tmp).getName()) - 1;
//                            tmp--;
//                        }
//                    }
                    //
                    if (small > tmpSmall) {
                        small = tmpSmall;
                        pre = tmpSmall - vehicles.getVehicleList().get(i).getPrice();

                        result1.getVehicleNum().replace(vehicles.getVehicleList().get(i - 1).getName(),
                                result1.getVehicleNum().get(vehicles.getVehicleList().get(i - 1).getName()) - 1);
                        result1.getVehicleNum().put(vehicles.getVehicleList().get(i).getName(), count + 1);
                        result1.setPrice(small);
                        result = result1;
                        totalWeight %= vehicles.getVehicleList().get(i).getWeight();
                    }
                }

//                else {

//                    }
            }
        }
        return result;
    }

}
