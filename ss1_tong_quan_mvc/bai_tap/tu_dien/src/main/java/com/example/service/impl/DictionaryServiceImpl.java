package com.example.service.impl;

import com.example.repository.IDictionaryRepository;
import com.example.repository.impl.DictionaryRepositoryImpl;
import com.example.service.IDictionaryService;
import org.springframework.stereotype.Service;


@Service
public class DictionaryServiceImpl implements IDictionaryService {
    IDictionaryRepository iDictionaryRepository = new DictionaryRepositoryImpl();


    @Override
    public String search(String word) {
        return iDictionaryRepository.search(word);
    }
}
