package ru.itstep;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Repository
@Transactional
public class UserDtoServiceImpl implements UserDtoService {
	@Autowired
	private UserDtoRepository userDtoRepository;

	@Override
	public UserDto save(UserDto u) {
		return (UserDto) userDtoRepository.save(u);
	}

	@Override
	public List<UserDto> findAll() {
		return userDtoRepository.findAll();
	}

	@Override
	public List<UserDto> findByFirstName(String firstName) {
		return userDtoRepository.findByFirstName(firstName);
	}

	@Override
	public UserDto findOneByEmail(String email) {
		return userDtoRepository.findOneByEmail(email);
	}
}
