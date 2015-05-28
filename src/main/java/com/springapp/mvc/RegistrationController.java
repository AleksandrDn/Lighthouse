package com.springapp.mvc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.validation.Valid;

import com.springapp.mvc.entity.Account;
import com.springapp.mvc.entity.AccountRoles;
import com.springapp.mvc.entity.Avatar;
import com.springapp.mvc.form.Registration;
import com.springapp.mvc.service.AccountService;
import com.springapp.mvc.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.springapp.mvc.entity.Client;

@Controller
@RequestMapping("/registrationform")
public class RegistrationController {
    @Autowired
    private RegistrationValidation registrationValidation;

    @Resource(name="clientService")
    private ClientService clientService;

    @Resource(name="accountService")
    private AccountService accountService;

    public void setRegistrationValidation(
            RegistrationValidation registrationValidation) {
        this.registrationValidation = registrationValidation;
    }

    // Display the form on the get request
    @RequestMapping(method = RequestMethod.GET)
    public String showRegistration(Map model) {
        Registration registration = new Registration();
        model.put("registration", registration);
        return "registrationform";
    }

    // Process the form.
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@Valid Registration registration,
                                      BindingResult result){
        // set custom Validation by user
        registrationValidation.validate(registration, result);
        if (!accountService.getAccountFromEmail(registration.getEmail()).isEmpty())
            registrationValidation.userExistsError();
        if (result.hasErrors()) {
            return "registrationform";
        }
        if (!putInDB(registration))
            return "registrationform";
        return "registrationsuccess";
    }

    private boolean putInDB(Registration registration)
    {
        int count = accountService.getAccountFromEmail(registration.getEmail()).size();
        if (count != 0)
            return false;
        /*fill client*/
        Client newClient = new Client();
        newClient.setFirst_name(registration.getFirstName());
        newClient.setLast_name(registration.getLastName());
        newClient.setPhone(registration.getPhone());
        clientService.add(newClient);

        /*fill account*/
        Account newAccount = new Account();
        newAccount.setEmail(registration.getEmail());
        newAccount.setEnabled("1");
        newAccount.setPassword(md5Custom(registration.getPassword()));
        newAccount.setClient(newClient);
        accountService.add(newAccount);

        /*fill userRole*/
        AccountRoles newRole = new AccountRoles();
        newRole.setAccount(newAccount);
        newRole.setROLE("ROLE_USER");
        accountService.addUserRole(newRole);

        /*fill avatar*/
        Avatar avatar = new Avatar();
        avatar.setAccount(newAccount);
        avatar.setCustom_img(null);
        avatar.setDefault_img("http://www.gravatar.com/avatar/" + md5Custom(newAccount.getEmail()) + "?s=32&d=identicon&r=PG");
        accountService.addDefaultAvatar(avatar);

        return true;
    }

    private static String md5Custom(String st) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while( md5Hex.length() < 32 ){
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }
}