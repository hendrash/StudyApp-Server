package com.StudyGuide.StudyGuide.api.user;

import com.StudyGuide.StudyGuide.dto.test.QuestionsDto;
import com.StudyGuide.StudyGuide.service.test.QuestionService;
import com.StudyGuide.StudyGuide.utility.HeaderUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    @CrossOrigin
    @GetMapping(value="/getAll", produces = "application/json")
    @ApiOperation(value="gets all questions")
    @ApiResponses(value={
            @ApiResponse(code=200, message ="Successfully retrieved all answers" ),
            @ApiResponse(code=400, message = "falied to retrieve answers")
    })
    public ResponseEntity<List<QuestionsDto>> getAll(@RequestParam Long testId){
        try {
            return new ResponseEntity<>(questionService.getAll(testId), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @CrossOrigin
    @DeleteMapping(value = "/delete", produces = "application/json")
    @ApiOperation(value="delete a Question from the list")
    @ApiResponses(value={
            @ApiResponse(code=200, message = "Successfully delete a question"),
            @ApiResponse(code=400, message = "failed to remove question")
    })
    public ResponseEntity<Object> deleteQuestion(@RequestParam Long questionId ){
        try{
            questionService.delete(questionId);
          return  ResponseEntity.accepted().headers(HeaderUtil.createEntityDeletionAlert("Question", "Deleted Question")).body(null);
        }catch(Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @CrossOrigin
    @PutMapping(value="/update", produces="application/json")
    @ApiResponses(value={
            @ApiResponse(code=200, message="Successfully updated a question", response = QuestionsDto.class),
            @ApiResponse(code=400, message="failed to update question")
    })
    public ResponseEntity<QuestionsDto> updateQuestions(@RequestBody QuestionsDto questionDto ){
        try{
            return ResponseEntity.created(new URI("/api/question/update"+questionDto.getQuestionId()))
                    .headers(HeaderUtil.createEntityUpdateAlert("Qusetion", "Update Questions"))
                    .body(questionService.edit(questionDto));
        }catch(Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @CrossOrigin
    @GetMapping(value="/getQuestion", produces = "application/json")
    @ApiResponses(value={
            @ApiResponse(code=200, message = "Successfully retrieved a question", response = QuestionsDto.class),
            @ApiResponse(code=400, message = "failed to retrieve a question")
    })
    public ResponseEntity<QuestionsDto> getQuestion(@RequestParam("questionId") Long questionId){
        try{
            return new ResponseEntity(questionService.getQuestion(questionId), HttpStatus.OK);
        }catch(Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
