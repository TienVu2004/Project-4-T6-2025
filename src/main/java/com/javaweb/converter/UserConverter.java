package com.javaweb.converter;

import com.javaweb.model.dto.RegisterDTO;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertToDto (UserEntity entity){
        UserDTO result = modelMapper.map(entity, UserDTO.class);
        return result;
    }



    public UserEntity convertToEntity (UserDTO dto){
        UserEntity result = modelMapper.map(dto, UserEntity.class);
        return result;
    }

    public RegisterDTO convertRegisterDTO (UserEntity entity){
        RegisterDTO result = modelMapper.map(entity, RegisterDTO.class);
        return result;
    }


    public UserEntity convertRegisterToEntity (RegisterDTO registerDTO){
        UserEntity result = modelMapper.map(registerDTO, UserEntity.class);
        return result;
    }
    
}
