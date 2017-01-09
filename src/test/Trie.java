package test;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class Trie {
    private int SIZE = 26;
    private TrieNode root;/*字典树的根*/

    Trie() {/*初始化字典树 */
        root = new TrieNode();
    }

    private class TrieNode {/*字典树节点*/
        private int num;/*有多少单词通过这个节点,即节点字符出现的次数*/
        private TrieNode[] son;/*所有的儿子节点*/
        private boolean isEnd;/*是不是最后一个节点*/
        private char val;/*节点的值*/

        TrieNode() {
            num = 1;
            son = new TrieNode[SIZE];
            isEnd = false;
        }
    } /*建立字典树*/

    public void insert(String str) {/*在字典树中插入一个单词*/
        if (str == null || str.length() == 0) return;
        TrieNode node = root;
        char[] letters = str.toCharArray();
        for (int i = 0, len = str.length(); i < len; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null) {
                node.son[pos] = new TrieNode();
                node.son[pos].val = letters[i];
            } else node.son[pos].num++;
            node = node.son[pos];
        }
        node.isEnd = true;
    } /*计算单词前缀的数量*/

    public int countPrefix(String prefix) {
        if (prefix == null || prefix.length() == 0) return -1;
        TrieNode node = root;
        char[] letters = prefix.toCharArray();
        for (int i = 0, len = prefix.length(); i < len; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null) return 0;
            else node = node.son[pos];
        }
        return node.num;
    } /*打印指定前缀的单词*/

    public String hasPrefix(String prefix) {
        if (prefix == null || prefix.length() == 0) return null;
        TrieNode node = root;
        char[] letters = prefix.toCharArray();
        for (int i = 0, len = prefix.length(); i < len; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null)
                return null;
            else {
                node = node.son[pos];
            }
        }
        preTraverse(node, prefix);
        return null;
    }

    // 遍历经过此节点的单词.
    public void preTraverse(TrieNode node, String prefix) {
        if (!node.isEnd) {
            for (TrieNode child : node.son) {
                if (child != null) {
                    preTraverse(child, prefix + child.val);
                }
            }
            return;
        }
        System.out.println(prefix);
    }


    //在字典树中查找一个完全匹配的单词.
    public boolean has(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        TrieNode node = root;
        char[] letters = str.toCharArray();
        for (int i = 0, len = str.length(); i < len; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] != null) {
                node = node.son[pos];
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    //前序遍历字典树.
    public void preTraverse(TrieNode node) {
        if (node != null) {
            System.out.print(node.val + "-");
            for (TrieNode child:node.son) {
                preTraverse(child);
            }
        }
    }

    public TrieNode getRoot() {
        return this.root;
    }

    public static void main(String[] args) {
        Trie tree = new Trie();
        String[] strs = {"banana", "band", "bee", "absolute", "acm",};
        String[] prefix = {"ba", "b", "band", "abc",};
        for (String str:
             strs) {
            tree.insert(str);
        }
        System.out.println(tree.has("abc"));
        tree.preTraverse(tree.getRoot());
        System.out.println();

        for (String pre:prefix) {
            int num = tree.countPrefix(pre);
            System.out.println(pre + "" + num);
        }
        int a = 'x';
        char aa = '中';
        byte ee = 'e';
        System.out.println("a========="+a);
        System.out.println("aa========="+aa);
        System.out.println("ee=========" + ee);

        String str = "中";
        byte[]  astr = new byte[0];
        try {
            astr = str.getBytes("gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(astr.length); //打印出多长？

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        linkedList.get(1);
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);
        linkedList.addFirst(1);
        linkedList.addLast(5);
        System.out.println(linkedList);
        linkedList.add(3, 0);
        System.out.println(linkedList);

        Stack<Integer> stack = new Stack<Integer>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        System.out.println(stack);
        Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue.element());
        System.out.println(queue.offer(5));
        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue);
        Thread.currentThread();
    }
}