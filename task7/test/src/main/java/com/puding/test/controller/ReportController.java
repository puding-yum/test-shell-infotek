package com.puding.test.controller;

import com.puding.test.dto.request.ReportReq;
import com.puding.test.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping
    public ResponseEntity<Object> getReport(@RequestBody ReportReq request) {
        return reportService.generateReport(request);
    }
}
