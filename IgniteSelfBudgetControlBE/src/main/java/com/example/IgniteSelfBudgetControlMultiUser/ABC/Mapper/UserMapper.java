package com.example.IgniteSelfBudgetControlMultiUser.ABC.Mapper;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.UserDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

//    @Mapping(source = "user.", target = "countryId")
//    @Mapping(source = "country.description", target = "countryDescription")
    UserDTO toUserDto(UserEntity item);

    UserEntity toUser(UserDTO userDto);

}
