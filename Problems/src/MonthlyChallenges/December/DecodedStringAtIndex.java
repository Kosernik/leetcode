package MonthlyChallenges.December;

public class DecodedStringAtIndex {
    // LeetCode #880.
    public static void main(String[] args) {
        DecodedStringAtIndex solution = new DecodedStringAtIndex();

        System.out.println(solution.decodeAtIndex("leet2code3", 10));

        System.out.println(solution.decodeAtIndex("y959q969u3hb22odq595", 222280369));
    }

    public String decodeAtIndexMLE(String S, int K) {
        StringBuilder builder = new StringBuilder();

        for (char ch : S.toCharArray()){
            if (Character.isAlphabetic(ch)) {
                builder.append(ch);
            } else {
                String currString = builder.toString();
                builder.append(currString.repeat(Math.max(0, (ch - '0') - 1)));
            }
            if (builder.length() > K) {
                return String.valueOf(builder.charAt(K-1));
            }
        }

        return String.valueOf(builder.charAt(K-1));
    }

    public String decodeAtIndex(String S, int K) {
        long totalLength = 0;

        for (char ch : S.toCharArray()) {
            if (Character.isLetter(ch)) {
                totalLength++;
            } else {
                totalLength = totalLength * (ch - '0');
            }
        }

        for (int i = S.length()-1; i >= 0; i--) {
            K %= totalLength;

            if (K == 0 && Character.isLetter(S.charAt(i))) {
                return String.valueOf(S.charAt(i));
            }
            if (Character.isDigit(S.charAt(i))) {
                totalLength /= S.charAt(i) - '0';
            } else {
                totalLength--;
            }
        }
        return "";
    }
}
