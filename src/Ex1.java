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
        base = getNumValue(c);
        sub = num.substring(0,indexOfB);
        if(sub.isEmpty()){
            return false;
        }
        for(int i = 0; i < sub.length(); i++){
            if(getNumValue(sub.charAt(i)) >= base || getNumValue(sub.charAt(i)) == -1 ){
                return false;
            }
        }
        return true;
    }
    public static int number2Int(String num) {
        if(!isNumber(num)){
            return -1;
        }
        if(allDigits(num)){
            return Integer.parseInt(num);
        }
        int Bindex = num.indexOf('b');
        int base = getNumValue(num.charAt(Bindex+1));
        String strValue = num.substring(0,Bindex);
        int value = 0;
        for (int i = 0; i < strValue.length(); i++) {
            int power = strValue.length() - 1 - i;
            value += Math.pow(base, power) * getNumValue(strValue.charAt(i));
        }

        return value;
    }
    public static boolean equals(String n1, String n2) {
        return number2Int(n1) == number2Int(n2);
    }

    public static String int2Number(int num, int base) {
        String ans = "";
        if(getStrValue(base).isEmpty()){
            return ans;
        }
        if(num == 0){
            return "0b"+getStrValue(base);
        }
        while (num >= 0) {
            ans = getStrValue(num%base) + ans;
            num/=base;
        }
        ans+="b"+getStrValue(base);
        return ans;
    }



    public static boolean allDigits(String num) {
        for (int i = 0; i < num.length(); i++) {
            if(!Character.isDigit(num.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static String getStrValue(int num) {
        if(num <= 1 || num > 16){
            return "";
        }
        String[] arr = {"","","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G"};
        return arr[num];
    }
    public static int getNumValue(char c ){
        char[] arr = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G'};
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == c){
                return i;
            }
        }
        return -1;
    }
}
