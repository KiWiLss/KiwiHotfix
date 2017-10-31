package com.winding.scrolling.db;

/**
 * Created by 刘少帅 on 2017/10/31
 */

public class SingleTon {
    private static SingleTon instance;

    private SingleTon(){

    }

    public static class SingleTonInstance{
        private static final SingleTon SINGLE_TON=new SingleTon();
    }

    public static SingleTon getInstance(){
        return  SingleTonInstance.SINGLE_TON;
    }

}
