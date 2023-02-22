package com.fantasy.tbs.client;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * WorkingTimeController test
 *
 * @author:heyaolei
 * @create: 2023-02-22
 */
public class WorkingTimeControllerTest {
    @Autowired
    private WorkingTimeController workingTimeController;

    @Test
    public void queryWorkingTime() {
        String personalNumber = "123";
        workingTimeController.queryWorkingTime(personalNumber);
    }
}
