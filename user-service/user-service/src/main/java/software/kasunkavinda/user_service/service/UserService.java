package software.kasunkavinda.user_service.service;

import software.kasunkavinda.user_service.dto.UserDTO;

public interface UserService {

    String newUser(UserDTO userDTO);
    void deleteUser(String id);
    UserDTO getUser(String id);
    String updateUser(UserDTO userDTO);
    boolean isUserExist(String id);

}

