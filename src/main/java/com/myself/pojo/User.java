package com.myself.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * @author laoying@talkweb.com.cn
 * @date 2023/3/20
 * @apiNote
 */
@Data
@Builder
public class User {

    String userName;
    Integer userAge;

    public User(String userName, Integer userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }
}
