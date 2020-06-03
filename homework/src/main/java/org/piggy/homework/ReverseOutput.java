package org.piggy.homework;

import java.util.Scanner;

/**
 * 倒序输出
 *
 * @author chenhongfa
 * @date 2020/5/26
 */
public class ReverseOutput {

    /**
     * 请参考以下代码，完成以下需求：
     * 输入4个单词，倒序输出
     * 输入：I have a cat
     * 输出：cat a have I
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你的名字：");
        String name = scanner.next();
        System.out.println("重要的事情说三遍：");
        for (int i = 0; i < 3; i++) {
            System.out.println(name + "最可爱！！！");
        }
    }
}
