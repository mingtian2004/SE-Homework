package src.main.java.com.ctgu.work1;

public class Max {
    public static int getMax(int[] nums){
        int maxsum=0;
        int currentsum;
        for(int i=0;i< nums.length;i++){
            currentsum=nums[i];
            for(int j=i+1;j<nums.length;j++){
                currentsum+=nums[j];
                if(currentsum>maxsum){
                    maxsum=currentsum;
                }
            }
        }
        return maxsum;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, -2, 3, 5, -1};
        int[] nums2 = {1, -2, 3, -8, 5, 1};
        int[] nums3 = {1, -2, 3, -2, 5, 1};

        System.out.println("数组1的最大子数组和：" + getMax(nums1)); // 输出8
        System.out.println("数组2的最大子数组和：" + getMax(nums2)); // 输出6
        System.out.println("数组3的最大子数组和：" + getMax(nums3)); // 输出7
    }
}
