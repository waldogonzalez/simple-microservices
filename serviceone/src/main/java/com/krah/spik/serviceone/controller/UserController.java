package com.krah.spik.serviceone.controller;

import com.krah.spik.serviceone.domain.User;
import com.krah.spik.serviceone.dto.UserDto;
import com.krah.spik.serviceone.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private final ProductService productService;
    private final List<User> users = new ArrayList<>();

    public UserController(ProductService productService) {
        this.productService = productService;
        users.add(new User("admin", "admin", 1L));
        users.add(new User("supervisor", "supervisor", 2L));
        users.add(new User("operator", "operator", 3L));
    }

    @GetMapping
    public List<User> getAll() {
        return users;
    }

    @GetMapping("{id}")
    public UserDto getById(@PathVariable Long id) {
        return this.users.stream().filter(user -> user.getId().equals(id)).findFirst().map(user -> {
            Long count = productService.getUserProductCount(id);
            UserDto userDto = new UserDto(count);
            userDto.setId(user.getId());
            userDto.setLogin(user.getLogin());
            userDto.setName(user.getName());
            return userDto;
        }).orElse(null);
    }
}
