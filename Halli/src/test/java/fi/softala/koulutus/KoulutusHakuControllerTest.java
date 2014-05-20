package fi.softala.koulutus;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fi.softala.controller.KoulutusHakuController;
import fi.softala.service.KoulutusHakuService;

@RunWith(MockitoJUnitRunner.class)
public class KoulutusHakuControllerTest {

	@Inject
	private MockMvc mockMvc;

	@InjectMocks
	private KoulutusHakuController controller;

	@Mock
	private KoulutusHakuService service;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void haeTulevatKoulutukset() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.model().size(2))
				.andExpect(MockMvcResultMatchers.view().name("listausuusi"));
		verify(service, times(1)).haeTulevat();
	}
	
	@Test
	public void haeMenneetKoulutukset() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/menneet"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.model().size(2))
				.andExpect(MockMvcResultMatchers.view().name("listausuusi"));
		verify(service, times(1)).haeMenneet();
	}
}
