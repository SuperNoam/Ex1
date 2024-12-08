import java.util.Arrays;
import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[] arr = new String[4];
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = reader.next();
            if (!num1.equals("quit")) {
                if(Ex1.isNumber(num1)) {
                    System.out.println("num1 = " + num1 + " is Number = true , value: " + Ex1.number2Int(num1));
                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                    num2 = reader.next();
                    if(!num2.equals("quit")) {
                        if(Ex1.isNumber(num2)) {
                            System.out.println("num2 = " + num2 + " is Number = true , value: " + Ex1.number2Int(num2));
                            System.out.println("Enter base for output");
                            int base = reader.nextInt();
                            if(base >= 2 && base <= 16){
                                arr[0] = num1;
                                arr[1] = num2;
                                arr[2] = Ex1.int2Number(Ex1.number2Int(num1) + Ex1.number2Int(num2),base);
                                arr[3] = Ex1.int2Number(Ex1.number2Int(num1) * Ex1.number2Int(num2),base);
                                System.out.println(num1 + " + " + num2 + " = " + arr[2]);
                                System.out.println(num1 + " * " + num2 + " = " + arr[3]);
                                System.out.println("Max number over " + Arrays.toString(arr) + " is: " + arr[Ex1.maxIndex(arr)]);
                            }

                            else{
                                System.out.println("ERR: wrong base, should be [2,16], got ("+base+")");
                            }

                        }
                        else{
                            System.out.println("num2 = " + num2 + " is Number = false , value: " + Ex1.number2Int(num2));
                            System.out.println("ERR: num1 is in the wrong format! ("+num2+")");
                        }
                    }
                }
                else{
                    System.out.println("num1 = " + num1 + " is Number = false , value: " + Ex1.number2Int(num1));
                    System.out.println("ERR: num1 is in the wrong format! ("+num1+")");
                }


            }
        }
        System.out.println("quiting now...");
    }
}