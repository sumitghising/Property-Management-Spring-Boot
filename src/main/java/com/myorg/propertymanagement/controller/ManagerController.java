    package com.myorg.propertymanagement.controller;

    import com.myorg.propertymanagement.dto.ManagerDTO;
    import com.myorg.propertymanagement.facade.ManagerFacade;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("api/v1/managers")
    public class ManagerController {

        @Autowired
        ManagerFacade managerFacade;

        @PostMapping("/")
        public ResponseEntity<ManagerDTO> signup(@RequestBody ManagerDTO body) {
            return new ResponseEntity(managerFacade.handleSignup(body),HttpStatus.OK);
        }

        @PostMapping("/auth")
        public ResponseEntity<Object> login(@RequestBody ManagerDTO body) {
            return managerFacade.handleLogin(body);
        }
    }

