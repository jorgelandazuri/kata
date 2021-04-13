package com.jalch.kata.algorithm.lang;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NGramTypeAheadTest {

    private static final String CORPUS_TEXT = "Mary had a little lamb its fleece was white as snow;" +
            "And everywhere that Mary went, the lamb was sure to go. " +
            "It followed her to school one day, which was against the rule;" +
            "It made the children laugh and play, to see a lamb at school." +
            "And so the teacher turned it out, but still it lingered near," +
            "And waited patiently about till Mary did appear." +
            "Why does the lamb love Mary so?\" the eager children cry;" +
            "\"Why, Mary loves the lamb, you know\" the teacher did reply.";

    private NGramTypeAhead underTest = new NGramTypeAhead();

    @Test
    public void invalidInput() {
        String expected = "Cannot predict next word with a unigram or n < 1.";
        assertThat(underTest.getProbableWords(1, "bla bla", CORPUS_TEXT), is(expected));
        expected = "Invalid input text, cannot be null, empty or be just space characters.";
        assertThat(underTest.getProbableWords(1, "", CORPUS_TEXT), is(expected));
        assertThat(underTest.getProbableWords(1, null, CORPUS_TEXT), is(expected));
        assertThat(underTest.getProbableWords(1, "\t\t", CORPUS_TEXT), is(expected));
        assertThat(underTest.getProbableWords(1, " ", CORPUS_TEXT), is(expected));
    }

    @Test
    public void twoGram() {
        String expected = "lamb,0.375;teacher,0.250;children,0.125;eager,0.125;rule,0.125";
        assertThat(underTest.getProbableWords(2, "the", CORPUS_TEXT), is(expected));
        expected = "at,0.200;its,0.200;love,0.200;was,0.200;you,0.200";
        assertThat(underTest.getProbableWords(2, "lamb", CORPUS_TEXT), is(expected));
        assertThat(underTest.getProbableWords(2, " \"lamb.$", CORPUS_TEXT), is(expected));
        expected = "the,1.000";
        assertThat(underTest.getProbableWords(2, "which was against", CORPUS_TEXT), is(expected));
        expected = "did,0.200;had,0.200;loves,0.200;so,0.200;went,0.200";
        assertThat(underTest.getProbableWords(2, "mary", CORPUS_TEXT), is(expected));
        assertThat(underTest.getProbableWords(2, "Mary", CORPUS_TEXT), is(expected));
    }

    @Test
    public void threeGram() {
        String expected = "lamb,0.375;teacher,0.250;children,0.125;eager,0.125;rule,0.125";
        assertThat(underTest.getProbableWords(3, "the", CORPUS_TEXT), is(expected));
        expected = "at,0.200;its,0.200;love,0.200;was,0.200;you,0.200";
        assertThat(underTest.getProbableWords(3, "lamb", CORPUS_TEXT), is(expected));
        assertThat(underTest.getProbableWords(3, " \"lamb.$", CORPUS_TEXT), is(expected));
        expected = "the,1.000";
        assertThat(underTest.getProbableWords(3, "which was against", CORPUS_TEXT), is(expected));
        expected = "did,0.222;loves,0.222;so,0.222;went,0.222;had,0.111";
        assertThat(underTest.getProbableWords(3, "mary", CORPUS_TEXT), is(expected));
        assertThat(underTest.getProbableWords(3, "Mary", CORPUS_TEXT), is(expected));
        expected = "a,1.000";
        assertThat(underTest.getProbableWords(3, "mary had", CORPUS_TEXT), is(expected));
        expected = "a,1.000";
        assertThat(underTest.getProbableWords(3, "mary had", CORPUS_TEXT), is(expected));

    }

}