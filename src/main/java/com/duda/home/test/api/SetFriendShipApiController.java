package com.duda.home.test.api;

import com.duda.home.test.repository.SchoolRepository;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-27T21:14:28.877Z")

@Controller
public class SetFriendShipApiController implements SetFriendShipApi {

    private static final Logger log = LoggerFactory.getLogger(SetFriendShipApiController.class);

    @Autowired
    private SchoolRepository schoolRepository;

    public ResponseEntity<Void> setFriendShipFirstPupilIdSecondPupilIdPost(@ApiParam(value = "ID of pet to return", required = true) @PathVariable("firstPupilId") Long firstPupilId, @ApiParam(value = "ID of pet to return", required = true) @PathVariable("secondPupilId") Long secondPupilId) {

        schoolRepository.findAll().forEach(school -> {
            if (school.addFriends(firstPupilId, secondPupilId)) {
                return;
            }
        });

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
