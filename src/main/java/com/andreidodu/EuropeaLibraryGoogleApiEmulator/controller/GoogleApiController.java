package com.andreidodu.EuropeaLibraryGoogleApiEmulator.controller;

import com.andreidodu.EuropeaLibraryGoogleApiEmulator.dto.GoogleBookResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GoogleApiController {

    @GetMapping
    public ResponseEntity<GoogleBookResponseDTO> retrieveEBookMetaInfo(@RequestParam String q, @RequestParam int maxResults, @RequestParam String key) {
        GoogleBookResponseDTO bookInfo = new GoogleBookResponseDTO();
        GoogleBookResponseDTO.GoogleBookItemDTO googleBookItem = new GoogleBookResponseDTO.GoogleBookItemDTO();
        bookInfo.getItems().add(googleBookItem);

        GoogleBookResponseDTO.GoogleBookItemDTO.VolumeInfoDTO volumeInfo = googleBookItem.getVolumeInfo();

        List<String> authors = new ArrayList<>();
        authors.add("Jackie Chang");
        authors.add("John Smith");
        authors.add("Mario Verdi");
        volumeInfo.setAuthors(authors);

        volumeInfo.setPublisher("Andrei");

        volumeInfo.setDescription("Hello world!");

        List<String> categories = new ArrayList<>();
        categories.add("ChingChang");
        categories.add("Buzdugan");
        categories.add("BadabumChaCha!");
        volumeInfo.setCategories(categories);

        volumeInfo.getImageLinks().setThumbnail("https://www.svgrepo.com/show/354380/spring-icon.svg");
        volumeInfo.getImageLinks().setSmallThumbnail("https://www.svgrepo.com/show/354380/spring-icon.svg");

        volumeInfo.setLanguage("English");
        volumeInfo.setAverageRating(5D);
        volumeInfo.setRatingsCount(100L);

        return ResponseEntity.ok(bookInfo);
    }

}
