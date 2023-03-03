package com.example.demo.leetcode.ii;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1487. 保证文件名唯一
 *  给你一个长度为 n 的字符串数组 names 。你将会在文件系统中创建 n 个文件夹：在第 i 分钟，新建名为 names[i] 的文件夹。
 *  由于两个文件 不能 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，
 *  系统会以 (k) 的形式为新文件夹的文件名添加后缀，其中 k 是能保证文件名唯一的 最小正整数 。
 *
 *  返回长度为 n 的字符串数组，其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/making-file-names-unique
 *
 * @author Zeti
 * @date 2023/3/3 16:55
 */
public class FolderNamesOnly {

    public static void main(String[] args) {
        //  输入：names = ["pes","fifa","gta","pes(2019)"]
        //  输出：["pes","fifa","gta","pes(2019)"]
        //  解释：文件系统将会这样创建文件名：
        //"pes" --> 之前未分配，仍为 "pes"
        //"fifa" --> 之前未分配，仍为 "fifa"
        //"gta" --> 之前未分配，仍为 "gta"
        //"pes(2019)" --> 之前未分配，仍为 "pes(2019)"
        String[] n1 = {"pes","fifa","gta","pes(2019)"};
        System.err.println(Arrays.toString(getFolderNames(n1)));

        //  输入：names = ["gta","gta(1)","gta","avalon"]
        //  输出：["gta","gta(1)","gta(2)","avalon"]
        //  解释：文件系统将会这样创建文件名：
        //  "gta" --> 之前未分配，仍为 "gta"
        //  "gta(1)" --> 之前未分配，仍为 "gta(1)"
        //  "gta" --> 文件名被占用，系统为该名称添加后缀 (k)，由于 "gta(1)" 也被占用，所以 k = 2 。实际创建的文件名为 "gta(2)" 。
        //  "avalon" --> 之前未分配，仍为 "avalon"
        String[] n2 = {"gta","gta(1)","gta","avalon"};
        System.err.println(Arrays.toString(getFolderNames(n2)));

        String[] n3 = {"kaido","kaido(1)","kaido","kaido(1)"};
        System.err.println(Arrays.toString(getFolderNames(n3)));

        String[] n4 = {"wano","wano","wano","wano"};
        System.err.println(Arrays.toString(getFolderNames(n4)));

        String[] n5 = {"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"};
        System.err.println(Arrays.toString(getFolderNames(n5)));

    }

    
    public static String[] getFolderNames(String[] names) {
        if (names.length <= 1) {
            return names;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];

            // 不存在 直接插入
            if (!map.containsKey(name)) {
                map.put(name, 1);
            } else {
                Integer integer = map.get(name);
                while (map.containsKey(name + "(" + integer + ")")) {
                    integer++;
                }
                names[i] = name + "(" + integer + ")";
                map.put(name, integer + 1);
                map.put(names[i], 1);
            }
        }
        return names;
    }

}
