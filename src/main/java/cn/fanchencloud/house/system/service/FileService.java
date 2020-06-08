package cn.fanchencloud.house.system.service;

import cn.fanchencloud.house.config.ImageConfig;
import cn.fanchencloud.house.util.MyStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/6
 * Time: 21:56
 * Description: 文件服务
 *
 * @author chen
 */
@Service
public class FileService {

    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(FileService.class);

    /**
     * 文件基础路径
     */
    @Value("${chen.file.basePath}")
    private String fileBasePath;

    /**
     * 将图片文件保存到本地
     *
     * @param file      文件
     * @param imageType 图片类别
     * @param mark      标识
     * @return 保存路径
     */
    public String saveImage(MultipartFile file, int imageType, String mark) {
        String path = null;
        switch (imageType) {
            // 是用户头像
            case ImageConfig.IMAGE_USER_AVATAR_INDEX:
                // 生成文件的唯一UUID
                path = File.separator + ImageConfig.IMAGE_USER_AVATAR_PATH
                        + File.separator + MyStringUtils.getUniversallyUniqueIdentifier() + "."
                        + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                File save = new File(fileBasePath + path);
                try {
                    file.transferTo(save);
                } catch (IOException e) {
                    logger.error("保存文件出错");
                    e.printStackTrace();
                }
                break;
            case ImageConfig.IMAGE_HOUSE_IMAGE_INDEX:
                System.out.println();
                break;
            default:
                break;
        }
        return path;
    }
}
