package com.base.dto.seminar.getSeminars;

import com.base.entity.TTSeminar;
import com.base.entity.TTSeminarApplication;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.util.StopWatch;
import reactor.util.function.Tuple2;

import javax.persistence.Tuple;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Slf4j
public class SeminarDto {
    @JsonProperty("seminar_title")
    private String serminarTittle;

    @JsonProperty("is_hall_seminar")
    private boolean isHallSeminar;

    @JsonProperty("is_online_seminar")
    private boolean isOnlineSeminar;

    @JsonProperty("seminar_id")
    private int seminarId;

    @JsonProperty("list_overview")
    private String listOverview;

    @JsonProperty("event_startdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Ho_Chi_Minh")
    private Date eventStartdate;

    @JsonProperty("event_enddate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Ho_Chi_Minh")
    private Date eventEnddate;

    @JsonProperty("publication_start_date_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Ho_Chi_Minh")
    private Date publicationStartDateTime;

    @JsonProperty("publication_end_date_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Ho_Chi_Minh")
    private Date publicationEndDateTime;

    @JsonProperty("seminar_application")
//    private List<SeminarApplicationDto> seminarApplicationDto;
    private List<Map<String, Integer>> seminarApplicationInfo;

    public SeminarDto(TTSeminar seminar) {

        serminarTittle = seminar.getSeminarTitle();
        isHallSeminar = seminar.isHallSeminar();
        isOnlineSeminar = seminar.isOnlineSeminar();
        seminarId = seminar.getSeminarId();
        listOverview = seminar.getListOverview();
        eventStartdate = seminar.getEventStartdate();
        eventEnddate = seminar.getEventEnddate();
        publicationStartDateTime = seminar.getPublicationStartDateTime();
        publicationEndDateTime = seminar.getPublicationEndDateTime();
        //seminarApplicationInfo = buildSeminarApplictionInfo(seminar);
    }

    public List<Map<String, Integer>> buildSeminarApplictionInfo(TTSeminar seminar) {
        List<TTSeminarApplication> seminarApplications = seminar.getTtSeminarApplication();

        // Lưu count category dưới dạng key: mã category, value: số lượng đếm được
        Map<Integer, Integer> countCategory = new HashMap<>();
        StopWatch checkTime = new StopWatch();
//        checkTime.start();
//        var a = seminar.getTtSeminarApplication()
//                .stream()
//                .collect(Collectors.groupingBy(
//                        seminarApplication -> seminarApplication.getSeminarApplicationCategory(),
//                        Collectors.toList()
//                ))
//                .entrySet()
//                .stream()
//                .map(e -> Pair.of(e.getKey(), e.getValue().size()))
//                .collect(Collectors.toList());
//        checkTime.stop();

//        log.info("aaaaa: {}, in time1: {}", a, checkTime.getTotalTimeMillis());
        checkTime.start();
        for (TTSeminarApplication seminarApplication : seminarApplications) {
            int categoryKey = seminarApplication.getSeminarApplicationCategory();
            if (countCategory.containsKey(categoryKey)) {
                int newCount = countCategory.get(categoryKey) + 1;
                countCategory.put(categoryKey, newCount);
            } else {
                countCategory.put(categoryKey, 1);
            }
        }

        List<Map<String, Integer>> seminarApplicationInfo = new ArrayList<>();
        for (Integer key : countCategory.keySet()) {
            Map<String, Integer> info = new HashMap<>();
            info.put("seminar_application_member", countCategory.get(key));
            info.put("seminar_application_category", key);
            seminarApplicationInfo.add(info);
        }
        checkTime.stop();

        log.info("in time2: {}", checkTime.getTotalTimeMillis());
        return seminarApplicationInfo;
    }
}
