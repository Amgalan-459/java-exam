package ru.itstep;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDtoRepository extends CrudRepository<UserDto, Long> {
	List<UserDto>  findByFirstName(String purpose);
	UserDto findOneByEmail(String email);
	List<UserDto> findAll();
}
