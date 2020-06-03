package cn.fanchencloud.house.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/3
 * Time: 16:08
 * Description:
 *
 * @author chen
 */
@ControllerAdvice
public class ErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public String error500(HttpServletRequest request, HttpServletResponse response, Exception e) {
        logger.error(e.getMessage(), e);
        logger.error(request.getRequestURL() + " encounter 500");
        return "error/500";

    }

}
