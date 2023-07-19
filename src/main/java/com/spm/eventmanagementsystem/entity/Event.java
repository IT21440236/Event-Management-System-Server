package com.spm.eventmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int eventId; //ideally this should be a String in the future, example ; BP001 ; BP - Birthday Party

    @Column(name = "event_name")
    private String eventName;

    private String data;
    private String time; //usually only start time is given for a event. so just name it time
    private String venue;
    private String description;
    private String organizer;
    private String category;

    @Column(name = "guest_count")
    private int guestCount;

    private String status;
}


//Notes

/*
In MySQL, the AUTO_INCREMENT feature is typically used for generating auto-incrementing numeric primary keys. However, if you want to generate a string primary key in MySQL, you can use the UUID (Universally Unique Identifier) data type.

To generate a UUID string as the primary key in your Event entity class, you can make the following modifications:

@Id
@GeneratedValue(generator = "uuid")
@GenericGenerator(name = "uuid", strategy = "uuid2")
@Column(name = "event_id", unique = true)
private String eventId;

Here, the @GeneratedValue annotation with the uuid generator and uuid2 strategy instructs the JPA provider to generate a unique UUID string for the eventId field.

Please note that you may need to add the appropriate import statements for the annotations and the GenericGenerator class.

Remember to ensure that your MySQL database column is set to accommodate the UUID string length, typically 36 characters.

* */