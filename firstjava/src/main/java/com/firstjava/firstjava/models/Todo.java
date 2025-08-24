package com.firstjava.firstjava.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Todo {

        @Id
        @GeneratedValue
        long id;
        String Description;
        String Status;

}
