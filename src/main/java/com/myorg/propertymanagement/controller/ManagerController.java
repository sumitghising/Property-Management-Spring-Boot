    package com.myorg.propertymanagement.controller;

    import com.myorg.propertymanagement.dto.ManagerDTO;
    import com.myorg.propertymanagement.model.Manager;
    import com.myorg.propertymanagement.service.ManagerService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.dao.DataIntegrityViolationException;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.HashMap;
    import java.util.Map;


    @RestController
    @RequestMapping("managers")
    public class ManagerController {
        @Autowired
        ManagerService managerService;

        @PostMapping("/")
        public ResponseEntity<Object> signup(@RequestBody ManagerDTO body){
            Map<String, Object> response =  new HashMap<>();

            try {
            Manager newManager = this.managerService.createManager(body);
            response.put("message", "Manager Added Successfully");
            response.put("data", newManager);
            response.put("success", true);

            return ResponseEntity.ok(response);
            }
            catch (DataIntegrityViolationException e){
                response.put("message", "Email already registered");
                response.put("success", false);

                return ResponseEntity.status(HttpStatus.CONFLICT).body(response);

            }

        }
        @PostMapping("/auth")
        public ResponseEntity<Object> login(@RequestBody ManagerDTO body){
            Map<String, Object> response =  new HashMap<>();
            try {
            response.put("token", this.managerService.login(body));
                response.put("message", "Login Successful");
                response.put("success", true);


            return ResponseEntity.ok(response);
            }
            catch (IllegalArgumentException e){
                response.put("message", "Invalid email or password");
                response.put("success", false);


                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);

            }






        }

        }
