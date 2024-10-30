package com.team13.swingbe.domain.driver.controller;

import com.team13.swingbe.domain.driver.dto.response.CallsResponse;
import com.team13.swingbe.domain.driver.dto.response.MyCallsResponse;
import com.team13.swingbe.domain.driver.service.CallService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DriverController {

    private final CallService callService;
    @GetMapping("/calls")
    public List<CallsResponse> calls() {
        return callService.calls();
    }

    @GetMapping("/mycall")
    public List<MyCallsResponse> myCalls() {
        return callService.myCalls();
    }

    @PostMapping("/call/{id}")
    public void call(@PathVariable Long id) {
        callService.call(id);
    }

    @PatchMapping ("/call/{id}")
    public void callCancle(@PathVariable Long id) {
        callService.callCancle(id);
    }
}
