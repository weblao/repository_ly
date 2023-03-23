package com.myself.service;

import com.myself.pojo.User;

/**
 * @author laoying@talkweb.com.cn
 * @date 2023/3/20
 * @apiNote
 */

@FunctionalInterface
public interface UserOperateService {

    void UserOperateService();

    default String queryUser(String arg,User user){
        return "FunctionalInterface";
    }
}
