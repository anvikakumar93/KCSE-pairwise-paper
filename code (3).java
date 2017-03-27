
import java.io.*;
import java.util.ArrayList;
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 
 }
 
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root == null)
        {
            return result;
        }
        dfs(root, String.valueOf(root.val), result);
        return result;
    }
    public void dfs(TreeNode root, String path, List<String> result)
    {
        if(root == null)
        {
            return;
        }
        if(root.left == null&& root.right == null)
        {
            result.add(path);
           
            
        }
        if(root.left != null)
        {
            dfs(root.left, path+"->"+String.valueOf(root.left.val) , result);
        }
        if(root.right != null)
        {
             dfs(root.right, path+"->"+String.valueOf(root.right.val), result);
        }
    }
        
}   
    
       