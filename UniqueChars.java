public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    public static String uniqueChars(String s) {
        String oldStr = s;
        String newStr = "";
        char ch;
        int doesCharExistsNewStr;
        
        for (int i = 0; i < oldStr.length(); i++) {
            ch = oldStr.charAt(i);
            doesCharExistsNewStr = newStr.indexOf(ch);
            if (doesCharExistsNewStr < 0 || ch == ' ') {
                newStr += ch;
            }
        }
        
        return newStr;
    }

    public static boolean doesCharMoreThanOnceInStr(String text, char chr) {
        int repeatCharCounter = 0, loopCounter = 0;
        int stringLength = text.length();
        while (repeatCharCounter <= 1 && loopCounter <= stringLength -1) {
            if(text.charAt(loopCounter) == chr) {
                repeatCharCounter++;
            }
            loopCounter++;
        }

        if(repeatCharCounter == 2) {
            return true;
        }
        return false;
    }
}