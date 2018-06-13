package com.funi.muyq.angular.zorroserver.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/12 16:55]
 */
@Data
@AllArgsConstructor
@ToString
public class ErrorDetails {
    private Long timestamp;
    private String message;
    private String path;
    private int status;
    private Object data;

}
