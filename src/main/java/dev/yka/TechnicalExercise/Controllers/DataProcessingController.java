package dev.yka.TechnicalExercise.Controllers;

import dev.yka.TechnicalExercise.Models.DataEntry;
import dev.yka.TechnicalExercise.Models.DataProcessingFilter;
import dev.yka.TechnicalExercise.Models.ProcessedData;
import dev.yka.TechnicalExercise.Services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("data-processing")
public class DataProcessingController {

    @Autowired
    DataProcessingService dataProcessingService;

    @PostMapping(value = "/process-data", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProcessedData>> processData(@RequestBody List<DataEntry> dataEntry,
                                                           @Nullable @RequestParam String sortType,
                                                           @Nullable @RequestParam String filterType,
                                                           @Nullable @RequestParam String filterComparator,
                                                           @Nullable @RequestParam String filterCriteria) {
        return ResponseEntity.ok(dataProcessingService.processData(dataEntry, sortType, new DataProcessingFilter(filterType,filterComparator,filterCriteria)));
    }
}
