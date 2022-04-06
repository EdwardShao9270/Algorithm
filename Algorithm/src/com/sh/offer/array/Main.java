package com.sh.offer.array;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: bjshaohang
 * @Date: 2021/1/17
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1 = scan.nextLine();
        System.out.println(strAmountChn(input1));
    }

    private static String strAmountChn(String amount) {
        if (amount == null || !isNumeric(amount)) {
            return "输入数据非数字，只能包含以下内容(0～9，'.')，且小数点后面只能有点两位，请检查~";
        }

        String amountTrim = amount.trim();

        String bigNums = "零壹贰叁肆伍陆柒捌玖";
        String units = "分角整元拾佰仟万拾佰仟亿拾佰仟";
        String result = "";

        int index;
        String num, unit;

        int length = !amountTrim.contains(".") ? amountTrim.length() : amountTrim.indexOf(".");

        if (length > units.length() - 3) {
            return ("输入的内容最大只能精确到仟亿，请检查~");
        }

        for (int i = 0; i < amountTrim.length(); i++) {
            if (i > length +2) {
                break;
            }
            if (i == length) {
                continue;
            }
            index = Integer.parseInt(String.valueOf(amountTrim.charAt(i)));
            num = bigNums.substring(index, index+1);
            index = length - i + 2;
            unit = units.substring(index, index+1);
            result = result + num + unit;

        }
        if ((length == amountTrim.length()) || (length == amountTrim.length() - 1)) {
            result = result.concat("整");
        }
        if (length == amountTrim.length() - 2) {
            result = result.concat("零分");
        }
        result = result.replace("零分", "");
        result = result.replace("零角", "零");
        int m = result.length();
        int n = 0;
        while (m != n) {

            m = result.length();
            if (!result.startsWith("零元")) {
                result = result.replace("零元", "元");
            }
            if (!result.startsWith("零万")) {
                result = result.replace("零万", "万");
            }
            if (!result.startsWith("零亿")) {
                result = result.replace("零亿", "亿");
            }
            if (!result.startsWith("零仟")) {
                result = result.replace("零仟", "零");
            }
            if (!result.startsWith("零佰")) {
                result = result.replace("零佰", "零");
            }
            if (!result.startsWith("零零")) {
                result = result.replace("零零", "零");
            }
            if (!result.startsWith("零拾")) {
                result = result.replace("零拾", "零");
            }
            if (!result.startsWith("亿万")) {
                result = result.replace("亿万", "亿零");
            }
            if (!result.startsWith("万仟")) {
                result = result.replace("万仟", "万零");
            }
            if (!result.startsWith("仟佰")) {
                result = result.replace("仟佰", "仟零");
            }
            n = result.length();
        }

        int tempLength = result.length();
        if (result.charAt(tempLength - 1) == '零') {
            result = result.substring(0, tempLength - 1);
        }
        tempLength = result.length();
        if (result.charAt(tempLength - 1) == '元') {
            result = result + '整';
        }
        return result;
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*\\.?[0-9][0-9]");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

}
