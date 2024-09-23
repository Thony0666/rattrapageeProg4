package com.anthonyo.kfc.patrimoineapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PatrimoineController.class)
public class PatrimoineControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateOrUpdatePatrimoine() throws Exception {
        mockMvc.perform(put("/patrimoines/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"possesseur\":\"John Doe\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.possesseur").value("John Doe"));
    }

    @Test
    public void testGetPatrimoine() throws Exception {
        // Créer d'abord un patrimoine
        mockMvc.perform(put("/patrimoines/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"possesseur\":\"John Doe\"}"))
                .andExpect(status().isOk());

        // Maintenant, récupérez le patrimoine
        mockMvc.perform(get("/patrimoines/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.possesseur").value("John Doe"));
    }
}
