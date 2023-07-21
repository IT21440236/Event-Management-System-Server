package com.spm.eventmanagementsystem.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDTO {
    private int eventId;
    private String eventCode;
    private String eventName;
    private String date;
    private String time;
    private String venue;
    private String description;
    private String organizer;
    private String category;
    private int guestCount;
    private String status;


}
