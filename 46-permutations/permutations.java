class Solution {

    public void helper(List<Integer> ds,
                       List<List<Integer>> ans,
                       int[] nums,
                       boolean[] vis) {

        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0; i < nums.length; i++){

            if(vis[i]) 
            continue;       //agar visited hai to add hi ahi karega

            vis[i] = true;
            ds.add(nums[i]);

            helper(ds, ans, nums, vis);

            ds.remove(ds.size()-1);
            vis[i] = false;   // backtrack
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];

        helper(new ArrayList<>(), ans, nums, vis);

        return ans;
    }
}
