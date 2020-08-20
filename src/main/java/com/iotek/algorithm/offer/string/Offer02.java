package com.iotek.algorithm.offer.string;

/**
 * 剑指offer：02、替换空格
 *
 * @author gzshan
 * @time 2020/8/17 11:53
 */
public class Offer02 {

    /**
     * 替换空格
     * @param str 字符串
     * @return 空格用0替换后的字符串
     */
    public String replaceSpace(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        StringBuffer stringBuffer = new StringBuffer(str);
        //统计空格数量
        int numOfblank = 0;
        for (int i = 0; i < stringBuffer.length();i++) {
            if (stringBuffer.charAt(i) == ' ') {
                numOfblank++;
            }
        }

        int len = stringBuffer.length();
        int newLen = len + 2 * numOfblank;
        stringBuffer.setLength(newLen);

        int i = len-1,j = newLen-1;
        while (i>=0 && j>i) {
            char c = stringBuffer.charAt(i);
            if(c==' '){
                stringBuffer.setCharAt(j--,'0');
                stringBuffer.setCharAt(j--,'2');
                stringBuffer.setCharAt(j--,'%');
            }else{
                stringBuffer.setCharAt(j--,c);
            }
            i--;
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args){
        Offer02 offer02 = new Offer02();
        String str = "123 45 6 ";
        System.out.println(offer02.replaceSpace(str));
    }
}
