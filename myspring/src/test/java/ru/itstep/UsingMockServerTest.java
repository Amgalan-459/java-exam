package ru.itstep;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
@SpringBootTest
@AutoConfigureMockMvc
class UsingMockServerTest {
	@Autowired
	MockMvc mockMvc;
//	@Test
//	void shouldReturnDefaultMessage() throws Exception {
//		mockMvc.perform(get("/test_url")
//				   ).andDo(print()
//				   ).andExpect(status().isOk()
//				   ).andExpect(content().string(
//					    containsString("Test Response String")));
//	}
	
//	@Test
//	void fakeUser() {
//		mockMvc.perform(formLogin("/login").user("admin").password("pass"));
//
//		mockMvc.perform(get("/admin").with(user("admin").password("pass").roles("USER","ADMIN")));
//
//		mockMvc.perform(get("/").with(user(userDetails)));
//	}
}
