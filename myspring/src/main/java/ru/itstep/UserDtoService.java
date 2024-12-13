package ru.itstep;

import java.util.List;

public interface UserDtoService {
	UserDto save(UserDto u);
	List<UserDto>  findAll();
	List<UserDto>  findByFirstName(String firstName);
	UserDto findOneByEmail(String email);
}
