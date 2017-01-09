package binarytree;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class Algorithm {

     public static void main(String[] args) {

          Node root = Node.createTree();
//          System.out.print("前序遍历： ");
//          new Traverse().proOrder(root);
          System.out.println();
          System.out.print("前序递归遍历： ");
          new Traverse().recursiveProOrder(root);
          System.out.println();
//          System.out.print("中序遍历： ");
//          new Traverse().inOrder(root);
          System.out.println();
          System.out.print("中序递归遍历： ");
          new Traverse().recursiveInOrder(root);
          System.out.println();
//          System.out.print("后序遍历： ");
//          new Traverse().postOrder(root);
          System.out.println();
          System.out.print("后序递归遍历： ");
          new Traverse().recursivePostOrder(root);
     }
}