package com.example.articlesmanager.Service;

import com.example.articlesmanager.Model.NewsArticle;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class NewsArticleService {

    ArrayList<NewsArticle> articles = new ArrayList<>();
    ArrayList<NewsArticle> publishedArticles = new ArrayList<>();

    public ArrayList<NewsArticle> getArticles(){
        return articles;
    }

    public void addArticle(NewsArticle article){
        articles.add(article);
    }

    public boolean deleteArticle(String id){
        for (int i = 0; i <articles.size() ; i++) {
            if (articles.get(i).getId().equals(id)){
                articles.remove(i);
                return true;
            }
        }
        return false;
    }


    public boolean updateArticle(String id, NewsArticle article){
        for (int i = 0; i <articles.size() ; i++) {
            if (articles.get(i).getId().equals(id)){
                articles.set(i,article);
                return true;
            }
        }
        return false;
    }

    public boolean publishArticle(String id){
        for (NewsArticle n: articles) {
            if (n.getId().equals(id)){
                n.setPublished(true);
                n.setPublishDate(LocalDateTime.now());
                publishedArticles.add(n);
            return true;
            }
        }
        return false;
    }
    public ArrayList<NewsArticle> getPublishedArticles(){
        return publishedArticles;
    }
    public ArrayList<NewsArticle> searchByCategory(String category){
        ArrayList<NewsArticle> articlesByCategory = new ArrayList<>();
        for (NewsArticle article: articles) {
            if(article.getCategory().equalsIgnoreCase(category)){
                articlesByCategory.add(article);
            }
        }
        return articlesByCategory;
    }








}
