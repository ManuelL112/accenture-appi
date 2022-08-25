package org.accenture.api.pruebaApi.application.rest.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.accenture.api.pruebaApi.application.rest.model.request.PermissionControllerRequest;
import org.accenture.api.pruebaApi.application.rest.model.request.PermissionControllerSearchRequest;
import org.accenture.api.pruebaApi.application.rest.model.response.PermissionControllerResponse;
import org.accenture.api.pruebaApi.application.rest.support.AbstractRestSupportController;
import org.accenture.api.pruebaApi.domain.model.support.Photo;
import org.springframework.http.ResponseEntity;

import java.util.List;


@Tag(name = "Accenture API")
public interface AccentureRestController extends AbstractRestSupportController {

    @Operation(summary = "register permission")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "register permission"),
            @ApiResponse(responseCode = "404", description = "Subdomain not found"),
            @ApiResponse(responseCode = "422", description = "The information is not complete"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PermissionControllerResponse> register(@Parameter(name= "permissions information") PermissionControllerRequest permissionControllerRequest);

    public List<Photo> findPhotosByUser(Long userId);

    @Operation(summary = "Find all permission")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List all permission"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<PermissionControllerResponse> findAll();

    @Operation(summary = "Serach  permission")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List permission"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<PermissionControllerResponse> search(@Parameter(name= "permissions Search information") PermissionControllerSearchRequest permissionControllerSearchRequest);
}
