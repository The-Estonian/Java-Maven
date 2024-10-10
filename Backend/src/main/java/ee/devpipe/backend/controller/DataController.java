package ee.devpipe.backend.controller;

import ee.devpipe.backend.model.Data;
import ee.devpipe.backend.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
@CrossOrigin(origins = "localhost:3000")
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @PostMapping
    public String saveData(@RequestBody Data data) {
        dataRepository.save(data);
        return "Data saved!!";
    }

    @GetMapping
    public List<Data> getAllData() {
        return dataRepository.findAll();
    }
}
