package com.gcuCLC.data;

import java.util.Optional;

import com.gcuCLC.entity.UserEntity;
import com.gcuCLC.entity.UserPhotoEntity;

public interface DataAcessUserImageInterface<T> {

	public Optional<UserPhotoEntity> findUserPhotosByUserId(UserEntity id);
}
