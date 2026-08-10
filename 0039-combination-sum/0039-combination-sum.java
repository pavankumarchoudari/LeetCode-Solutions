class Solution {
    private void findComb(int ind,int[] candidates,int target,List<List<Integer>>ans,List<Integer>ds){
        if(ind==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;

        }
        if(candidates[ind]<=target){
            ds.add(candidates[ind]);
            findComb( ind, candidates, target-candidates[ind],ans,ds);
            ds.remove(ds.size()-1);


        }
         findComb( ind+1, candidates, target,ans,ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
         findComb(0, candidates, target,ans,new ArrayList<>());
         return ans;

        
    }
}