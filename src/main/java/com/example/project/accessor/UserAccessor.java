package com.example.project.accessor;

import com.example.project.dto.UserDTO;
import com.example.project.models.Roles;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserAccessor {
    public UserDTO findByEmail(String email){
        if (email.equals("nidhi.agr@gmail.com")){
            return new UserDTO(email,"hello123","123456", Roles.ROLE_ADMIN);
        }
        else if(email.equals("nidhi.agrawal@gmail.com")){
            return new UserDTO(email,"bye123","789456",Roles.ROLE_VIEWER);
        }
        else if(email.equals(("nidhiagr1327@gmail.com"))){
            return new UserDTO(email,"hello321","12345678",Roles.ROLE_GUEST);
        }
        else{
            return null;
        }
    }
}
