//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。 
//
// 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(String s, int pos, ArrayList<String> track, List<String> res) {
        if (track.size() == 4) {
            if (pos == s.length()) {
                res.add(String.join(".", track));
            }
            return;
        }
        //ip 每段最多 3 位
        for (int i = 1; i <= 3; i++) {
            //pos 在字符串尾部，无需再分段
            if (pos + i > s.length()) {
                break;
            }
            String segment = s.substring(pos, pos + i);
            //剪枝：段的起始位置不能为 0；段值不能超过 255
            if (segment.startsWith("0") && segment.length() > 1 || (i == 3 && Integer.parseInt(segment) > 255)) {
                continue;
            }
            //符合要求的段值
            track.add(segment);
            //寻找下一段
            backtrack(s, pos + i, track, res);
            //回溯
            track.remove(track.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
