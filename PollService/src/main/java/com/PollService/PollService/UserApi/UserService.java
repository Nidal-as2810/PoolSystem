package com.PollService.PollService.UserApi;

import com.PollService.PollService.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "UserApi",
        url = "http://localhost:8082"
)
public interface UserService {
    @GetMapping(value = "/user/{userId}")
    User getUserById(@PathVariable Long userId);

    @GetMapping(value = "/user")
    User getUserByEmail(@RequestParam String email);
}
