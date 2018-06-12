package com.funi.muyq.angular.zorroserver.controller;

import com.funi.muyq.angular.zorroserver.po.SystemUser;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/12 16:45]
 */
@RestController
@RequestMapping("user")
@Api(value = "系统用户接口")
public class UserController {

    @GetMapping(value = "/{uuid}")
    public List<SystemUser> findUserByUuid(@PathVariable("uuid") String uuid) throws Exception {
        if (!Strings.isNullOrEmpty(uuid)) {
            throw new Exception("user not found");
        }
        return Lists.newArrayList();
    }
}
