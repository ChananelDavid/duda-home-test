package com.duda.home.test.api;

import com.duda.home.test.model.Pupil;
import com.duda.home.test.repository.PupilRepository;
import com.duda.home.test.repository.SchoolRepository;
import com.duda.home.test.util.Haversine;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-27T21:14:28.877Z")

@Controller
public class EnrollApiController implements EnrollApi {

    private static final Logger log = LoggerFactory.getLogger(EnrollApiController.class);

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private PupilRepository pupilRepository;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public EnrollApiController(HttpServletRequest request) {
        this.request = request;
    }

    public ResponseEntity<Void> enrollPupilIdPost(@ApiParam(value = "ID of pet to return", required = true) @PathVariable("pupilId") Long pupilId) {
        if (!pupilRepository.existsById(pupilId)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Pupil pupil = pupilRepository.getOne(pupilId);
        schoolRepository.findAll().stream()
                .filter(school -> school.getMinimumGpa() <= pupil.getGrades().getGrade())
                .filter(school -> school.getMaxNumberOfPupils() >= school.getCurrentNumberOfPupils())
                .max(Comparator.comparingDouble(school -> school.getFriendsInSchool() / Haversine.distance(school.getLat(), school.getLon(), pupil.getLat(), pupil.getLon())))
                .ifPresent(school -> school.addPupil(pupilId));

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
