package cn.fanchencloud.house.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/6
 * Time: 21:11
 * Description: 我的字符串工具类
 *
 * @author chen
 */
public class MyStringUtils {

    /**
     * 盐值
     */
    private static final String SALT = "fanchencloud";

    /**
     * 进行MD5加密
     *
     * @param info 要加密的信息
     * @return String 加密后的字符串
     */
    public static String encryptToMD5(String info) {
        info = info + SALT;
        byte[] digesta = null;
        try {
            // 得到一个md5的消息摘要
            MessageDigest alga = MessageDigest.getInstance("md5");
            // 添加要进行计算摘要的信息
            alga.update(info.getBytes());
            // 得到该摘要
            digesta = alga.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 将摘要转为字符串
        assert digesta != null;
        return byte2hex(digesta);
    }

    /**
     * 将二进制转化为16进制字符串
     *
     * @param b 二进制字节数组
     * @return String
     */
    private static String byte2hex(byte[] b) {
        StringBuilder sb = new StringBuilder();
        String stmp;
        for (byte value : b) {
            stmp = (Integer.toHexString(value & 0XFF));
            if (stmp.length() == 1) {
                sb.append("0").append(stmp);
            } else {
                sb.append(stmp);
            }
        }
        return sb.toString().toUpperCase();
    }

    /**
     * 获取唯一通用识别码
     *
     * @return UUID
     */
    public static String getUniversallyUniqueIdentifier() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
