package com.example.demo.leetcode.文本相识度匹配;


import org.apache.commons.collections4.SetUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description: 文本相似度匹配
 *
 * @author Zeti
 * @date 2022/11/11 14:18
 */
public class TextSimilarityMatch {

    public static void main(String[] args) {
//        String a = "3类用户（店铺面积：60-90㎡）选择月份同期累计下单用户数（去重）";
//        String b = "4类用户（店铺面积：90-120㎡）选择月份同期累计下单用户数（去重）";

        String a = "上月城市站商品GMV销量排名取值(头部:上月城市站商品GMV销量排名取值(头部:A品类各物流圈TOP200,上月城市站商品GMV销量排名取值(头部:A品类各物流圈TOP200,B品类全城TOP100 腰部:除头部商品外商品毛利率在10%以上且全城排名TOP501-TOP1000 尾部:除头部跟腰部剩余有销量商品) 腰部:除头部商品外商品毛利率在10%以上且全城排名TOP501-TOP1000 上月城市站商品GMV销量排名取值(头部:A品类各物流圈TOP200,B品类全城TOP100 腰部:除头部商品外商品毛利率在10%以上且全城排名TOP501-TOP1000 上月城市站商品GMV销量排名取值(头部:A品类各物流圈TOP200,B品类全城TOP100 腰部:除头部商品外商品毛利率在10%以上且全城排名TOP501-TOP1000 尾部:除头部跟腰部剩余有销量商品):除头部跟腰部剩余有销量商品):除头部跟腰部剩余有销量商品),B品类全城TOP100 腰部:除头部商品外商品毛利率在10%以上且全城排名TOP501-TOP1000 尾部:除头部跟腰部剩余有销量商品)";
        String b = "上月城市站商品GMV销量排名取值(上月城市站商品GMV销量排名取值(头部:A品类各物流圈TOP200,B品类全城TOP100 腰部:除头部商品外商品毛利率在10%以上且全城排名TOP501-TOP1000 尾部:除头部跟腰部剩余有销量商品):A品类各物流圈TOP200,B品类全城TOP100 腰部:除头部商品外商品毛利率在10%以上且全城排名TOP501-TOP1000 尾部:除头部跟腰部剩余有销量商品)(头部:A品类各物流圈TOP200,B品类全城TOP100 腰部:除头部商品外商品毛利率在10%上月城市站商品GMV销量排名取值(头部:A品类各物流圈TOP200,上月城市站商品GMV销量排名取值(头部:A品类各物流圈TOP200,B品类全城TOP100 腰部:除头部商品外商品毛利率在10%以上且全城排名TOP501-TOP1000 尾部:除头部跟腰部剩余有销量商品) 腰部:除头部商品外商品毛利率在10%以上且全城排名TOP501-TOP1000 尾部:除头部跟腰部剩余有销量商品)-TOP1000 尾部:除头部跟腰部剩余有销量商品)";

        a = StringUtils.lowerCase(a);
        b = StringUtils.lowerCase(b);
        System.err.println(a + " <> " + b);
        System.err.println("-------------------------------");

        System.err.println("Jaccard => " + jaccard(a, b));
        System.err.println("sorensenDice => " + sorensenDice(a, b));
        System.err.println("levenshtein => " + levenshtein(a, b));
        System.err.println("hamming => " + hamming(a, b));
        System.err.println("cos[0-1] => " + cos(a, b));
    }

    /**
     * Jaccard 相似度
     * 集合的交集与集合的并集的比例.
     */
    public static float jaccard(String a, String b) {
        if (a == null && b == null) {
            return 1f;
        }
        // 都为空相似度为 1
        if (a == null || b == null) {
            return 0f;
        }
        Set<Integer> aChar = a.chars().boxed().collect(Collectors.toSet());
        Set<Integer> bChar = b.chars().boxed().collect(Collectors.toSet());
        // 交集数量
        int intersection = SetUtils.intersection(aChar, bChar).size();
        if (intersection == 0) return 0;
        // 并集数量
        int union = SetUtils.union(aChar, bChar).size();
        return ((float) intersection) / (float)union;
    }

