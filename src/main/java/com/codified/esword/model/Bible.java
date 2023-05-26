package com.codified.esword.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@Entity
@ToString
@Table(name = "Bible")
public class Bible {

    @EmbeddedId
    private ScriptureId scriptureId;

    @NonNull
    @Column(name = "scripture")
    private String scripture;
}
