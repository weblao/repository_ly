package com.batchjob;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 *
 * @author laoying@talkweb.com.cn
 * @date 2023/3/31
 * @apiNote
 */
@SpringBootApplication
@EnableBatchProcessing
public class PkslowBatchJobMain {
    public static void main(String[] args) {
        SpringApplication.run(PkslowBatchJobMain.class, args);
    }
}

