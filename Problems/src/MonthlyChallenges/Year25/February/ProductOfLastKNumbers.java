package MonthlyChallenges.Year25.February;

import java.util.ArrayList;
import java.util.List;

public class ProductOfLastKNumbers {

    /**
     * LeetCode №1352. Product of the Last K Numbers.
     */
    class ProductOfNumbers {
        private final List<Long> products;
        private int lastZero = -1;

        public ProductOfNumbers() {
            products = new ArrayList<>();
            products.add(1L);
        }

        public void add(int num) {
            if (num == 0) {
                lastZero = products.size();
                products.add(1L);
            } else {
                long prevProduct = products.get(products.size() - 1);
                products.add(prevProduct * num);
            }
        }

        public int getProduct(int k) {
            int curSize = products.size();
            int lastIdx = curSize - k;

            if (lastZero >= lastIdx) return 0;

            long prevProduct = products.get(curSize - 1);
            long startProduct = products.get(lastIdx - 1);

            return (int) (prevProduct / startProduct);
        }
    }
}
