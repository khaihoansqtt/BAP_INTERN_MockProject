
package com.base.controller.token;

import com.base.dto.BaseResDto;
import com.base.dto.seminar.adminCreateSeminar.AdminCreateSeminarReqAndResDto;
import com.base.dto.seminar.adminCreateSeminar.FERequirePresignedUrlReqDto;
import com.base.dto.seminar.adminGetSeminars.AdminGetSeminarsResDto;
import com.base.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class SeminarController {

    @Autowired
    SeminarService seminarService;

    @GetMapping("/seminars")
    public ResponseEntity<?> getSeminars() {
        BaseResDto<AdminGetSeminarsResDto> res = seminarService.getSeminars();
        return ResponseEntity.ok(res);
    }

    @PostMapping("/seminar/create")
    public ResponseEntity<?> createSeminar(@Valid @RequestBody AdminCreateSeminarReqAndResDto req) {
        seminarService.createSeminar(req);
        return ResponseEntity.ok(BaseResDto.ok(req));
    }

    @PostMapping("/admin/seminar/create/presignUrl")
    public ResponseEntity<?> generateUrl(@Valid @RequestBody FERequirePresignedUrlReqDto req) {
        String fileName = req.getFileName();
        String folderPath = req.getFolderPath();
        String key = folderPath + fileName;
        String contentType = req.getContentType();
        return ResponseEntity.ok(seminarService.generatePreSignedUrl(key, contentType));
    }
}
