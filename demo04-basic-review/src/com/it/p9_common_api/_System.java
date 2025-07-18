package com.it.p9_common_api;

public class _System {
    public static void main(String[] args) {
        // 获取时间戳，可用于技术代码执行时间
        long currentTime = System.currentTimeMillis();

        // 数组拷贝
        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        int[] arr2 = new int[10];
        // 参数一：原数据
        // 参数二：从原数据的哪个位置开始拷贝
        // 参数三：目标数据
        // 参数四：拷贝到目标数据的哪个位置
        // 参数五：拷贝的长度
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);

        // 退出当前系统
        System.exit(0);
    }
}
