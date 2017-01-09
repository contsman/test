package binarytree;

import java.util.ArrayList;

public class Traverse {

    /**
     * 递归前序遍历
     *
     * @param root
     */
    public void recursiveProOrder(Node root) {
        // 遍历根节点
        if (root != null) {
            System.out.print(root.value);
        }
        // 遍历左子树
        if (root.left != null) {
            recursiveProOrder(root.left);
        }
        // 遍历右子树
        if (root.right != null) {
            recursiveProOrder(root.right);
        }
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public void proOrder(Node root) {
        // 使用ArrayList作为堆栈
        ArrayList<Node> stack = new ArrayList<Node>();
        // 栈指针
        int top = -1;
        Node current = root;
        while (true) {
            if (current != null) {
                System.out.print(current.value);
            }
            // 右子节点进栈
            if (current.right != null) {
                stack.add(current.right);
                top++;
            }
            // 左子节点进栈
            if (current.left != null) {
                stack.add(current.left);
                top++;
            }
            // 如果栈内还有节点，栈顶节点出栈
            if (top > -1) {
                current = stack.get(top);
                stack.remove(top--);
            } else {
                break;
            }
        }
    }

    /**
     * 递归中序遍历
     *
     * @param root
     */
    public void recursiveInOrder(Node root) {
        if (root != null) {
            if (root.left != null) {
                recursiveInOrder(root.left);
            }
            System.out.print(root.value);
            if (root.right != null) {
                recursiveInOrder(root.right);
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void inOrder(Node root) {
        if (root != null) {
            ArrayList<Node> stack = new ArrayList<Node>();
            int top = -1;
            Node current = root;
            while (current != null || top > -1) {
                if (current != null) {
                    // 一直深入地寻找左子节点，并将路上的节点都进栈
                    stack.add(current);
                    top++;
                    current = current.left;
                } else {
                    // 取出栈顶节点，并继续遍历右子树
                    current = stack.get(top);
                    stack.remove(top--);
                    System.out.print(current.value);
                    current = current.right;
                }
            }
        }
    }

    /**
     * 递归后续遍历
     *
     * @param root
     */
    public void recursivePostOrder(Node root) {
        if (root != null) {
            if (root.left != null) {
                recursivePostOrder(root.left);
            }
            if (root.right != null) {
                recursivePostOrder(root.right);
            }
            System.out.print(root.value);
        }
    }

    /**
     * 后序遍历：可以被遍历的节点都要进栈出栈两次，所以添加第二个栈用来标示进栈次数
     *
     * @param root
     */
    public void postOrder(Node root) {
        if (root != null) {
            // 用来保存节点的栈
            ArrayList<Node> stack = new ArrayList<Node>();
            // 用来保存标志位的栈
            ArrayList<Integer> stack2 = new ArrayList<Integer>();
            // 两个栈共用的栈指针
            int top = -1;
            int tag;
            Node current = root;
            do {
                //将所有左子节点进栈
                while (current != null) {
                    stack.add(current);
                    stack2.add(0);
                    top++;
                    current = current.left;
                }
                //取出栈顶节点，并判断其标志位
                current = stack.get(top);
                tag = stack2.get(top);
                stack2.remove(top);
                if (tag == 0) {
                    // tag为0,表明该节点第一次进栈，还需要进栈一次，同时修改标志位
                    current = current.right;
                    stack2.add(1);
                } else {
                    // tag不位0,表明非首次进栈，可以遍历了。
                    stack.remove(top);
                    top--;
                    System.out.print(current.value);
                    current = null;
                }
            } while (current != null || top != -1);
        }
    }
}