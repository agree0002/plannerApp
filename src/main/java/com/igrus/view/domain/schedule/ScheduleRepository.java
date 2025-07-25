package com.igrus.view.domain.schedule;


import java.util.List;

public interface ScheduleRepository {
    Schedule insert (Schedule schedule);
    long delete (int schedule_index);
    List<Schedule> findByIdx(int user_index);
}