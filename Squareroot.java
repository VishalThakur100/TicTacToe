import java.util.Scanner;

public class Squareroot {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("enter a number");
        int n=in.nextInt();
        System.out.println(BinSquareroot(n));
//        System.out.println(findSquareroot(n));
    }

    private static int BinSquareroot(int n) {
        int l=1;
        int h=n;
        while(l<=h){
            int mid=(l+h)/2;
            if (mid*mid==n)
                return mid;
            if (mid*mid<n){
               l=mid+1;
            }
            else
                h=mid-1;
        }
        return h;
    }

    private static int findSquareroot(int n) {
        int i=0;
        while(i<=n/2){
            if (i*i<=n)
                i++;
            else
                return i-1;
        }
        return i-1;
    }
}
