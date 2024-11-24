package com.serveur.serveurGestBureauOrdre.Controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serveur.serveurGestBureauOrdre.Entity.Courier;
import com.serveur.serveurGestBureauOrdre.Service.ICourierService;

@RestController
@RequestMapping("/api/courier")
@CrossOrigin(origins = "http://localhost:4200")
public class CourierController {

	@Autowired
	private ICourierService courierService;
	
	@GetMapping
	public List<Courier> getCouriers(){
		return courierService.getCourier();
	}
//	@PostMapping
//	public void addCourier(@RequestBody Courier courier) {
//		courierService.addCourier(courier);
//	}
	
	private final String uploadDirectory = "C:/Users/LENOVO/Desktop/dossierStage";

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Sauvegarde du fichier
            String fileName = file.getOriginalFilename();
            Path path = Paths.get(uploadDirectory, fileName);
            Files.write(path, file.getBytes());

            return new ResponseEntity<>("Fichier uploadé avec succès", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Erreur lors de l'upload", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/add")
    public ResponseEntity<Courier> addCourier(@RequestParam("courier") String courierJson, 
                                              @RequestParam("file") MultipartFile file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Courier courier = objectMapper.readValue(courierJson, Courier.class);
        
        // Sauvegarder le fichier PDF
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            Path path = Paths.get(uploadDirectory, fileName);
            Files.write(path, file.getBytes());
            courier.setFileName(fileName); // Sauvegarder le nom du fichier
        }
    	
        // Sauvegarder le courrier (logique de persistance)
        try {
            courierService.addCourier(courier); // Appel au service pour sauvegarder le courrier
            return new ResponseEntity<>(courier, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws IOException {
        Path path = Paths.get(uploadDirectory, fileName);
        Resource resource = new UrlResource(path.toUri());

        if (resource.exists() && resource.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                    .body(resource);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	// Update a courier
    @PutMapping("/{numOrdre}")
    public ResponseEntity<String> updateCourier(@PathVariable String numOrdre, @RequestBody Courier courier) {
        courierService.updateCourier(courier);
        return ResponseEntity.ok("Courier updated successfully.");
    }
    
    // Delete a courier by numOrdre
    @DeleteMapping("/{numOrdre}")
    public ResponseEntity<String> deleteCourier(@PathVariable String numOrdre) {
        courierService.deleteCourier(numOrdre);
        return ResponseEntity.ok("Courier deleted successfully.");
    }
    
 
    @GetMapping("/search")
    public ResponseEntity<List<Courier>> searchCouriers(@RequestParam String searchTerm) {
        List<Courier> couriers = courierService.searchCouriers(searchTerm);
        return ResponseEntity.ok(couriers);
    }
    
   
}

