package dev.yka.TechnicalExercise.Services;

import dev.yka.TechnicalExercise.Models.DataEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DataProcessingServiceTest {

    @Autowired
    DataProcessingService dataProcessingService;

    List<DataEntry> listOfDataEntries;

    @BeforeEach
    public void dataSetup() {
        listOfDataEntries = new ArrayList<>();
        listOfDataEntries.add(new DataEntry("Fred","Smith","Customs House","1 Long Street","Glasgow","Glasgow","G10","UK","M",LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE)));
    }

    @Test
    public void returnsProcessedDataObject() {
        Assertions.assertTrue(listOfDataEntries.size() > 0);
        Assertions.assertNotNull(dataProcessingService.processData(listOfDataEntries));
    }
}