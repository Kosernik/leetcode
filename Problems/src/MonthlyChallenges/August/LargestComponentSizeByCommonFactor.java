package MonthlyChallenges.August;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class LargestComponentSizeByCommonFactor {
    public static void main(String[] args) {
        LargestComponentSizeByCommonFactor solution = new LargestComponentSizeByCommonFactor();

//        Set<Integer> testBig = new HashSet<>();
//        while (testBig.size() < 20000) {
//            int currRandom = ThreadLocalRandom.current().nextInt(1, 100001);
//            testBig.add(currRandom);
//        }
//        System.out.println(testBig.toString());

//        int[] test2 = {20,50,9,63};
//
//        long start = System.currentTimeMillis();
//        System.out.println("solution brute " + solution.largestComponentSize(test2));
//        System.out.println("Brute: " + (System.currentTimeMillis() - start));
//
//        start = System.currentTimeMillis();
//        System.out.println("solution alt " + solution.largestComponentSizeAlt(test2));
//        System.out.println("Alt: " + (System.currentTimeMillis() - start));

        int[] test5 = {1,2,3,4,5,6,7,8,9};
//        System.out.println("solution brute " + solution.largestComponentSize(test5));
        System.out.println("solution alt " + solution.largestComponentSize(test5));


//        int[] test4 = new int[testBig.size()];
//        int idx = 0;
//        for (Integer num : testBig) {
//            test4[idx++] = num;
//        }
//
//        long start = System.currentTimeMillis();
//        System.out.println("solution alt " + solution.largestComponentSize(test4));
//        System.out.println("Alt: " + (System.currentTimeMillis() - start));

//        start = System.currentTimeMillis();
//        System.out.println("solution brute " + solution.largestComponentSizeBrute(test4));
//        System.out.println("Brute: " + (System.currentTimeMillis() - start));
    }

    public int largestComponentSizeBrute(int[] A) {
        if (A == null || A.length == 0) return 0;

        Map<Integer, Set<Integer>> commonFactors = new HashMap<>();
        int length = A.length;
        int largestComponent = 0;

        for (int i = 0; i < length-1; i++) {
            Set<Integer> currSet = new HashSet<>();
            int currNumber = A[i];
            currSet.add(currNumber);

            for (int j = i+1; j < length; j++) {
                int commonFactor = gcd(currNumber, A[j]);
                if (commonFactor != 1) {
                    currSet.add(A[j]);
                    if (commonFactors.containsKey(commonFactor)) {
                        currSet.addAll(commonFactors.get(commonFactor));
                    }
                    commonFactors.put(commonFactor, currSet);
                }
            }
            largestComponent = Math.max(currSet.size(), largestComponent);
        }

        return largestComponent;
    }

    private int gcd(int a, int b) {
        return b==0 ? a : gcd(b, a%b);
    }

    private int largestComponent = 0;
    public int largestComponentSize(int[] A) {
        if (A == null || A.length == 0) return 0;
        int maxNumber = -1;
        for (int number : A) {
            maxNumber = Math.max(maxNumber, number);
        }
        Set<Integer> primes = primeNumbers(maxNumber);

        int length = A.length;
        int[] sizes = new int[length];
        int[] parents = new int[length];
        int[] primeToIndex = new int[maxNumber+1];
        Arrays.fill(primeToIndex, -1);

        for (int i = 0; i < length; i++) {
            parents[i] = i;
            sizes[i] = 1;
        }

        for (int i = 0; i < length; i++) {
            int currNumber = A[i];
            for (int prime : primes) {
                if (primes.contains(currNumber)) {
                    prime = currNumber;
                }
                if (currNumber % prime == 0) {
                    if (primeToIndex[prime] > -1) {
                        union(parents, sizes, primeToIndex[prime], i);
                    }
                    primeToIndex[prime] = i;
                    while (currNumber % prime == 0) {
                        currNumber /= prime;
                    }
                }
                if (currNumber == 1) break;
            }
        }

//        System.out.println(Arrays.toString(parents));
//        System.out.println(Arrays.toString(sizes));
//        System.out.println(Arrays.toString(primeToIndex));

        return largestComponent;
    }

    private void union(int[] parents, int[] sizes, int first, int second) {
        int rootFirst = find(parents, first);
        int rootSecond = find(parents, second);
        if (rootFirst == rootSecond) return;

        int size = sizes[rootFirst] + sizes[rootSecond];
        largestComponent = Math.max(size, largestComponent);
        parents[rootFirst] = rootSecond;
        sizes[rootSecond] = size;
    }

    private int find(int[] parents, int number) {
        if (parents[number] != number) {
            parents[number] = find(parents, parents[number]);
        }
        return parents[number];
    }

    private Set<Integer> primeNumbers(int maxNumber) {
        int size = maxNumber+1;
        boolean[] notPrime = new boolean[size];
        notPrime[0] = true;
        notPrime[1] = false;
        Set<Integer> res = new HashSet<>();

        for (int  i = 2; i < size; i++) {
            if (!notPrime[i]) {
                res.add(i);
                int multiplier = 2;
                int currNum = i * multiplier;
                while (currNum < size) {
                    notPrime[currNum] = true;
                    multiplier++;
                    currNum = i * multiplier;
                }
            }
        }

        return res;
    }
}
