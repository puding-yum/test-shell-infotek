package com.puding.test.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportReq {
    private String startDate;  // Format: mm-yyyy
    private String endDate;    // Format: mm-yyyy
}
