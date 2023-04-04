package com.batchjob.entity;

import lombok.Data;

/**
 * @author laoying@talkweb.com.cn
 * @date 2023/3/31
 * @apiNote
 */
@Data
public class Employee {

    String id;
    String firstName;
    String lastName;

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


}
