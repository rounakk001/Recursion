/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class pair{
    TreeNode node;
    int index;
    pair(TreeNode node,int index){
        this.node=node;
        this.index=index;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
         if(root==null)
         return 0;
         Queue<pair> q=new LinkedList<>();

         q.add(new pair(root,0));
         int ans=0;


         while(!q.isEmpty()){
            int size=q.size();
            
            int min=q.peek().index;

             int first=0;
             int last=0;
        
            //iske baad ek level me iterate krte hai
            for(int i=0;i<size;i++){
                int curr_index=q.peek().index-min;
                TreeNode node=q.peek().node;
                q.poll();

            if(i==0)
             first=curr_index;
            if(i==size-1)
            last=curr_index;

             if(node.left!=null)
             q.add(new pair(node.left,2*curr_index+1));
             if(node.right!=null)
             q.add(new pair(node.right,2*curr_index+2));

            }

            ans=Math.max(ans,last-first+1);
         }
         return ans;
    }
}