package ru.itstep;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyspringApplicationTests {
	@Autowired
	PageController controller; 
	
	
	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
