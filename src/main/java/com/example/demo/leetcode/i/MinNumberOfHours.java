package com.example.demo.leetcode.i;

/**
 * Description: 2383. 赢得比赛需要的最少训练时长
 *  你正在参加一场比赛，给你两个 正 整数 initialEnergy 和 initialExperience 分别表示你的初始精力和初始经验。
 *  另给你两个下标从 0 开始的整数数组 energy 和 experience，长度均为 n 。
 *  你将会 依次 对上 n 个对手。第 i 个对手的精力和经验分别用 energy[i] 和 experience[i] 表示。当你对上对手时，需要在经验和精力上都 严格 超过对手才能击败他们，然后在可能的情况下继续对上下一个对手。
 *  击败第 i 个对手会使你的经验 增加 experience[i]，但会将你的精力 减少 energy[i] 。
 *  在开始比赛前，你可以训练几个小时。每训练一个小时，你可以选择将增加经验增加 1 或者 将精力增加 1 。
 *  返回击败全部 n 个对手需要训练的 最少 小时数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition
 *
 * @author Zeti
 * @date 2023/3/13 16:25
 */
public class MinNumberOfHours {

    public static void main(String[] args) {
        int initialEnergy = 5, initialExperience = 3;
        int[] energy = {1,4,3,2}, experience = {2,6,3,1};
        System.err.println(minNumberOfHours(initialEnergy, initialExperience, energy, experience));

        int initialEnergy2 = 2, initialExperience2 = 4;
        int[] energy2 = {1}, experience2 = {3};
        System.err.println(minNumberOfHours(initialEnergy2, initialExperience2, energy2, experience2));

        int initialEnergy3 = 1, initialExperience3 = 1; // 1
        int[] energy3 = {1,1,1,1}, experience3 = {1,1,1,50};
        System.err.println(minNumberOfHours(initialEnergy3, initialExperience3, energy3, experience3));

        int initialEnergy4 = 11, initialExperience4 = 23;
        int[] energy4 = {69,22,93,68,57,76,54,72,8,78,88,15,58,61,25,70,58,91,79,22,91,74,90,75,31,53,31,7,51,96,76,17,64,89,83,54,28,33,32,45,20},
                experience4 = {51,81,46,80,56,7,46,74,64,20,84,66,13,91,49,30,75,43,74,88,82,51,72,4,80,30,10,19,40,27,21,71,24,94,79,13,40,28,63,85,70};
        System.err.println(minNumberOfHours(initialEnergy4, initialExperience4, energy4, experience4));

        int initialEnergy5 = 100, initialExperience5 = 100;
        int[] energy5 = {1,2,3,4,5,6,7,8,9}, experience5 = {1,2,3,1,2,3,1,2,10};
        System.err.println(minNumberOfHours(initialEnergy5, initialExperience5, energy5, experience5));

    }


    // initialEnergy = 5
    // initialExperience = 3

    // energy =     [1,4,3,2]
    // experience = [2,6,3,1]

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int m = 0, totalEnergy = 1;
        for (int i : energy) {
            totalEnergy += i;
        }
        if (totalEnergy > initialEnergy) {
            m = totalEnergy - initialEnergy;
        }

        int n = 0;
        int totalExp = initialExperience;
        for (int i : experience) {
            if (totalExp > i) {
                totalExp +=i;
                continue;
            }
            n += (i-totalExp + 1);
            totalExp = i*2+1;
        }
        return m + n;
    }


    
}
