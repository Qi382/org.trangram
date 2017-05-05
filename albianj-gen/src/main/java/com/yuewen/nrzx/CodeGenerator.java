package com.yuewen.nrzx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.trangram.config.TrangramContext;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 17:27
 */
public class CodeGenerator {

    private final static Logger logger = LoggerFactory.getLogger(CodeGenerator.class);

    public static void main(String[] args) {

        if (args.length == 0) {
            logger.error("需要指定路径");
            return;
        }
        String context = args[0];

        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(context);

        TrangramContext trangramContext = applicationContext.getBean(TrangramContext.class);

        trangramContext.run();

    }


}
