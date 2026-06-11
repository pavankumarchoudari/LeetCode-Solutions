class Solution {
    public boolean isBalanced(String num) {
        int evensum=0;int oddsum=0; int len=num.length();
        for( int i=0;i<len;i++){
            if(i%2==0){
                evensum = evensum + (num.charAt(i)-'0');
            }
            else{
                oddsum = oddsum +(num.charAt(i)-'0');
            }
        }
        return oddsum==evensum;
        
    }
}