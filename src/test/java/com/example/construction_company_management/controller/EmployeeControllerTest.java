package com.example.construction_company_management.controller;

import com.example.construction_company_management.dto.EmployeeAfterCreationDto;
import com.example.construction_company_management.dto.EmployeeCreateDto;
import com.example.construction_company_management.entity.Role;
import com.example.construction_company_management.repository.RoleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.management.relation.RoleNotFoundException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
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

        Assertions.assertEquals(200, result.getResponse().getStatus());
    }
}