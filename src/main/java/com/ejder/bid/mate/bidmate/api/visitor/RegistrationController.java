package com.ejder.bid.mate.bidmate.api.visitor;

import com.ejder.bid.mate.bidmate.constants.Common;
import com.ejder.bid.mate.bidmate.data.model.Address;
import com.ejder.bid.mate.bidmate.data.model.User;
import com.ejder.bid.mate.bidmate.data.repositories.UserRepository;
import com.ejder.bid.mate.bidmate.utils.Util;
import com.ejder.bid.mate.bidmate.ux.forms.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
        }catch (DataIntegrityViolationException exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Common.EXISTS);
        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Common.ERROR);
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
