package com.spm.eventmanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId; //ideally this should be a String in the future, example ; BP001 ; BP - Birthday Party
    private String eventName;
    private String time; //usually only start time is given for a event. so just name it time
    private String venue;
    private int guestCount;
}
