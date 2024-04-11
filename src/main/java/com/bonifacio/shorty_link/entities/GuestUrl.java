package com.bonifacio.shorty_link.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "guest_urls")
@Data
public class GuestUrl extends Url {
    public GuestUrl(){
        super();
    }
}
