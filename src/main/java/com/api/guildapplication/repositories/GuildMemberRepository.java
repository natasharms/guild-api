package com.api.guildapplication.repositories;

import com.api.guildapplication.models.GuildMemberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GuildMemberRepository extends JpaRepository<GuildMemberModel, UUID> {

    boolean existsByCharName(String charName);
    Optional<GuildMemberModel> findByCharName(@Param("char_name")  String charName);
}
