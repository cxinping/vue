package com.ruoyi.system.test;

import com.ruoyi.common.core.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.IntBuffer;

public class UseBuffer {
    protected final static Logger logger = LoggerFactory.getLogger(BaseController.class);

    static IntBuffer intBuffer = null;

    public static void allocatTest() {
        intBuffer = IntBuffer.allocate(20);
        logger.debug("------------after allocate------------------");
        logger.debug("position=" + intBuffer.position());
        logger.debug("limit=" + intBuffer.limit());
        logger.debug("capacity=" + intBuffer.capacity());
    }

    public static void putTest() {
        for (int i = 0; i < 5; i++) {
            intBuffer.put(i);

        }

        logger.debug("------------after putTest------------------");
        logger.debug("position=" + intBuffer.position());
        logger.debug("limit=" + intBuffer.limit());
        logger.debug("capacity=" + intBuffer.capacity());

    }

    public static void flipTest() {

        intBuffer.flip();
        logger.debug("------------after flipTest ------------------");

        logger.debug("position=" + intBuffer.position());
        logger.debug("limit=" + intBuffer.limit());
        logger.debug("capacity=" + intBuffer.capacity());
    }

    public static void getTest() {
        for (int i = 0; i < 2; i++) {
            int j = intBuffer.get();
            logger.debug("j = " + j);
        }
//        logger.debug("------------after get 2 int ------------------");
//        logger.debug("position=" + intBuffer.position());
//        logger.debug("limit=" + intBuffer.limit());
//        logger.debug("capacity=" + intBuffer.capacity());


//        for (int i = 0; i < 3; i++) {
//            int j = intBuffer.get();
//            logger.debug("j = " + j);
//        }
//
//        logger.debug("------------after get 3 int ------------------");
//        logger.debug("position=" + intBuffer.position());
//        logger.debug("limit=" + intBuffer.limit());
//        logger.debug("capacity=" + intBuffer.capacity());
    }

    public static void main(String[] args) {
        logger.debug("分配内存");
        allocatTest();

        logger.debug("写入");
        allocatTest();

        logger.debug("翻转");
        flipTest();

        logger.debug("读取");
        getTest();

    }

}
