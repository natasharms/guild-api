package com.api.guildapplication.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_GUILD_MEMBER")
public class GuildMemberModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 12)
    private String charName;

    @Column(nullable = false)
    private Integer level;

    @Column(nullable = false, length = 70)
    private String race;

    @Column(nullable = false, length = 70)
    private String classe;

    @Column(nullable = false)
    private Integer gearScore;

    @Column(nullable = false)
    private LocalDateTime registrationDate;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Integer getGearScore() {
        return gearScore;
    }

    public void setGearScore(Integer gearScore) {
        this.gearScore = gearScore;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