    /**
     * Sorensen Dice 相似度系数
     * 与 Jaccard 类似，Dice 系数也是一种计算简单集合之间相似度的一种计算方式。
     * 与 Jaccard 不同的是，计算方式略有不同。
     * 需要注意的是，他是：集合交集的 2 倍除以两个集合相加。并不是并集.
     */
    public static float sorensenDice(String a, String b) {
        if (a == null && b == null) {
            return 1f;
        }
        if (a == null || b == null) {
            return 0F;
        }
        Set<Integer> aChars = a.chars().boxed().collect(Collectors.toSet());
        Set<Integer> bChars = b.chars().boxed().collect(Collectors.toSet());
        // 求交集数量
        int intersect = SetUtils.intersection(aChars, bChars).size();
        if (intersect == 0) {
            return 0F;
        }
        // 全集，两个集合直接加起来
        int aSize = aChars.size();
        int bSize = bChars.size();
        return (2 * (float) intersect) / ((float) (aSize + bSize));
    }


    /**
     * Levenshtein
     * 莱文斯坦距离，又称 Levenshtein 距离，是编辑距离的一种。指两个字串之间，由一个转成另一个所需的最少编辑操作次数。
     */
    private static double levenshtein(String a, String b) {
        if (a == null && b == null) {
            return 1f;
        }
        if (a == null || b == null) {
            return 0F;
        }

        int aLen = a.length();
        int bLen = b.length();

        if (aLen == 0)
            return aLen;
        if (bLen == 0)
            return bLen;

        int[][] v = new int[aLen + 1][bLen + 1];
        for (int i = 0; i <= aLen; ++i) {
            for (int j = 0; j <= bLen; ++j) {
                if (i == 0) {
                    v[i][j] = j;
                } else if (j == 0) {
                    v[i][j] = i;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    v[i][j] = v[i - 1][j - 1];
                } else {
                    v[i][j] = 1 + Math.min(v[i - 1][j - 1], Math.min(v[i][j - 1], v[i - 1][j]));
                }
            }
        }

        int i = v[aLen][bLen];
        return 1 - ((float) i / Math.max(a.length(), b.length()));
    }

    /**
     * 汉明距离
     * 汉明距离是编辑距离中的一个特殊情况，仅用来计算两个等长字符串中不一致的字符个数。
     */
    public static float hamming(String a, String b) {
        if (a == null || b == null) {
            return 0f;
        }
        if (a.length() != b.length()) {
            return 0f;
        }

        int disCount = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                disCount++;
            }
        }
        return (float) disCount / (float) a.length();
    }

    /**
     * 余弦相似性
     * 首先是余弦相似性的定义：
     * <p>
     * 余弦相似性通过测量两个向量的夹角的余弦值来度量它们之间的相似性。
     * 0 度角的余弦值是 1，而其他任何角度的余弦值都不大于1；并且其最小值是-1。从而两个向量之间的角度的余弦值确定两个向量是否大致指向相同的方向。
     * 两个向量有相同的指向时，余弦相似度的值为 1；
     * 两个向量夹角为 90°时，余弦相似度的值为 0；
     * 两个向量指向完全相反的方向时，余弦相似度的值为-1。
     * 这结果是与向量的长度无关的，仅仅与向量的指向方向相关。
     * 余弦相似度通常用于正空间，因此给出的值为 0 到 1 之间。
     */
    public static float cos(String a, String b) {
        if (a == null || b == null) {
            return 0F;
        }
        Set<Integer> aChar = a.chars().boxed().collect(Collectors.toSet());
        Set<Integer> bChar = b.chars().boxed().collect(Collectors.toSet());

        // 统计字频
        Map<Integer, Integer> aMap = new HashMap<>();
        Map<Integer, Integer> bMap = new HashMap<>();
        for (Integer a1 : aChar) {
            aMap.put(a1, aMap.getOrDefault(a1, 0) + 1);
        }
        for (Integer b1 : bChar) {
            bMap.put(b1, bMap.getOrDefault(b1, 0) + 1);
        }

        // 向量化
        Set<Integer> union = SetUtils.union(aChar, bChar);
        int[] aVec = new int[union.size()];
        int[] bVec = new int[union.size()];
        List<Integer> collect = new ArrayList<>(union);
        for (int i = 0; i < collect.size(); i++) {
            aVec[i] = aMap.getOrDefault(collect.get(i), 0);
            bVec[i] = bMap.getOrDefault(collect.get(i), 0);
        }

        // 分别计算三个参数
        int p1 = 0;
        for (int i = 0; i < aVec.length; i++) {
            p1 += (aVec[i] * bVec[i]);
        }

        float p2 = 0f;
        for (int i : aVec) {
            p2 += (i * i);
        }
        p2 = (float) Math.sqrt(p2);

        float p3 = 0f;
        for (int i : bVec) {
            p3 += (i * i);
        }
        p3 = (float) Math.sqrt(p3);

        return ((float) p1) / (p2 * p3);
    }

}
