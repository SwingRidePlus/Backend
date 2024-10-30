package com.team13.swingbe.domain.driver.controller;

import com.team13.swingbe.domain.driver.dto.response.CallsResponse;
import com.team13.swingbe.domain.driver.service.CallService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DriverController {

    private final CallService callService;
    @GetMapping("/calls")
    public List<CallsResponse> calls() {
        return callService.calls();
    }

    @PostMapping("/call/{id}")
    public void call(@PathVariable Long id) {
        callService.call(id);
    }
}
