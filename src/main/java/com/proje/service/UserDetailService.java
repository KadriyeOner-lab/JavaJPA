package com.proje.service;

import com.proje.entityFactory.EntityFactory;
import com.proje.entityFactory.Impl.EntityFactoryImpl;
import com.proje.model.UserDetail;

public interface UserDetailService {

	EntityFactory entityFactory = new EntityFactoryImpl();

	boolean saveUserDetail(UserDetail userDetail);

	boolean updateUserDetail(UserDetail userDetail);

	boolean removeUserDetail(UserDetail userDetail);

	UserDetail findById(Integer id);

	UserDetail findByUsername(String username);

	UserDetail findWithAdressByUsername(String username);

	UserDetail findWithAdvertisementByUsername(String username);

}
