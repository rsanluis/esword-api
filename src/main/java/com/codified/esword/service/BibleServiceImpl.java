package com.codified.esword.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codified.esword.model.Bible;
import com.codified.esword.model.Details;
import com.codified.esword.model.ScriptureId;
import com.codified.esword.repository.BibleRepository;
import com.codified.esword.repository.DetailsRepository;

@Service
public class BibleServiceImpl implements BibleService {

    @Autowired
    BibleRepository bibleRepository;

	@Autowired
	DetailsRepository detailsRepository;

	@Override
	public Bible getVerse(Integer book, Integer chapter, Integer verse) {
		return bibleRepository.getByScriptureId(new ScriptureId(book, chapter, verse));
	}

	@Override
	public List<Bible> getVerses(Integer book, Integer chapter) {
		return bibleRepository.getByBookIdAndChapterId(book, chapter);
	}

	@Override
	public List<Bible> getVerses(Integer book) {
		return bibleRepository.getByBookId(book);
	}

	@Override
	public List<Bible> getVerses() {
		return bibleRepository.findAll();
	}

	@Override
	public List<Details> getDetails() {
		return detailsRepository.findAll();
	}
}
