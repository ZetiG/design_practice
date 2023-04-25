package com.example.demo.leetcode.ii;

import java.util.HashSet;
import java.util.List;

/**
 * Description: LCP 73. 探险营地
 * 探险家小扣的行动轨迹，都将保存在记录仪中。expeditions[i] 表示小扣第 i 次探险记录，用一个字符串数组表示。其中的每个「营地」由大小写字母组成，通过子串 -> 连接。
 * 例："Leet->code->Campsite"，表示到访了 "Leet"、"code"、"Campsite" 三个营地。
 * expeditions[0] 包含了初始小扣已知的所有营地；对于之后的第 i 次探险(即 expeditions[i] 且 i > 0)，如果记录中包含了之前均没出现的营地，则表示小扣 新发现 的营地。
 * 请你找出小扣发现新营地最多且索引最小的那次探险，并返回对应的记录索引。如果所有探险记录都没有发现新的营地，返回 -1
 *
 * 注意：
 * 大小写不同的营地视为不同的营地；
 * 营地的名称长度均大于 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/0Zeoeg
 *
 * @author Zeti
 * @date 2023/4/24 19:06
 */
public class AdventureCamp {

    public static void main(String[] args) {
        String[] a1 = {"leet->code","leet->code->Campsite->Leet","leet->code->leet->courier"};
        System.err.println(adventureCamp(a1));  // 1

        String[] a2 = {"Alice->Dex","","Dex"};
        System.err.println(adventureCamp(a2));  // -1

        String[] a3 = {"","Gryffindor->Slytherin->Gryffindor","Hogwarts->Hufflepuff->Ravenclaw"};
        System.err.println(adventureCamp(a3));  // 2

        String[] a4 = {"xO->xO->xO","xO->BKbWDH","xO->BKbWDH","BKbWDH->mWXW","LSAYWW->LSAYWW","oAibBvPdJ","LSAYWW->u","LSAYWW->LSAYWW"};
        System.err.println(adventureCamp(a4));  // 1


    }

    public static int adventureCamp(String[] expeditions) {
        String ex = expeditions[0];
        HashSet<String> set = new HashSet<>(List.of(ex.split("->")));

        int ct = -1;
        int resIdx = -1;
        for (int i = 1; i < expeditions.length; i++) {
            if (expeditions[i].length() == 0) {
                continue;
            }

            int currentCt = 0;
            HashSet<String> curSet = new HashSet<>(List.of(expeditions[i].split("->")));
            for (String s : curSet) {
                if (!set.contains(s)) {
                    set.add(s);
                    currentCt++;
                }
            }
            if (currentCt > 0 && currentCt > ct) {
                ct = currentCt;
                resIdx = i;
            }
        }
        return resIdx;
    }

}
