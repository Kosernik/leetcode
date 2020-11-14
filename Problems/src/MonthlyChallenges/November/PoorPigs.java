package MonthlyChallenges.November;

public class PoorPigs {
    public static void main(String[] args) {
        double l1 = Math.log(1000);
        double l2 = Math.log(Math.floor(60 * 1.0/15) + 1);

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(Math.ceil(l1 / l2));
    }

    /**
     * Returns the minimum number of 'pigs' to find the poisonous bucket.
     *
     * @param buckets - total number of buckets.
     * @param minutesToDie - time required to test a bucket.
     * @param minutesToTest - time after when the poisonous bucket should be find.
     * @return - minimum number of 'pigs'.
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) Math.ceil(Math.log(buckets) / Math.log(Math.floor(minutesToTest * 1.0/minutesToDie) + 1));
    }
}
