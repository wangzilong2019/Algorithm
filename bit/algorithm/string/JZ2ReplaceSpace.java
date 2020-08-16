package bit.algorithm.string;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.Stack;

public class JZ2ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        //首先统计空格字符的个数
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int new_length = str.length() + count*2;
        int old_end = str.length() - 1;
        int new_end = new_length - 1;
        //设置新字符串大小防止越界
        str.setLength(new_length);
        while (old_end >= 0 && new_end >= 0) {
            if (str.charAt(old_end) == ' ') {
                str.setCharAt(new_end--, '0');
                str.setCharAt(new_end--, '2');
                str.setCharAt(new_end--, '%');
                old_end--;
            } else {
                str.setCharAt(new_end--, str.charAt(old_end));
                old_end--;
            }
        }
        return str.toString();
    }


}
