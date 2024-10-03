import java.util.Scanner;

public class removevowel {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("enter a string");
        String a=in.nextLine();
        System.out.println(a.replaceAll("[aeiouAEIOU]",""));
    }
}
