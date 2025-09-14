package Binary_Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import Binary_Tree.BinaryTree.BinaryTreeBt;
import Binary_Tree.BinaryTree.Node;

public class Top_view_of_Tree {

    static class Info2{
        Node node;
        int hd;
        public Info2(Node node,int hd){
            this.node=node;
            this.hd=hd;

        }
    }
    
    public static void topView(Node root){

        Queue<Info2> q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();
        int min=-1;
        int max=0;


        q.add(new Info2(root,0));
        q.add(null);

        while(!q.isEmpty()){
            Info2 curr=q.remove();
            if(curr==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd,curr.node);
                }
                if(curr.node.left!=null){
                    q.add(new Info2(curr.node.left,curr.hd-1));
                    min=Math.min(min,curr.hd-1);
                }
                if(curr.node.right!=null){
                    q.add(new Info2(curr.node.right,curr.hd+1));
                    max=Math.max(min,curr.hd+1);
                }
            }
        }
        for(int i=min;i<=max;i++){
            System.out.println(map.get(i).data);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};

        Node root=BinaryTreeBt.buildTree(nodes);
        topView(root);
    }
}
