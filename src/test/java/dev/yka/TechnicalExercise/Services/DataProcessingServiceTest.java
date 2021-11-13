package dev.yka.TechnicalExercise.Services;

import dev.yka.TechnicalExercise.Models.DataEntry;
import dev.yka.TechnicalExercise.Models.Resident;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
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
    Resident resident1;

    @BeforeEach
    public void dataSetup() {
        listOfDataEntries = new ArrayList<>();
        resident1 = new Resident("Fred","Smith","M",LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));
        listOfDataEntries.add(new DataEntry(resident1.getFirstName(),resident1.getSurname(),"Customs House","1 Long Street","Glasgow","Glasgow","G10","UK",resident1.getGender(),resident1.getDateOfBirth()));
    }

    @Test
    public void returnsProcessedDataObject() {
        Assertions.assertTrue(listOfDataEntries.size() > 0);
        Assertions.assertNotNull(dataProcessingService.processData(listOfDataEntries));
    }

    @Test
    public void assignsResidentToAddress() {
        Assertions.assertTrue(new ReflectionEquals(dataProcessingService.processData(listOfDataEntries).get(0).getResident()).matches(resident1));
    }
}