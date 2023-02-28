package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerNew {

    @GetMapping("/request_access")
    public String requestAccess() {
        return "requestAccess";
    }

    @GetMapping("/employee_request")
    public String requestEmployeeAccess() {
        return "employeeAccess";
    }

    @GetMapping("/it_request")
    public String requestItAccess() {
        return "itRequest";
    }

    @GetMapping("/security_request")
    public String requestSecurityAccess() {
        return "securityRequest";
    }

    @GetMapping("/director_request")
    public String requestDirectorAccess() {
        return "directorRequest";
    }

}
