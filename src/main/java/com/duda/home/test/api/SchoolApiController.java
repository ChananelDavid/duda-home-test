package com.duda.home.test.api;

import com.duda.home.test.model.School;
import com.duda.home.test.repository.SchoolRepository;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-27T23:29:56.092Z")

@Controller
public class SchoolApiController implements SchoolApi {

    private static final Logger log = LoggerFactory.getLogger(SchoolApiController.class);

    @Autowired
    private SchoolRepository schoolRepository;

    public ResponseEntity<Long> schoolPost(@ApiParam(value = "Pet object that needs to be added to the store", required = true) @Valid @RequestBody School body) {
        School school = schoolRepository.save(body);
        return ResponseEntity.ok().body(school.getId());
    }

}
