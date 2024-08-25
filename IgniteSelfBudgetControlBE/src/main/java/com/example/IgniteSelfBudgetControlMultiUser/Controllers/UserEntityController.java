package com.example.IgniteSelfBudgetControlMultiUser.Controllers;

import com.example.IgniteSelfBudgetControlMultiUser.ABC.IAbstractController;
import com.example.IgniteSelfBudgetControlMultiUser.ABC.Utils.JwtUtil;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.UserDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Security.AuthRequest;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.UserEntity;
import com.example.IgniteSelfBudgetControlMultiUser.Models.SearchCriteria;
import com.example.IgniteSelfBudgetControlMultiUser.Services.UserEntityServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequestMapping("/UserEntity")
@RestController

public class UserEntityController implements IAbstractController<UserEntity> {

    @Autowired
    UserEntityServiceImp userEntityService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Operation(operationId = "LoginUserEntity")
    @PostMapping(value = "/Login/{login}/{pass}", produces = "application/json")
    public ResponseEntity<UserDTO> login(@PathVariable String login, @PathVariable String pass) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login, pass)
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        String authToken =  jwtUtil.generateToken(login);
        UserDTO userDto = userEntityService.login(login, pass) ;
        userDto.setAuthtoken(authToken);
        userDto.setPass("");
        if (userDto == null)
        {
            return new ResponseEntity<>(userDto, HttpStatus.NOT_FOUND);
        }
        else
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<UserEntity> save(UserEntity entity) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<UserEntity>> saveAll(List<UserEntity> entities) throws Exception {
        return null;
    }

    @Override
    @Operation(operationId = "loadUserEntity")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<UserEntity> load(@PathVariable Long id) {
//        UserEntity userEntity = userEntityService.getById(id);
//        return new ResponseEntity<>(userEntity,HttpStatus.OK);
        return null;
    }

    @Override
    public ResponseEntity<List<UserEntity>> getAll(Long page, Long size) throws Exception {
        return null;
    }

    @Override
    @Operation(operationId = "getAllUserEntities")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<UserEntity>> getAll() throws Exception {
//        List<UserEntity> userEntities = userEntityService.getAll();
//        return new ResponseEntity<>(userEntities,HttpStatus.OK);
        return null;
    }

    @Operation(operationId = "getAllUserEntitiesDTO")
    @GetMapping(value = "/GetAllDTO", produces = "application/json")
    public ResponseEntity<List<Objects>> getUserEntities() throws Exception {
//        List<UserEntityDTO> userEntities = userEntityService.getUserEntities();
//        return new ResponseEntity<>(userEntities,HttpStatus.OK);
        return null;
    }

    @Override
    @Operation(operationId = "deleteUserEntity")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) {
        //userEntityService.delete(id);

    }

    @Override
    public ResponseEntity<List<UserEntity>> search(SearchCriteria criteria) throws Exception {
        return null;
    }

}
