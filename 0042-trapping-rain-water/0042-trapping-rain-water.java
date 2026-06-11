
class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1; // Initialize two pointers, one at the beginning and one at the end of the height array
        int leftMax = -1, rightMax = -1; // Initialize variables to store the maximum height encountered so far from the left and right sides
        int water = 0; // Initialize a variable to store the total trapped water

        // Traverse the height array from both ends towards each other until the pointers meet
        while (l < r) {
            leftMax = Math.max(leftMax, height[l]); // Update the maximum height encountered from the left side
            rightMax = Math.max(rightMax, height[r]); // Update the maximum height encountered from the right side

            // Calculate the trapped water based on the lower maximum height encountered so far (between leftMax and rightMax)
            // If leftMax is less than rightMax, the current height at index l can trap water, otherwise, the current height at index r can trap water
            if (leftMax < rightMax)
                water += leftMax - height[l++];
            else
                water += rightMax - height[r--];
        }

        return water; // Return the total trapped water
    }
}