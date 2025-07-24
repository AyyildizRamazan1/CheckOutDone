package com.ramazanayyildiz.CheckOutDone.dto;

import com.ramazanayyildiz.CheckOutDone.entity.Users;
import com.ramazanayyildiz.CheckOutDone.entity.enums.Role;
import lombok.Data;

@Data
public class UsersDto {

    private int userId;

    private String userName;

    private Role role;

    public UsersDto(Users users) {
        this.userId = users.getUserId();
        this.userName = users.getUserName();
        this.role = users.getRole();

    }

    public UsersDto() {
    }
}
