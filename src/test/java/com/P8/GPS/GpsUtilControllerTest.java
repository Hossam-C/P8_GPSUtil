package com.P8.GPS;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Locale;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GpsUtilControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUserLocation_validUser() throws Exception {
        Locale.setDefault(Locale.US);

        UUID userId = UUID.randomUUID();

        mockMvc.perform(get("/gpsuserlocation?userId="+userId))
                .andExpect(status().isOk());
    }

    @Test
    public void getUserLocation_EmptyUser() throws Exception {
        Locale.setDefault(Locale.US);

        mockMvc.perform(get("/gpsuserlocation?userId="))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getAttraction() throws Exception {
        Locale.setDefault(Locale.US);

        mockMvc.perform(get("/gpsattractions"))
                .andExpect(status().isOk());
    }

    @Test
    public void gpsHome() throws Exception {
        Locale.setDefault(Locale.US);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk());

    }

}
