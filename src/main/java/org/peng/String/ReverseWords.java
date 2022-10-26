package org.peng.String;

/*给定一个字符串，逐个翻转字符串中的每个单词。

        示例 1：
        输入: "the sky is blue"
        输出: "blue is sky the"

        示例 2：
        输入: "  hello world!  "
        输出: "world! hello"
        解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

        示例 3：
        输入: "a good   example"
        输出: "example good a"
        解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。*/

public class ReverseWords {
    public String reverseWords(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        char[] org = s.toCharArray();
        char[] result = new char[org.length + 1];

        int left = org.length;
        int right = org.length;
        int pos = 0;
        int i = org.length - 1;
        while (i >= 0) {
            //跳过空格
            while (i >= 0 && org[i] == ' ') {
                i--;
            }
            //记录右侧边界
            right = i;
            //跳过空格
            while (i >= 0 && org[i] != ' ') {
                i--;
            }
            //记录左边界
            left = i;
            if (left < right) {
                for (int j = left + 1; j <= right; j++) {
                    result[pos] = org[j];
                    pos++;
                }
                //最后会多一个空格，所以构造返回的时候去掉最后一个空格
                result[pos++] = ' ';
            }
        }
        return new String(result, 0, pos - 1);
    }
}
