package com.example.construction_company_management.controller;


import com.example.construction_company_management.dto.UserCreateDto;
import com.example.construction_company_management.dto.UserUpdateDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/db/schemaTest.sql")
@Sql("/db/dataTest.sql")
 class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date registrationDate = dateFormat.parse("2023-12-25");
    Date dateOfBirth = dateFormat.parse("1992-11-09");
    public UserControllerTest() throws ParseException {
    }

    @Test
    void findByIdTest() throws Exception {
        UUID id = UUID.fromString("0f9368f4-518f-48cb-b917-2f0f967dd41e");
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get/{id}", id))
                .andExpect(status().isOk());
    }
    @Test
    void createUserTest() throws Exception {
        UserCreateDto userCreateDto = new UserCreateDto(
               "Name",
               "LastName",
               dateOfBirth ,
                registrationDate,
                "NickName",
                "123",
                "0751677677",
                "ROLE_ADMIN"
        );

        String json = objectMapper.writeValueAsString(userCreateDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    void deleteUserByIdTest() throws Exception {
        UUID id = UUID.fromString("0f9368f4-518f-48cb-b917-2f0f967dd41e");
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/delete/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string("User with id " + id + " was deleted"));
    }

    @Test
    void updateUserTest() throws Exception {
        UUID id = UUID.fromString("0f9368f4-518f-48cb-b917-2f0f967dd41e");
        UserUpdateDto userUpdateDto = new UserUpdateDto(
                "NewName",
                "NewLastName",
                dateOfBirth ,
                "NewNickName",
                "123",
                "0751677677",
                "ROLE_ADMIN"
        );

        String json = objectMapper.writeValueAsString(userUpdateDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/user/update/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }
}
