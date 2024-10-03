public class binsearchwithrecursion {
    public static void main(String[] args) {
//        int[] a=new int[10];
        int[] arr={2,5,8,90,110,111,120,190};
        System.out.println("found at index"+ bs(arr,0,arr.length,90)  );
    }

    private static int bs(int[] arr, int i, int length,int key) {
        while (length>=i){
            int mid=i+(length-i)/2;
            if (arr[mid]==key)
                return mid;
            else if (arr[mid]<key) {
                return bs(arr,mid+1,length,key);
            }
            else
                return bs(arr,i,mid-1,key);
        }
        return -1;
    }
}
