package com.wecode.realestateagency.Controllers;

import com.wecode.realestateagency.Models.Local;
import com.wecode.realestateagency.Models.User;
import com.wecode.realestateagency.Services.Local.LocalService;
import com.wecode.realestateagency.Services.User.UserService;
import com.wecode.realestateagency.utill.ChangePasswordVM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("list")
    public List<User> getAllUsers(){ return userService.findAll(); }


    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") Long id){
        //return modelMapper.map(userService.findById(id),UserDto.class);
        return userService.findById(id);
    }

    @RequestMapping(value = "/addLocalToWishlist/{idUser}/{idLocal}", method = RequestMethod.POST)
    public void addLocalToWishlist(@PathVariable(value = "idUser") Long idUser,@PathVariable(value = "idLocal") Long idLocal){
          userService.addLocaltoWishlist(idUser,idLocal);
    }

    @RequestMapping(value = "/removeLocalFromWishlist/{idUser}/{idLocal}", method = RequestMethod.POST)
    public void removeLocalFromWishlist(@PathVariable(value = "idUser") Long idUser,@PathVariable(value = "idLocal") Long idLocal){
         userService.removeLocalfromWishlist(idUser,idLocal);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public User getUserByAuth() {
        return userService.findOne(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
         userService.delete(id);
    }

    @RequestMapping(value="/update", method = RequestMethod.PUT)
    public User modifyUser(@RequestBody User user){
       return userService.update(user);
    }
    @RequestMapping(value = "password/{username}", method = RequestMethod.POST)
    public Boolean changePassword(@RequestBody ChangePasswordVM user, @PathVariable(value = "username") String username){
        return userService.changePassword(user, username);
    }
    @RequestMapping(value = "/userByUsername/{username}", method = RequestMethod.GET)
    public User findByUsername(@PathVariable(value = "username") String us){
        return userService.findOne(us);
    }


}
