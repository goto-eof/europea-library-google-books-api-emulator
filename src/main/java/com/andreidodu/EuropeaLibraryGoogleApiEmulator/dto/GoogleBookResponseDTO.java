package com.andreidodu.EuropeaLibraryGoogleApiEmulator.dto;

import ch.qos.logback.core.util.COWArrayList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class GoogleBookResponseDTO {
    private String kind;
    private int totalItems;
    List<GoogleBookItemDTO> items = new ArrayList<>();

    @Getter
    @Setter
    @ToString
    public static class GoogleBookItemDTO {

        private String kind;
        private VolumeInfoDTO volumeInfo = new VolumeInfoDTO();


        @Getter
        @Setter
        @ToString
        public static class VolumeInfoDTO {
            private String title;
            private List<String> authors = new ArrayList<>();
            private String publisher;
            private String publishedDate;
            private String description;
            private List<IndustryIdentifierDTO> industryIdentifiers = new ArrayList<>();
            private Integer pageCount;
            private List<String> categories = new ArrayList<>();
            private Double averageRating;
            private Long ratingsCount;
            private String language;
            private ImageLinksDTO imageLinks = new ImageLinksDTO();

            @Getter
            @Setter
            @ToString
            public static class IndustryIdentifierDTO {
                private String type;
                private String identifier;
            }

            @Getter
            @Setter
            public static class ImageLinksDTO {
                private String smallThumbnail;
                private String thumbnail;
            }
        }
    }
}
