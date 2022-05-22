package com.example.ehealthcare.web.search;

import org.springframework.web.bind.annotation.GetMapping;

public class DoctorSearchController {
    @GetMapping("/search")
    public String searchForm() {
        return "medicalField";
    }

    @GetMapping("/search/option1")
    public String option1Form() {
        return "option1_consult";
    }

    @GetMapping("/search/option2")
    public String option2Form() {
        return "option2_consult";
    }

    @GetMapping("/search/option3")
    public String option3Form() {
        return "option3_consult";
    }

    @GetMapping("/search/option4")
    public String option4Form() {
        return "option4_consult";
    }

    @GetMapping("/search/option5")
    public String option5Form() {
        return "option5_consult";
    }
}
