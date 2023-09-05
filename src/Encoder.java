import java.util.List;
import java.util.Random;

public class Encoder {
    private int offset;
    Random random = new Random();

    private final List<Character> reference = List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', '(', ')', '*', '+', ',', '-', '.', '/');


    public String encode(String plainText) {
        offset = random.nextInt(44); //generate random offset value
        StringBuilder encodedText = new StringBuilder();
        encodedText.append(reference.get(offset));

        for (int i = 0; i < plainText.length(); i++) {
            char textChar = plainText.charAt(i); //plainText's char at index i
            if (reference.contains(textChar)) {
                int textIndex = reference.indexOf(textChar); //char's position in reference table
                //check if the offset char will be out of bound
                if (textIndex - offset >= 0) {
                    encodedText.append(reference.get(textIndex - offset));
                } else {
                    encodedText.append(reference.get(44 + textIndex - offset));
                }
            } else {
                // if the char is empty space or not in reference table
                encodedText.append(textChar);
            }
        }
        return encodedText.toString();
    }

    public String decode(String plainText) {
        StringBuilder decodedText = new StringBuilder();
        offset = reference.indexOf(plainText.charAt(0)); // get offset value from the first char

        for (int i = 1; i < plainText.length(); i++) {
            char textChar = plainText.charAt(i); //plainText's char at index i
            if (reference.contains(textChar)) {
                int textIndex = reference.indexOf(textChar); //char's position in reference table
                // check if the offset char will be out of bound
                if (textIndex + offset <= 43) {
                    decodedText.append(reference.get(textIndex + offset));
                } else {
                    decodedText.append(reference.get(textIndex + offset - 44));
                }
            } else {
                // if the char is empty space or not in reference table
                decodedText.append(textChar);
            }
        }
        return decodedText.toString();
    }
}
