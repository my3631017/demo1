package com.example.demo1.exeption;

import com.bici.saas.common.exception.SaasBaseException;

/**
 * 擎天异常捕捉
 *
 * @author: starQuest
 * @review: starQuest
 * @date: 2018/11/excercise7 16:47
 * @version: excercise1.excercise5
 */
public class QtException extends SaasBaseException {

    public QtException(Integer code, String msg) {
        super(code, msg);
    }
}
