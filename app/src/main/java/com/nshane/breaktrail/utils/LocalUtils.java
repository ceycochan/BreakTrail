package com.nshane.breaktrail.utils;

/**
 * Created by Administrator on 2018/11/22 0022.
 */

public class LocalUtils {


    /**
     * 该方法待改进
     * @param ladder
     * @param maxJump
     * @return
     */

    //递归方法处理爬楼梯算法问题
    public static int calculateStair(int ladder, int maxJump) {
        int jump = 0;
        if (ladder == 0) {
            return 1;
        }

        //剩下的楼梯大于最大可跳跃数
        if (ladder >= maxJump) {


            /**
             * 赋值运算符：a+=5---> a=a+5;
             */
            for (int i = 1; i < maxJump; i++) {
                jump += calculateStair(ladder - i, maxJump);
            }

        } else {
            //剩下的楼梯不足最大可跳跃数
            jump = calculateStair(ladder, ladder);
        }

        return jump;

    }


    //非递归算法处理爬楼梯问题
    //斐波那契数列相关

    public static int countStair(int ladder) {
        if (ladder == 1 || ladder == 2) {
            return ladder;
        }

        int s1 = 1;
        int s2 = 2;
        for (int i = 3; i <= ladder; i++) {
            int temp = s2;
            s2 = s1 + s2;
            s1 = temp;

        }

        return s2;

    }


    //判断是否为回文结构,也是排序练习

}
