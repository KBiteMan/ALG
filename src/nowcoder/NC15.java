package nowcoder;

import data.Creater;
import data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 * 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7},
 *
 *               3
 *             /   \
 *            9    20
 *                /  \
 *               15   7
 *
 * 该二叉树层序遍历的结果是
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * 提示:
 * 0 <= 二叉树的结点数 <= 1500
 *
 * 示例1
 * 输入：
 * {1,2}
 * 返回值：
 * [[1],[2]]
 *
 * 示例2
 * 输入：
 * {1,2,3,4,#,#,5}
 * 返回值：
 * [[1],[2,3],[4,5]]
 */
public class NC15 {
    public static void main(String[] args) {
        TreeNode<Integer> tree = Creater.createTree();
        ArrayList<ArrayList<Integer>> order = levelOrder(tree);
        System.out.println(order);
        int i = lowestCommonAncestor(tree, 5, 6);
        System.out.println(i);
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode<Integer> root){
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                list.add(node.value);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public static int lowestCommonAncestor (TreeNode<Integer> root, int o1, int o2) {
        // write code here
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode<Integer> node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                if (node.left != null && node.right!=null){
                    if(node.left.value == o1 && node.right.value == o2){
                        return node.value;
                    }
                }
            }
        }
        return -1;
    }
}
