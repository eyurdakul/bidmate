package com.ejder.bid.mate.bidmate.api.visitor;

import com.ejder.bid.mate.bidmate.constants.Common;
import com.ejder.bid.mate.bidmate.data.model.Address;
import com.ejder.bid.mate.bidmate.data.model.User;
import com.ejder.bid.mate.bidmate.data.repositories.UserRepository;
import com.ejder.bid.mate.bidmate.utils.Util;
import com.ejder.bid.mate.bidmate.ux.forms.RegisterForm;
import com.ejder.bid.mate.bidmate.ux.forms.ResetForm;
import io.netty.util.internal.StringUtil;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;

@RestController
@RequestMapping("/public/api")
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;

    @PostMapping(value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity register(@RequestBody RegisterForm registerForm){

        User user = new User();
        user.setEmail(registerForm.getEmail());
        user.setConfirmed(false);
        user.setConfirmation(Util.generateHash());
        user.setFirstname(registerForm.getFirstname());
        user.setLastname(registerForm.getLastname());
        user.setPassword(registerForm.getPassword());

        user.setNewsletter(registerForm.isNewsletter());
        user.setTerms(registerForm.isTerms());

        Address address = new Address();
        address.setCity(registerForm.getCity());
        address.setCountry(registerForm.getCountry());
        address.setNumber(registerForm.getNumber());
        address.setPostcode(registerForm.getPostcode());
        address.setStreet(registerForm.getStreet());
        address.setUser(user);

        //@TODO send mail with hash for confirmation

        user.setAddress(address);
        try{
            userRepository.save(user);
        }catch (DataIntegrityViolationException | ConstraintViolationException exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Util.responseBody(Common.EXISTS));
        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Util.responseBody(Common.ERROR));
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value = "/reset",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity reset(@RequestBody ResetForm resetForm){

        if(StringUtil.isNullOrEmpty(resetForm.getEmail())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Util.responseBody(Common.INVALID));
        }

        Session session = entityManager.unwrap(Session.class);
        User userFound = session.byNaturalId(User.class).using("email", resetForm.getEmail()).load();

        if(userFound == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Util.responseBody(Common.NOTFOUND));
        }

        if(!StringUtil.isNullOrEmpty(resetForm.getToken())
                && !StringUtil.isNullOrEmpty(resetForm.getPassword())){
            if(!userFound.getConfirmation().equals(resetForm.getToken())){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Util.responseBody(Common.INVALID));
            }
            userFound.setPassword(resetForm.getPassword());
            try {
                userRepository.save(userFound);
            }catch (Exception exception){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Util.responseBody(Common.ERROR));
            }
        }else{
            //@TODO send email to user with reset link www.abc.com?token=xxxx&email=some@mail.com
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
