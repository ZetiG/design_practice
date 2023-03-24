package com.example.demo.leetcode.iii;


import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1032. 字符流 
 *  设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 words 中的一个字符串。
 *  例如，words = ["abc", "xyz"] 且字符流中逐个依次加入 4 个字符 'a'、'x'、'y' 和 'z' ，
 *  你所设计的算法应当可以检测到"axyz" 的后缀 "xyz" 与words 中的字符串 "xyz"匹配。
 *
 *  按下述要求实现 StreamChecker 类：
 *
 *  StreamChecker(String[] words) ：构造函数，用字符串数组words 初始化数据结构。
 *  boolean query(char letter)：从字符流中接收一个新字符，如果字符流中的任一非空后缀能匹配 words 中的某一字符串，返回 true ；否则，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/stream-of-characters
 *
 * @author Zeti
 * @date 2023/3/24 14:08
 */
public class StreamChecker {
    private Trie trie;
    private StringBuffer stringBuffer;


    // 简单描述下题目：
    // 1.初始化数据结构，将StreamChecker数组初始化进去；
    // 2.依次追加query字符流生成新的字符串, 并判断新生成的字符串的后缀是否存在自定义数据结构内，存在返回true，否则false；
    public static void main(String[] args) {
        // ["StreamChecker","query","query","query","query","query","query","query","query","query","query","query","query"]
        // [["a"],["b"],["c"],["d"],["e"],["f"],["g"],["h"],["i"],["j"],["k"],["l"]]

        String[] words = {"cd","f","kl"};
        StreamChecker streamChecker = new StreamChecker(words);

        char[] query = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l'};

        List<Boolean> res = new ArrayList<>();
        for (char c : query) {
            boolean result = streamChecker.query(c);
            res.add(result);
            System.err.println(result);
        }
        //          a     b      c      d     e      f     g      f       i      j     k      l
        // [null, false, false, false, true, false, true, false, false, false, false, false, true]
        //        false  false  false  true  false  true  false  false  false  false  false  true

    }



    public StreamChecker(String[] words) {
        this.trie = new Trie();
        this.stringBuffer = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            String s = new StringBuffer(words[i]).reverse().toString();
            trie.insert(s);
        }
    }

    public boolean query(char letter) {
        stringBuffer.append(letter);
        // 新建StringBuffer进行反转字符串
        String string = new StringBuffer(stringBuffer).reverse().toString();
        return trie.isContainsSuffix(string);
    }


    /**
     * 内建字典树
     */
     class Trie {
        private int SIZE = 26;  // 字典树只会存储每个字符，a-z/A-Z
        private TrieNode root;  //  字典树的根，不存储任何东西
        
        Trie() {
            root = new TrieNode();  // 初始化字典树
        }

        /**
         * 插入字符串
         */
        public void insert(String str) {
            if (str == null || str.length() <= 0) {
                return;
            }

            TrieNode node = root;
            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';

                // 节点还未有该下标的子节点, 则插入
                if (node.son[idx] == null) {
                    node.son[idx] = new TrieNode(str.charAt(i));
                    node.haveSon = true;

                } else {
                    // 该节点已存在，计数+1
                    node.son[idx].num++;
                }

                // 继续循环插入下个字符，且将刚才的节点作为父节点
                node = node.son[idx];
            }
            node.isEnd = true;
        }

        /**
         * 传入字符串的后缀是否存在
         */
        public boolean isContainsSuffix(String str) {
            if (str == null || str.length() == 0) {
                return false;
            }

            TrieNode node = root;
            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                if (node.son[idx] != null) {
                    node = node.son[idx];
                    if (node.isEnd) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            return false;
        }

        
        TrieNode getRootNode() {
            return this.root;
        }
        
         public class TrieNode {
             private int num;   // 有多少单词通过这个节点,即由根至该节点组成的字符串模式出现的次数
             private char value;  // 当前节点值
             private boolean isEnd; // 是否最后一个节点
             private boolean haveSon; // 是否包含儿子
             private TrieNode[] son;    // 所有的儿子节点

             TrieNode() {
                 num = 1;
                 son = new TrieNode[SIZE];
                 isEnd = false;
                 haveSon = false;
             }

             public TrieNode(char value) {
                 this.num = 1;
                 this.value = value;
                 this.isEnd = false;
                 this.haveSon = false;
                 this.son = new TrieNode[SIZE];
             }
         }
    }
}
