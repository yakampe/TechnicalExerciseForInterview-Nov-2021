package dev.yka.TechnicalExercise.Services;

import dev.yka.TechnicalExercise.Models.DataEntry;
import dev.yka.TechnicalExercise.Models.ProcessedData;
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
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class DataProcessingServiceTest {

    @Autowired
    DataProcessingService dataProcessingService;

    List<DataEntry> listOfDataEntries;
    Resident resident1;
    Resident resident2;

    @BeforeEach
    public void dataSetup() {
        listOfDataEntries = new ArrayList<>();
        resident1 = new Resident("Fred","Smith","M",LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));
        resident2 = new Resident("Frog","Shmet","T",LocalDate.parse("2012-01-01", DateTimeFormatter.ISO_DATE));

        listOfDataEntries.add(new DataEntry(resident1.getFirstName(),resident1.getSurname(),"Customs House","1 Long Street","Glasgow","Glasgow","G10","UK",resident1.getGender(),resident1.getDateOfBirth()));
        listOfDataEntries.add(new DataEntry(resident2.getFirstName(),resident2.getSurname(),"Customs House","1 Long Street","Glasgow","Glasgow","G10","UK",resident2.getGender(),resident2.getDateOfBirth()));
        listOfDataEntries.add(new DataEntry(resident2.getFirstName(),resident2.getSurname(),"Residential area","37 Java Street","Chelmsford","Essix","CM2","GB",resident2.getGender(),resident2.getDateOfBirth()));
        listOfDataEntries.add(new DataEntry(resident2.getFirstName(),resident2.getSurname(),"Tea area","341 Java Street","Zyx","Essix","CO3","UK",resident2.getGender(),resident2.getDateOfBirth()));
        listOfDataEntries.add(new DataEntry(resident2.getFirstName(),resident2.getSurname(),"67 TDD Street","","Abc","Essix","CO3 5GE","GB",resident2.getGender(),resident2.getDateOfBirth()));
    }

    @Test
    public void returnsProcessedDataObject() {
        Assertions.assertTrue(listOfDataEntries.size() > 0);
        Assertions.assertNotNull(dataProcessingService.processData(listOfDataEntries, null));
    }

    @Test
    public void assignsResidentToAddress() {
        Assertions.assertTrue(new ReflectionEquals(dataProcessingService.processData(listOfDataEntries, null).get(0).getResidents().get(0)).matches(resident1));
    }

    @Test
    public void assignsMultipleResidentsToSameAddress() {
        List<ProcessedData> processedData = dataProcessingService.processData(listOfDataEntries, null);
        Assertions.assertTrue(new ReflectionEquals(processedData.get(0).getResidents().get(0)).matches(resident1));
        Assertions.assertTrue(new ReflectionEquals(processedData.get(0).getResidents().get(1)).matches(resident2));
        Assertions.assertTrue(processedData.get(0).getResidents().size() > 1);
    }

    @Test
    public void noDuplicates() {
        List<ProcessedData> processedData = dataProcessingService.processData(listOfDataEntries, null);
        Assertions.assertTrue(processedData.stream().filter(i -> Collections.frequency(processedData, i) > 1).collect(Collectors.toList()).size() == 0);
    }

    @Test
    public void sortByCity() {
        List<ProcessedData> processedData = dataProcessingService.processData(listOfDataEntries, "city");
        Assertions.assertEquals("Abc",processedData.get(0).getCity());
        Assertions.assertEquals("Zyx",processedData.get(processedData.size()-1).getCity());
    }

    @Test
    public void sortByAddress1() {
        List<ProcessedData> processedData = dataProcessingService.processData(listOfDataEntries, "address1");
        Assertions.assertEquals("67 TDD Street",processedData.get(0).getAddress1());
        Assertions.assertEquals("Tea area",processedData.get(processedData.size()-1).getAddress1());
    }

    @Test
    public void sortByPostCode() {
        List<ProcessedData> processedData = dataProcessingService.processData(listOfDataEntries, "postcode");
        Assertions.assertEquals("CM2",processedData.get(0).getPostcode());
        Assertions.assertEquals("G10",processedData.get(processedData.size()-1).getPostcode());
    }

}