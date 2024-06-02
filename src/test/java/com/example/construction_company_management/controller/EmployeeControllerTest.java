package com.example.construction_company_management.controller;

import com.example.construction_company_management.dto.EmployeeAfterCreationDto;
import com.example.construction_company_management.dto.EmployeeCreateDto;
import com.example.construction_company_management.dto.EmployeeUpdateDto;
import com.example.construction_company_management.repository.RoleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "admin", password = "123123", roles = "ADMIN")
@Sql("/db/schemaTest.sql")
@Sql("/db/dataTest.sql")
class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    RoleRepository roleRepository;
    LocalDate startDate = LocalDate.parse("2023-01-01");
    LocalDate endDate = LocalDate.parse("2024-10-10");

    @Test
    void createEmployeePositiveTest() throws Exception {
        EmployeeCreateDto employeeCreateDto = new EmployeeCreateDto(
                "Slava",
                "Bolshov",
                "email.com",
                30,
                startDate,
                endDate,
                "Builders",
                "ADMIN"
        );


        String json = objectMapper.writeValueAsString(employeeCreateDto);

        System.out.println(json);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();
        String jsonResult = result.getResponse().getContentAsString();
        EmployeeAfterCreationDto afterCreationDto = objectMapper.readValue(jsonResult, EmployeeAfterCreationDto.class);
        System.out.println(jsonResult);

        Assertions.assertEquals(201, result.getResponse().getStatus());
    }

    @Test
    void updateEmployeePositiveTest() throws Exception {
        EmployeeUpdateDto employeeUpdateDto = new EmployeeUpdateDto(
                "NewName",
                "NewLastName",
                "newMail",
                20,
                startDate,
                endDate,
                "Drivers",
                "ROLE_SUPERVISOR"
        );
        String json = objectMapper.writeValueAsString(employeeUpdateDto);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/employee/update/{id}", "639d7bc4-9845-40aa-84c8-b0f1dced6732")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());

        String jsonResult = result.getResponse().getContentAsString();
        EmployeeAfterCreationDto updatedEmployeeDto = objectMapper.readValue(jsonResult, EmployeeAfterCreationDto.class);
    }

    @Test
    void deleteEmployeePositiveTest() throws Exception {
        UUID id = UUID.fromString("a2b4f08a-734e-42c7-83e1-ccea7d50a461");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/employee/delete/{id}", id))
                .andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void findByIdTest() throws Exception {
        UUID id = UUID.fromString("639d7bc4-9845-40aa-84c8-b0f1dced6732");
        mockMvc.perform(MockMvcRequestBuilders.get("/employee/get/{id}", id))
                .andExpect(status().isOk());
    }
}