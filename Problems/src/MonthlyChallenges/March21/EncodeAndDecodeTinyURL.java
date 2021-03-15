package MonthlyChallenges.March21;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {
    //
    // LeetCode #535.
    //

    public static void main(String[] args) {
        EncodeAndDecodeTinyURL solution = new EncodeAndDecodeTinyURL();
//        String enc = solution.encode("http://www.leetcode.com/faq/?id=10");
        String enc = solution.encode("https://leetcode.com/discuss/interview-question/124658/Design-a-URL-Shortener-(-TinyURL-)-System/");
        System.out.println(enc);
        String dec = solution.decode(enc);
        System.out.println(dec);
    }

    private final Map<String, String> originals = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int resultID = longUrl.hashCode();

        String result = getEncoded(resultID);
        this.originals.put(result, longUrl);
        return result;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return this.originals.get(shortUrl);
    }


    private String getEncoded(int resultID) {
        char[] chars = {
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                '0','1','2','3','4','5','6','7','8','9'
        };

        String encoded = new String(String.valueOf(resultID));
        while (this.originals.containsKey(encoded)) {
            encoded = encoded + chars[(int) (Math.random()*62)];
        }

        return encoded;
    }
}
