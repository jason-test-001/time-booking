package com.fantasy.tbs.repository;

import com.fantasy.tbs.domain.TimeBooking;
import com.fantasy.tbs.domain.WorkingTimeVo;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data SQL repository for the TimeBooking entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TimeBookingRepository extends JpaRepository<TimeBooking, Long> {

    /**
     * 1. Split time variable booking to date and time
     * 2.  search for day's minTime and maxTime,group by booking date
     * 3. maxTime - minTime = working time
     *
     * @param personalMember
     * @return
     */
    @Query("select aa.bookingDate,max(aa.bookingTime) as endTime,min(aa.bookingTime) as beginTime, max(aa.bookingTime) - min(aa.bookingTime) as resultTime\n" +
            "from \n" +
            "(select personal_number,booking,cast(booking AS date) as bookingDate,cast(booking AS Time) as bookingTime\n" +
            "from time_booking\n" +
            "where personal_number = :personalMember aa\n" +
            "group by aa.bookingDate")
    List<WorkingTimeVo> queryWorkingTime(String personalMember);
}
