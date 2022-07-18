import java.util.*;

public class ZigzagLevelOrder {

    // get a node that stores val, and left and right
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }
    // method to return a list of lists
    public List<List<Integer>> zigZaglevelOrder(TreeNode root){
        //get a list of list
       List<List<Integer>> ans = new ArrayList<>();
       //if root is null then simply return the list
        if(root == null) return ans;
        //queue will contain the roots by levels
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level =1;
        // until the queue is empty
        while(!q.isEmpty())
        {
            // get a list to store the datas of the nodes
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();

            while(size> 0)
            {   // remove the node from the queue and add its value to the list
                // and decrease the size
                TreeNode current = q.remove();
                list.add(current.val);
                size--;
                // check the left and right too
                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);
            }
            // if level is odd then simply add it, otherwise reverse it first
            if(level %2 == 1)
            {
                ans.add(list);
            }
            else
            {
                Collections.reverse(list);
                ans.add(list);
            }// also increment the level after every traversal
                level ++;
        } // return the ans
        return ans;



    }

    public static void main(String[] args) {

    }
}
