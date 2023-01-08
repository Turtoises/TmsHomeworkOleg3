package by.tms.tmsmyproject.entities.mapers;

import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.entities.dto.user.UserRequestCreateDto;
import by.tms.tmsmyproject.entities.dto.user.UserRequestUpdateDto;
import by.tms.tmsmyproject.entities.dto.user.UserResponseGetDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequestCreateDto userRequestCreateDto);

    User toEntity(UserRequestUpdateDto userRequestCreateDto);

    UserResponseGetDto toDto(User user);

    List<UserResponseGetDto> toDtoList(List<User> users);

}
