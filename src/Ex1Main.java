import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[] trues = {"135bA","135", "100111b2", "12345b6","012b5", "123bG", "EFbG"};
        String[] falses = {"b2", "0b1", "123b", "1234b11", "3b3", "-3b5", "3 b4", "GbG", "", null};
        System.out.println("TRUES:");
        for (int i = 0; i < trues.length; i++) {
            System.out.print(Ex1.isNumber(trues[i])+ " , ");
        }
        System.out.println("\nFALSES:");
        for (int i = 0; i < falses.length; i++) {
            System.out.print(Ex1.isNumber(falses[i])+ " , ");
        }
    }
}
