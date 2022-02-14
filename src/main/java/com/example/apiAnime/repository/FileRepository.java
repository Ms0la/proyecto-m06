package com.example.apiAnime.repository;

import com.example.apiAnime.domain.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface FileRepository extends JpaRepository<File, UUID> {

}
