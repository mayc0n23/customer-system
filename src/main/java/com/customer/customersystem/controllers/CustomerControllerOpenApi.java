package com.customer.customersystem.controllers;

import com.customer.customersystem.dtos.request.CreateCustomerRequest;
import com.customer.customersystem.dtos.request.UpdateCustomerRequest;
import com.customer.customersystem.dtos.response.CustomerResponse;
import com.customer.customersystem.dtos.response.MinimalCustomerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

public interface CustomerControllerOpenApi {

    @Operation(description = "Cria um novo cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity")
    })
    CustomerResponse register(
            @Parameter(name = "request", description = "Representação de um cliente com a lista de telefones", required = true) CreateCustomerRequest request
    );

    @Operation(description = "Lista todos os clientes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK")
    })
    List<MinimalCustomerResponse> listAll();

    @Operation(description = "Busca um cliente pelo id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    CustomerResponse searchById(
            @Parameter(description = "ID do cliente", example = "1", required = true) Long id
    );

    @Operation(description = "Deleta um cliente pelo id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    void delete(
            @Parameter(description = "ID do cliente", example = "1", required = true) Long id
    );


    @Operation(description = "Edita um cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity")
    })
    CustomerResponse edit(
            @Parameter(description = "ID do cliente", example = "1", required = true) Long id,
            @Parameter(name = "request", description = "Representação de um cliente com a lista de telefones", required = true) UpdateCustomerRequest request
    );

}
