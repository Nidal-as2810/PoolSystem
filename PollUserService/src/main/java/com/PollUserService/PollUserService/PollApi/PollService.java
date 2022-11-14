package com.PollUserService.PollUserService.PollApi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "PollApi",
        url = "http://localhost:8081"
)
public interface PollService {
    @DeleteMapping(value = "/user-answer/delete-answers/{userId}")
    void deleteUserAnswersByUserId(@PathVariable Long userId);
}
