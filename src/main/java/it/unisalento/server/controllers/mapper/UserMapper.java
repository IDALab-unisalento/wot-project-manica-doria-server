package it.unisalento.server.controllers.mapper;

import it.unisalento.server.DTO.UserDTO;
import it.unisalento.server.entities.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserMapper {

    public static UserDTO makeUserDTO(User user) {
         UserDTO.UserDTOBuilder userDTOBuilder = new UserDTO.UserDTOBuilder()
                 .setId(user.getId())
                 .setName(user.getName())
                 .setSurname(user.getSurname())
                 .setRole(user.getRole())
                 .setEmail(user.getEmail())
                 .setPassword(user.getPassword())
                 .setPasswordVerify(user.getPassword())
                 .setSerialNumber(user.getSerialNumber());

         return userDTOBuilder.build();
    }

    public static User makeUser(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getSurname(),
                userDTO.getSerialNumber(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getRole()
        );
    }

    public static List<UserDTO> makeUserDTOList(List<User> userList) {
        Iterator<User> iter = userList.iterator();
        List<UserDTO> userDTOList = new ArrayList<>();
        while (iter.hasNext()) userDTOList.add(makeUserDTO(iter.next()));
        return userDTOList;
    }

    public static List<User> makeUserList(List<UserDTO> userDTOList) {
        Iterator<UserDTO> iter = userDTOList.iterator();
        List<User> userList = new ArrayList<>();
        while (iter.hasNext()) userList.add(makeUser(iter.next()));
        return userList;
    }

}
