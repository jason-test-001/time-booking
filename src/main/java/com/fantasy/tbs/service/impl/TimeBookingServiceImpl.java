package com.fantasy.tbs.service.impl;

import com.fantasy.tbs.domain.TimeBooking;
import com.fantasy.tbs.domain.WorkingTimeVo;
import com.fantasy.tbs.repository.TimeBookingRepository;
import com.fantasy.tbs.service.TimeBookingService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * Service Implementation for managing {@link TimeBooking}.
 */
@Service
@Transactional
public class TimeBookingServiceImpl implements TimeBookingService {

    private final Logger log = LoggerFactory.getLogger(TimeBookingServiceImpl.class);


    private final TimeBookingRepository timeBookingRepository;

    public TimeBookingServiceImpl(TimeBookingRepository timeBookingRepository) {
        this.timeBookingRepository = timeBookingRepository;
    }

    /**
     * query personnal member working time
     *
     * @param personalMember
     * @return
     */
    @Override
    public List<WorkingTimeVo> queryWorkingTime(String personalMember) {
        return timeBookingRepository.queryWorkingTime(personalMember);
    }


    /**
     * set time to inform worker
     */
    public void informWorker() {
        //get currentDate
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String currentDate = localDateTime.format(formatter);

        List<String> personnumList = new LinkedList<>();
        // get all the company worker number
        for (int i = 0; i < personnumList.size(); i++) {
            List<TimeBooking> timeBookingList = timeBookingRepository.queryWorkingTime(personnumList.get(i), currentDate);
            if (CollectionUtils.isEmpty(timeBookingList)) {
                continue;
            }
            //send email to inform worker
        }
    }
}
