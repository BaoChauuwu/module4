package chaudnb.example.validate_song.service;

import chaudnb.example.validate_song.entity.Song;
import chaudnb.example.validate_song.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SongService {
    
    private final SongRepository songRepository;
    
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }
    
    public Optional<Song> getSongById(Long id) {
        return songRepository.findById(id);
    }
    
    public Song saveSong(Song song) {
        return songRepository.save(song);
    }
    
    public Song updateSong(Long id, Song songDetails) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if (optionalSong.isPresent()) {
            Song existingSong = optionalSong.get();
            existingSong.setTitle(songDetails.getTitle());
            existingSong.setArtist(songDetails.getArtist());
            existingSong.setGenre(songDetails.getGenre());
            return songRepository.save(existingSong);
        }
        throw new RuntimeException("Không tìm thấy bài hát với ID: " + id);
    }
    
    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}

