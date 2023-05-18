package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.models.requests.UpdateUserRequest;
import com.openclassrooms.mddapi.models.response.MessageResponse;
import com.openclassrooms.mddapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PutMapping("/api/user/{id}")
    public MessageResponse updateUser(@PathVariable("id") Long id, @RequestBody UpdateUserRequest req) {

        User current_user = userService.findById(id);
        current_user.setEmail(req.getEmail());
        current_user.setUsername(req.getUsername());
        userService.save(current_user);

        return new MessageResponse("User updated with success");
    }

}
