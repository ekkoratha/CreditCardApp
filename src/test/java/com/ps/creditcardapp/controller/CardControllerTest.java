package com.ps.creditcardapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ps.creditcardapp.entity.Card;
import com.ps.creditcardapp.repository.CardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CardController.class)
public class CardControllerTest {

    @MockBean
    CardController cardController;

    @MockBean
    CardRepository cardRepo;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private Card card;

    @BeforeEach
    void setUp() {
        card = new Card(1L, "George Bush", "30569309025904",100L,0L);
        List<Card> t = Arrays.asList(card);
        when(cardRepo.findAll()).thenReturn(t);
    }

    @Test
    void testGetAllMethod() throws Exception {
        mockMvc.perform(
                get("/GetAll")
                        .content(mapper.writeValueAsString(card))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testAddMethod() throws Exception {

        when(cardRepo.save(any(Card.class))).thenReturn(card);

        mockMvc.perform(post("/Add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"id\": \"6\", \"name\":\"testname\",\"number\":\"371449635398431\",\"limitoncard\": 5000}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}