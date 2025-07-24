package com.ramazanayyildiz.CheckOutDone.service;

import com.ramazanayyildiz.CheckOutDone.dto.UsersDto;
import com.ramazanayyildiz.CheckOutDone.entity.Users;
import com.ramazanayyildiz.CheckOutDone.exception.GeneralException;
import com.ramazanayyildiz.CheckOutDone.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private IUsersRepository iUsersRepository;

    public List<Users> getAllUsers() {
        return iUsersRepository.findAll();
    }


    public UsersDto createUser(Users users) {
        Users savedUser = iUsersRepository.save(users);
        return new UsersDto(savedUser);
    }

    public Users findUser(Integer id) {
        return iUsersRepository.findById(id)
                .orElseThrow(() -> new GeneralException(id + " Id numaralı kullanıcı bulunamadı!"));
    }


    public UsersDto updateUser(Integer userId, UsersDto usersDto) {
        Users existingUser = iUsersRepository.findById(userId)
                .orElseThrow(() -> new GeneralException(userId + " Id numaralı kullanıcı bulunamadı!"));

        existingUser.setUserName(usersDto.getUserName());
        existingUser.setRole(usersDto.getRole());

        Users updatedUser = iUsersRepository.save(existingUser);

        return new UsersDto(updatedUser);
    }
}
