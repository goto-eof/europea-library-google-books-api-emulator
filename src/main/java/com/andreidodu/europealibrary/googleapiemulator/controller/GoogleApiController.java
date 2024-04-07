package com.andreidodu.europealibrary.googleapiemulator.controller;

import com.andreidodu.europealibrary.googleapiemulator.configuration.ApplicationConfiguration;
import com.andreidodu.europealibrary.googleapiemulator.dto.ApplicationConfigurationDTO;
import com.andreidodu.europealibrary.googleapiemulator.dto.GoogleBookResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GoogleApiController {

    private final ApplicationConfigurationDTO applicationConfigurationBean;

    @GetMapping
    public ResponseEntity<GoogleBookResponseDTO> retrieveEBookMetaInfo(@RequestParam String q, @RequestParam int maxResults, @RequestParam String key) {
        this.applicationConfigurationBean.setCounter(this.applicationConfigurationBean.getCounter() + 1);
        log.info("counter={}", this.applicationConfigurationBean.getCounter());
        if (this.applicationConfigurationBean.getCounter() > ApplicationConfiguration.MAX_NUMBER_REQUESTS_ALLOWED) {
            this.applicationConfigurationBean.setCounter(0);
            log.info("KO");
            return ResponseEntity.badRequest().build();
        }
        GoogleBookResponseDTO bookInfo = buildBookInfo();
        log.info("OK: {}", bookInfo);
        return ResponseEntity.ok(bookInfo);
    }

    private static GoogleBookResponseDTO buildBookInfo() {
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

        volumeInfo.getImageLinks().setThumbnail("https://act-upload.hoyoverse.com/event-ugc-hoyowiki/2023/12/27/94376896/535398cb0ba01203eb959d029eb28342_552441375921968825.png?x-oss-process=image%2Fformat%2Cwebp");
        volumeInfo.getImageLinks().setSmallThumbnail("https://act-upload.hoyoverse.com/event-ugc-hoyowiki/2023/12/27/94376896/535398cb0ba01203eb959d029eb28342_552441375921968825.png?x-oss-process=image%2Fformat%2Cwebp");

        volumeInfo.setLanguage("English");
        volumeInfo.setAverageRating(5D);
        volumeInfo.setRatingsCount(100L);
        return bookInfo;
    }

}
