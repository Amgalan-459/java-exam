package ru.itstep;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HttpRequestTest {
	@LocalServerPort
	int port;
	@Autowired
	TestRestTemplate restTemplate;
	@Test
	void test_function() throws Exception {
		assertThat(
			this.restTemplate.getForObject(
				"http://localhost:" + port + "/test_url",
				String.class)).contains("Test Response String");
	}
}

