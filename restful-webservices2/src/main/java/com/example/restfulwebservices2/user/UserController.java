package com.example.restfulwebservices2.user;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

// Q.4 Create GET Method to fetch the list of users in XML format.
    @GetMapping(value = "/users", produces = "application/xml")
    @ApiOperation(value = "GET users", notes = "Get all user details")
    List<User> retrieveAllUsers() {
        return userService.getAllUsers();
    }
//Q.11 Configure hateoas with your spring boot application.
// Create an api which returns User Details along with url to show all topics.
    @GetMapping("/users/{id}")
    @ApiOperation(value = "User details", notes = "Get user details by id")
    EntityModel<User> getOne(@PathVariable int id) {

        User user = userService.getUserById(id);
        if (user == null) {
            throw new UserNotFoundException("id - " + id);
        }
        EntityModel<User> resource = EntityModel.of(user);
        Link linkTo = linkTo(methodOn(getClass()).retrieveAllUsers()).withRel("get-all-users");
        resource.add(linkTo);

        return resource;
    }
//   Q.3 Create POST Method to create user details which can accept XML for user creation.
    @PostMapping(value = "/users", consumes = "application/xml")
    @ApiOperation(value = "create user", notes = "create user using xml format")
    ResponseEntity<Object> saveUser(@RequestBody User user) {

        userService.addUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("users/{id}")
    @ApiOperation(value = "Delete user", notes = "Delete user using id path variable")
    User deleteUserById(@PathVariable int id) {
        User user = userService.deleteUser(id);

        if (user == null)
            throw new UserNotFoundException("Id - " + id);
        return user;
    }

}
