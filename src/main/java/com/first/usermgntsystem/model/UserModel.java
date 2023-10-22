package com.first.usermgntsystem.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

        private long id;
        private String userName;
        private String userLastname;
        private String userEmail;

}
