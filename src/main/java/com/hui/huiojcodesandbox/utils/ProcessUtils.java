package com.hui.huiojcodesandbox.utils;

import cn.hutool.core.text.StrBuilder;
import com.hui.huiojcodesandbox.model.ExecuteMessage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 进程工具类
 *
 * @author 王程辉
 * @date 2024/10/09 10:32
 */
public class ProcessUtils {
    /**
     * 执行进程并获取信息
     *
     * @param runProcess
     * @param opName
     * @return
     */
    public static ExecuteMessage runProcessAndGetMessage(Process runProcess, String opName) {
        ExecuteMessage executeMessage = new ExecuteMessage();

        try {
            // 等待程序执行，获取错误码
            int exitValue = runProcess.waitFor();
            executeMessage.setExitValue(exitValue);

            // 正常退出
            if (exitValue == 0) {
                System.out.println(opName + "成功");
                // 分批获取进程的正常输出
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
                StrBuilder compileOutputStringBuilder = new StrBuilder();
                // 逐行读取
                String compileOutputline;
                while ((compileOutputline = bufferedReader.readLine()) != null) {
                    compileOutputStringBuilder.append(compileOutputline);
                }
                executeMessage.setMessage(compileOutputStringBuilder.toString());
            } else {
                // 异常退出
                System.out.println(opName + "失败，错误码：" + exitValue);
                // 分批获取进程的正常输出
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
                StrBuilder compileOutputStringBuilder = new StrBuilder();
                // 逐行读取
                String compileOutputline;
                while ((compileOutputline = bufferedReader.readLine()) != null) {
                    compileOutputStringBuilder.append(compileOutputline);
                }
                executeMessage.setMessage(compileOutputStringBuilder.toString());

                // 分批获取进程的错误输出
                BufferedReader errorBufferedReader = new BufferedReader(new InputStreamReader(runProcess.getErrorStream()));
                StrBuilder errorCompileOutputStringBuilder = new StrBuilder();
                // 逐行读取
                String errorCompileOutputline;
                while ((errorCompileOutputline = errorBufferedReader.readLine()) != null) {
                    errorCompileOutputStringBuilder.append(errorCompileOutputline);
                }
                executeMessage.setErrorMessage(errorCompileOutputStringBuilder.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return executeMessage;
    }
}
