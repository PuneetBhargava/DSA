import java.util.ArrayList;

import Nodes.TreeNode;

public class BinaryTree {

    private TreeNode root;

    public BinaryTree(){
        this.root = null;
    }

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.key+" - ");
        this.preOrder(root.leftChild);
        this.preOrder(root.rightChild);
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        this.inOrder(root.leftChild);
        System.out.print(root.key+" - ");
        this.inOrder(root.rightChild);
    }

    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        this.postOrder(root.leftChild);
        this.postOrder(root.rightChild);
        System.out.print(root.key+" - ");
    }

    public void levelOrder(TreeNode root){
        if(root == null){
            System.out.println("Tree is empty!!!");
            return;
        }
        ArrayList<TreeNode> customQueue = new ArrayList<TreeNode>();
        customQueue.add(root);
        while(!customQueue.isEmpty()){
            TreeNode current = customQueue.remove(0);
            System.out.print(current.key+" - ");
            if(current.leftChild != null){
                customQueue.add(current.leftChild);
            }
            if(current.rightChild != null){
                customQueue.add(current.rightChild);
            }
        }
    }

    public TreeNode insert(TreeNode root, int key){
        TreeNode node = new TreeNode(key);
        if(root == null){
            root = node;
            return root;
        }
        ArrayList<TreeNode> customQueue = new ArrayList<TreeNode>();
        customQueue.add(root);
        while(!customQueue.isEmpty()){
            TreeNode current = customQueue.remove(0);
            if(current.leftChild == null){
                current.leftChild = node;
                return root;
            }else{
                customQueue.add(current.leftChild);
            }
            if(current.rightChild == null){
                current.rightChild = node;
                return root;
            }else{
                customQueue.add(current.rightChild);
            }
        }
        return root;
    }

    public TreeNode getDeepestNode(TreeNode root){
        if(root == null){
            System.out.println("Tree is empty!!!");
            return root;
        }
        ArrayList<TreeNode> customQueue = new ArrayList<TreeNode>();
        customQueue.add(root);
        TreeNode current = null;
        while(!customQueue.isEmpty()){
            current = customQueue.remove(0);
            if(current.leftChild != null){
                customQueue.add(current.leftChild);
            }
            if(current.rightChild != null){
                customQueue.add(current.rightChild);
            }
        }
        return current;
    }

    public TreeNode deleteDeepestNode(TreeNode root, int key){
        if(root == null){
            System.out.println("Tree is empty!!!");
            return root;
        }
        ArrayList<TreeNode> customQueue = new ArrayList<TreeNode>();
        customQueue.add(root);
        while(!customQueue.isEmpty()){
            TreeNode current = customQueue.remove(0);
            if(current.key == key){
                current = null;
                return root;
            }
            if(current.leftChild != null){
                if(current.leftChild.key == key){
                    current.leftChild = null;
                    return root;
                }
                customQueue.add(current.leftChild);
            }
            if(current.rightChild != null){
                if(current.rightChild.key == key){
                    current.rightChild = null;
                    return root;
                }
                customQueue.add(current.rightChild);
            }
        }
        return root;
    }

    public TreeNode delete(TreeNode root, int key){
        if(root == null){
            System.out.println("Tree is empty!!!");
            return root;
        }
        ArrayList<TreeNode> customQueue = new ArrayList<TreeNode>();
        customQueue.add(root);
        while(!customQueue.isEmpty()){
            TreeNode current = customQueue.remove(0);
            if(current.key == key){
                TreeNode deepestNode = this.getDeepestNode(root);
                this.deleteDeepestNode(root, deepestNode.key);
                current.key = deepestNode.key;
                return root;
            }
            if(current.leftChild != null){
                customQueue.add(current.leftChild);
            }
            if(current.rightChild != null){
                customQueue.add(current.rightChild);
            }
        }
        return root;
    }

    public void search(TreeNode root, int key){
        if(root == null){
            System.out.println("Tree is empty!!!");
            return;
        }
        ArrayList<TreeNode> customQueue = new ArrayList<TreeNode>();
        customQueue.add(root);
        while(!customQueue.isEmpty()){
            TreeNode current = customQueue.remove(0);
            if(current.key == key){
                System.out.println("Key "+key+" Found in tree!!!");
                return;
            }
            if(current.leftChild != null){
                customQueue.add(current.leftChild);
            }
            if(current.rightChild != null){
                customQueue.add(current.rightChild);
            }
        }
        System.out.println("Key does not found in tree!!!");
    }

    public static void main(String[] args) {
        int[] keys = new int[]{
            15, 23, 56, 98, 14, 21, -45, -78
        };
        BinaryTree tree = new BinaryTree();
        for(int key: keys){
            tree.root = tree.insert(tree.root, key);
        }
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
        System.out.println();
        tree.levelOrder(tree.root);
        System.out.println();
        tree.root = tree.delete(tree.root, 14);
        tree.levelOrder(tree.root);
        System.out.println();
        tree.search(tree.root, 15);
        tree.search(tree.root, 98);
        tree.search(tree.root, -78);
        tree.search(tree.root, 115);
    }
}