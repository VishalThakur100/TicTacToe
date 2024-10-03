import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class CrazyBitStringmain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=6;
        String s="010100";
        ArrayList<Integer> a=new ArrayList<>();
        a.add(30);
        a.add(37);
        a.add(28);
        a.add(69);
        a.add(74);
        a.add(47);
//        a.add(57);
        System.out.println(getcrazyBitstring(n, s, a));
    }

    private static int getcrazyBitstring(int n, String s, ArrayList<Integer> a) {
        if (s.isEmpty()){
            return 0;
        }
        int count1=0;
        int count2=0;
        ArrayList<Integer> myArr=new ArrayList<>(5);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)=='0'){
                count1++;
            }
            else
                count2++;
        }
        if (count1==count2){
            return 0;
        }

        if (count2>count1){
            if (count2-count1==1) {
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '1') {
                        myArr.add(a.get(i));
                    }
                }
                int min = myArr.get(0);
                for (int i = 1; i < myArr.size(); i++) {
                    if (myArr.get(i) < min) {
                        min = myArr.get(i);
                    }
                }
                return min;
            }
            else {
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '0') {
                        myArr.add(a.get(i));
                    }
                }
                int cost=0;
//                int min = myArr.get(0);
                for (int i = 1; i < myArr.size(); i++) {
                    cost=cost+myArr.get(i);
                }
                return cost;
            }
        }
        else if (count1>count2){
            if (count1-count2==1)
            {
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '0') {
                        myArr.add(a.get(i));
                    }
                }
                int min = myArr.get(0);
                for (int i = 0; i < myArr.size(); i++) {
                    if (myArr.get(i) < min) {
                        min = myArr.get(i);
                    }
                }
                return min;
            }
            else {
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '1') {
                        myArr.add(a.get(i));
                    }
                }
                int cost=0;
//                int min = myArr.get(0);
                for (int i = 0; i < myArr.size(); i++) {
//                   cost+=myArr.get(i);
                    cost=cost+myArr.get(i);
                }
                return cost;
            }
        }
        if (count1==1){
            for (int i = 0; i < n; i++) {
                if (s.charAt(i)=='0'){
                    return a.get(i);
                }
            }
        }else {
            for (int i = 0; i < n; i++) {
                if (s.charAt(i)=='1'){
                    return a.get(i);
                }
            }
        }
       return 0;
    }
}