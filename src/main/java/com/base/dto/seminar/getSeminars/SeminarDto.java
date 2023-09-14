package com.base.dto.seminar.getSeminars;

import com.base.entity.TTSeminar;
import com.base.entity.TTSeminarApplication;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
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
    private Date eventStartdate;

    @JsonProperty("event_enddate")
    private Date eventEndDate;

    @JsonProperty("publication_start_date_time")
    private Date publicationStartDateTime;

    @JsonProperty("publication_end_date_time")
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
        eventEndDate = seminar.getEventEndDate();
        publicationStartDateTime = seminar.getPublicationStartDateTime();
        publicationEndDateTime = seminar.getPublicationEndDateTime();
        seminarApplicationInfo = buildSeminarApplictionInfo(seminar);
    }

    public List<Map<String, Integer>> buildSeminarApplictionInfo(TTSeminar seminar) {
        List<TTSeminarApplication> seminarApplications = seminar.getTtSeminarApplication();

        // Lưu count category dưới dạng key: mã category, value: số lượng đếm được
        Map<Integer, Integer> countCategory = new HashMap<>();
        for (TTSeminarApplication seminarApplication : seminarApplications) {
            int categoryKey = seminarApplication.getSeminarApplicationCategory();
            if (countCategory.containsKey(categoryKey)) {
                int newCount = countCategory.get(categoryKey) + 1;
                countCategory.put(categoryKey, newCount);
            } else {
                countCategory.put(categoryKey, 0);
            }
        }

        List<Map<String, Integer>> seminarApplicationInfo = new ArrayList<>();
        for (Integer key : countCategory.keySet()) {
            Map<String, Integer> info = new HashMap<>();
            info.put("seminar_application_category", key);
            info.put("seminar_application_member", countCategory.get(key));
            seminarApplicationInfo.add(info);
        }
        return seminarApplicationInfo;
    }
}
