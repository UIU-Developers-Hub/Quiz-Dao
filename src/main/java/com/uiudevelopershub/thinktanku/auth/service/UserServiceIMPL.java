package com.uiudevelopershub.thinktanku.auth.service;

import com.uiudevelopershub.thinktanku.auth.dto.request.UserRequestDTO;
import com.uiudevelopershub.thinktanku.auth.dto.request.UserRoleRequestDTO;
import com.uiudevelopershub.thinktanku.auth.dto.request.UserUpdateRequestDto;
import com.uiudevelopershub.thinktanku.auth.dto.response.CustomUserResponseDTO;
import com.uiudevelopershub.thinktanku.auth.model.Role;
import com.uiudevelopershub.thinktanku.auth.model.Status;
import com.uiudevelopershub.thinktanku.auth.model.User;
import com.uiudevelopershub.thinktanku.auth.repository.RoleRepo;
import com.uiudevelopershub.thinktanku.auth.repository.UserRepo;
import com.uiudevelopershub.thinktanku.config.notification.SSEService;
import com.uiudevelopershub.thinktanku.service.CloudneryImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Service

public class UserServiceIMPL implements UserService {

    private UserRepo userRepository;
    private  PasswordEncoder passwordEncoder;
    private RoleRepo roleRepository;
    private SSEService<User> userSSEService;

    @Autowired
    private CloudneryImageService cloudneryImageService;


   public UserServiceIMPL(UserRepo userRepo,PasswordEncoder passwordEncoder,RoleRepo roleRepository,SSEService<User> userSSEService) {
       this.userRepository = userRepo;
       this.passwordEncoder = passwordEncoder;
       this.roleRepository = roleRepository;
       this.userSSEService = userSSEService;
   }


   public User ConvertToEntity(User user, UserRequestDTO userRequestDTO){
//       Map<String, Object> heroUploadResult = cloudneryImageService.upload(profilepic);
//       String profileImageUrl = (String) heroUploadResult.get("secure_url");
       user.setUsername( userRequestDTO.username() );
       user.setEmail( userRequestDTO.email() );
       user.setPassword( passwordEncoder.encode(userRequestDTO.password() ));
//       user.setBio(userRequestDTO.bio() );
//       user.setAddress( userRequestDTO.address() );
//       user.setPhone(userRequestDTO.phone() );

//       user.setProfession(userRequestDTO.profession());
//       user.setProfilpic(profileImageUrl);

//       user.setFullname(userRequestDTO.fullname());

       return user;
   }




    public void create(UserRequestDTO requestDto) {
       User user1 =userRepository.findByUsername(requestDto.username());
       if(Objects.isNull(user1)) {
           User user = ConvertToEntity(new User(), requestDto);

           userRepository.save(user);

           userSSEService.emit( user );
       }else{
           throw new RuntimeException("User already exists");
       }
    }


    public CustomUserResponseDTO readOne(Long id ) {
        CustomUserResponseDTO singleUserById = userRepository.findUserByUserId(id);
        if ( Objects.isNull( singleUserById ) ) {
            throw new RuntimeException( "User with id " + id + " not found." );
        }
        return singleUserById;
    }


    public User setUserRoles( UserRoleRequestDTO requestDTO ) {

        User foundUser = userRepository.findById( requestDTO.userId() ).get();

        if ( Objects.isNull( foundUser ) ) {
            throw new RuntimeException( "User with id " + requestDTO.userId() + " not found." );
        }

        Set<Role> foundRoles = roleRepository.findAllByIdIn( requestDTO.roleIds() );
        foundUser.getRoles().addAll( foundRoles );

        return  userRepository.save( foundUser );

    }


    @Override
    public void updateUser(Long id, UserUpdateRequestDto userRequestDTO, MultipartFile heroImageFile, MultipartFile cover) throws IOException {

       User user=userRepository.findById( id ).get();

       User updateUser = ConvertToEntityUpdate(user, userRequestDTO, heroImageFile,cover);

       userRepository.save( updateUser );

    }

    @Override
    public List<CustomUserResponseDTO> searchByUsername(String username) {
        return userRepository.searchByUsername( username );
    }

    public User ConvertToEntityUpdate(User user,UserUpdateRequestDto userRequestDTO,MultipartFile profilepic,MultipartFile coverpic) throws IOException {
        Map<String, Object> heroUploadResult = cloudneryImageService.upload(profilepic);

        Map<String, Object> Coverpic = cloudneryImageService.upload(coverpic);

        String profileImageUrl = (String) heroUploadResult.get("secure_url");
        String CoverUrl=(String) Coverpic.get("secure_url");
        user.setBio(userRequestDTO.bio() );
        user.setAddress( userRequestDTO.address() );
        user.setPhone(userRequestDTO.phone() );

        user.setProfession(userRequestDTO.profession());
        user.setProfilpic(profileImageUrl);
        user.setCoverPicture(CoverUrl);

        user.setFullname(userRequestDTO.fullname());

        return user;
    }



    public void saveActiveUser(User user) {
        user.setStatus(Status.ONLINE);
        userRepository.save(user);
    }

    public void disconnect(User user) {
        User storedUser = userRepository.findByUsername(user.getUsername());
        if (storedUser != null) {
            storedUser.setStatus(Status.OFFLINE);
            userRepository.save(storedUser);
        }
    }

    public List<User> findConnectedUsers() {
        return userRepository.findAllByStatus(Status.ONLINE);
    }


}
