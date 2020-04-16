package com.StudyGuide.StudyGuide.api.user;

import com.StudyGuide.StudyGuide.service.test.AnswerService;
import com.StudyGuide.StudyGuide.utility.HeaderUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/answer")
public class AnswerApi {
    @Autowired
    private AnswerService answerService;

    @CrossOrigin
    @DeleteMapping(value="/delete", produces="application/json")
    @ApiOperation(value="delete an answer from the list")
    @ApiResponses(value={
            @ApiResponse(code=200, message ="Successfully deleted a answer"),
            @ApiResponse(code=400, message="failed to remove a answer")
    })
    public ResponseEntity<Object> deleteAnswer(@RequestParam("answerId") Long answerId){
        try{
            answerService.delete(answerId);
            return ResponseEntity.accepted().headers(HeaderUtil.createEntityUpdateAlert("Answer","Deleted Answer")).body(null);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
