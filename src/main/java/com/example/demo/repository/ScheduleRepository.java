package com.example.demo.repository;


import com.example.demo.domain.Schedule;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ScheduleRepository {
    Schedule insert (Schedule schedule);
    long delete (int schedule_index);
    List<Schedule> findByIdx(int user_index);
}