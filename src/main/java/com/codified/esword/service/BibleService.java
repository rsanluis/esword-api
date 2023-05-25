package com.codified.esword.service;

import java.util.List;

import com.codified.esword.model.Bible;

public interface BibleService {
    Bible getVerse(Integer book, Integer chapter, Integer verse);
    List<Bible> getVerses(Integer book, Integer chapter);
    List<Bible> getVerses(Integer book);
    List<Bible> getVerses();
}