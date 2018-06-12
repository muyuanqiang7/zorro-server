package com.funi.muyq.angular.zorroserver.po;

import lombok.Data;

import java.util.Date;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/12 16:30]
 */
@Data
public abstract class BasePo {
    private Date createTime;
    private String createUserId;
    private Date updateTime;
    private String updateUserId;
    private Date deleteTime;
    private String deleteUserId;
    private boolean isDelete;
    private Integer version;
}
