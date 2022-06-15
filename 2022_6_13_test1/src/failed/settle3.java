package failed;

import test1.Result;
import test1.Vehicles;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : 2022_6_13_test1
 * @Package : PACKAGE_NAME
 * @createTime : 2022/6/15 14:16
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class settle3 {

    public int consume(Node root) {
        if (root == null) {
            return 0;
        }
        int minConsume = 0;
        List<Node> children = root.children;
        for (Node child : children) {
            int childConsume = consume(child);
            minConsume = Math.min(minConsume, childConsume);
        }
        return minConsume + 1;
    }


    static Vehicles vehicles = new Vehicles();

//    private double rec(double weight, double vehiclesWeight, int vehiclesPrice) {
//        if (weight < vehiclesWeight) {
//            return vehiclesPrice;
//        }
////        return rec(weight - vehiclesWeight, vehicles.);
//    }


    public static void main(String[] args) {
        int len = vehicles.getVehicleList().size();
        Result result1 = new Result();
        for (int j = 0; j < len; j++) {
            result1.setVehicleNum(vehicles.getVehicleList().get(j).getName(), 0);
        }
        double totalWeight = vehicles.getTotalWeight();
        for (int i = 0; i < len; i++) {

        }

    }


}
