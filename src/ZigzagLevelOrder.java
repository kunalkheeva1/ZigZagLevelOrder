import java.util.*;

public class ZigzagLevelOrder {
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
    public List<List<Integer>> zigZaglevelOrder(TreeNode root){
       List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level =1;
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();

            while(size> 0){
                TreeNode current = q.remove();
                list.add(current.val);
                size--;
                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);
            }
            if(level %2 == 1)
            {
                ans.add(list);
            }
            else
            {
                Collections.reverse(list);
                ans.add(list);
            }
                level ++;
        }return ans;



    }

    public static void main(String[] args) {

    }
}
