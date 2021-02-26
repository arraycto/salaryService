package com.weyoung.wxapp.common.shiro;

import com.weyoung.wxapp.common.domain.JsonResult;
import com.weyoung.wxapp.common.exception.FileDownloadException;
import com.weyoung.wxapp.common.exception.LimitAccessException;
import com.weyoung.wxapp.common.exception.NoSuchRecordException;
import com.weyoung.wxapp.common.exception.UnauthorizedException;
import com.weyoung.wxapp.common.util.ResponseUtil;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pushy
 * @since 2018/11/21 13:39
 */
@RestControllerAdvice
public class AppWideExceptionHandler {

    /**
     * 捕捉AuthorizationException异常
     */
    @ExceptionHandler(AuthorizationException.class)
    public Object handleAuthorizationException(AuthorizationException e) {
        JsonResult jsonResult = ResponseUtil.fail();
        jsonResult.setMsg("你无权访问，请联系管理员！\n" + e.getMessage());
        return jsonResult;
    }

    /**
     * 捕捉UnauthorizedException异常
     */
    @ExceptionHandler(UnauthorizedException.class)
    public Object authenticationException(UnauthorizedException e) {
        JsonResult jsonResult = ResponseUtil.fail();
        jsonResult.setMsg(e.getMessage());
        return jsonResult;
    }

    @ExceptionHandler(value = LimitAccessException.class)
    public Object handleLimitAccessException(LimitAccessException e) {
        JsonResult result = ResponseUtil.buildResult(HttpStatus.TOO_MANY_REQUESTS.value());
        result.setMsg(e.getMessage());
        return result;
    }

    @ExceptionHandler(value = FileDownloadException.class)
    public Object handleFileDownloadException(FileDownloadException e) {
        JsonResult result = ResponseUtil.unkownException();
        result.setMsg(e.getMessage());
        return result;
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public Object handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        JsonResult result = ResponseUtil.buildResult(HttpStatus.METHOD_NOT_ALLOWED.value());
        result.setMsg(e.getMessage());
        return result;
    }

    @ExceptionHandler(value = DuplicateKeyException.class)
    public Object handleDuplicateKeyException(DuplicateKeyException e) {
        JsonResult result = ResponseUtil.fail();
        result.setMsg("该数据已存在，请勿重复插入！");
        return result;
    }

    @ExceptionHandler(value = SQLException.class)
    public Object handleSQLException(SQLException e) {
        JsonResult result = ResponseUtil.unkownException();
        result.setMsg("数据库操作异常，请联系管理员！");
        return result;
    }

    @ExceptionHandler(value = NoSuchRecordException.class)
    public Object handleNoSuchRecordException(NoSuchRecordException e) {
        JsonResult result = ResponseUtil.fail();
        result.setMsg(e.getMessage());
        return result;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object validationErrorHandler(MethodArgumentNotValidException ex) {
        // 同样是获取BindingResult对象，然后获取其中的错误信息
        // 如果前面开启了fail_fast，事实上这里只会有一个信息
        //如果没有，则可能又多个
        List<String> errorInformation = ex.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        JsonResult result = ResponseUtil.fail();
        result.setMsg(errorInformation.toString());
        return result;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Object validationErrorHandler(ConstraintViolationException ex) {
        List<String> errorInformation = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        JsonResult result = ResponseUtil.fail();
        result.setMsg(errorInformation.toString());
        return result;
    }

    @ExceptionHandler(ValidationException.class)
    public Object validationErrorHandler2(ValidationException ex) {
        JsonResult result = ResponseUtil.fail();
        result.setMsg(ex.getMessage());
        return result;
    }


   /* @ExceptionHandler(value = Exception.class)
    public Object handleOtherException(Exception e) {
        JsonResult result = ResponseUtil.buildResult(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result.setMsg("服务器未知异常，请联系管理员！");
        result.setData(e.getMessage());
        return result;
    }*/

}
