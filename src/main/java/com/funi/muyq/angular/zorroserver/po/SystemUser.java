package com.funi.muyq.angular.zorroserver.po;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/12 16:29]
 */
@Data
@ToString
@ApiModel
public class SystemUser extends BasePo {
    private String uuid;
    private String name;
    private String loginName;
    private String email;
    private String password;
    private String phoneNumber;
    private String lastLoginIpAddress;
}
