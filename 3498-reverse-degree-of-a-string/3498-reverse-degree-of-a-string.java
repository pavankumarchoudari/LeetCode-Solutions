class Solution {
    public int reverseDegree(String s) {
        int finalva =0;
         
       
        for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);


        int value = 'z' - ch + 1;
           finalva = finalva +  value *(i+1);
        }
        
        return finalva;
        
    
    }
}