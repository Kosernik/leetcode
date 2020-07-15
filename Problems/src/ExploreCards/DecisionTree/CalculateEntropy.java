package ExploreCards.DecisionTree;

import java.util.HashMap;
import java.util.Map;

public class CalculateEntropy {
    public static void main(String[] args) {
        CalculateEntropy solution = new CalculateEntropy();
        int[] test0 = {1,1,2,2};
        double res0 = 1;
        int[] test1 = {1,2,3,4,2,6,1,2,4,2,3,5,4};
        double res1 = 2.4116;

        System.out.println(solution.calculateEntropy(test0));
        System.out.println(res0);
        System.out.println(solution.calculateEntropy(test1));
        System.out.println(res1);
    }

    // H(X) = -Sum(P(Xi)*Log2(Xi))
    public double calculateEntropy(int[] input) {
        double length = (double) input.length;
        Map<Integer, Integer> uniqueElems = new HashMap<>();
        for (int element : input) {
            int currCount = uniqueElems.getOrDefault(element, 0);
            uniqueElems.put(element, currCount+1);
        }

        double entropy = 0;
        double log2 = Math.log(2);
        for (Map.Entry<Integer, Integer> entry : uniqueElems.entrySet()){
            double probability = entry.getValue() / length;
            entropy += probability * (Math.log(probability) / log2) * -1;
        }

        return entropy;
    }
}
