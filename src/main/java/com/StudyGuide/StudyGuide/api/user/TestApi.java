package com.StudyGuide.StudyGuide.api.user;
import com.StudyGuide.StudyGuide.dao.model.entity.test.Test;
import com.StudyGuide.StudyGuide.dto.test.TestDto;
import com.StudyGuide.StudyGuide.dto.user.UserDto;
import com.StudyGuide.StudyGuide.service.test.TestService;
import com.StudyGuide.StudyGuide.utility.HeaderUtil;
import com.sun.mail.iap.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/test")
public class TestApi {
    @Autowired
    private TestService testService;

    @CrossOrigin
    @PostMapping(value="",produces = "application/json")
    @ApiOperation(value="create test")
    @ApiResponses(value={
            @ApiResponse(code=200, message="Successfully create a test", response = TestDto.class),
            @ApiResponse(code=400, message = "Failed to create a test")
    })
    public ResponseEntity<TestDto> addTest(@RequestBody TestDto testDto){
        try{
            return new ResponseEntity<>(testService.createTest(testDto), HttpStatus.OK);
        }catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(testDto, HttpStatus.BAD_REQUEST);
        }
    }
    @CrossOrigin
    @GetMapping(value="/getAll", produces="application/json")
    @ApiOperation(value="gets all the test")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Successfully retrieved all the tests "),
            @ApiResponse(code=400, message="unable to retrieve tests ")})
    public ResponseEntity<List<TestDto>> getTests(@RequestParam("userId") Long userId){
        try{

            return new ResponseEntity<>(testService.getAll(userId), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @CrossOrigin
    @DeleteMapping(value="/delete",produces = "application/json")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Successfully deleted a test"),
            @ApiResponse(code=400, message = "failed to remove a test")
    })
    public ResponseEntity<Object> deleteTest(@RequestParam Long testId){
        try{testService.delete(testId);
            return ResponseEntity.accepted().headers(HeaderUtil.createEntityDeletionAlert("Test","Delete Test")).body(null);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }



}
