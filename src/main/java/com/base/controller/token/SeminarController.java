
package com.base.controller.token;

import com.base.dto.BaseResDto;
import com.base.dto.seminar.getSeminars.GetSeminarsResDto;
import com.base.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SeminarController {

    @Autowired
    SeminarService seminarService;

    @GetMapping("/seminars")
    public ResponseEntity<?> getSeminars() {
        BaseResDto<GetSeminarsResDto> res = seminarService.getSeminars();
        return ResponseEntity.ok(res);
    }
}
