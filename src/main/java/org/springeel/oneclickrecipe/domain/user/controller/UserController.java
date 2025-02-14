package org.springeel.oneclickrecipe.domain.user.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springeel.oneclickrecipe.domain.user.dto.controller.UserLoginControllerRequestDto;
import org.springeel.oneclickrecipe.domain.user.dto.controller.UserSignUpControllerRequestDto;
import org.springeel.oneclickrecipe.domain.user.dto.service.UserLoginServiceRequestDto;
import org.springeel.oneclickrecipe.domain.user.dto.service.UserSignUpServiceRequestDto;
import org.springeel.oneclickrecipe.domain.user.mapper.dto.UserDtoMapper;
import org.springeel.oneclickrecipe.domain.user.service.LoginServletService;
import org.springeel.oneclickrecipe.domain.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class UserController {

    private final UserDtoMapper userDtoMapper;
    private final UserService userService;
    private final LoginServletService loginServletService;

    @PostMapping("/users/signup")
    public ResponseEntity<Void> singUp(
        @RequestBody UserSignUpControllerRequestDto controllerRequestDto
    ) {
        UserSignUpServiceRequestDto serviceRequestDto = userDtoMapper.toUserSignUpServiceRequestDto(
            controllerRequestDto);
        userService.signUp(serviceRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/users/login")
    public ResponseEntity<Void> login(
        @RequestBody UserLoginControllerRequestDto controllerRequestDto,
        HttpServletResponse httpServletResponse
    ) {
        UserLoginServiceRequestDto serviceRequestDto = userDtoMapper.toUserLoginServiceRequestDto(
            controllerRequestDto);
        userService.login(serviceRequestDto);
        loginServletService.addJwtToHeader(serviceRequestDto, httpServletResponse);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
