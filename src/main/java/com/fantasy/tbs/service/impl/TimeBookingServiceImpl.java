package com.fantasy.tbs.service.impl;

import com.fantasy.tbs.domain.TimeBooking;
import com.fantasy.tbs.domain.WorkingTimeVo;
import com.fantasy.tbs.repository.TimeBookingRepository;
import com.fantasy.tbs.service.TimeBookingService;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link TimeBooking}.
 */
@Service
@Transactional
public class TimeBookingServiceImpl implements TimeBookingService {


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
}
