import java.util.*;

public class Q2ass {

    public static void function(List<List<Integer>> ans,int arr[],List<Integer> current,int index){
        if(index==arr.length){
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(!current.contains(arr[i])){
                current.add(arr[i]);
                function(ans, arr, current, index+1);
                current.remove(current.size()-1);
            }
        }
    }

    public static List<List<Integer>> permutate(int arr[]){
        List<List<Integer>> ans= new ArrayList<>();

        List<Integer> current= new ArrayList<>();
        function(ans,arr,current,0);
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3};
        List<List<Integer>> res= new ArrayList<>();
        res= permutate(arr);
        System.out.println(res);
    }
}
