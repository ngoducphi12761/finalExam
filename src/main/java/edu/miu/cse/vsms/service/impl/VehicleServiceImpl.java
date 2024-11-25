package edu.miu.cse.vsms.service.impl;

import edu.miu.cse.vsms.dto.request.ServiceRequestDto;
import edu.miu.cse.vsms.dto.response.VehicleServiceResponseDto;
import edu.miu.cse.vsms.exception.ResourceNotFoundException;
import edu.miu.cse.vsms.model.Employee;
import edu.miu.cse.vsms.model.VService;
import edu.miu.cse.vsms.repository.EmployeeRepository;
import edu.miu.cse.vsms.repository.VehicleServiceRepository;
import edu.miu.cse.vsms.service.VehicleService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleServiceRepository vehicleServiceRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public Optional<VehicleServiceResponseDto>  assignService(ServiceRequestDto request) {
        // Write your code here
        Optional<Employee> employee = employeeRepository.findById(request.employeeId());
        VService vService = new VService(request.serviceName(), request.cost(), request.vehicleType(), employee.get());

        return Optional.of(new VehicleServiceResponseDto(vService.getId(), vService.getServiceName(), vService.getCost(), vService.getVehicleType()));

    }
}
