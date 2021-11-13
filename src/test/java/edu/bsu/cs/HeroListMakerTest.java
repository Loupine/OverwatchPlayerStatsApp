package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HeroListMakerTest {
    private final InputStream dataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("LoupineData.txt");
    private Parser parser;

    @BeforeEach
    public void setup() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        assert dataStream != null;
        dataStream.transferTo(byteArrayOutputStream);

        String testData = byteArrayOutputStream.toString();
        this.parser = new Parser(testData);
    }

    @Test
    public void testAccessCompetitiveHeroList() {
        HeroListMaker heroListMaker = new HeroListMaker(parser);
        StringBuilder heroNames = new StringBuilder();
        for(Hero hero: heroListMaker.accessCompetitiveHeroList()){
            heroNames.append(hero.accessHeroName());
        }
        Assertions.assertEquals("ashe cassidy hanzo reaper soldier76 symmetra tracer",
                heroNames.toString());
    }
}
