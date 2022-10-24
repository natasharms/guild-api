package com.api.guildapplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
