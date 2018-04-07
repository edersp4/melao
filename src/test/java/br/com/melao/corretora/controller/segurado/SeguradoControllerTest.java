package br.com.melao.corretora.controller.segurado;

import br.com.melao.corretora.builder.SeguradoBuilder;
import br.com.melao.corretora.model.segurado.Segurado;
import br.com.melao.corretora.service.segurado.SeguradoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class SeguradoControllerTest {




    @Mock
    private SeguradoService service;
    private SeguradoController controller;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new SeguradoController(service);
    }

    @Test
    public void cadastroSegurado() {
    }

    @Test
    public void gravar() {
    }

    @Test
    public void consultaSegurado() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/segurado/consulta-segurado"))
                .andExpect(status().isOk())
                .andExpect(view().name("segurado/consulta-segurado"));
    }

    @Test
    public void buscar() throws Exception {
        Iterable<Segurado> segurados = Arrays.asList(SeguradoBuilder.umSegurado().comId(1L).comNome("Ederson").agora());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        Mockito.when(service.buscarPorExemplo(Mockito.any())).thenReturn(segurados);
        mockMvc.perform(MockMvcRequestBuilders.get("/segurado/buscar"))
                .andExpect(status().isOk())
                .andExpect(view().name("segurado/consulta-segurado"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("listaSegurados"));//verifica se existe um model com esse nome

    }

    @Test
    public void alterarSegurado() {
    }

    @Test
    public void detalheSegurado() {
    }

    @Test
    public void cadastrarItem() {
    }
}