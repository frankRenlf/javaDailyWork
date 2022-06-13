import test1.Problem;
import test1.Result;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : 2022_6_13_test1
 * @Package : PACKAGE_NAME
 * @createTime : 2022/6/13 10:29
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Settle {

    private static Problem initiate() {
        List<String> vehicleNames = new ArrayList<>();
        List<Double> vehicleWeight = new ArrayList<>();
        List<Double> vehiclePrice = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of v: ");
        int n = sc.nextInt();
        while (n > 0) {
            System.out.print("Enter vehicleNames: ");
            vehicleNames.add(sc.next());
            System.out.print("Enter vehicleWeight: ");
            vehicleWeight.add(sc.nextDouble());
            System.out.print("Enter vehiclePrice: ");
            vehiclePrice.add(sc.nextDouble());
            n--;
        }
        System.out.print("Enter weight: ");
        Double weight = sc.nextDouble();
        return new Problem(vehicleNames, vehicleWeight, vehiclePrice, weight);
    }

//    public static void ret(Result result) {
//        System.out.println(result);
//    }

    public static void main(String[] args) {
        Problem problem = initiate();
        Result result = new Result();
        for (int i = 0; i < problem.getVehicleNames().size(); i++) {
            result.setVehicleNum(problem.getVehicleNames().get(i), 0);
        }

        Map<Double, Double> eff_co = new HashMap<>();
        List<Double> eff = new ArrayList<>();
        for (int i = 0; i < problem.getVehicleNames().size(); i++) {
            eff_co.put(problem.getVehicleWeight().get(i) / problem.getVehiclePrice().get(i), problem.getVehicleWeight().get(i));
            eff.add(problem.getVehicleWeight().get(i) / problem.getVehiclePrice().get(i));
        }
        System.out.println();

        //
        double totalWeight = problem.getWeight();
        eff.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (int) (o2 - o1);
            }
        });

        double small = (int) (totalWeight / eff.get(0)) + 1;
        for (int i = 0; i < eff.size(); i++) {
            result.setVehicleNum(problem.getVehicleNames().get(problem.getVehicleWeight().indexOf(eff_co.get(eff.get(i)))), (int) (totalWeight / eff.get(i)) + 1);
            totalWeight -= eff.get(0) * (small - 1);

        }

    }

}
