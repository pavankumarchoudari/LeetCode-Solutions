public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Make sure to initialize result array
        for (int i = 0; i < n; i++) {
            result[i] = -1; // Default value (assuming no greater element)
        }
        
        // Assuming you're using a stack to find the next greater element
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) { // Make sure to loop over twice to simulate circular array
            int num = nums[i % n];  // Wrap index for circular behavior
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return result;
    }
}
