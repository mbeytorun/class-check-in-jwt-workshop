package com.tr.classroom.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ClassRoom {

    @Id
    @Column(name = "CLASS_ID", unique = true, nullable = false)
    private Long id;
    private String description;
    private String longitude;
    private String latitude;

    @OneToMany(mappedBy="classRoom", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Activity> activities = new HashSet<>();

    public ClassRoom() {

    }

    public ClassRoom(Long id, String description, String longitude, String latitude) {
        this.setId(id);
        this.setDescription(description);
        this.setLongitude(longitude);
        this.setLatitude(latitude);
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
