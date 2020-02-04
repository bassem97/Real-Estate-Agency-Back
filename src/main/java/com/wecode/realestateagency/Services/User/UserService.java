package com.wecode.realestateagency.Services.User;


import com.wecode.realestateagency.Models.User;
import com.wecode.realestateagency.utill.ChangePasswordVM;

import java.util.List;

public interface UserService {

//    User save(User user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);
    User update(User user);
    User findById(Long id);
    public boolean changePassword(ChangePasswordVM vm, String username);
}