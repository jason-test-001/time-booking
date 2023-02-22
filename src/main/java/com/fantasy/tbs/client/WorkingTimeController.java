package com.fantasy.tbs.client;

import com.fantasy.tbs.domain.WorkingTimeVo;
import com.fantasy.tbs.service.TimeBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * calculate working time
 *
 * @author:heyaolei
 * @create: 2023-02-22
 */
@RestController
public class WorkingTimeController {

    @Autowired
    private TimeBookingService timeBookingService;

    @RequestMapping("queryWorkingTime")
    public List<WorkingTimeVo> queryWorkingTime(String personalNumber){
        return timeBookingService.queryWorkingTime(personalNumber);
    }
}
