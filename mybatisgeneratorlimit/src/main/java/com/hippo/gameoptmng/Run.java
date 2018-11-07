package com.hippo.gameoptmng;

import org.mybatis.generator.api.ShellRunner;

/**
 * @Author: luoan
 * @Date: 2018/11/7 16:18
 * @Description:
 */
public class Run {

    public static void main(String[] args) {

        String config = Run.class.getClassLoader()
                .getResource("generatorConfig.xml").getFile();
        String[] arg = { "-configfile", config, "-overwrite" };
        ShellRunner.main(arg);
    }
}
