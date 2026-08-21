package com.BuildingWeb.Present;

import com.BuildingWeb.DTO.CustomerDTO;
import com.BuildingWeb.Repository.UserRepository;
import com.BuildingWeb.Service.CustomerService;
import com.BuildingWeb.Utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerAPI {
    private final CustomerService customerService;
    private final UserRepository userRepository;

    private Long getStaffIdIfStaff() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean isStaff = auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_STAFF"));
        if (!isStaff) return null;
        return userRepository.findByphone(auth.getName()).map(u -> u.getIdUser()).orElse(null);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Object>> getAllCustomer(@RequestParam(value="customerName",required = false)String customerName, @RequestParam(value = "phone",required = false)String phone) {
        return ResponseEntity.ok(ApiResponse.success(customerService.findAllCustomer(customerName, phone, getStaffIdIfStaff())));
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Object>> createCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.insertCustomer(customerDTO);
        return ResponseEntity.ok(ApiResponse.created(null));
    }
    @PutMapping
    public ResponseEntity<ApiResponse<Object>> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(customerDTO);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
    @DeleteMapping("/{idCustomer}")
    public ResponseEntity<ApiResponse<Object>> deleteCustomer(@PathVariable Long[] idCustomer) {
        customerService.deleteCustomer(idCustomer);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
    @GetMapping("/neglected/total")
    public ResponseEntity<ApiResponse<Object>> countNeglectedCustomers() {
        return ResponseEntity.ok(ApiResponse.success(customerService.countNeglectedCustomers()));
    }
    @GetMapping("/neglected/list")
    public ResponseEntity<ApiResponse<Object>> findNeglectedCustomers() {
        return ResponseEntity.ok(ApiResponse.success(customerService.findNeglectedCustomers()));
    }
}
