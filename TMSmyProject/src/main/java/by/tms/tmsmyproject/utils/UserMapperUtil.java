package by.tms.tmsmyproject.utils;

import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.entities.dto.user.UserCreateDto;
import by.tms.tmsmyproject.entities.dto.user.UserLoginIdDto;
import by.tms.tmsmyproject.entities.dto.user.UserLoginPasswordDto;

public final class UserMapperUtil {

    private UserMapperUtil() {
    }

    public static User getUserLoginPasswordDto(User user) {
        return UserLoginPasswordDto.builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .build();
    }

    public static User getUserLoginIdDto(User user) {
        return UserLoginIdDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .build();
    }

    public static User getUseCreateDto(User user) {
        return UserCreateDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .login(user.getLogin())
                .build();
    }


}
