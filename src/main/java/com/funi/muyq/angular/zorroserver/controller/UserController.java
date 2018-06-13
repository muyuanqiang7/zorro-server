package com.funi.muyq.angular.zorroserver.controller;

import com.funi.muyq.angular.zorroserver.po.SystemUser;
import com.google.common.base.Strings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/12 16:45]
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping(value = "/{uuid}")
    public SystemUser findUserByUuid(@PathVariable("uuid") String uuid) {
        if (!Strings.isNullOrEmpty(uuid)) {
            return new SystemUser();
        }
        SystemUser systemUser = new SystemUser();
        systemUser.setUuid(UUID.randomUUID().toString());
        return systemUser;
    }
}
