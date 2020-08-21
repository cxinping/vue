package com.ruoyi.common.utils.id;

import java.util.UUID;

/**
 * 生成24位字符串ID
 *
 */
public class IdGenerator  {


    /**
     * 调用该方法获取24位字符串ID
     * @return
     */
    public static String get() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-","");
    }



    public static void main(String[] args) {

        for(int i=0;i<5;i++){
            String uuid = IdGenerator.get();

           // UUID uuid2 = UUID.randomUUID();
           // System.out.println(uuid2);

            System.out.println(uuid);
        }


    }



}
