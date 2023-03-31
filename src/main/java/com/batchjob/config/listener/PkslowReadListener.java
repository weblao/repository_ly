package com.batchjob.config.listener;

import com.batchjob.entity.Employee;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.ItemReadListener;


public class PkslowReadListener implements ItemReadListener<Employee> {
    private static final Log logger = LogFactory.getLog(PkslowReadListener.class);

    @Override
    public void beforeRead() {
        logger.info("beforeRead");

    }

    @Override
    public void afterRead(Employee employee) {
        logger.info("afterRead:" + employee);

    }

    @Override
    public void onReadError(Exception e) {

    }
}