package com.duda.home.test.api;

import com.duda.home.test.repository.PupilRepository;
import com.duda.home.test.repository.SchoolRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-28T20:50:30.805Z")

@Controller
public class MapDataApiController implements MapDataApi {

    private static final Logger log = LoggerFactory.getLogger(MapDataApiController.class);

    @Autowired
    private PupilRepository pupilRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    public ResponseEntity<String> mapDataGet() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n" +
                "\"type\": \"FeatureCollection\",\n" +
                "\"features\": [ ");

        pupilRepository.findAll().forEach(pupil -> {
            sb.append("{\n" +
                    "\"type\": \"Feature\",\n" +
                    "\"geometry\": {\n" +
                    "\"type\": \"Point\",\n" +
                    "\"coordinates\": [ ")
                    .append(pupil.getLon())
                    .append(", ")
                    .append(pupil.getLat())
                    .append("]\n" +
                            "},\n" +
                            "\"properties\": {\n" +
                            "\"title\": \"Pupil\",\n" +
                            "\"icon\": \"man\"\n" +
                            "}\n" +
                            "},");
        });

        schoolRepository.findAll().forEach(school -> {
            sb.append("{\n" +
                    "\"type\": \"Feature\",\n" +
                    "\"geometry\": {\n" +
                    "\"type\": \"Point\",\n" +
                    "\"coordinates\": [")
                    .append(school.getLon())
                    .append(", ")
                    .append(school.getLat())
                    .append("]\n" +
                            "},\n" +
                            "\"properties\": {\n" +
                            "\"title\": \"School\",\n" +
                            "\"icon\": \"school\"\n" +
                            "}\n" +
                            "},");
        });
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]\n" +
                "}\n");
        return ResponseEntity.ok().body(sb.toString());
    }

}
