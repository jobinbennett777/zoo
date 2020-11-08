DROP TABLE Room;
CREATE TABLE Room 
(
  id BIGINT primary not null,
  version int not null default 0,
  title VARCHAR(255),
  size BIGINT,
  created TIMESTAMP
);

DROP TABLE Animal;
CREATE TABLE Animal 
(
  id BIGINT primary not null,
  version int not null default 0,
  title VARCHAR(255),
  room_id BIGINT,
  located TIMESTAMP,
  type VARCHAR(10)
  preference BIGINT 
  FOREIGN KEY (room_id) REFERENCES Room(id)
  
);

DROP TABLE Favorite;
CREATE TABLE Favorite 
(
  id BIGINT primary not null,
  version int not null default 0,
  room_id BIGINT,
  animal_id BIGINT
  FOREIGN KEY (animal_id) REFERENCES Animal(id)
  FOREIGN KEY (room_id) REFERENCES Room(id)
);

CREATE INDEX room_idx ON Room(id);
CREATE INDEX animal_idx ON Animal(id);
CREATE INDEX favorite_idx ON Favorite(id);