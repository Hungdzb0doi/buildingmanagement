package com.BuildingWeb.DTO.response;




import lombok.Builder;
import lombok.Data;
import java.util.List;
@Builder
@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";

    private List<String> roles;

}
