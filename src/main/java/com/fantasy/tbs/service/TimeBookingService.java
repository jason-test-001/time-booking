package com.fantasy.tbs.service;

import com.fantasy.tbs.domain.TimeBooking;
import com.fantasy.tbs.domain.WorkingTimeVo;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link TimeBooking}.
 */
public interface TimeBookingService {

    /**
     * query personnal member working time
     *
     * @param personalMember
     * @return
     */
    List<WorkingTimeVo> queryWorkingTime(String personalMember);

    /**
     * set time to inform worker
     */
    void informWorker();


}
