package com.wecode.realestateagency.Controllers;

import com.wecode.realestateagency.Services.UserServiceDetails;
import com.wecode.realestateagency.security.TokenProvider;
import com.wecode.realestateagency.utill.JwtRespone;
import com.wecode.realestateagency.utill.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    private UserServiceDetails userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginModel loginModel){
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginModel.getUsername(),
                        loginModel.getPassword()
                )
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginModel.getUsername());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = tokenProvider.generateToken(userDetails);
        return ResponseEntity.ok(new JwtRespone(token));
    }

}
