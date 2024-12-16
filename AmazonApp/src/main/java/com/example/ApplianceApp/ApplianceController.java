package com.example.ApplianceApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/appliances")
public class ApplianceController {

    @Autowired
    private ApplianceService applianceService;

    // Add new appliance
    @PostMapping
    public ResponseEntity<ApplianceDTO> addAppliance(@Valid @RequestBody ApplianceDTO applianceDTO) {
        ApplianceDTO savedAppliance = applianceService.addAppliance(applianceDTO);
        return ResponseEntity.ok(savedAppliance);
    }

    // Update appliance price
    @PutMapping("/{id}/price")
    public ResponseEntity<ApplianceDTO> updatePrice(@PathVariable Long id, @RequestParam double newPrice) {
        ApplianceDTO updatedAppliance = applianceService.updatePrice(id, newPrice);
        return ResponseEntity.ok(updatedAppliance);
    }

    // Get appliance by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApplianceDTO> getApplianceById(@PathVariable Long id) {
        ApplianceDTO applianceDTO = applianceService.getApplianceById(id);
        return ResponseEntity.ok(applianceDTO);
    }

    // Delete appliance
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppliance(@PathVariable Long id) {
        applianceService.deleteAppliance(id);
        return ResponseEntity.noContent().build();
    }
}

