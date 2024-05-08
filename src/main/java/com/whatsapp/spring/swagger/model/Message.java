
package com.whatsapp.spring.swagger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Message {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String textOrEmoji;
 private String fileUrl;

 @JsonIgnore
 @ManyToOne
 private User sender;

 @JsonIgnore
 @ManyToOne
 private ChatRoom chatroom;


 @Override
 public boolean equals(Object o) {
  if (this == o) return true;
  if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
  Message message = (Message) o;
  return getId() != null && Objects.equals(getId(), message.getId());
 }

 @Override
 public int hashCode() {
  return getClass().hashCode();
 }
}
