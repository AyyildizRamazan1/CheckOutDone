package com.ramazanayyildiz.CheckOutDone.controller;

import com.ramazanayyildiz.CheckOutDone.dto.UsersDto;
import com.ramazanayyildiz.CheckOutDone.entity.Users;
import com.ramazanayyildiz.CheckOutDone.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("check/users")// http://localhost:8080/check/users
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping()
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> usersList = usersService.getAllUsers();
        return ResponseEntity.ok(usersList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(usersService.findUser(id));
    }

    @PostMapping("/save")
    public ResponseEntity<UsersDto> createUser(@RequestBody Users users) {//RequestBody gelen json verisini Java nesnesine çevirir
        UsersDto createdUserDto = usersService.createUser(users);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);//Role kontrol yapılacak
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersDto> updateUser(@PathVariable("id") Integer userId, @RequestBody UsersDto usersDto) {
        UsersDto updatedUser = usersService.updateUser(userId, usersDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }


}
