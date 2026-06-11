
        class Solution {
    public static int nextG(int n,int nums2[]){
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<nums2.length;i++){
            st.push(nums2[i]);
        }
        int temp=-1;
        while(!st.isEmpty()){
            if(st.peek()>n){
                temp=st.peek();
            }
            if(st.peek()==n){
                return temp;
            }
            st.pop();
        }
        return temp;

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int arr[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int n=nextG(nums1[i],nums2);
            arr[i]=n;
        }
        return arr;

    }
}
    