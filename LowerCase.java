public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }

    public static String lowerCase(String s) {
        String toLower = "";
        for (int i = 0; i < s.length(); i++) {
            if ((int)(s.charAt(i)) >= 65 && (int)(s.charAt(i)) <= 90 ) {
                char ascii = (char)((int)(s.charAt(i)) + 32);
                toLower += ascii;
            }
            else {
                toLower += s.charAt(i);
            }
        }
        return toLower;
    }
}