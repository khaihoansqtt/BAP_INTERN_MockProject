//package com.base.controller.token;
//
//import com.base.dto.BaseOkResDto;
//import com.base.service.SeminarService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//public class SeminarController {
//
//    @Autowired
//    SeminarService seminarService;
//
//    @RequestMapping("/seminars")
//    public ResponseEntity<?> getSeminars() {
//        BaseOkResDto res = seminarService.getSeminars();
//        return ResponseEntity.ok(res);
//    }
//}
