package test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : 2022_6_13_test1
 * @Package : test1
 * @createTime : 2022/6/13 13:11
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Vehicles {
    private static Problem initiate() {
        List<String> vehicleNames = new ArrayList<>();
        List<Double> vehicleWeight = new ArrayList<>();
        List<Double> vehiclePrice = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter number of v: ");
//        int n = sc.nextInt();
//        while (n > 0) {
//            System.out.print("Enter vehicleNames: ");
//            vehicleNames.add(sc.next());
//            System.out.print("Enter vehicleWeight: ");
//            vehicleWeight.add(sc.nextDouble());
//            System.out.print("Enter vehiclePrice: ");
//            vehiclePrice.add(sc.nextDouble());
//            n--;
//        }
//        vehicleNames.add("A");
//        vehicleWeight.add(50.0);
//        vehiclePrice.add(100.0);
//        Double weight = 200.0;

//        vehicleNames.add("A");
//        vehicleWeight.add(18.33);
//        vehiclePrice.add(100.5);
//        vehicleNames.add("B");
//        vehicleWeight.add(24.55);
//        vehiclePrice.add(146.5);
//        vehicleNames.add("C");
//        vehicleWeight.add(35.04);
//        vehiclePrice.add(198.3);
//        Double weight = 49.2;

        vehicleNames.add("1");
        vehicleWeight.add(2.0);
        vehiclePrice.add(3.0);
        vehicleNames.add("2");
        vehicleWeight.add(3.0);
        vehiclePrice.add(5.0);
        vehicleNames.add("3");
        vehicleWeight.add(5.0);
        vehiclePrice.add(7.0);
        vehicleNames.add("4");
        vehicleWeight.add(7.0);
        vehiclePrice.add(11.0);
        vehicleNames.add("5");
        vehicleWeight.add(11.0);
        vehiclePrice.add(13.0);
        vehicleNames.add("6");
        vehicleWeight.add(13.0);
        vehiclePrice.add(17.0);
        vehicleNames.add("7");
        vehicleWeight.add(17.0);
        vehiclePrice.add(19.0);
        vehicleNames.add("8");
        vehicleWeight.add(19.0);
        vehiclePrice.add(23.0);
        vehicleNames.add("9");
        vehicleWeight.add(23.0);
        vehiclePrice.add(29.0);
        Double weight = 503.91;


        return new Problem(vehicleNames, vehicleWeight, vehiclePrice, weight);
    }

    public static class Vehicle {
        public Double getWeight() {
            return weight;
        }

        public Double getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        String name; //车型名称
        Double weight; //车型能装载的重量
        Double price; //车型需支付价格

        public Vehicle(String name, Double weight, Double price) {
            this.name = name;
            this.weight = weight;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Vehicle{" +
                    "name='" + name + '\'' +
                    ", weight=" + weight +
                    ", price=" + price +
                    '}';
        }
    }

    private List<Vehicle> vehicleList;
    private double totalWeight;

    public double getTotalWeight() {
        return totalWeight;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public Vehicles() {
        Problem problem = initiate();
        vehicleList = new ArrayList<>();
        for (int i = 0; i < problem.getVehicleNames().size(); i++) {
            vehicleList.add(new Vehicle(problem.getVehicleNames().get(i),
                    problem.getVehicleWeight().get(i),
                    problem.getVehiclePrice().get(i)));
        }
        totalWeight = problem.weight;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "vehicles=" + vehicleList +
                '}';
    }
}
