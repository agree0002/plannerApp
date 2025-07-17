package com.igrus.view.domain.schedule;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaScheduleRepository implements ScheduleRepository {

    private final EntityManager em;

    public JpaScheduleRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Schedule insert(Schedule schedule) {
        em.persist(schedule);
        return schedule;
    }

    @Override
    public long delete(int schedule_index) {
        // 먼저 schedule_index에 해당하는 엔티티 조회
        Schedule schedule = em.find(Schedule.class, schedule_index);

        if (schedule != null) {
            // 엔티티 삭제
            em.remove(schedule);
            return schedule_index; // 삭제된 schedule_index 반환
        } else {
            return 0; // 삭제 대상이 없으면 0 반환
        }
    }

    @Override
    public List<Schedule> findByIdx(int user_index) {
        return em.createQuery("select m from Schedule m where m.user_index= :user_index order by date", Schedule.class)
                .setParameter("user_index", user_index)
                .getResultList();
    }
}
