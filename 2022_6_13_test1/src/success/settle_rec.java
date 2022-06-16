package success;

import test1.Result;
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
 * @Package : PACKAGE_NAME
 * @createTime : 2022/6/15 14:50
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */


public class settle_rec {


    static class Node {
        public double curWeight;
        public double curPrice;
        public List<Node> children;

        public Node() {
        }

        public Node(double weight, double price) {
            curWeight = weight;
            curPrice = price;
        }

        public Node(double weight, List<Node> children) {
            curWeight = weight;
            this.children = children;
        }
    }

//    public double sum = 0;

    public Node createTree(double weight, Vehicles.Vehicle vehicle) {
        if (weight <= 0) {
            return null;
        }
        Node root = new Node(vehicle.getWeight(), vehicle.getPrice());
        root.children = new ArrayList<>();
        for (int i = 0; i < vehicles.getVehicleList().size(); i++) {
            root.children.add(createTree(weight - root.curWeight, vehicles.getVehicleList().get(i)));

        }

        return root;
    }


//    public double minSum(Node root) {
//        if (root == null) {
//            return 0;
//        }
//        List<Double>
//
//
//    }

    public static double run(Node root) {
        if (root == null)
            return 0.0;
        List<Double> tmp = new ArrayList<>();
        for (int i = 0; i < vehicles.getVehicleList().size(); i++) {
            if (root.children.get(i) != null) {
                tmp.add(run(root.children.get(i)));
            }
        }
        tmp.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return Double.compare(o1, o2);
            }
        });
        if (tmp.size() > 0) {
            return tmp.get(0) + root.curPrice;
        }
        return root.curPrice;
    }


    static Vehicles vehicles = new Vehicles();


    public static void main(String[] args) {
        int len = vehicles.getVehicleList().size();
        Result result = new Result();
        for (int j = 0; j < len; j++) {
            result.setVehicleNum(vehicles.getVehicleList().get(j).getName(), 0);
        }
        settle_rec rec = new settle_rec();
        Node root = rec.createTree(vehicles.getTotalWeight(), vehicles.getVehicleList().get(0));
        double minConsume = run(root);
        for (int i = 1; i < len; i++) {
            root = rec.createTree(vehicles.getTotalWeight(), vehicles.getVehicleList().get(i));
            minConsume = Math.min(minConsume, run(root));
        }
        System.out.println("cost: " + minConsume);
//        Stack<Vehicles.Vehicle> stack = new Stack<>();
//        for (int i = 0; i < len; i++) {
//            stack.push(vehicles.getVehicleList().get(i));
//            while (!stack.isEmpty()) {
//                for (int j = 0; j < len; j++) {
//                    if ()
//                }
//            }
//        }
    }

}
