import java.util.*;

public class Q3ass {

    public static void function(List<List<Integer>> ans,int arr[],List<Integer> current,int index,boolean taken[]){
        if(index==arr.length){
            if(!ans.contains(current)){             // for not having duplicate elements
                ans.add(new ArrayList<>(current));
                return;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(taken[i]==false){
                taken[i]=true;
                current.add(arr[i]);
                function(ans, arr, current, index+1, taken);
                // backtracking
                current.remove(current.size()-1);
                taken[i]=false;
            }
        }

    }

    public static List<List<Integer>> permutateIt(int arr[]){
        List<List<Integer>> ans= new ArrayList<>();

        List<Integer> current= new ArrayList<>();
        boolean taken[]= new boolean[arr.length];          //Using taken to know if that element in array is used or not. 
        function(ans,arr,current,0,taken);
        return ans;
    }

    public static void main(String[] args) {
        int arr1[]={1,2,1};
        // int arr2[]={1,2,3};
        List<List<Integer>> res= new ArrayList<>();
        res= permutateIt(arr1);
        System.out.println(res);
    }
}
