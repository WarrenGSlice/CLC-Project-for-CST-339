package com.gcuCLC.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

/**
 * ---------------------------------------------------------------------------
 * Name      : Group H1
 * Members   : W. Peterson, J. LeVan, and I. Gudino
 * Date      : 2022-03-11
 * Class     : CST-339 Java Programming III
 * Professor : Brandon Bass
 * Assignment: Milestone - CLC Group Assignment
 * Disclaimer: This is our own work
 * ---------------------------------------------------------------------------
 * Description:
 * 1. Controller - User Controller
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

// User Controller controls User Settings Actions
@Controller
@RequestMapping("/userSettings")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
    @SuppressWarnings("unused")
	@Autowired
    private ProductsBusinessInterface bservice;
    
    @SuppressWarnings("unused")
	@Autowired
    private UserBusinessService userService;
    
    @Autowired
    private JavaMailSender mailSender;
    private Password password;

    public static User user;
    public int code;

    /**
     * Displays The User Settings Page
     * @param login - Auto Injected Login Model
     * @param model - Auto Injected Model
     * @param userEntity - Auto Injected User Entity Entity
     * @param loggedUser - Auto Injected gcuCLCuserDetails
     * @return userSettings - User Settings Page
     */
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
        if(userRepo.findByUsernameAndPassword(LoginController.login.getUsername(), LoginController.login.getPassword()) != null)
        {
            ue = userRepo.findByUsername(LoginController.login.getUsername());
            UserController.user = new User(ue);
        }

        model.addAttribute("user", userEntity);
        model.addAttribute("user", UserController.user);
        model.addAttribute("login", LoginController.login);
        return "userSettings";
    }

    /**
     * Handles The saving of user settings
     * @param user - Auto Injected User Model
     * @param bindingResult - Auto Injected Binding Result
     * @param model - Auto Injected Model
     * @param login - Auto Injected Login Model
     * @param userEntity - Auto Injected User Entity Entity
     * @param loggedUser - Auto Injected gcuCLCuserDetails
     * @return userSettings - User Settings Page
     */
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
        if(userRepo.findByUsernameAndPassword(ue.getUsername(), ue.getPassword()) != null)
            userRepo.save(ue);
        else
            userRepo.save(ue);

        return "userSettings";
    }
    
    /**
     * Handles the Changing Password
     * @param pass - Auto Injected Password Model
     * @param bindingResult - Auto Injected Binding Result
     * @param model - Auto Injected Model
     * @return userSettings - User Settings Page
     */
    @PostMapping("/changePassword")
    public String changePassword(@ModelAttribute @Valid Password pass, BindingResult bindingResult, Model model)
    {
        password.setCode(code);

        if(pass.getCurPassword() == UserController.user.getPassword() && pass.getCode() == code)
        {

        }

        return "userSettings";
    }
    
    /**
     * Displays the Password Change Page
     * @param user - Auto Injected User Model
     * @param bindingResult - Auto Injected Binding Result
     * @param model - Auto Injected Model
     * @return userSettings - User Settings Page
     */
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
    
    /**
     * Sends Password Reset Code to Email
     * @param code - Auto Injected int
     * @throws UnsupportedEncodingException - Unsupported Encoding Exception
     * @throws MessagingException - Messaging Exception
     */
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

}