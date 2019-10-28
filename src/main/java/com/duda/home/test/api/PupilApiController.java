package com.duda.home.test.api;

import com.duda.home.test.model.Pupil;
import com.duda.home.test.repository.PupilRepository;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-27T23:29:56.092Z")

@Controller
public class PupilApiController implements PupilApi {

    private static final Logger log = LoggerFactory.getLogger(PupilApiController.class);

    @Autowired
    private PupilRepository pupilRepository;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PupilApiController(HttpServletRequest request) {
        this.request = request;
    }

    public ResponseEntity<Long> pupilPost(@ApiParam(value = "Pet object that needs to be added to the store", required = true) @Valid @RequestBody Pupil body) {

        Pupil pupil = pupilRepository.save(body);
        return ResponseEntity.ok().body(pupil.getId());
    }

}
