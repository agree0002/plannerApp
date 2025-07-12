package com.igrus.demo.demo.repository;


import com.igrus.demo.demo.domain.Schedule;

import java.util.List;

public interface ScheduleRepository {
    Schedule insert (Schedule schedule);
    long delete (int schedule_index);
    List<Schedule> findByIdx(int user_index);
}