package software.kasunkavinda.user_service.service.impl;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import software.kasunkavinda.user_service.dao.UserRepo;
import software.kasunkavinda.user_service.dto.UserDTO;
import software.kasunkavinda.user_service.entity.User;
import software.kasunkavinda.user_service.exception.QuantityExceededException;
import software.kasunkavinda.user_service.service.UserService;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepo userRepo;


    @Override
    public String newUser(UserDTO userDTO) {

        logger.info("Attempting to save User: {}", userDTO.getId());
        boolean opt = userRepo.existsById(userDTO.getId());
        if (opt) {
            logger.warn("User id already exists: {}", userDTO.getId());
            throw new QuantityExceededException("User already exists");
        } else {
            userRepo.save(new User(userDTO.getId(),userDTO.getName()));
            logger.info("User saved successfully: {}", userDTO.getId());
            return "User saved successfully";
        }

    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public UserDTO getUser(String id) {
        logger.info("Fetching user: {}", id);
        User user = userRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        return new UserDTO(user.getId(), user.getName());
    }

    @Override
    public String updateUser(UserDTO userDTO) {
        logger.info("Attempting to update User: {}", userDTO.getId());
        Optional<User> existingUserOpt = userRepo.findById(userDTO.getId());
        if (!existingUserOpt.isPresent()) {
            logger.warn("User not found: {}", userDTO.getId());
            throw new NotFoundException("User not found");
        }

        User existingUser = existingUserOpt.get();

        // Update the customer entity with new values
        User updateUser =new User(userDTO.getId(),userDTO.getName());
        updateUser.setId(existingUser.getId()); // Ensure the ID remains the same

        userRepo.save(updateUser);
        logger.info("User updated successfully: {}", updateUser.getId());
        return "User updated successfully";
    }

    @Override
    public boolean isUserExist(String id) {
        logger.info("Fetching user: {}", id);
        return userRepo.existsById(id);
    }
}
