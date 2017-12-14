package com.tcs;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.tcs.SorterApplication;
import com.tcs.config.AppPropertyConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SorterApplication.class, initializers = ConfigFileApplicationContextInitializer.class)
@WebAppConfiguration
public class SorterApplicationIntegrationTests {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
				.defaultRequest(get("/").with(httpBasic("TCS", "tcs123")))
				.build();
	}

	@Test
	public void testSortNumbers() throws Exception {
		
		mockMvc.perform(post("/app/sortNumbers/").param("numbersBeforeSort", "9,5,7,3,6,8,2"))
				.andExpect(status().is(302))
				.andExpect(view().name("redirect:/app/list-appData"));
	}

	@Test
	public void testGetAppData() throws Exception {

		mockMvc.perform(get("/app/list-appData/"))
				.andExpect(status().isOk())
				.andExpect(view().name("list-appData"));
				
	}

}
