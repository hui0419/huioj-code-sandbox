package com.hui.huiojcodesandbox;

import com.hui.huiojcodesandbox.model.ExecuteCodeRequest;
import com.hui.huiojcodesandbox.model.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
