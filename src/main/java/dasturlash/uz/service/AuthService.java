package dasturlash.uz.service;

import dasturlash.uz.dto.auth.RegistrationDto;
import dasturlash.uz.entity.ProfileEntity;
import dasturlash.uz.enums.ProfileRole;
import dasturlash.uz.enums.ProfileStatus;
import dasturlash.uz.exception.BadRequestException;
import dasturlash.uz.repository.AuthRepository;
import dasturlash.uz.service.email.EmailSenderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmailSenderService emailSenderService;

    public String register(@Valid RegistrationDto dto) {
        Optional<ProfileEntity> optional = authRepository.findByEmail(dto.getEmail());
        if (optional.isPresent()) {
            ProfileEntity existProfile = optional.get();
            throw new BadRequestException("Email already exists");
        }

        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        entity.setStatus(ProfileStatus.INACTIVE);
        entity.setRole(ProfileRole.ROLE_USER);
        authRepository.save(entity);
        emailSenderService.sendRegistrationStyledEmail(entity.getEmail());
        return "Send confirmation code!";
    }
}
