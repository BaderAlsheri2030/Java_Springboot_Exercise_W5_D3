package com.example.articlesmanager.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

@Data
@AllArgsConstructor
public class NewsArticle {
    @NotNull(message = "id cannot be null")
    private String id;
    @NotNull(message = "title cannot be null")
    @Length(max = 100, message = "max character is 100")
    private String title;
    @NotNull(message = "author cannot be null")
    @Size(max = 20, min = 4,message = "must be more than 4 characters and less than 20")
    private String author;
    @NotNull(message = "content cannot be null")
    @Size(min = 200, message = "content must be more than 200 characters")
    private String content;
    @NotNull(message = "category cannot be null")
    @Pattern(regexp = "politics|sports|technology", message = "category must be either (politics) or (sports)or (technology)")
    private String category;
    @NotNull(message = "Image url cannot be null")
    private String imageUrl;
    @AssertFalse(message = "ispublished must be set to false")
    private boolean isPublished;
    @JsonFormat(pattern ="yyyy-mm-dd hh:mm")
    private LocalDateTime publishDate;


}
