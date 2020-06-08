package cn.fanchencloud.house.model;

import lombok.Data;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/6
 * Time: 20:24
 * Description: 返回页面错误信息
 *
 * @author chen
 */
@Data
public class ResultMessage {

    /**
     * 成功的消息的键
     */
    public static final String SUCCESS_MESSAGE_KEY = "successMessage";

    /**
     * 错误消息的键
     */
    public static final String ERROR_MESSAGE_KEY = "errorMessage";

    /**
     * 成功消息内容
     */
    private String successMessage;

    /**
     * 错误消息内容
     */
    private String errorMessage;

    /**
     * 创建一个成功消息
     *
     * @param message 消息内容
     * @return 成功消息
     */
    public static ResultMessage successMessage(String message) {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setSuccessMessage(message);
        return resultMessage;
    }

    /**
     * 创建一个错误消息
     *
     * @param message 消息内容
     * @return 错误消息
     */
    public static ResultMessage errorMessage(String message) {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setErrorMessage(message);
        return resultMessage;
    }

    /**
     * 是否成功
     *
     * @return 是否成功
     */
    public boolean isSuccess() {
        return errorMessage == null;
    }
}
