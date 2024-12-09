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
            //if the length of the String after the b is not equal 1
            //return false
            return false;
        }
        char c = sub.charAt(0);
        int base =(int)c;
        if(!((base >= 50 && base <= 57) || (base >= 65 && base <= 71))){
            //check if the base is the right letters / digits
            //using ASCII
            return false;
        }
        base = getNumValue(c);
        sub = num.substring(0,indexOfB);
        if(sub.isEmpty()){
            //check if the string from the start to the b
            //is empty or not
            return false;
        }
        for(int i = 0; i < sub.length(); i++){
            if(getNumValue(sub.charAt(i)) >= base || getNumValue(sub.charAt(i)) == -1 ){
                //chech if the digits/letter are correct according to the base
                //and also if they fit in the format
                return false;
            }
        }
        return true;
    }
    public static int number2Int(String num) {
        if(!isNumber(num)){
            //check if the number are in correct format
            return -1;
        }
        if(allDigits(num)){
            //if the number is already in base 10 and its made
            //only from digits just cast it to int
            return Integer.parseInt(num);
        }
        int bIndex= num.indexOf('b');
        int base = getNumValue(num.charAt(bIndex+1));
        String strValue = num.substring(0,bIndex);
        int value = 0;
        for (int i = 0; i < strValue.length(); i++) {
            //calc the value of the number
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
        if(base == 10){
            return String.valueOf(num);
        }
        while (num > 0) {
            //build the number from left to right
            ans = getStrValue(num%base) + ans;
            num/=base;
        }
        ans = ans+"b"+getStrValue(base);
        return ans;
    }
    public static int maxIndex(String[] arr){
        int maxIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null && isNumber(arr[i])) {
                if(maxIndex == -1) {
                    maxIndex = i;

                }else if(number2Int(arr[i]) > number2Int(arr[maxIndex])){
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
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
        if(num < 0  || num > 16){
            return "";
        }
        String[] arr = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G"};
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
