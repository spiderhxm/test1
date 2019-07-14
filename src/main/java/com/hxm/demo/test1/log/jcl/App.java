package com.hxm.demo.test1.log.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class App {
    //commons-logging最核心有用的功能是解耦
    private final static Log logger = LogFactory.getLog(App.class);
    public static void main( String[] args )
    {
        //当 commons-logging.jar 被加入到 CLASSPATH之后，它会按照一定顺序寻找你想使用的日志工具
        //如果都找不到，它会使用自带的SimpleLog

        //当使用了jcl-over-slf4j，会把jcl调用都转为slf4j调用
        logger.error("jcl error log");
        logger.info("jcl info log");
    }
}
