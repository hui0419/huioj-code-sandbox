package com.hui.huiojcodesandbox.model;

import lombok.Data;

/**
 * 进程执行信息
 *
 * @author 王程辉
 * @date 2024/10/09 10:34
 */
@Data
public class ExecuteMessage {
    private Integer exitValue;
    private String message;
    private String errorMessage;
}
