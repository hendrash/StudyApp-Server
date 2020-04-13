package com.StudyGuide.StudyGuide.api.user;

import com.StudyGuide.StudyGuide.dto.test.QuestionsDto;
import com.StudyGuide.StudyGuide.service.test.QuestionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/question")
public class QuestionApi {
    @Autowired
    private QuestionService questionService;

    @CrossOrigin
    @PostMapping(value="",produces = "application/json")
    @ApiOperation(value="create question")
    @ApiResponses(value={
            @ApiResponse(code=200, message="Successfully created questions", response = QuestionsDto.class),
            @ApiResponse(code=400,message = "Request not valid")
    })
    public ResponseEntity<QuestionsDto> addQuestion(@RequestBody QuestionsDto questionsDto){
        try{
            return new ResponseEntity<>(questionService.create(questionsDto), HttpStatus.OK);     
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(questionsDto, HttpStatus.BAD_REQUEST);
        }
    }
}
