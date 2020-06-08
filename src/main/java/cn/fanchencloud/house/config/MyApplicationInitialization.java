package cn.fanchencloud.house.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/7
 * Time: 16:52
 * Description: 在系统启动完成执行的一些必要的初始化
 *
 * @author chen
 */
@Component
@Order(value = 1)
public class MyApplicationInitialization implements ApplicationRunner {

    /**
     * 文件基础路径
     */
    @Value("${chen.file.basePath}")
    private String fileBasePath;

    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(MyApplicationInitialization.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("system started , Initialization");
        // 初始化用户头像存储的文件夹
        if (!isChartPathExist(fileBasePath + File.separator + ImageConfig.IMAGE_USER_AVATAR_PATH)) {
            logger.error(fileBasePath + File.separator + ImageConfig.IMAGE_USER_AVATAR_PATH + " 文件夹创建失败！");
            throw new RuntimeException();
        }
    }


    private boolean isChartPathExist(String directoryPath) {
        assert directoryPath != null;
        File file = new File(directoryPath);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }
}
