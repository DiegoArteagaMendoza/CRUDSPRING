package com.crud.CRUD.News;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    // crear noticias
    @PostMapping("/create")
    public void createNew(@RequestBody News news) {
        newsService.createNew(news);
    }

    // buscar noticia
    @GetMapping("/search")
    public List<News> findAllNews() {
        return newsService.findAllNews();
    }

    // modificar titular noticia por id
    @PutMapping("/updateTitular/{id}")
    public ResponseEntity<News> updateTitular(@PathVariable int id, @RequestBody String newTitulo) {
        try {
            News updatedNews = newsService.updateTitulo(id, newTitulo);
            return ResponseEntity.ok(updatedNews);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    // eliminar noticia
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNew(@PathVariable int id) {
        boolean isDeleted = newsService.deleteNews(id);
        if (isDeleted) {
            return ResponseEntity.ok("Noticia eliminada exitosamente");
        } else {
            return ResponseEntity.status(404).body("Noticia no encontrada");
        }
    }
}
