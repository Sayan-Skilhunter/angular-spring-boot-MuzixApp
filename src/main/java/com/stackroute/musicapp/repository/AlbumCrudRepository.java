package com.stackroute.musicapp.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.musicapp.model.Album;
@Repository
public interface AlbumCrudRepository extends JpaRepository<Album, Integer> {

	Optional<List<Album>> findByUserId(Long id);
}
