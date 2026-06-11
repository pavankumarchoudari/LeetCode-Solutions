class Solution {
    public char repeatedCharacter(String s) {
        int freq[]=new int[26];
        int temp;
        for(int i=0;i<s.length();i++){
            temp=s.charAt(i)-'a';
            if(freq[temp]==1){
                return s.charAt(i);
            }
            freq[temp]=1;

        }return ' ';
        
    }
}