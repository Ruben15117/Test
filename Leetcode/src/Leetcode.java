import java.util.ArrayList;
import java.util.Arrays;
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

//    class Solution {
//        public static void solve(int n, List<String> ans, int l, int r, StringBuilder st){
//            if(st.length()==2*n){
//                ans.add(st.toString());
//                return;
//            }
//            if(l<n){
//                solve(n,ans, l+1,r,st.append('('));
//                st.deleteCharAt(st.length()-1);
//            }
//
//            if(r<l){
//                solve(n,ans, l,r+1,st.append(')'));
//                st.deleteCharAt(st.length()-1);
//            }
//
//        }
//        public static List<String> generateParenthesis(int n) {
//            List<String> ans=new ArrayList<String>();
//            StringBuilder st=new StringBuilder();
//            solve(n, ans, 0, 0, st);
//            return ans;
//        }
//    }

//11

//class Solution {
//    public static int maxArea(int[] height) {
//        int right=0;
//        int maxArea=0;
//        for (int i = 0; i < height.length; i++) {
//            if(height[i]==0){
//                continue;
//            }
//            right=Math.max(i+1,maxArea/height[i]);
//            for (int j = right; j < height.length; j++) {
//                int temp=(j-i)*Math.min(height[i],height[j]);
//                maxArea=Math.max(temp,maxArea);
//            }
//        }
//        return maxArea;
//
//    }
//}

// 3423

//class Solution {
//    public int maxAdjacentDistance(int[] nums) {
//        int maxDiff=Math.abs(nums[0]-nums[nums.length-1]);
//        for (int i = 0; i <nums.length -1 ; i++) {
//            maxDiff=Math.max(maxDiff,Math.abs(nums[i]-nums[i+1]));
//        }
//        return maxDiff;
//    }
//}

//42
class Solution {
    static int fill(int left, int[] height, int[] water){
        int i=left+1;
        int rocks=0;
        int maxPot=0;
        int right=left+1;
        while (i< height.length && height[i]<height[left]){
            if(height[i]!=0){
                if(height[i]>height[right]){
                    maxPot=(i-left-1)*height[i]-rocks;
                    right=i;
                }
                rocks+=height[i];
            }
            i++;
        }
        if(i>=height.length){
            if(rocks==0){
                return i;
            }
            water[0]+=maxPot;
            return right-1;
        }
        water[0]+=((i-left-1)*height[left]-rocks);
        return i-1;
    }
    public static int trap(int[] height) {
        int[] water={0};
        int left=0;
        int right=0;
        for (int i = 0; i < height.length; i++) {
            if (height[i]!=0){
                i=fill(i,height,water);
            }
        }
        return water[0];
    }
}


public class Leetcode {
        public static void main(String[] args) {
            int[] arr={5,4,1,2};
            System.out.println(Solution.trap(arr));
        }
    }
