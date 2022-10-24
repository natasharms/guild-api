package com.api.guildapplication.dtos;

import javax.validation.constraints.*;

public class GuildMemberDTO {

    @NotBlank
    @Size(min = 2, max = 12)
    private String charName;

    @NotNull
    @Min(60)
    @Max(80)
    private Integer level;

    @NotBlank
    private String race;

    @NotBlank
    private String classe;

    @NotNull
    @Min(1000)
    private Integer gearScore;

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
}
