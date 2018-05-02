package br.com.melao.corretora.controller.comum;

import br.com.melao.corretora.service.comum.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class HomeControllerTest {


    @Mock
    private UserService service;

    private HomeController controller;

    @Before
    public void setUp()  {
        MockitoAnnotations.initMocks(this);
        controller = new HomeController(service);
    }

    @Test
    public void index() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("/home/index"));
    }

    @Test
    public void home() {

    }

    @Test
    public void login() {
    }
}