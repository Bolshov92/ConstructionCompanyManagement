package com.example.construction_company_management.controller;


import com.example.construction_company_management.dto.DepartmentCreateDto;
import com.example.construction_company_management.dto.EmployeeAfterCreationDto;
import com.example.construction_company_management.service.DepartmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "admin", password = "123123", roles = "ADMIN")
@Sql("/db/schemaTest.sql")
@Sql("/db/dataTest.sql")
public class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DepartmentService departmentService;

    @Test
    void findByDepName() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/department/get/{name}", "Builders"))
                .andExpect(status().isOk());
    }

    @Test
    void createDepartment() throws Exception {
        DepartmentCreateDto departmentCreateDto = new DepartmentCreateDto("Manager");

        String json = objectMapper.writeValueAsString(departmentCreateDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/department/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    void deleteDepartmentByIdPositiveTest() throws Exception {
        UUID id = UUID.fromString("02614a58-e256-482c-9284-c188c00a7ec6");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/department/delete/{id}", id))
                .andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void departmentUpdatePositiveTest() throws Exception {
        DepartmentCreateDto departmentCreateDto = new DepartmentCreateDto(
                "NewName"
        );
        String json = objectMapper.writeValueAsString(departmentCreateDto);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/department/update/{id}", "02614a58-e256-482c-9284-c188c00a7ec6")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());

        String jsonResult = result.getResponse().getContentAsString();
        EmployeeAfterCreationDto updatedEmployeeDto = objectMapper.readValue(jsonResult, EmployeeAfterCreationDto.class);
    }

}
