public class Ex1 {
    public static boolean isNumber(String num) {
        int index = num.indexOf('b');
        if(index == -1) {
            return false;
        }
        String sub = num.substring(index+1);
        if(sub.length() >=2 ) {
            return false;
        }
        char c = sub.charAt(0);
        int base = (int)c;
        if(!((base >= 50 && base <= 57) || (base >= 65 && base <= 70))){
            return false;
        }
        sub = num.substring(0,index);
        if(sub.isEmpty()){
            return false;
        }
        for (int i = 0; i < sub.length(); i++) {
            if(!Character.isDigit(num.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
