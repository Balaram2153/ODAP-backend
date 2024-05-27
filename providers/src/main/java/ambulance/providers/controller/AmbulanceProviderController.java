package ambulance.providers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ambulance.providers.entity.AmbulanceProvider;
import ambulance.providers.entity.EmailRequest;
import ambulance.providers.repository.AmbulanceProviderRepository;
import ambulance.providers.service.EmailService;

@RestController
@RequestMapping("/api/ambulance-providers")
@CrossOrigin(origins = "https://localhost:3000")
public class AmbulanceProviderController {

    @Autowired
    private AmbulanceProviderRepository repository;

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public void sendEmailToProvider(@RequestBody EmailRequest request) {
        AmbulanceProvider provider = repository.findById(request.getProviderId()).orElse(null);
        if (provider != null) {
            String to = provider.getEmail();
            String subject = "New Booking Request";
            String body = "You have a new booking request. Please login to your dashboard to view details.";
            emailService.sendEmail(to, subject, body);
        } else {
            throw new IllegalArgumentException("Ambulance provider not found");
        }
    }

    @GetMapping("/{providerId}")
    public ResponseEntity<AmbulanceProvider> getProviderById(@PathVariable Long providerId) {
        AmbulanceProvider provider = repository.findById(providerId).orElse(null);
        if (provider != null) {
            return ResponseEntity.ok(provider);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public List<AmbulanceProvider> getAllProviders() {
        return repository.findAll();
    }

}
