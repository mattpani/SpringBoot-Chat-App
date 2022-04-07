package sk.plaut.ChatApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.plaut.ChatApp.data.Messages;

import java.util.List;

public interface MessageRepository extends JpaRepository<Messages, Long> {

    List<Messages> findByUserId(Long id);
}
