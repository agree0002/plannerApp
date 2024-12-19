package com.example.demo.controller;

import com.example.demo.domain.Schedule;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.service.ScheduleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;

    public ScheduleController(ScheduleService scheduleService, ScheduleRepository scheduleRepository) {
        this.scheduleService = scheduleService;
        this.scheduleRepository = scheduleRepository;
    }

    @ModelAttribute("user_index")
    public int index(HttpSession session) {
        // 세션에서 "user_index" 값을 가져옴 (없으면 기본값 1 반환)
        Integer userIndex = (Integer) session.getAttribute("user_index");
        return (userIndex != null) ? userIndex : 1; // 기본값을 1로 설정
    }

    @PostMapping(value = "/schedules/new")
    public String create(ScheduleForm form, @ModelAttribute("user_index") int index) {
        Schedule schedule = new Schedule();
        schedule.setDate(form.getDate());
        schedule.setTask(form.getTask());
        schedule.setUser_index(form.getUser_index());
        scheduleService.enterSchedule(schedule);
        return "redirect:/schedules";
    }

    @PostMapping(value = "/schedules/delete")
    public String delete(ScheduleForm form) {
        Schedule schedule = new Schedule();
        schedule.setSchedule_index(form.getSchedule_index());
        scheduleService.deleteSchedule(schedule.getSchedule_index());
        return "redirect:/schedules";
    }

    @GetMapping("/schedules")
    public String list(Model model, @ModelAttribute("user_index") int index) {
        List<Schedule> schedules = scheduleService.findSchedule(index);
        model.addAttribute("schedules", schedules);
        return "schedules/scheduleList";
    }

    @PostMapping("/schedules")
    public String returnHome() {
        return "redirect:/home";
    }
}

