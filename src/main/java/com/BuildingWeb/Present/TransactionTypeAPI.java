package com.BuildingWeb.Present;

import com.BuildingWeb.Service.TransactionTypeService;
import com.BuildingWeb.Utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/transactiontype")
@RequiredArgsConstructor
public class TransactionTypeAPI {
    private final TransactionTypeService transactionTypeService;

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'STAFF')")
    @GetMapping
    public ResponseEntity<ApiResponse<Object>> getAllTransactionType(){
        return ResponseEntity.ok(ApiResponse.success(transactionTypeService.findAllTransactionTypes()));
    }
}

