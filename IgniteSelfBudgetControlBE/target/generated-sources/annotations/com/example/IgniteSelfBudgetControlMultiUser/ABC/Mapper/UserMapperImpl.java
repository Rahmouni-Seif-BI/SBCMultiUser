package com.example.IgniteSelfBudgetControlMultiUser.ABC.Mapper;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.UserDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-18T14:52:03+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toUserDto(UserEntity item) {
        if ( item == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( item.getId() );
        userDTO.setName( item.getName() );
        userDTO.setSurname( item.getSurname() );
        userDTO.setLogin( item.getLogin() );
        userDTO.setPass( item.getPass() );

        return userDTO;
    }

    @Override
    public UserEntity toUser(UserDTO userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userDto.getId() );
        userEntity.setName( userDto.getName() );
        userEntity.setSurname( userDto.getSurname() );
        userEntity.setLogin( userDto.getLogin() );
        userEntity.setPass( userDto.getPass() );

        return userEntity;
    }
}
