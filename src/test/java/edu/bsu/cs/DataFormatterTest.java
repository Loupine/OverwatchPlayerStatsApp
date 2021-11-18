package edu.bsu.cs;

import edu.bsu.cs.Model.DataFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataFormatterTest {
    DataFormatter dataFormatter = new DataFormatter();

    @Test
    public void testFormatRank(){
        Assertions.assertEquals("Platinum", dataFormatter.formatRank("2785"));
    }
}
