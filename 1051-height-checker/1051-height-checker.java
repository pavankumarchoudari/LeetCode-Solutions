class Solution {
    public int heightChecker(int[] heights) {
        int n=heights.length;
        int [] expected=Arrays.copyOfRange(heights,0,heights.length);

        Arrays.sort(expected);
        int count=0;
        for(int i=0;i<n;i++){
            if(heights[i]!=expected[i]){
                count++;
            }
        }
        return count;
        
    }
}