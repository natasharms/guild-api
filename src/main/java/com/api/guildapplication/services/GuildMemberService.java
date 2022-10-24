package com.api.guildapplication.services;

import com.api.guildapplication.models.GuildMemberModel;
import com.api.guildapplication.repositories.GuildMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import java.util.UUID;

@Service
public class GuildMemberService {

    @Autowired
    GuildMemberRepository guildMemberRepository;


    @Transactional
    public GuildMemberModel save(GuildMemberModel guildMemberModel) {
        return guildMemberRepository.save(guildMemberModel);
    }

    public boolean existsByCharName(String charName) {
        return guildMemberRepository.existsByCharName(charName);
    }

    public Page<GuildMemberModel> findAll(Pageable pageable) {
        return guildMemberRepository.findAll(pageable);
    }

    public Optional<GuildMemberModel> findById(UUID id) {
        return guildMemberRepository.findById(id);
    }

    @Transactional
    public void delete(GuildMemberModel guildMemberModel) {
        guildMemberRepository.delete(guildMemberModel);
    }

    public Optional<GuildMemberModel> findByCharName(String charName) {
        return guildMemberRepository.findByCharName(charName);
    }
}
