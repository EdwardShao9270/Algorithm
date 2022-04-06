package com.sh.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 * @Auther: bjshaohang
 * @Date: 2019/3/6
 */
public class JVMErrorTest {
    static class OOMObject{}
    public static void main(String[] args) {
        //堆溢出
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }

    }
}
