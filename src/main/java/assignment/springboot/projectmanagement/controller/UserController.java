package assignment.springboot.projectmanagement.controller;

import assignment.springboot.projectmanagement.entities.Users;
import assignment.springboot.projectmanagement.model.JwtRequestModel;
import assignment.springboot.projectmanagement.model.JwtResponseModel;
import assignment.springboot.projectmanagement.security.TokenManager;
import assignment.springboot.projectmanagement.service.IUserService;
import assignment.springboot.projectmanagement.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import static assignment.springboot.projectmanagement.service.UsersService.createUserDetails;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenManager tokenManager;

    @PostMapping("/login")
    public ResponseEntity createToken(@RequestBody JwtRequestModel request) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final Users user = userService.getUser(request.getUsername()).get();
        final String jwtToken = tokenManager.generateJwtToken(createUserDetails(user.getUserName(), user.getPassword()));
        return ResponseEntity.ok(new JwtResponseModel(jwtToken, user.getNickName(), user.getId()));
    }
}
