
package com.base.service;

import com.base.dto.BaseResDto;
import com.base.dto.seminar.adminCreateSeminar.AdminCreateSeminarReqAndResDto;
import com.base.dto.seminar.adminGetSeminars.AdminGetSeminarsResDto;
import com.base.dto.seminar.s3.PresignedUrlDto;
import org.springframework.stereotype.Service;

@Service
public interface SeminarService {
    BaseResDto<AdminGetSeminarsResDto> getSeminars();

    BaseResDto<AdminCreateSeminarReqAndResDto> createSeminar(AdminCreateSeminarReqAndResDto req);
    BaseResDto<PresignedUrlDto> generatePreSignedUrl(String key, String contentType);
}
