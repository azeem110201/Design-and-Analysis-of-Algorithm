import java.util.Scanner;

class Node{
   int data;
   Node left, right;

   Node(int data){
      this.data = data;
      this.left = null;
      this.right = null;
   }
}

class BinarySearchTree{
   Node root;
   BinarySearchTree(){
      this.root = null;
   }

   void insert(int data){
      Node temp = new Node(data);
      if(this.root == null){
         this.root = temp;
         return;
      }

      Node curr = this.root;
      Node prev = null;

      while(curr != null){
         prev = curr;
         if(curr.data > data){
            curr = curr.left;
         }
         else{
            curr = curr.right;
         }
      }

      if(prev == null){
         prev = temp;
      }
      else if(data < prev.data){
         prev.left = temp;
      }
      else{
         prev.right = temp;
      }
   }
   void inorder(){
      inorderUtil(this.root);
   }

   void inorderUtil(Node root){
      if(root != null){
         inorderUtil(root.left);
         System.out.print(root.data + " ");
         inorderUtil(root.right);
      }
   }
   boolean search(int data){
      if(this.root == null){
         return false;
      }
      Node curr = this.root;
      Node prev = null;

      while(curr != null){
         prev = curr;
         if(curr.data == data){
            return true;
         }
         else if(curr.data > data){
            curr = curr.left;
         }
         else{
            curr = curr.right;
         }
      }
      return false;
   }
}


class BST{
   public static void main(String[] args){
      BinarySearchTree bst = new BinarySearchTree();
      Scanner scr = new Scanner(System.in);
      System.out.print("Enter Number of elements in BST:");
      int count = scr.nextInt();
      System.out.println();
      System.out.println("Enter elements in BST.....");

      int i = 1;

      while(i <= count){
         int data = scr.nextInt();
         bst.insert(data);
         i++;
      }

      System.out.println("Inorder traversal of the tree is....");
      bst.inorder();

      System.out.print("Enter element to find in BST:");
      int element = scr.nextInt();
      boolean flag = bst.search(element);

      if(flag){
         System.out.println("Element found");
      }
      else{
         System.out.println("Element Not found");
      }
   }
}