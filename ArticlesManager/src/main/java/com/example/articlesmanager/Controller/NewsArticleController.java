package com.example.articlesmanager.Controller;

import com.example.articlesmanager.Model.NewsArticle;
import com.example.articlesmanager.Service.NewsArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/article")
@RequiredArgsConstructor
public class NewsArticleController {

private final NewsArticleService articleService;

@GetMapping("/get")
public ResponseEntity getArticles(){
return ResponseEntity.status(HttpStatus.OK).body(articleService.getArticles());
}

@PostMapping("/add")
public ResponseEntity addArticle(@Valid @RequestBody NewsArticle article, Errors errors){
if (errors.hasErrors()){
    String message = errors.getFieldError().getDefaultMessage();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
}
    articleService.addArticle(article);
    return ResponseEntity.status(HttpStatus.OK).body("Article added");
}

@DeleteMapping("/delete/{id}")
public ResponseEntity deleteArticle(@PathVariable String id){
boolean isDeleted = articleService.deleteArticle(id);
if (isDeleted){
    return ResponseEntity.status(HttpStatus.OK).body("Article is removed");
}
return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id is invalid");
}
@PutMapping("/update/{id}")
public ResponseEntity updateArticle(@PathVariable String id, @Valid @RequestBody NewsArticle article, Errors errors){
if (errors.hasErrors()){
    String message = errors.getFieldError().getDefaultMessage();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
}
boolean isUpdated = articleService.updateArticle(id,article);
if (isUpdated){
return ResponseEntity.status(HttpStatus.OK).body("Article updated");
}
return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID not found");

}

@GetMapping("/publish/{id}")
public ResponseEntity  publishArticle(@PathVariable String id){
    boolean isPublished = articleService.publishArticle(id);
if (isPublished){
return ResponseEntity.status(HttpStatus.OK).body("Article is published");
}
return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID invalid");

}
@GetMapping("/get/published")
public ResponseEntity getPublishedArticles(){
    return ResponseEntity.status(HttpStatus.OK).body(articleService.getPublishedArticles());
}

@GetMapping("/get/category/{category}")
public ResponseEntity searchByCategory(@PathVariable String category){
return ResponseEntity.status(HttpStatus.OK).body(articleService.searchByCategory(category));
}




}
