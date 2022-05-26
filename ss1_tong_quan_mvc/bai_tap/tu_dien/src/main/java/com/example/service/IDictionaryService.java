package com.example.service;


import org.springframework.stereotype.Service;

@Service
public interface IDictionaryService {
    String search(String word);
}
