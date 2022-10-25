package org.peng.HashTable;

/*给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。

        示例 1：

        输入：words = ["bella","label","roller"] 输出：["e","l","l"]
        示例 2：

        输入：words = ["cool","lock","cook"] 输出：["c","o"]

        提示：  1 <= words.length <= 100 1 <= words[i].length <= 100 words[i] 由小写英文字母组成*/

import java.util.ArrayList;
import java.util.List;

public class CommonChars {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }
        int[] count = new int[26];
        int[] temp = new int[26];
        //第一个用来初始化计数器，之后的用来比较最小值
        for (int i = 0; i < words[0].length(); i++) {
            count[words[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                temp[words[i].charAt(j) - 'a']++;
            }
            for (int k = 0; k < count.length; k++) {
                count[k] = Math.min(count[k], temp[k]);
                temp[k] = 0;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    result.add(String.valueOf((char) (i + 'a')));
                }
            }
        }
        return result;
    }
}
