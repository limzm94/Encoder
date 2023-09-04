import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Encoder {
    int offset;
    Random random = new Random();
    /*char[] reference = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', '(', ')', '*', '+', ',', '-', '.', '/'};*/

    List<Character> reference = List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', '(', ')', '*', '+', ',', '-', '.', '/');


    public Encoder() {
        //offset = random.nextInt(44);
        offset = 5;
    }

    public String encode(String plainText) {
        StringBuilder encodedText = new StringBuilder();
        encodedText.append(reference.get(offset));

        // loop through the message
        for (int i = 0; i < plainText.length(); i++) {
            char textChar = plainText.charAt(i);
            if (reference.contains(textChar)) {
                // find out what's the charAt(i) and then find out the index of the char in reference table
                int textIndex = reference.indexOf(textChar);
                // check if the offset char will out of bound
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

        // loop through the message
        for (int i = 0; i < plainText.length(); i++) {
            char textChar = plainText.charAt(i);
            if (reference.contains(textChar)) {
                // find out what's the charAt(i) and then find out the index of the char in reference table
                int textIndex = reference.indexOf(textChar);
                // check if the offset char will out of bound
                if (textIndex + offset <= 43) {
                    decodedText.append(reference.get(textIndex + offset));
                } else {
                    decodedText.append(reference.get(44 - textIndex + offset));
                }
            } else {
                // if the char is empty space or not in reference table
                decodedText.append(textChar);
            }
        }

        return decodedText.toString();
    }


}
