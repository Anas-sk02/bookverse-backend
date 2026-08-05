package com.bookverse.controller;

import com.bookverse.dto.DashboardStatsDto;
import com.bookverse.service.DashboardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/stats")
    public DashboardStatsDto getDashboardStats() {

        return dashboardService.getDashboardStats();
    }

}
