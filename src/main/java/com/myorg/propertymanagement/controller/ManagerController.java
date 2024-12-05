    package com.myorg.propertymanagement.controller;

    import com.myorg.propertymanagement.dto.ManagerDTO;
    import com.myorg.propertymanagement.facade.ManagerFacade;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("managers")
    public class ManagerController {

        @Autowired
        ManagerFacade managerFacade;

        @PostMapping("/")
        public ResponseEntity<Object> signup(@RequestBody ManagerDTO body) {
            return managerFacade.handleSignup(body);
        }

        @PostMapping("/auth")
        public ResponseEntity<Object> login(@RequestBody ManagerDTO body) {
            return managerFacade.handleLogin(body);
        }
    }

