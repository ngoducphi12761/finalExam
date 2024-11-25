package edu.miu.cse.vsms.service;

import edu.miu.cse.vsms.dto.request.ServiceRequestDto;
import edu.miu.cse.vsms.dto.response.VehicleServiceResponseDto;

import java.util.Optional;

public interface VehicleService {
   Optional<VehicleServiceResponseDto>  assignService(ServiceRequestDto request);
}
