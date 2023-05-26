package com.codified.esword.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codified.esword.model.Bible;
import com.codified.esword.model.Details;
import com.codified.esword.service.BibleService;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ESwordBibleController {

    @Autowired
    BibleService bibleService;

    @GetMapping(value = "/verses/{book}")
    @ResponseStatus(HttpStatus.OK)
    public List<Bible> getVerseByBook(
        @Parameter(description = "Book Id") @NotBlank Integer bookId
    ) {
        List<Bible> bibleVerseList = bibleService.getVerses(bookId);
        log.info("numVerses: {}", bibleVerseList.size());
        return bibleVerseList;
    }

    @GetMapping(value = "/verses/{book}/{chapter}")
    @ResponseStatus(HttpStatus.OK)
    public List<Bible> getVerseByBookAndChapter(
        @Parameter(description = "Book Id") @NotBlank Integer bookId,
        @Parameter(description = "Chapter Id") @NotBlank Integer chapterId
    ) {
        List<Bible> bibleVerseList = bibleService.getVerses(bookId, chapterId);
        log.info("numVerses: {}", bibleVerseList.size());
        return bibleVerseList;
    }

    @GetMapping(value = "/verses/{book}/{chapter}/{verse}")
    @ResponseStatus(HttpStatus.OK)
    public Bible getVerseByBookAndChapterAndVerse(
        @Parameter(description = "Book Id") @NotBlank Integer bookId,
        @Parameter(description = "Chapter Id") @NotBlank Integer chapterId,
        @Parameter(description = "Verse Id") @NotBlank Integer verseId
    ) {
        Bible bibleVerse = bibleService.getVerse(bookId, chapterId, verseId);
        log.info("numVerses: {}", (bibleVerse != null) ? 1 : 0);
        return bibleVerse;
    }

    @GetMapping(value = "/details")
    @ResponseStatus(HttpStatus.OK)
    public List<Details> getDetails() {
        return bibleService.getDetails();
    }
}
