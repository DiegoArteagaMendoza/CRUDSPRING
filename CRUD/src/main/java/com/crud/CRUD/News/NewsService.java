package com.crud.CRUD.News;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public void createNew(News news) {
        if (news != null) {
            newsRepository.save(news);
        } else {
            System.out.println("Error al crear la noticia");
        }
    }

    public List<News> findAllNews() {
        return newsRepository.findAll();
    }

    public Optional<News> findNewsById(int id) {
        return newsRepository.findById(id);
    }

    public boolean deleteNews(int id) {
        if (newsRepository.existsById(id)) {
            newsRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public News updateTitulo(int id, String newTitulo) {
        return newsRepository.findById(id).map(news -> {
            news.setTitulo(newTitulo);
            return newsRepository.save(news);
        }).orElseThrow(() -> new RuntimeException("Noticia no encontrada" + id));
    }

}
