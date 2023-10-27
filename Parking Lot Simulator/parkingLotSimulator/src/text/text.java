package text;

import java.util.ArrayList;

public class text {
    public static void main(String[] args) {
        // 定义要存储的字符串数量
        int n = 3;

        // 创建二维数组arry
        String[][] arry = new String[n][];

        // 存储多个字符串
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "!";
        arry[0] = new String[]{str1, str2, str3};
        arry[1] = new String[]{"Java", "Programming"};
        arry[2] = new String[]{"Example", "Code"};

        // 输出数组
        System.out.println("二维数组：");
        for (int i = 0; i < arry.length; i++) {
            for (int j = 0; j < arry[i].length; j++) {
                System.out.print(arry[i][j] + " ");
            }
            System.out.println();
        }
    }
}
