package com.ruoyi.system.test;

import com.ruoyi.common.core.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.IntBuffer;

public class NioDemo1 {
    protected final static Logger logger = LoggerFactory.getLogger(BaseController.class);

    public static void test1(){
        IntBuffer intBuffer = null;

        intBuffer = IntBuffer.allocate(20);
        logger.debug("------------after allocate------------------");
        logger.debug("position=" + intBuffer.position());
        logger.debug("limit=" + intBuffer.limit());
        logger.debug("capacity=" + intBuffer.capacity());

        for (int i = 0; i < 5; i++) {
            intBuffer.put(i);

        }

        logger.debug("------------after putTest------------------");
        logger.debug("position=" + intBuffer.position());
        logger.debug("limit=" + intBuffer.limit());
        logger.debug("capacity=" + intBuffer.capacity());

        intBuffer.flip();
        logger.debug("------------after flipTest ------------------");

        logger.debug("position=" + intBuffer.position());
        logger.debug("limit=" + intBuffer.limit());
        logger.debug("capacity=" + intBuffer.capacity());

        for (int i = 0; i < 2; i++) {
            int j = intBuffer.get();
            logger.debug("j = " + j);
        }

        logger.debug("------------after get 2 int ------------------");
        logger.debug("position=" + intBuffer.position());
        logger.debug("limit=" + intBuffer.limit());
        logger.debug("capacity=" + intBuffer.capacity());

        for (int i = 0; i < 3; i++) {
            int j = intBuffer.get();
            logger.debug("j = " + j);
        }

        intBuffer.rewind();
        logger.debug("------------after rewind ------------------");
        logger.debug("position=" + intBuffer.position());
        logger.debug("limit=" + intBuffer.limit());
        logger.debug("capacity=" + intBuffer.capacity());

        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                intBuffer.mark();
            }
            int j = intBuffer.get();
            logger.debug("j = " + j);

        }
        logger.debug("------------after reRead------------------");
        logger.debug("position=" + intBuffer.position());
        logger.debug("limit=" + intBuffer.limit());
        logger.debug("capacity=" + intBuffer.capacity());

        logger.debug("------------after reset------------------");
        intBuffer.reset();
        logger.debug("position=" + intBuffer.position());
        logger.debug("limit=" + intBuffer.limit());
        logger.debug("capacity=" + intBuffer.capacity());
        for (int i =2; i < 5; i++) {
            int j = intBuffer.get();
            logger.debug("j = " + j);

        }


        logger.debug("------------after clear------------------");
        intBuffer.clear();
        logger.debug("position=" + intBuffer.position());
        logger.debug("limit=" + intBuffer.limit());
        logger.debug("capacity=" + intBuffer.capacity());


    }
    public static void main(String[] args) {
        test1();


    }

}
