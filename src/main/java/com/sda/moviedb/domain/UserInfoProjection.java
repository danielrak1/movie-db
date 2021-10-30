package com.sda.moviedb.domain;

public interface UserInfoProjection {

    String getUserName();
    String getEmail();
    int getUserRating();
    String getMovieName();
    int getMovieRating();
    String getYear();
}
