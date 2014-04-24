package fi.softala.koulutus;

import static org.mockito.Mockito.times;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fi.softala.bean.Koulutustilaisuus;
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

		// mockaa KoulutusHakuController
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
		Mockito.when(service.haeTulevat()).thenReturn(
				new ArrayList<Koulutustilaisuus>());
	}
	// Tarkastaa, että haetaan lista koulutustilaisuus olioita
	@Test
	public void haeKoulutuksia() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/");
		mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.model().size(1))
				.andExpect(MockMvcResultMatchers.view().name("listausuusi"));
		// Tarkasta, että haeKaikki()-metodia on kutsuttu yhden kerran
		verify(service, times(1)).haeTulevat();
	}
}
