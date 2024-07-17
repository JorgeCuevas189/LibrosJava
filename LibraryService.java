package com.example.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private GutenbergService gutenbergService;

    public List<GutenbergService.GutenbergBook> searchBookByTitle(String title) {
        return gutenbergService.searchBooks(title);
    }
}
