import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String text, int shift){
        if (shift > 26) {
            shift %= 26;
        }
        else if (shift < 0) {
            shift = (shift % 26) + 26;
        }

        String str = "";
        int length = text.length();
        for (int i = 0 ; i < length; i++) {
            char alpha = text.charAt(i);
            if(Character.isLetter(alpha)){
                if(Character.isLowerCase(alpha)) {
                    char c = (char)(alpha + shift);
                    if (c > 'z') {
                        str += (char)(alpha - (26-shift));
                    }
                    else {
                        str += c;
                    }
                }
                else {
                    char c = (char)(alpha + shift);
                    if(c > 'Z') {
                        str += (char)(alpha - (26-shift));
                    }
                    else {
                        str += c;
                    }
                }
            }
            else {
                str += alpha;
            }
        }
        return str;

    }
    public static String decrypt(String text, int shift){
        if (shift > 26) {
            shift %= 26;
        }
        else if (shift < 0) {
            shift = (shift % 26) + 26;
        }
        
        String str = "";
        int length = text.length();
        for (int i = 0 ; i < length; i++) {
            char alpha = text.charAt(i);
            if(Character.isLetter(alpha)){
                if(Character.isLowerCase(alpha)) {
                    char c = (char)(alpha - shift);
                    if (c < 'a') {
                        str += (char)(alpha + (26-shift));
                    }
                    else {
                        str += c;
                    }
                }
                else {
                    char c = (char)(alpha - shift);
                    if(c < 'A') {
                        str += (char)(alpha + (26-shift));
                    }
                    else {
                        str += c;
                    }
                }
            }
            else {
                str += alpha;
            }
        }
        return str;
    }

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("What's the message?");
            String text = in.nextLine();

            System.out.println("What's the shift?");
            int shift = in.nextInt();

            if (shift >= 0) {
                String str = encrypt(text, shift);
                System.out.println(str);}
            else {
                String str = text;
                String decrypted = decrypt(str, -(shift));
                System.out.println(decrypted);
            }
        }
    }
}