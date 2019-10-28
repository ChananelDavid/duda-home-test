/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.9).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.duda.home.test.api;

import com.duda.home.test.model.Pupil;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-27T23:29:56.092Z")

@Api(value = "pupil", description = "the pupil API")
public interface PupilApi {

    @ApiOperation(value = "Add a new pet to the store", nickname = "pupilPost", notes = "", response = Long.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "OK", response = Long.class),
            @ApiResponse(code = 405, message = "Invalid input")})
    @RequestMapping(value = "/pupil",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Long> pupilPost(@ApiParam(value = "Pet object that needs to be added to the store", required = true) @Valid @RequestBody Pupil body);

}
