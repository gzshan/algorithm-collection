package com.iotek.algorithm.offer.tree;

import com.iotek.algorithm.offer.common.TreeNode;

/**
 * 剑指offer：04、根据前+中重建二叉树
 *
 * @author gzshan
 * @time 2020/8/17 14:39
 */
public class Offer04 {

    /**
     * 根据前序和中序序列重建二叉树
     *
     * @param pre 前序序列
     * @param in  中序序列
     * @return 重建好的二叉树
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if(pre==null || pre.length==0 || in==null || in.length==0)
            return null;

        return reConstructBinaryTree(pre,in,0,pre.length-1,0,in.length-1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in, int pre_begin, int pre_end, int in_begin, int in_end) {
        if(pre_begin>pre_end || in_begin>in_end)
            return null;

        //前序序列的第一个为根
        TreeNode root = new TreeNode(pre[pre_begin]);
        if(pre_begin == pre_end)
            return root;

        //在中序序列中找到根
        int rootPos = in_begin;
        while(rootPos<=in_end && in[rootPos]!=root.val) {
            rootPos++;
        }

        int leftCount = rootPos-in_begin;  //左子树的结点个数

        root.left = reConstructBinaryTree(pre,in,pre_begin+1,pre_begin+leftCount,in_begin,rootPos-1);
        root.right = reConstructBinaryTree(pre,in,pre_begin+leftCount+1,pre_end,rootPos+1,in_end);

        return root;
    }

    public static void main(String[] args){
        Offer04 offer04 = new Offer04();
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};

        TreeNode root = offer04.reConstructBinaryTree(pre,in);
        //System.out.println(root.toString());
    }
}
