package leetcode.hard;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * @author baibhav <baibhavr@gmail.com>
 * 3:07:37 AM Oct 25, 2021
 */
public class CodecBinaryTree {

	StringBuilder encoded = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Using pre-order traversal
        preOrder(root);
        // System.out.println(encoded.toString());
        return encoded.toString();
    }
    
    public void preOrder(TreeNode cur){
        if(cur==null){
            encoded.append("null");
            encoded.append(",");
            return;
        }
        encoded.append(cur.val);
        encoded.append(",");
        preOrder(cur.left);
        preOrder(cur.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Using pre-order traversal
        return preOrderDecode(data.split(","),new int[]{-1});
    }
    
    public TreeNode preOrderDecode(String[] values, int[] i){
        i[0]++;
        if(values[i[0]].equals("null")){
            return null;
        }
        
        TreeNode cur = new TreeNode(Integer.valueOf(values[i[0]]));
        cur.left = preOrderDecode(values, i);
        cur.right = preOrderDecode(values, i);
        return cur;
    }
    
	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
