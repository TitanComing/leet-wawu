package org.peng.String;

/*请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
        示例 1： 输入：s = "We are happy."
        输出："We%20are%20happy."*/

public class ReplaceSpace {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        //扩充空间，增加空格2倍的空间
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') { //单引号表示字符
                stringBuilder.append("  "); //双引号表示字符串
            }
        }
        //没有空格
        if (stringBuilder.length() == 0) {
            return s;
        }
        //左指针，原始字符串最后一个位置
        int left = s.length() - 1;
        //右指针，指向扩展后的字符串的最后一个位置
        s += stringBuilder.toString();
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left >= 0) {
            if (chars[left] == ' ') {
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            } else {
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }
}
