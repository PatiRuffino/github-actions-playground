package com.playground.githubactionsplayground.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class GreetingsControllerTests {
    private final MockMvc mockMvc;

    @Autowired
    GreetingsControllerTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    @DisplayName("Should return hello world message when performing a request sucessfully")
    void shouldReturnHelloWorldWhenPerformingRequestSuccessfully() throws Exception {
        var httpResponse = this.mockMvc
                .perform(get("/greetings/hello")
                        .accept(MediaType.APPLICATION_JSON));

        httpResponse.andExpect(status().isOk());
        httpResponse.andExpect(jsonPath("$.message").exists());
        httpResponse.andExpect(jsonPath("$.message").value("Hello World"));
    }

    @Test
    @DisplayName("Should return goodbye message when performing a request sucessfully")
    void shouldReturnGoodbyeMessageWhenPerformingRequestSuccessfully() throws Exception {
        var httpResponse = this.mockMvc
                .perform(get("/greetings/goodbye")
                        .accept(MediaType.APPLICATION_JSON));

        httpResponse.andExpect(status().isOk());
        httpResponse.andExpect(jsonPath("$.message").exists());
        httpResponse.andExpect(jsonPath("$.message").value("Goodbye"));
    }
}
