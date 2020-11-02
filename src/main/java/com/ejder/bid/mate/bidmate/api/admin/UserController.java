package com.ejder.bid.mate.bidmate.api.admin;

import com.ejder.bid.mate.bidmate.constants.Common;
import com.ejder.bid.mate.bidmate.data.model.User;
import com.ejder.bid.mate.bidmate.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/admin/api/user", consumes = "application/json", produces = "application/json")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/add")
    public @ResponseBody
    ResponseEntity<User> addNew(@RequestBody User user) {
        User added = userRepository.save(user);
        return ResponseEntity.ok(added);
    }

    @PostMapping(value = "/all/{page}/{sort}/{asc}")
    public @ResponseBody
    ResponseEntity<Iterable<User>> getAll(@PathVariable("page") int page,
                                          @PathVariable("sort") String sort,
                                          @PathVariable("asc") String asc) {
        //@TODO error handling
        String sortString = (sort == null) ? "updated" : sort;
        Sort criteria = Sort.by(sortString);
        if(asc.equals("asc")){
            criteria.ascending();
        }else{
            criteria.descending();
        }
        PageRequest pageable = PageRequest.of(page, Common.PAGE_SIZE_LARGE, criteria);
        Iterable<User> users = userRepository.findAll(pageable);
        return ResponseEntity.ok(users);
    }
}
