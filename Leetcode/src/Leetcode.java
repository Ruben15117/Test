import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


//class Solution {
//    public static int jump(int[] nums) {
//        if(nums.length==1){
//            return 0;
//        }
//        int count=0;
//        int i=0;
//        while(nums[i]+i<nums.length-1){
//            int reach=0;
//            int index=0;
//            for (int j = i+1; j <= nums[i]+i; j++) {
//                if(nums[j]!=0 && nums[j]+j>=reach){
//                    reach=nums[j]+j;
//                    index=j;
//                }
//            }
//            count++;
//            i=index;
//        }
//        return ++count;
//    }
//}

//class Solution {
//    public static boolean canJump(int[] nums) {
//        if(nums.length==1){
//            return true;
//        }
//        int i=0;
//        while(nums[i]+i<nums.length-1){
//            int reach=0;
//            int index=0;
//            for (int j = i+1; j <= nums[i]+i; j++) {
//                if(nums[j]!=0 && nums[j]+j>=reach){
//                    reach=nums[j]+j;
//                    index=j;
//                }
//            }
//            if(reach==0){
//                return false;
//            }
//            i=index;
//        }
//        return true;
//    }
//}

//class Solution {
//    public static boolean canReach(int[] arr, int start) {
//        if(start<0 || start>= arr.length || arr[start]<0){
//            return false;
//        }
//        if(arr[start]==0){
//            return true;
//        }
//        arr[start]=-arr[start];
//        if(canReach(arr, start-arr[start])|| canReach(arr, start+arr[start])){
//            arr[start]=-arr[start];
//            return true;
//        }
//        arr[start]=-arr[start];
//        return false;
//    }
//}

    class Solution {
        public static void solve(int n, List<String> ans, int l, int r, StringBuilder st){
            if(st.length()==2*n){
                ans.add(st.toString());
                return;
            }
            if(l<n){
                solve(n,ans, l+1,r,st.append('('));
                st.deleteCharAt(st.length()-1);
            }

            if(r<l){
                solve(n,ans, l,r+1,st.append(')'));
                st.deleteCharAt(st.length()-1);
            }

        }
        public static List<String> generateParenthesis(int n) {
            List<String> ans=new ArrayList<String>();
            StringBuilder st=new StringBuilder();
            solve(n, ans, 0, 0, st);
            return ans;
        }
    }


public class Leetcode {
        public static void main(String[] args) {
            int[] arr={3,0, 2, 1, 2};
            System.out.println(Solution.generateParenthesis(2));
        }
    }
