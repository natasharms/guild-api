package com.api.guildapplication.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_GUILD_MEMBER")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
