package com.gcuCLC.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/** * * * * * * * * * * * * * * *
 * CST-339 CLC Milestone Project
 * Order Management Application *
 * Created by Warren Peterson,* *
 * Jonathan Levan, Ivan Gudino  *
 * * * * * * * * * * * * * * * **/

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcuCLC.business.ProductsBusinessInterface;
import com.gcuCLC.business.UserBusinessService;
import com.gcuCLC.entity.UserEntity;
import com.gcuCLC.model.Login;
import com.gcuCLC.model.Password;
import com.gcuCLC.model.User;
import com.gcuCLC.model.gcuCLCuserDetails;
import com.gcuCLC.repository.UserRepository;

// User Controller controls User Settings Actions
@Controller
@RequestMapping("/userSettings")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
    @SuppressWarnings("unused")
	@Autowired
    private ProductsBusinessInterface bservice;
    
    @Autowired
    private UserBusinessService userService;
    
    @Autowired
    private JavaMailSender mailSender;
    private Password password;

    public static User user;
    public int code;

    // Show User Settings form
    @GetMapping("/")
    public String showUserSettings(Login login, Model model, UserEntity userEntity, @AuthenticationPrincipal gcuCLCuserDetails loggedUser) {
        if (user == null)
            user = new User(LoginController.login.getUsername(), LoginController.login.getPassword(), "First", "Last",
                    "Email", "Business", "Address", "City", "Zip", "000-000-0001", "State");
        model.addAttribute("title", "Settings Form");
        model.addAttribute("login", LoginController.login);
        String username = loggedUser.getUsername();
        userEntity = userRepo.findByUsername(username);
        UserEntity ue;
        //UserDataService uds = new UserDataService(null, getDataSource());
        if(userRepo.findByUsernameAndPassword(LoginController.login.getUsername(), LoginController.login.getPassword()) != null)
        {
            ue = userRepo.findByUsername(LoginController.login.getUsername());
            UserController.user = new User(ue);
        }
//        loggedUser.setFirstName(user.getFirstName());
//        loggedUser.setLastName(user.getLastName());
//        loggedUser.setBusinessName(user.getBusinessName());
//        loggedUser.setAddress(user.getAddress());
//        loggedUser.setEmail(user.getEmail());
//        loggedUser.setPhone(user.getPhone());
//        loggedUser.setCity(user.getCity());
//        loggedUser.setState(user.getState());
//        loggedUser.setZip(user.getZip());
        //UserDetails username = UserBusinessService.loadUserByUsername();
		//UserDetails username = userService.loadUserByUsername();
        model.addAttribute("user", userEntity);
        model.addAttribute("user", UserController.user);
        model.addAttribute("login", LoginController.login);
        return "userSettings";
    }

    // Register new user
    @PostMapping("/changeSettings")
    public String saveUser(@ModelAttribute @Valid User user, BindingResult bindingResult, Model model, Login login, UserEntity userEntity,
    						@AuthenticationPrincipal gcuCLCuserDetails loggedUser) {
        if (user.getFirstName() != null)
            UserController.user.setFirstName(user.getFirstName());
        if (user.getLastName() != null)
            UserController.user.setLastName(user.getLastName());
        if (user.getPhone() != null)
            UserController.user.setPhone(user.getPhone());
        if (user.getEmail() != null)
            UserController.user.setEmail(user.getEmail());
        if (user.getBusinessName() != null)
            UserController.user.setBusinessName(user.getBusinessName());
        if (user.getAddress() != null)
            UserController.user.setAddress(user.getAddress());
        if (user.getCity() != null)
            UserController.user.setCity(user.getCity());
        if (user.getState() != null)
            UserController.user.setState(user.getState());
        if (user.getZip() != null)
            UserController.user.setZip(user.getZip());
        model.addAttribute("title", "User Settings");
        model.addAttribute("login", LoginController.login);
        model.addAttribute("user", UserController.user);

        UserEntity ue = new UserEntity(UserController.user);
        //UserDataService uds = new UserDataService(null, getDataSource());
        if(userRepo.findByUsernameAndPassword(ue.getUsername(), ue.getPassword()) != null)
            userRepo.save(ue);
        else
            userRepo.save(ue);

        return "userSettings";
    }
    
    @PostMapping("/changePassword")
    public String changePassword(@ModelAttribute @Valid Password pass, BindingResult bindingResult, Model model)
    {
        password.setCode(code);

        if(pass.getCurPassword() == UserController.user.getPassword() && pass.getCode() == code)
        {

        }

        return "userSettings";
    }
    
    @GetMapping("/doPassChange")
    public String doPassChange(@ModelAttribute @Valid User user, BindingResult bindingResult, Model model)
    {
        Random rn = new Random();
        code = rn.nextInt();

        if (user.getFirstName() != null)
            UserController.user.setFirstName(user.getFirstName());
        if (user.getLastName() != null)
            UserController.user.setLastName(user.getLastName());
        if (user.getPhone() != null)
            UserController.user.setPhone(user.getPhone());
        if (user.getEmail() != null)
            UserController.user.setEmail(user.getEmail());
        if (user.getBusinessName() != null)
            UserController.user.setBusinessName(user.getBusinessName());
        if (user.getAddress() != null)
            UserController.user.setAddress(user.getAddress());
        if (user.getCity() != null)
            UserController.user.setCity(user.getCity());
        if (user.getState() != null)
            UserController.user.setState(user.getState());
        if (user.getZip() != null)
            UserController.user.setZip(user.getZip());
        model.addAttribute("title", "Change Password");
        model.addAttribute("login", LoginController.login);
        model.addAttribute("user", UserController.user);

        password = new Password();
        model.addAttribute("password", password);

        try
        {
            sendCode(code);
            return "passwordChange";
        }
        catch(Exception ex)
        {
            System.out.println("Error When Sending Email");
            return "userSettings";
        }
    }
    
    public void sendCode(int code) throws UnsupportedEncodingException, MessagingException
    {
        String toAddress = user.getEmail();
        String fromAddress = "shoeflysolutions@gmail.com";
        String senderName = "Shoe Fly OMS";
        String subject = "Password Change";
        String content = "Dear [[name]],<br>"
                + "Here is the code for your password change: [[code]]"
                + "Thank you,<br>"
                + "Shoe Fly Order Management Solutions";
     
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        
        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        
        content = content.replace("[[name]]", user.getFirstName());
        content = content.replace("[[code]]", Integer.toString(code));
        
        helper.setText(content, true);
        
        mailSender.send(message);
    }

//    public DataSource getDataSource(){
//        DataSourceBuilder<?> dsb = DataSourceBuilder.create();
//        dsb.url("jdbc:mysql://localhost:3306/oms");
//        dsb.username("root");
//        dsb.password("root");
//        dsb.driverClassName("com.mysql.cj.jdbc.Driver");
//        return dsb.build();
//    }
}