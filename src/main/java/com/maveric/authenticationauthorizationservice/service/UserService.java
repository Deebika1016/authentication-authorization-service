package com.maveric.authenticationauthorizationservice.service;

import com.maveric.authenticationauthorizationservice.constants.Type;
import com.maveric.authenticationauthorizationservice.dto.AuthResponseDto;
import com.maveric.authenticationauthorizationservice.dto.UserDetailsDto;
import com.maveric.authenticationauthorizationservice.exceptions.UserNotFoundException;
import com.maveric.authenticationauthorizationservice.feignconsumer.UserServiceConsumer;
import com.maveric.authenticationauthorizationservice.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.maveric.authenticationauthorizationservice.constants.Constants.USER_NOT_FOUND_MESSAGE;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserServiceConsumer userServiceConsumer;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        ResponseEntity<UserDetailsDto> userDetailsDto = userServiceConsumer.getUserDetailsByEmail(email);
        System.out.println(userDetailsDto.getBody());
        System.out.println(userDetailsDto.getBody().getEmail());
        System.out.println(userDetailsDto.getBody().getPassword());
        try {
            if(userDetailsDto.getBody()!=null)
            {

                return new UserPrincipal(userDetailsDto.getBody());
            }
            else {

                throw new UserNotFoundException(USER_NOT_FOUND_MESSAGE+email);
            }
        }
        catch(UserNotFoundException ex)
        {

            throw new UserNotFoundException(USER_NOT_FOUND_MESSAGE+email);
        }
    }
}
