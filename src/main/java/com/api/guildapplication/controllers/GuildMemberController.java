package com.api.guildapplication.controllers;

import com.api.guildapplication.dtos.GuildMemberDTO;
import com.api.guildapplication.models.GuildMemberModel;
import com.api.guildapplication.services.GuildMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/guild-member")
public class GuildMemberController {

    @Autowired
    GuildMemberService guildMemberService;

    @PostMapping
    public ResponseEntity<Object> saveGuildMember(@RequestBody @Valid GuildMemberDTO guildMemberDTO){
        var guildMemberModel = new GuildMemberModel();
        BeanUtils.copyProperties(guildMemberDTO, guildMemberModel);
        guildMemberModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(guildMemberService.save(guildMemberModel));
    }

    @GetMapping
    public ResponseEntity<Page<GuildMemberModel>> getAllGuildMembers(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(guildMemberService.findAll(pageable));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getOneGuildMember(@PathVariable UUID id){
        Optional<GuildMemberModel> guildMemberModelOptional = guildMemberService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(guildMemberModelOptional.get());
    }

    @GetMapping("/name/{char_name}")
    public ResponseEntity<Object> getGuildMember(@PathVariable(value = "char_name") String charName){
        Optional<GuildMemberModel> guildMemberModelOptional = guildMemberService.findByCharName(charName);
        return ResponseEntity.status(HttpStatus.OK).body(guildMemberModelOptional.get());
    }

    @DeleteMapping("/{char_name}")
    public ResponseEntity<Object> deleteGuildMember(@PathVariable(value = "char_name") String charName){
        Optional<GuildMemberModel> guildMemberModelOptional = guildMemberService.findByCharName(charName);
        guildMemberService.delete(guildMemberModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Member deleted successfully.");
    }

    @PutMapping("/{char_name}")
    public ResponseEntity<Object> updateGuildMember(@PathVariable(value = "char_name") String charName,
                                                    @RequestBody @Valid GuildMemberDTO guildMemberDTO){
        Optional<GuildMemberModel> guildMemberModelOptional = guildMemberService.findByCharName(charName);
        var guildMemberModel = new GuildMemberModel();
        BeanUtils.copyProperties(guildMemberDTO, guildMemberModel);
        guildMemberModel.setId(guildMemberModelOptional.get().getId());
        guildMemberModel.setRegistrationDate(guildMemberModelOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(guildMemberService.save(guildMemberModel));
    }


}
