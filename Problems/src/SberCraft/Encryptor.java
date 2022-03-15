package SberCraft;

public class Encryptor {

    /**
     * Implement function encode
     */
    public static String encode(String text) {
        // Write your code here...
        StringBuilder result = new StringBuilder();

        String postfix = "оп ";
        char[] letters = text.toCharArray();
        int idx = 0;

        for (; idx < letters.length; idx++) {
            char ch = letters[idx];
            if (isRussianAlpha(ch)) {
                idx++;
                while (idx < letters.length && isRussianAlpha(letters[idx])) {
                    result.append(letters[idx]);
                    idx++;
                }
                result.append(ch);
                result.append(postfix);
            } else {
                result.append(letters[idx]);
            }
        }

        if (result.charAt(result.length()-1) == ' ') result.deleteCharAt(result.length()-1);
        return result.toString();
    }
    private static boolean isRussianAlpha(char ch) {
        return (ch >= 'а' && ch <= 'я') || (ch >= 'А' && ch <='Я');
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }
}
