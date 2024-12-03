import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while(true){
            String number = reader.nextLine();
            System.out.println(Ex1.isNumber(number));
        }
    }
}
