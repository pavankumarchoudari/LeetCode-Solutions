class Solution {
    public String reverseWords(String s) {
        String ans = "";
       StringBuilder str = new StringBuilder(s);
        str.reverse();
        for(int i=0;i<str.length();i++){
            String word = "";
            while(i<str.length() && str.charAt(i) != ' '){
               word += str.charAt(i);
                i++;
            }
             StringBuilder st = new StringBuilder(word); st.reverse();
            
            if(st.length()>0){
                
                  
            
             ans += " "+ st;

                }
            
           
            
        }
        return ans.substring(1);
        
    }
}