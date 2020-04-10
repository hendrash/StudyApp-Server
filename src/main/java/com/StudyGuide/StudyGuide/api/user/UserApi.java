package com.StudyGuide.StudyGuide.api.user;

import com.StudyGuide.StudyGuide.dto.user.UserDto;
import com.StudyGuide.StudyGuide.service.user.UserService;
import com.StudyGuide.StudyGuide.utility.HeaderUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/user")
public class UserApi {
    @Autowired
    private UserService userService;
    @CrossOrigin
    @PostMapping(value="", produces="application/json")
    @ApiOperation(value="creates user")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Successfully created user", response= UserDto.class),
            @ApiResponse(code=400, message="Request not valid")
    })
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        try {
            return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(userDto, HttpStatus.BAD_REQUEST);
        }
        }
        @CrossOrigin
        @GetMapping(value="/getAll", produces="application/json")
        @ApiOperation(value="gets all the users")
        @ApiResponses(value = {
            @ApiResponse(code=200, message="Successfully retrieved all the users "),
            @ApiResponse(code=400, message="unable to retrieve users ")})
        public ResponseEntity<List<UserDto>> getUsers(){
        try{
            return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        }
        @CrossOrigin
        @DeleteMapping(value="/delete", produces="application/json")
        @ApiOperation(value="Delete a User from list")
        @ApiResponses(value={
                @ApiResponse(code=200,message="Successfully deleted a user"),
                @ApiResponse(code=400, message = "failed to remove a user")
        })
        public ResponseEntity<Object> deleteUser(@RequestParam Long userId){
            try{
                userService.delete(userId);
                return ResponseEntity.accepted()
                        .headers(HeaderUtil.createEntityDeletionAlert("User", "delete User")).
                                body(null);
            }catch(Exception e){
                e.printStackTrace();
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }
        @CrossOrigin
        @PutMapping(value="/update", produces = "application/json")
        @ApiOperation(value="update user")
        @ApiResponses(value={
                @ApiResponse(code=200, message="Successfully updated user", response = UserDto.class),
                @ApiResponse(code=400, message="failed to update user")
        })
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto){
        try{
            return ResponseEntity.created(new URI("/api/user/update"+userDto.getUserId()))
                    .headers(HeaderUtil.createEntityUpdateAlert("User","Update User"))
                    .body(userService.edit(userDto));       }
        catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }
}
