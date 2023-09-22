public class Q1ass{

    public static boolean backtrack(int arr[],int k,int currentSum,int target,int index,int count,boolean taken[]){

        if(count==k-1)return true;

        if(currentSum>target) return false;

        if(currentSum == target){
            return backtrack(arr, k, 0, target, 0, count+1, taken);
        }

        for(int i=index;    i<arr.length;   i++){
            if(taken[i] == false){

                taken[i] =true;
                if(backtrack(arr, k, currentSum + arr[i], target, i+1, count, taken)){
                    return true;
                }
                taken[i] = false;
            }
        }

        return false;
    }

    public static boolean isSumPossible(int arr[],int k){

        if(k==1)return true;

        int sum=0;
        for (int i : arr) {
            sum+=i;
        }
        if(sum % k !=0){
            return false;
        }
        int target= sum/k;
        boolean[] taken= new boolean[arr.length]; 
        for(int i=0;i<arr.length;i++){
            taken[i]=false;
        }

        return backtrack(arr,k,0,target,0,0,taken);
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,2};
        int k=2;
        System.out.println(isSumPossible(arr,k)); 
    }
}