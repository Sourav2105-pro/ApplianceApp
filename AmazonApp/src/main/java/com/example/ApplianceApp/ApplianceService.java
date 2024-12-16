package com.example.ApplianceApp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplianceService{
	
	@Autowired
	private ApplianceRepository applianceRepository;

	public ApplianceDTO addAppliance(ApplianceDTO applianceDTO) {
        Appliances appliance = new Appliances();
        appliance.setName(applianceDTO.getName());
        appliance.setBrand(applianceDTO.getBrand());
        appliance.setPrice(applianceDTO.getPrice());
        appliance.setEnergyRating(applianceDTO.getEnergyRating());

        appliance = applianceRepository.save(appliance);
        return new ApplianceDTO(appliance.getid(), appliance.getName(), appliance.getBrand(), appliance.getPrice(), appliance.getEnergyRating());
    }

    // Update appliance price
    public ApplianceDTO updatePrice(Long applianceId, double newPrice) {
        Optional<Appliances> applianceOpt = applianceRepository.findById(applianceId);
        if (applianceOpt.isPresent()) {
            Appliances appliance = applianceOpt.get();
            appliance.setPrice(newPrice);
            appliance = applianceRepository.save(appliance);
            return new ApplianceDTO(appliance.getid(), appliance.getName(), appliance.getBrand(), appliance.getPrice(), appliance.getEnergyRating());
        }
        throw new IllegalArgumentException("Appliance not found");
    }

    // Get appliance by ID
    public ApplianceDTO getApplianceById(Long applianceId) {
        Appliances appliance = applianceRepository.findById(applianceId)
                .orElseThrow(() -> new IllegalArgumentException("Appliance not found"));
        return new ApplianceDTO(appliance.getid(), appliance.getName(), appliance.getBrand(), appliance.getPrice(), appliance.getEnergyRating());
    }

    // Delete appliance
    public void deleteAppliance(Long applianceId) {
        applianceRepository.deleteById(applianceId);
    }
	

}
