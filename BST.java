package Tree;

import java.util.LinkedList;

public class BST {
    private TreeNode root;

    public BST(){
        this.root = null;
    }

    public TreeNode insert(TreeNode root, int key){
        if(root == null){
            return new TreeNode(key);
        }
        if(key < root.key){
            root.leftChild = insert(root.leftChild, key);
        }else{
            root.rightChild = insert(root.rightChild, key);
        }
        return root;
    }

    public TreeNode delete(TreeNode root, int key){
        if(key < root.key){
            root.leftChild = delete(root.leftChild, key);
        }else if(key >root.key){
            root.rightChild = delete(root.rightChild, key);
        }else{
            if(root.leftChild == null && root.rightChild == null){
                return null;
            }
            if(root.leftChild == null){
                return root.rightChild;
            }else if(root.rightChild == null){
                return root.leftChild;
            }else{
                TreeNode IS = inorderSuccessor(root.rightChild);
                delete(root.rightChild, key);
                root.key = IS.key;
            }
        }
        return root;
    }

    public TreeNode inorderSuccessor(TreeNode rightChild){
        TreeNode current = rightChild;
        while(current.leftChild != null){
            current = current.leftChild;
        }
        return current;
    }

    public boolean search(TreeNode root, int key){
        boolean isFound = false;
        if(root == null){
            return false;
        }
        if(key == root.key){
            return true;
        }
        if(key < root.key){
            isFound = search(root.leftChild, key);
        }else{
            isFound = search(root.rightChild, key);
        }
        return isFound;
    }

    public void preOrder(TreeNode current){
        if(current == null){
            return;
        }
        System.out.print(current.key + " -> ");
        preOrder(current.leftChild);
        preOrder(current.rightChild);
    }

    public void inOrder(TreeNode current){
        if(current == null){
            return;
        }
        inOrder(current.leftChild);
        System.out.print(current.key + " -> ");
        inOrder(current.rightChild);
    }

    public void postOrder(TreeNode current){
        if(current == null){
            return;
        }
        postOrder(current.leftChild);
        postOrder(current.rightChild);
        System.out.print(current.key + " -> ");
    }

    public void levelOrder(TreeNode root){
        if(root == null){
            System.out.println("Tree is empty!!!");
            return;
        }
        LinkedList<TreeNode> customeQueue = new LinkedList<TreeNode>();
        customeQueue.add(root);
        while(!customeQueue.isEmpty()){
            TreeNode current = customeQueue.remove(0);
            System.out.println(current.key);
            if(current.leftChild != null){
                customeQueue.add(current.leftChild);
            }
            if(current.rightChild != null){
                customeQueue.add(current.rightChild);
            }
        }
    }
}
