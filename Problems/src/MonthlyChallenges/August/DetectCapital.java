package MonthlyChallenges.August;

public class DetectCapital {
    public static void main(String[] args) {
        DetectCapital solution = new DetectCapital();
        solution.testDetectCapitalUse();
    }

    private void testDetectCapitalUse() {
        String[] tests = {"USA", "FlaG", "ABDSDSDS", "ASadfsf", "Adfsdf", "A", "AB", "Ab", "a", "AsdfsdfsdA", "ASADASASa"};
        boolean[] results = {true, false, true, false, true, true, true, true, true, false, false};

        for (int i = 0; i < tests.length; i++) {
            if (detectCapitalUse(tests[i]) != results[i]) {
                System.out.println("Failed test #" + i);
                System.out.println("Got: " + (!results[i]) + " , instead of: " + (results[i]));
            }
        }
    }

    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;

        char[] letters = word.toCharArray();
        // Проверка превого символа в строке на регистр
        // Первый символ - заглавная буква
        if (Character.isUpperCase(letters[0])) {
            // Если вторая буква заглавная, то все буквы должны быть заглавными
            if (Character.isUpperCase(letters[1])) {
                for (int i = 2; i < letters.length; i++) {
                    if (!Character.isUpperCase(letters[i])) return false;
                }
            }
            // Вторая буква строчная, все остальные буквы должны быть строчными
            else {
                for (int i = 2; i < letters.length; i++) {
                    if (Character.isUpperCase(letters[i])) return false;
                }
            }
        }
        // Первый символ - строчная буква
        else {
            // Проверка каждого символа на регистр
            for (int i = 1; i < letters.length; i++) {
                // Если буква заглавная - возврат FALSE
                if (Character.isUpperCase(letters[i])) return false;
            }
        }
        return true;
    }
}
