public class goodcharacter {
    public static void main(String[] args) {
        String s="eebb";
        int n=s.length();
        int num = noofgoodcharacter(n,s);
        System.out.println("no of good character in given string is " + num);
    }
    static int noofgoodcharacter(int n,String s){
        int good=0;
        for (int i = 0; i < n; i+=3) {
            if(s.isEmpty()){
                break;
            }
            else {
                if (i==0){
                    if (s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                        good++;
                    }
                    if (s.charAt(i+1)=='a'||s.charAt(i+1)=='e'||s.charAt(i+1)=='i'||s.charAt(i+1)=='o'||s.charAt(i+1)=='u'){
                        good++;
                    }
                }
                else if (i>=1&&i<n-2){
                    if (s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                        good++;
                    }
                    if (s.charAt(i+1)=='a'||s.charAt(i+1)=='e'||s.charAt(i+1)=='i'||s.charAt(i+1)=='o'||s.charAt(i+1)=='u'){
                        good++;
                    }
                    if (s.charAt(i-1)=='a'||s.charAt(i-1)=='e'||s.charAt(i-1)=='i'||s.charAt(i-1)=='o'||s.charAt(i-1)=='u'){
                        good++;
                    }
                }
                else {
                    if (s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                        good++;
                    }

                    if (s.charAt(i-1)=='a'||s.charAt(i-1)=='e'||s.charAt(i-1)=='i'||s.charAt(i-1)=='o'||s.charAt(i-1)=='u'){
                        good++;
                    }
                }
            }
        }
        return good;
    }
}
