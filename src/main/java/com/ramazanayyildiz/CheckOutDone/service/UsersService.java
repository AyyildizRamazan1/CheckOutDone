package com.ramazanayyildiz.CheckOutDone.service;

import com.ramazanayyildiz.CheckOutDone.dto.UsersDto;
import com.ramazanayyildiz.CheckOutDone.entity.Users;
import com.ramazanayyildiz.CheckOutDone.exception.GeneralException;
import com.ramazanayyildiz.CheckOutDone.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    private IUsersRepository iUsersRepository;

    public List<UsersDto> getAllUsers() {
        List<Users> users = iUsersRepository.findAll();
        return users.stream()
                .map(UsersDto::new)
                .collect(Collectors.toList());
    }

    public UsersDto createUser(Users users) {
        Users savedUser = iUsersRepository.save(users);
        return new UsersDto(savedUser);
    }

    public UsersDto findUser(Integer id) {
        Users user = iUsersRepository.findById(id).orElseThrow(() -> new GeneralException("Kullanıcı bulunamadı!!!"));
        return new UsersDto(user);
    }


    public UsersDto updateUser(Integer userId, UsersDto usersDto) {
        Users existingUser = iUsersRepository.findById(userId)
                .orElseThrow(() -> new GeneralException(userId + " Id numaralı kullanıcı bulunamadı!"));

        existingUser.setUserName(usersDto.getUserName());
        existingUser.setRole(usersDto.getRole());

        Users updatedUser = iUsersRepository.save(existingUser);

        return new UsersDto(updatedUser);
    }

    public String deleteUserById(Integer id) {
        Optional<Users> users = iUsersRepository.findById(id);
        if (users.isPresent()) {
            iUsersRepository.deleteById(id);
            return "Kullanıcı Başarılı Şekilde Silindi";
        }
        return "Kullanıcı Bulunamadı !!!";
    }
}
