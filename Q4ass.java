public class Q4ass {

    public static boolean productSet(int arr[],int target,int product,boolean[] taken){

        if(product==target){
            return true;
        }
        if(product>target)return false;

        for(int i=0;i<arr.length;i++){
            if(taken[i]==false){
                taken[i]=true;
                if(productSet(arr, target, product*arr[i], taken)){
                    return true;
                }
                else{
                    taken[i]=false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[]={2,3,2,5,4};
        int target=16;
        boolean taken[]= new boolean[arr.length];          
        boolean res=productSet(arr,target,1,taken);
        System.out.println(res);
    }
}
