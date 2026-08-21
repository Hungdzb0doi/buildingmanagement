package com.BuildingWeb.Present;

import com.BuildingWeb.DTO.AssigmentCustomerDTO;
import com.BuildingWeb.Service.AssignmentCustomerService;
import com.BuildingWeb.Utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignmentcustomer")
@RequiredArgsConstructor
public class AssignmentCustomerAPI {
    private final AssignmentCustomerService assignmentCustomerService;

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @PostMapping
    public ResponseEntity<ApiResponse<Object>> insertAssignmentCustomer(@RequestBody AssigmentCustomerDTO assigmentCustomerDTO){
        assignmentCustomerService.insertAssignmentCustomer(assigmentCustomerDTO);
        return ResponseEntity.ok(ApiResponse.created(null));
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'STAFF')")
    @GetMapping("/{idCustomer}")
    public ResponseEntity<ApiResponse<Object>> getIdUserByIdCustomer(@PathVariable("idCustomer") Long idCustomer){
        return ResponseEntity.ok(ApiResponse.success(assignmentCustomerService.getIdUserByIdCustomer(idCustomer)));
    }
}
