public class SecondLargest {
    public static void main (String[] args){
        int[] arr={1,2,3,7,7,5,0};
        int largest=arr[0];
        int Slargest=Integer.MIN_VALUE;
        int smallest=arr[0];
        int Ssmallest=Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
                if (arr[i]>largest&&largest>Slargest){
                    Slargest=largest;
                    largest=arr[i];

                } else if (arr[i]<largest&& arr[i]>Slargest) {
                    Slargest=arr[i];
                }
        }
//
        System.out.println(Slargest);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<smallest){
                    Ssmallest=smallest;
                    smallest=arr[i];
            } else if (arr[i]>smallest&& arr[i]<Ssmallest) {
Ssmallest=arr[i];
            }
        }
        System.out.println(Ssmallest);
//        for (int i = 0; i < arr.length; i++) {
////            if (arr[i]>largest){
////                largest=arr[i];
////            }
////        }
////        System.out.println(largest);
////        int Slargest=-1;
////        for (int i = 0; i < arr.length; i++) {
////            if (arr[i]>Slargest&& arr[i]!=largest){
////                Slargest=arr[i];
////            }
////        }
    }
}
