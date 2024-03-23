package ecom.mobile.app.controller;

import ecom.mobile.app.model.*;
import ecom.mobile.app.payload.request.LoginRequest;
import ecom.mobile.app.payload.request.SignUpRequest;
import ecom.mobile.app.payload.response.JwtResponse;
import ecom.mobile.app.payload.response.MessageResponse;
import ecom.mobile.app.security.CustomUserDetails;
import ecom.mobile.app.security.jwt.JwtTokenProvider;
import ecom.mobile.app.service.serviceInterface.AccountService;
import ecom.mobile.app.service.serviceInterface.RoleService;
import ecom.mobile.app.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserService userService;
    @Autowired
    AccountService accountService;
    @Autowired
    RoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) throws Exception {
        if (accountService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already"));
        }
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setGender(signUpRequest.getGender());
        Account account = new Account();
        account.setEmail(signUpRequest.getEmail());
        account.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        Set<String> roles = signUpRequest.getRoles();
        Set<Role> listRole = new HashSet<>();
        if (roles == null) {
            Role role = roleService.findByRoleName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
            listRole.add(role);
        } else {
            roles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleService.findByRoleName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        listRole.add(adminRole);
                    case "user":
                        Role userRole = roleService.findByRoleName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        listRole.add(userRole);
                }
            });
        }
        account.setRoles(listRole);
        user.setAccount(account);

        UserSetting userSetting = new UserSetting();
        userSetting.setEnableFingerPrint(0);
        userSetting.setEnableNotification(0);
        userSetting.setEnableLocationService(0);
        user.setSetting(userSetting);

        Address address = new Address();
        address.setAddress("Chưa có địa chỉ");
        user.setAddress(address);

        String avtImageFileName = "_avt.jpg";
        if(signUpRequest.getGender().equals("Nam")) avtImageFileName = "male" + avtImageFileName;
        else avtImageFileName = "female" + avtImageFileName;
        user.setAvatarImage(readImage(avtImageFileName));

        userService.saveOrUpdate(user);
        return ResponseEntity.ok(new MessageResponse("User register successfully"));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
            String jwt = jwtTokenProvider.generateToken(customUserDetails);
            List<String> listRoles = customUserDetails.getAuthorities().stream()
                    .map(item -> item.getAuthority()).toList();
            User user = userService.findByAccountEmail(customUserDetails.getEmail());

            return ResponseEntity.ok(
                    new JwtResponse(jwt,
                            user.getId(),
                            user.getName(),
                            customUserDetails.getEmail(),
                            listRoles
                    )
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body(new MessageResponse("Thông tin đăng nhập không chính xác!"));
        }

    }

    private byte[] readImage(String fileName) throws Exception{
        //local folder path
        String folderPath = "B:\\document\\2-4\\MAD-14\\ecom_app_db\\ecom_app_db\\app\\src\\user_default_avatar\\";
        String filePath = folderPath + fileName;
        BufferedImage bImg = ImageIO.read(new File(filePath));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImg, "jpg", bos);
        return bos.toByteArray();
    }

}
