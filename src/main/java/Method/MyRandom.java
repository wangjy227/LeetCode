package Method;

import java.util.Random;

/**
 * 简单随机数生成
 */
public class MyRandom {
    Random numList;

    public MyRandom() {
        numList = new Random();
    }

    // 随机生成 0-100
    public int RandomNumber() {
        int ran = (int) (Math.random() * 100);
        //循环同一时间会产生相同的数
        return ran;
    }

    public int RandomNumber(int min, int max) {
        int ran = (int) (Math.random() * (max - min) + min);
        //循环同一时间会产生相同的数
        return ran;
    }
}

