public class BCipher implements ICipher {
    @Override
    public String encode(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    result.append((char) ('z' - (c - 'a')));
                } else {
                    result.append((char) ('Z' - (c - 'A')));
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    @Override
    public String decode(String input) {
        return encode(input);
    }
}