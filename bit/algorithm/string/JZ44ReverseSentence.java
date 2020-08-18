package bit.algorithm.string;

public class JZ44ReverseSentence {
    /**
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
     * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
     * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
     * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     */
    /**
     *方法一：采用原生态方法
     * 先局部逆置，再整体逆置
     * 先将将每个单词反转，然后再整体反转
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] list = str.toCharArray();
        int len = list.length;
        int i = 0;
        int j = i;
        while (i < len) {
            while (i < len && !Character.isSpace(list[i])) {
                i++;
            }
            //逆置单词
            Reverse(list, j, i - 1);
            //找到下一个单词的其实位置
            while (i < len && Character.isSpace(list[i])) {
                i++;
            }
            j = i;
        }
        //逆置最后一个单词
        Reverse(list, j, i -1);
        //逆置整个字符串
        Reverse(list, 0, len - 1);
        return new String(list);
    }

    public void Reverse(char[] list, int left, int right) {
        while (left < right) {
            char temp = list[left];
            list[left] = list[right];
            list[right] = temp;
            left++;
            right--;
        }
    }
}
