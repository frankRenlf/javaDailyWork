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
