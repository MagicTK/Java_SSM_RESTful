package com.hym.ssm.Utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sun.xml.internal.ws.util.VersionUtil.compare;


/**
 * 字符串工具类
 * @author ZhangTK
 * @version 1.0.0
 * @Time 2018//01/18
 */

public class StringUtil {

    /**
     * 判断是否是空字符串 null和"" 都返回 true
     * @param string 判断的字符串
     * @return 是否有效(boolean)
     */
    public static boolean isEmpty(String string) {
        return string == null || string.equals("");
    }


    /**
     * 把string array or list用给定的符号symbol连接成一个字符串
     * @param list   需要处理的列表
     * @param symbol 链接的符号
     * @return 处理后的字符串(String)
     */
    public static String joinString(List list, String symbol) {
        String result = "";
        if (list != null) {
            for (Object o : list) {
                String temp = o.toString();
                if (temp.trim().length() > 0)
                    result += (temp + symbol);
            }
            if (result.length() > 1) {
                result = result.substring(0, result.length() - 1);
            }
        }
        return result;
    }


    /**
     * 判定第一个字符串是否等于的第二个字符串中的某一个值
     * @param string1 测试的字符串
     * @param string2 字符串数组(用,分割)
     * @return 是否包含(boolean)
     */
    public static boolean requals(String string1, String string2) {
        if (string1 != null && string2 != null) {
            string2 = string2.replaceAll("\\s*", "");
            String[] arr = string2.split(",");
            for (String t : arr) {
                if (t.equals(string1.trim())) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 判定第一个字符串是否等于的第二个字符串中的某一个值
     * @param string1  测试的字符串
     * @param string2  字符串数组
     * @param split string2字符串的分隔符
     * @return 是否包含(boolean)
     */
    public static boolean requals(String string1, String string2, String split) {
        if (string1 != null && string2 != null) {
            string2 = string2.replaceAll("\\s*", "");
            String[] arr = string2.split(split);
            for (String s : arr) {
                if (s.equals(string1.trim())) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 字符串省略截取：字符串截取到指定长度size+...的形式
     * @param subject 需要处理的字符串
     * @param size    截取的长度（int）
     * @return 处理后的字符串（String）
     */
    public  static String subStringOmit(String subject, int size) {
        if (subject != null && subject.length() > size) {
            subject = subject.substring(0, size) + "...";
        }
        return subject;
    }


    /**
     * 截取字符串　超出的字符用symbol代替
     *
     * @param string 需要处理的字符串
     * @param length 字符串长度
     * @param symbol 最后拼接的字符串
     * @return 测试后的字符串（String）
     */
    public  static String subStringSymbol(String string, int length, String symbol) {
        String temp = "";
        if (string != null && string.length() > length) {
            temp = string.substring(0, length) + symbol;
        }
        return temp;
    }


    /**
     * 把string array or list用给定的符号symbol连接成一个字符串
     *
     * @param array  需要处理的字符串数组
     * @param symbol 链接的符号
     * @return 处理后的字符串（String）
     */
    public  static String joinString(String[] array, String symbol) {
        String result = "";
        if (array != null) {
            for (String temp : array) {
                if (temp != null && temp.trim().length() > 0)
                    result += (temp + symbol);
            }
            if (result.length() > 1 && CheckUtil.valid(symbol)) {
                result = result.substring(0, result.length() - symbol.length());
            }
        }
        return result;
    }


    /**
     * 将一组字符才以指定的字符链接起来
     * @param linkString 链接字符
     * @param strings    需要连接的动态参数
     * @return 连接后的字符串（String）
     */
    public  static String join(String linkString,String ... strings){
        StringBuffer result = new StringBuffer();
        for (String temp : strings) {
            if (temp != null && temp.trim().length() > 0)
                result.append(temp + linkString);
        }
        if (result.length() > 1 && CheckUtil.valid(linkString)) {
            return result.substring(0, result.length() - linkString.length());
        }
        return result.toString();
    }


    /**
     * 隐藏邮件地址前缀
     * @param email EMail邮箱地址 例如: tkneu@gmail.com
     * @return 返回已隐藏前缀邮件地址, 如 *******@gmail.com
     */
    public  static String getHideEmailPrefix(String email) {
        if (null != email) {
            int index = email.lastIndexOf('@');
            if (index > 0) {
                email = repeat("*", index).concat(email.substring(index));
            }
        }
        return email;
    }


    /**
     * repeat - 通过源字符串重复生成N次组成新的字符串。
     *
     * @param src 源字符串 例如: 空格(" "), 星号("*"), "浙江" 等等...
     * @param num 重复生成次数
     * @return 返回已生成的重复字符串（String）
     */
    public  static String repeat(String src, int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num; i++)
            stringBuilder.append(src);
        return stringBuilder.toString();
    }


    /**
     * 截取字符串左侧的Num位截取到末尾
     * @param string 处理的字符串
     * @param num    开始位置
     * @return 截取后的字符串（String）
     */
    public  static String lefTrim(String string, int num) {
        String str = "";
        if (!isEmpty(string) && string.length() >= num) {
            str = string.substring(num, string.length());
        }
        return str;

    }


    /**
     * 截取字符串右侧第0位到第Num位
     * @param string 处理的字符串
     * @param num    截取的位置
     * @return 截取后的字符串（String）
     */
    public  static String rightTrim(String string, int num) {
        if (!isEmpty(string) && string.length() > num) {
            string = string.substring(0, string.length() - num);
        }
        return string;
    }


    /**
     * 根据指定的字符把源字符串分割成一个list
     * @param src     处理的字符串
     * @param pattern 分割字符串
     * @return 处理后的list（List<String>）
     */
    public  static List<String> parseString2List(String src, String pattern) {
        List<String> list = new ArrayList<>();
        if (src != null) {
            String[] tt = src.split(pattern);
            list.addAll(Arrays.asList(tt));
        }
        return list;
    }


    /**
     * 格式化一个float
     * @param format 要格式化成的格式 such as #.00, #.#
     * @return 格式化后的字符串（String）
     */
    public  static String formatDouble(double f, String format) {
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(f);
    }


    /**
     * 截取字符串左侧指定长度的字符串
     * @param input 输入字符串
     * @param count 截取长度
     * @return 截取字符串（String）
     */
    public  static String left(String input, int count) {
        if (isEmpty(input)) {
            return "";
        }
        count = (count > input.length()) ? input.length() : count;
        return input.substring(0, count);
    }


    /**
     * 截取字符串右侧指定长度的字符串（其他编码的有待测试）
     * @param input 输入字符串
     * @param count 截取长度
     * @return 截取字符串（String）
     */
    public  static String right(String input, int count) {
        if (isEmpty(input)) {
            return "";
        }
        count = (count > input.length()) ? input.length() : count;
        return input.substring(input.length() - count, input.length());
    }


    /**
     * 页面中去除字符串中的空格、回车、换行符、制表符
     * @param string 需要处理的字符串
     * @return 处理后的字符串（String）
     */
    public  static String replaceBlank(String string) {
        if (string != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(string);
            string = m.replaceAll("");
        }
        return string;
    }


    /**
     * 判断字符串数组中是否包含某字符串元素
     * @param substring 某字符串
     * @param source    源字符串数组
     * @return 包含则返回true，否则返回false（boolean）
     */
    public  static boolean isIn(String substring, String[] source) {
        if(isEmpty(substring) || !CheckUtil.valid(source)){
            return false;
        }
        for (String t:source) {
            if (substring.equals(t)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 字符串转换unicode.实现native2ascii.exe类似的功能
     * @param string 需要处理的字符串
     * @return 处理后的字符串（String）
     */
    public  static String string2Unicode(String string) {
        StringBuilder uni = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            String temp ="\\u"+String.valueOf(Integer.toHexString(string.charAt(i)));
            uni.append(temp);
        }
        return uni.toString();
    }

    /**
     * 转字符串 实现native2ascii.exe类似的功能
     * @param unicode 需要处理的字符串
     * @return 处理后的字符串（String）
     */
    public  static String unicode2String(String unicode) {
        StringBuilder str = new StringBuilder();
        String[]     hex    = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            int data = Integer.parseInt(hex[i], 16);
            str.append((char) data);
        }
        return str.toString();
    }


    /**
     * 删除所有的标点符号
     * @param string 处理的字符串
     * @return 处理后的字符串（String）
     */
    public  static String trimPunct(String string) {
        if(isEmpty(string)){
            return "";
        }
        return string.replaceAll("[\\pP\\p{Punct}]", "");
    }


    /**
     * 获取字符串的相似度
     * @param string
     * @param target
     * @return
     */
    public static double SimilarityRatioSimple(String string, String target) {
        return 1 - (double) compare(string, target) / Math.max(string.length(), target.length());
    }

    /**
     * 字符串相似度比较(速度较快)
     */
    public  static double SimilarityRatio(String string1, String string2) {
        string1 = StringUtil.trimPunct(string1);
        string2 = StringUtil.trimPunct(string2);
        if (string1.length() > string2.length()) {
            return SimilarityRatioSimple(string1, string2);
        } else {
            return SimilarityRatioSimple(string2, string1);
        }

    }


    /**
     * 获取字符串str在String中出现的次数
     * @param string 处理的字符串
     * @param str    子字符串
     */
    public  static int countSubStr(String string, String str) {
        if ((str == null) || (str.length() == 0) || (string == null) || (string.length() == 0)) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while ((index = string.indexOf(str, index)) != -1) {
            count++;
            index += str.length();
        }
        return count;
    }


    /**
     * 替换一个出现的子字符串
     * @param s    source string
     * @param sub  substring to replace
     * @param with substring to replace with
     */
    public  static String replaceFirst(String s, String sub, String with) {
        int i = s.indexOf(sub);
        if (i == -1) {
            return s;
        }
        return s.substring(0, i) + with + s.substring(i + sub.length());
    }


    /**
     * 替换最后一次出现的字串
     * @param s    source string
     * @param sub  substring to replace
     * @param with substring to replace with
     */
    public  static String replaceLast(String s, String sub, String with) {
        int i = s.lastIndexOf(sub);
        if (i == -1) {
            return s;
        }
        return s.substring(0, i) + with + s.substring(i + sub.length());
    }


    /**
     * 删除所有的子串
     * @param s   source string
     * @param sub substring to remove
     */
    public  static String remove(String s, String sub) {
        int c      = 0;
        int sublen = sub.length();
        if (sublen == 0) {
            return s;
        }
        int i = s.indexOf(sub, c);
        if (i == -1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        do {
            sb.append(s.substring(c, i));
            c = i + sublen;
        } while ((i = s.indexOf(sub, c)) != -1);
        if (c < s.length()) {
            sb.append(s.substring(c, s.length()));
        }
        return sb.toString();
    }


    /**
     * 将字符串首字母转大写
     * @param string 需要处理的字符串
     */
    public  static String upperFirstChar(String string){
        if(isEmpty(string)){
            return "";
        }
        char[] cs=string.toCharArray();
        if((cs[0] >= 'a') && (cs[0] <= 'z')){
            cs[0] -= (char) 0x20;
        }
        return String.valueOf(cs);
    }


    /**
     * 将字符串首字母转小写
     * @param string
     * @return
     */
    public  static String lowerFirstChar(String string){
        if(isEmpty(string)){
            return "";
        }
        char[] cs=string.toCharArray();
        if((cs[0] >= 'A') && (cs[0] <= 'Z')){
            cs[0] += (char) 0x20;
        }
        return String.valueOf(cs);
    }


    /**
     * 判读俩个字符串右侧的length个字符串是否一样
     * @param str1
     * @param str2
     * @param length
     * @return
     */
    public  static boolean rigthEquals(String str1,String str2,int length){
        return right(str1,length).equals(right(str2,length));
    }


    /**
     * 判读俩个字符串左侧的length个字符串是否一样
     * @param str1
     * @param str2
     * @param length
     * @return
     */
    public  static boolean leftEquals(String str1,String str2,int length){
        return left(str1,length).equals(left(str2,length));
    }

}
