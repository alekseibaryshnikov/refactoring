package com.ebayk;

import com.ebayk.data.user.User;
import com.ebayk.service.RatingAnalyzer;
import java.util.List;

import com.ebayk.service.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/{id}")
public class UserController {

  @RequestMapping("/rated-users")
  public List<User> listAd(@PathVariable("id") Integer userId) throws UserNotFoundException {
    return RatingAnalyzer.getRatedUserForRatingCreator(userId);
  }

}
