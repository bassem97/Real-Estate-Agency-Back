package com.wecode.realestateagency.Services.User;


import com.wecode.realestateagency.Models.Local;
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
    void addLocaltoWishlist(Long idUser, Long idLocal);
    void removeLocalfromWishlist(Long idUser, Long idLocal);
    public boolean changePassword(ChangePasswordVM vm, String username);
}
