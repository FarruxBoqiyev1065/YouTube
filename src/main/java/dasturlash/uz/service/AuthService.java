package dasturlash.uz.service;

import dasturlash.uz.dto.auth.RegistrationDto;
import dasturlash.uz.entity.ProfileEntity;
import dasturlash.uz.repository.AuthRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

//    @Autowired
//    private AuthRepository authRepository;
//    public String register(@Valid RegistrationDto dto) {
//        Optional<ProfileEntity> optional = authRepository.findByEmail(dto.getEmail());
//        if (optional.isPresent()) {
//            return "Email already exists";
//        }
//
//    }
}
