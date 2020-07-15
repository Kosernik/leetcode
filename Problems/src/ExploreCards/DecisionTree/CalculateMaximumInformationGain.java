package ExploreCards.DecisionTree;

import java.util.*;

public class CalculateMaximumInformationGain {
    public static void main(String[] args) {
        CalculateMaximumInformationGain solution = new CalculateMaximumInformationGain();
        List<Double> petal = new ArrayList<>();
        petal.add(0.5);petal.add(2.3);petal.add(1.0);petal.add(1.5);
        List<String> species = new ArrayList<>();
        species.add("setosa");species.add("versicolor");species.add("setosa");species.add("versicolor");

        double res = solution.calculateMaxInfoGain(petal, species);
        System.out.println(res);
    }
    public double calculateMaxInfoGain(List<Double> petal_length, List<String> species) {
        SortedMap<Double, String> sorted = new TreeMap<>();

        for (int i = 0, length = petal_length.size(); i < length; i++) {
            sorted.put(petal_length.get(i), species.get(i));
        }

//        System.out.println(sorted);
//        System.out.println("Map  \n");
        List<String> values = new ArrayList<>(sorted.values());

//        System.out.println(values);
//        System.out.println("values \n");

        double initialEntropy = calculateEntropy(values);
//        System.out.println("Initial entropy:" + initialEntropy);
        double informationGain = 0;
        for (int i = 1, length = values.size(); i < length; i++) {
            double leftSubArrEntropy = calculateEntropy(values.subList(0, i));
            double rightSubArrayEntropy = calculateEntropy(values.subList(i, length));
//            System.out.println("Curr i:" + i + ", " + leftSubArrEntropy + ", " + rightSubArrayEntropy);
            double currEntropy = initialEntropy - leftSubArrEntropy * (i*1.0 / length) - rightSubArrayEntropy * ((length - i)*1.0 / length);
            informationGain = Math.max(informationGain, currEntropy);
        }
        return informationGain;
    }



    private double calculateEntropy(List<String> input) {
        double length = (double) input.size();
        Map<String, Integer> uniqueElems = new HashMap<>();
        for (String element : input) {
            int currCount = uniqueElems.getOrDefault(element, 0);
            uniqueElems.put(element, currCount+1);
        }

        double entropy = 0;
        double log2 = Math.log(2);

        for (Map.Entry<String, Integer> entry : uniqueElems.entrySet()){
            double probability = entry.getValue() / length;
            entropy += probability * (Math.log(probability) / log2) * -1;
        }

        return entropy;
    }
}
