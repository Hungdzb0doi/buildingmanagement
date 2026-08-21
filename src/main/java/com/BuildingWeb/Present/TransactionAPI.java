package com.BuildingWeb.Present;

import com.BuildingWeb.DTO.request.RequestTransactionDTO;
import com.BuildingWeb.Service.TransactionService;
import com.BuildingWeb.Utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionAPI {
    private final TransactionService transactionService;

    private String getPhoneIfStaff() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean isStaff = auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_STAFF"));
        return isStaff ? auth.getName() : null;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'STAFF')")
    @GetMapping
    public ResponseEntity<ApiResponse<Object>> searchTransactions(@RequestParam(required = false) String customerName, @RequestParam(required = false) String userName, @RequestParam(required = false) String code) {
        return ResponseEntity.ok(ApiResponse.success(transactionService.searchTransactions(customerName, userName, code, getPhoneIfStaff())));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'STAFF')")
    @PostMapping
    public ResponseEntity<ApiResponse<Object>> insertTransactions(@RequestBody RequestTransactionDTO requestTransactionDTO) {
        transactionService.insertTransactions(requestTransactionDTO);
        return ResponseEntity.ok(ApiResponse.success(null));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @GetMapping("/totaldx")
    public ResponseEntity<ApiResponse<Long>> countDdxTransactions() {
        return ResponseEntity.ok(ApiResponse.success(transactionService.countDdxTransactions()));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @GetMapping("/topstaff")
    public ResponseEntity<ApiResponse<Object>> getTopStaffPerformance() {
        return ResponseEntity.ok(ApiResponse.success(transactionService.getTopStaffPerformance()));
    }
}
