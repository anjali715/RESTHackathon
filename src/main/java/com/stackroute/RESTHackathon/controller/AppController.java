package com.stackroute.RESTHackathon.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.RESTHackathon.domain.AppDomain;
import com.stackroute.RESTHackathon.repository.AppRepository;
import com.stackroute.RESTHackathon.service.AppService;
import com.stackroute.RESTHackathon.service.AppServiceDaoImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//Start of controller
@RestController
@Api(value = "Hackathon", description = "User operations")
public class AppController {
    @Autowired
    private AppRepository appRepository;
    @Autowired
    private AppServiceDaoImpl appService;
    
    //To get all users
    @RequestMapping(value = "/user", produces = "application/json", method = RequestMethod.GET)
    @ApiOperation(value = "View a list of available users", response = Iterable.class)
    public ResponseEntity<Iterable<AppDomain>> getAllUsers() {
        return new ResponseEntity<Iterable<AppDomain>>(appRepository.findAll(), HttpStatus.OK);
    }
    //To get user by ID
    @RequestMapping(value = "/user/{id}", produces = "application/json",method = RequestMethod.GET)
    @ApiOperation(value = "User for given Id", response = Iterable.class)
    public ResponseEntity<AppDomain> getUserById(@PathVariable("id") int id) {
        if(appService.ifExists(id))
        return new ResponseEntity<AppDomain>(appRepository.findById(id), HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    //To create new user
    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public ResponseEntity addUser(@RequestBody AppDomain appDomain) {
        if (appService.validate(appDomain.getEmail())) {
        appService.add(appDomain);
        return new ResponseEntity<String>("Added successfully", HttpStatus.OK);
        }
        else
            return new ResponseEntity<String>("Invalid email.", HttpStatus.EXPECTATION_FAILED);
            
    }
    //To update user by ID
    @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
    public ResponseEntity updateUser(@RequestBody AppDomain appDomain, @PathVariable int id) {
        if(appService.ifExists(id)) {
        appService.update(id, appDomain);
        return new ResponseEntity<String>("Updated successfully", HttpStatus.OK);
        }
        else
            return new ResponseEntity<String>("Id does not exist.", HttpStatus.NOT_FOUND);
            
    }
    //To delete user by ID
    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        if(appService.ifExists(id)) {
        appService.delete(id);
        return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
        }
        else return new ResponseEntity<String>("Id does not exist.", HttpStatus.NOT_FOUND);
    }
}
//End of controller
