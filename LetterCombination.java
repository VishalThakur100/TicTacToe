import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    static String[] options={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args) {
        String n="24";
        System.out.println(getCombination(n));
    }
    private static List<String> getCombination(String n) {
        if (n.isEmpty()){
            return new ArrayList<>();
        }
        return result(n,0);
    }
    private static List<String> result(String n, int i) {
        if (i==n.length()){
            List<String> list=new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> finalans=new ArrayList<>();
        List<String> ans = result(n,i+1);
        char ch=n.charAt(i);  //  '2'
        String s=options[ch-'0'];
//        System.out.println(s);
        for (String res: ans
             ) {
            for (int j = 0; j < s.length(); j++) {
                char st=s.charAt(j);
                finalans.add(st+res);
            }
        }
        return finalans;
    }
}
