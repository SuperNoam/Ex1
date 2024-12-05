public class Ex1 {

    public static boolean isNumber(String num) {
        if (num == null || num.isEmpty()) {
            return false;
        }
        int indexOfB = num.indexOf('b');
        if(indexOfB == -1) {
            //no b in the String so check if the number is only digits
            return allDigits(num);
        }
        String sub = num.substring(indexOfB+1);
        if(sub.length() != 1) {
            return false;
        }
        char c = sub.charAt(0);
        int base =(int)c;
        if(!((base >= 50 && base <= 57) || (base >= 65 && base <= 71))){
            return false;
        }
        base = getvalue(c);
        sub = num.substring(0,indexOfB);
        if(sub.isEmpty()){
            return false;
        }
        for(int i = 0; i < sub.length(); i++){
            if(getvalue(sub.charAt(i)) >= base || getvalue(sub.charAt(i)) == -1 ){
                return false;
            }
        }
        return true;
    }
    public static boolean allDigits(String num) {
        for (int i = 0; i < num.length(); i++) {
            if(!Character.isDigit(num.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static int getvalue(char c ){
        char[] arr = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G'};
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == c){
                return i;
            }
        }
        return -1;
    }
}
