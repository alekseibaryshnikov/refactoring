package com.ebayk.service;

import com.ebayk.data.user.User;
import com.ebayk.data.user.UserRepository;
import com.ebayk.service.exceptions.UserNotFoundException;

import java.util.*;

public class RatingAnalyzer {

  public static List<User> getRatedUserForRatingCreator(Integer ratingCreatorId)
          throws UserNotFoundException {
    UserRepository userRepository = new UserRepository();
    User ratingCreator = userRepository.getUser(ratingCreatorId);

    if (ratingCreator == null) throw new UserNotFoundException(ratingCreatorId);

    List<User> userList = new LinkedList<>();
    userRepository.getUsers().forEach(user -> user.getRatings().stream()
            .filter(rating -> rating.getRatingCreatorUserId().equals(ratingCreatorId))
            .findAny()
            .ifPresent(result -> userList.add(user)));
    return userList;
  }
}