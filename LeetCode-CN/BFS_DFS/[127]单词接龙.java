//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        //遍历字典集所有字符可能是由哪些字符生成的
        HashMap<String, List<String>> allCombWord = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                List<String> combWord = allCombWord.getOrDefault(newWord, new ArrayList<String>());
                combWord.add(word);
                allCombWord.put(newWord, combWord);
            }
        }
        //BFS
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<String, Integer>(beginWord, 1));
        //访问记录，避免处理同样的字符
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
                for (String str : allCombWord.getOrDefault(newWord, new ArrayList<>())) {
                    if (str.equals(endWord)) {
                        return ++level;
                    }
                    if (!visited.containsKey(str)) {
                        visited.put(str, true);
                        queue.add(new Pair<>(str, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
