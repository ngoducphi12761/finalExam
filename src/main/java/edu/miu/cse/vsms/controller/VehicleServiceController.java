package edu.miu.cse.vsms.controller;

import edu.miu.cse.vsms.dto.request.ServiceRequestDto;
import edu.miu.cse.vsms.dto.response.EmployeeResponseDto;
import edu.miu.cse.vsms.dto.response.VehicleServiceResponseDto;
import edu.miu.cse.vsms.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/api/v1/services")
@RequiredArgsConstructor
public class VehicleServiceController {
    
    private final VehicleService vehicleService;

    // Assign a service to an employee
    @PostMapping
    public ResponseEntity<VehicleServiceResponseDto> assignService(@RequestBody ServiceRequestDto request) {
        // Write your code here
            Optional<VehicleServiceResponseDto> vehicleServiceResponseDto = vehicleService.assignService(request);
            return ResponseEntity.status(HttpStatus.OK).body(vehicleServiceResponseDto.get());
    }
    
}
