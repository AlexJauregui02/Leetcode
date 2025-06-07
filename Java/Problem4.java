
public String shortestPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        String combinedString = s + "." + reverse;

        int[] lps = new int[combinedString.length()];

        for (int i = 1; i < combinedString.length(); i++) {
            int pattern = lps[i - 1];
            while (pattern > 0 && combinedString.charAt(i) != combinedString.charAt(pattern)) {
                pattern = lps[pattern - 1];
            }
            if (combinedString.charAt(i) == combinedString.charAt(pattern)) {
                pattern++;
            }
            lps[i] = pattern;
        }

        String charsToAdd = s.substring(lps[combinedString.length() - 1]);
        String prefix = new StringBuilder(charsToAdd).reverse().toString();

        return prefix + s;
    }
