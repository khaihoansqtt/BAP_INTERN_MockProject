
package com.base.service.impl;

import com.base.dto.BaseResDto;
import com.base.dto.seminar.adminCreateSeminar.AdminCreateSeminarReqAndResDto;
import com.base.dto.seminar.adminCreateSeminar.SeminarImageDto;
import com.base.dto.seminar.adminCreateSeminar.SeminarQuestionDto;
import com.base.dto.seminar.adminGetSeminars.AdminGetSeminarsResDto;
import com.base.dto.seminar.adminGetSeminars.SeminarDto;
import com.base.dto.seminar.s3.PresignedUrlDto;
import com.base.entity.*;
import com.base.repository.*;
import com.base.service.SeminarService;
import com.base.spring.exception.NoSeminarExistedException;
import com.base.spring.exception.SeminarTimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import javax.transaction.Transactional;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class SeminarServiceImpl implements SeminarService {
    @Autowired
    SeminarRepository seminarRepository;
    @Autowired
    IconRepository iconRepository;
    @Autowired
    SeminarIconRepository seminarIconRepository;
    @Autowired
    SeminarImageRepository seminarImageRepository;
    @Autowired
    SeminarDetailRepository seminarDetailRepository;
    @Autowired
    SeminarMailInfoRepository seminarMailInfoRepository;
    @Autowired
    QuestionnairesQuestionRepository questionnairesQuestionRepository;
    @Autowired
    QuestionnairesRepository questionnairesRepository;
    @Autowired
    private S3Presigner presigner;
    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Value("${aws.region}")
    private String regionValue;

    @Override
    public BaseResDto<AdminGetSeminarsResDto> getSeminars() {
        Optional<List<TTSeminar>> seminarListOptional = seminarRepository.findAllByIsDeleteIsFalse();

        if (seminarListOptional.isPresent()) {
            List<TTSeminar> seminars = seminarListOptional.get();

            List<SeminarDto> seminarDtos = seminars.stream().map(SeminarDto::new).collect(Collectors.toList());
            return BaseResDto.ok(new AdminGetSeminarsResDto(seminarDtos));
        } else throw new NoSeminarExistedException();
    }

    public BaseResDto<PresignedUrlDto> generatePreSignedUrl(String key, String contentType) {
        log.info("create presigned url with key: " + key);
        try {
            PutObjectRequest objectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .contentType(contentType)
                    .build();

            PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                    .signatureDuration(Duration.ofMinutes(2))
                    .putObjectRequest(objectRequest)
                    .build();

            PresignedPutObjectRequest presignedRequest = presigner.presignPutObject(presignRequest);
            String presignedUrl = presignedRequest.url().toString();
            System.out.println("Presigned URL to upload a file to: " +presignedUrl);
            System.out.println("Which HTTP method needs to be used when uploading a file: " + presignedRequest.httpRequest().method());

            GetUrlRequest getUrlRequest = GetUrlRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .build();
            S3Client s3Client = S3Client.builder().region(Region.of(regionValue)).build();
            String publicUrl = s3Client.utilities().getUrl(getUrlRequest).toExternalForm();
            return BaseResDto.ok(new PresignedUrlDto(presignedUrl, publicUrl));
        } catch (S3Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public BaseResDto<AdminCreateSeminarReqAndResDto> createSeminar(AdminCreateSeminarReqAndResDto req) {
        if (req.getEventStartdate().after(req.getEventEnddate())) {
            throw new SeminarTimeException();
        }
//      create questionnaires and question
        TTQuestionnaires questionnaires = TTQuestionnaires.builder()
                .isDelete(false)
                .createFuncId("M0502")
                // hardcode
                .createPersonId(1)
                .createDateTime(new Date())
                .updateFuncId("M0502")
                // hardcode
                .updatePersonId(1)
                .updateDateTime(new Date())
                .build();

        for (SeminarQuestionDto seminarQuestionDto : req.getSeminarQuestionDtoList()) {
            TTQuestionnairesQuestion questionnairesQuestion = TTQuestionnairesQuestion.builder()
                    .isRequiredAnswer(seminarQuestionDto.isRequiredAnswer())
                    .questionnaireCdformat(seminarQuestionDto.getQuestionnaireCdFormat())
                    .questionnaireQuestion(seminarQuestionDto.getQuestionnaireQuestion())
                    .answer(seminarQuestionDto.getAnswer())
                    .isDelete(false)
                    .ttQuestionnaires(questionnaires)
                    .createFuncId("M0502")
                    // hardcode
                    .createPersonId(1)
                    .createDateTime(new Date())
                    .updateFuncId("M0502")
                    // hardcode
                    .updatePersonId(1)
                    .updateDateTime(new Date())
                    .build();
            questionnairesQuestionRepository.save(questionnairesQuestion);
        }
//      create seminar
        TTSeminar newSeminar = TTSeminar.builder()
                .seminarTitle(req.getSerminarTittle())
                .isHallSeminar(req.isHallSeminar())
                .isOnlineSeminar(req.isOnlineSeminar())
                .eventStartdate(req.getEventStartdate())
                .eventEnddate(req.getEventEnddate())
                .publicationStartDateTime(req.getPublicationStartDateTime())
                .publicationEndDateTime(req.getPublicationEndDateTime())
                .seminarMaximumParticipant(req.getSeminarMaximumParticipant())
                .listOverview("list overview")
                .isDelete(false)
                .ttQuestionnaires(questionnaires)
                .createFuncId("M0502")
                // hardcode
                .createPersonId(1)
                .createDateTime(new Date())
                .updateFuncId("M0502")
                // hardcode
                .updatePersonId(1)
                .updateDateTime(new Date())
                .build();
//      create seminarIcon
        req.getSeminarAttributeDtoList().stream().map(seminarAttributeDto ->
                        iconRepository.findById(seminarAttributeDto.getIconId()).get()
                )
                .forEach((icon) -> {
                    TRSeminarIcon seminarIcon = TRSeminarIcon.builder()
                            .isDelete(false)
                            .tmIcon(icon)
                            .ttSeminar(newSeminar)
                            .createFuncId("M0502")
                            // hardcode
                            .createPersonId(1)
                            .createDateTime(new Date())
                            .updateFuncId("M0502")
                            // hardcode
                            .updatePersonId(1)
                            .updateDateTime(new Date())
                            .build();
                    seminarIconRepository.save(seminarIcon);
                });
//      create seminarImage
        List<SeminarImageDto> seminarImageDtoList = req.getSeminarImageDtoList();
        for (SeminarImageDto seminarImageDto : seminarImageDtoList) {

            if (seminarImageDto == null) continue;
            TTSeminarImage seminarImage = TTSeminarImage.builder()
                    .imageCategory(1)
                    .fileName(seminarImageDto.getFileName())
                    .filePath(seminarImageDto.getFilePath())
                    // + 1 để thành các số 1, 2, 3, 4, 5, 6 -> display-order
                    .displayOrder(seminarImageDtoList.indexOf(seminarImageDto) + 1)
                    .isDelete(false)
                    .ttSeminar(newSeminar)
                    .createFuncId("M0502")
                    // hardcode
                    .createPersonId(1)
                    .createDateTime(new Date())
                    .updateFuncId("M0502")
                    // hardcode
                    .updatePersonId(1)
                    .updateDateTime(new Date())
                    .build();
            seminarImageRepository.save(seminarImage);
        }
//      create seminarDetails
        TTSeminarDetail seminarDetail = TTSeminarDetail.builder()
                .displayOrder(1)
                .headline(req.getSeminarDetailsDto().getHeadline())
                .contents(req.getSeminarDetailsDto().getContent())
                .isDelete(false)
                .ttSeminar(newSeminar)
                .createFuncId("M0502")
                // hardcode
                .createPersonId(1)
                .createDateTime(new Date())
                .updateFuncId("M0502")
                // hardcode
                .updatePersonId(1)
                .updateDateTime(new Date())
                .build();
        seminarDetailRepository.save(seminarDetail);
//      create seminarMailInfo
        TTSeminarMailInfo seminarMailInfo = TTSeminarMailInfo.builder()
                .optionalMessageHall(req.getSeminarEmailDto().getOptionalMessageHall())
                .optionalMessageOnline(req.getSeminarEmailDto().getOptionalMessageOnline())
                .isDelete(false)
                .ttSeminar(newSeminar)
                .createFuncId("M0502")
                // hardcode
                .createPersonId(1)
                .createDateTime(new Date())
                .updateFuncId("M0502")
                // hardcode
                .updatePersonId(1)
                .updateDateTime(new Date())
                .build();
        seminarMailInfoRepository.save(seminarMailInfo);
        return null;
    }
}