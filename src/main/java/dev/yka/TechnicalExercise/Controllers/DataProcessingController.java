package dev.yka.TechnicalExercise.Controllers;

import dev.yka.TechnicalExercise.Models.DataEntry;
import dev.yka.TechnicalExercise.Services.DataProcessingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("data-processing")
public class DataProcessingController {

    @GetMapping("/process-google-data")
    public ResponseEntity<List<DataEntry>> processData() {
        return new ResponseEntity<List<DataEntry>>(DataProcessingService.processData(), HttpStatus.OK);
    }
}
