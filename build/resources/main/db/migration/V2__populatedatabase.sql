
INSERT INTO anime(name, description, type, year, imageurl) VALUES
    ('Mushishi','Ginko se dedica a investigar a los mushis en sus viajes','TV', 2005, 'https://images.mubicdn.net/images/film/153182/cache-133623-1587132044/image-w1280.jpg?size=1200x'),
    ('Evangelion','Niño lloron, llora mucho y muy fuerte mientras pelea en un robot gigante y se masturba','TV', 1995, 'https://images.mubicdn.net/images/film/154627/cache-146791-1611262868/image-w1280.jpg?size=1200x'),
    ('Berserk','Un puto chad reparte espadazos en un mundo medieval en el que todo son violaciones','TV', 1997, 'https://images.mubicdn.net/images/film/178494/cache-245510-1502335231/image-w1280.jpg?size=1200x'),
    ('Inicial D','Niño coche brum brum manda a tomar por culo a furcia','TV', 1998, 'https://i.ytimg.com/vi/yK3-cgVejaw/maxresdefault.jpg'),
    ('GTO','Se le hinchan los huevos a un profe mafioso y pues acontecen eventos','TV', 1999, 'https://images.mubicdn.net/images/film/255010/cache-505973-1579403203/image-w1280.jpg?size=1200x');

INSERT INTO author(name, imageurl) VALUES
    ('Yuki Urushibara', 'https://www.babelio.com/users/AVT_Yuki-Urushibara_1980.jpeg'),
    ('Hideaki Anno', 'https://alchetron.com/cdn/hideaki-anno-deb11247-498d-414b-bd4c-d1e5cef3e2e-resize-750.jpeg'),
    ('Kentaro Miura', 'https://upload.wikimedia.org/wikipedia/en/thumb/1/1a/Kentaro_Miura.png/220px-Kentaro_Miura.png'),
    ('Shuichi Shigeno', 'https://sumikai.com/wp-content/uploads/2016/02/Shigeno-Shuuchi.jpg'),
    ('Tooru Fujisawa', 'https://static.wikia.nocookie.net/great-teacher-onizuka-gto/images/f/f7/Tohru_Fujisawa.PNG/revision/latest/scale-to-width-down/250?cb=20170725111304');


INSERT INTO genre(label) VALUES
      ('Seinen'),
      ('Mecha'),
      ('Cochecitos'),
      ('Shonen');

INSERT INTO anime_author VALUES
    ((SELECT animeid FROM anime WHERE name='Mushishi'),(SELECT authorid FROM author WHERE name='Yuki Urushibara')),
    ((SELECT animeid FROM anime WHERE name='Evangelion'),(SELECT authorid FROM author WHERE name='Hideaki Anno')),
    ((SELECT animeid FROM anime WHERE name='Berserk'),(SELECT authorid FROM author WHERE name='Kentaro Miura')),
    ((SELECT animeid FROM anime WHERE name='Inicial D'),(SELECT authorid FROM author WHERE name='Shuichi Shigeno')),
    ((SELECT animeid FROM anime WHERE name='GTO'),(SELECT authorid FROM author WHERE name='Tooru Fujisawa'));

INSERT INTO anime_genre VALUES
    ((SELECT animeid FROM anime WHERE name='Mushishi'),(SELECT genreid FROM genre WHERE label='Seinen')),
    ((SELECT animeid FROM anime WHERE name='Evangelion'),(SELECT genreid FROM genre WHERE label='Mecha')),
    ((SELECT animeid FROM anime WHERE name='Berserk'),(SELECT genreid FROM genre WHERE label='Seinen')),
    ((SELECT animeid FROM anime WHERE name='Inicial D'),(SELECT genreid FROM genre WHERE label='Cochecitos')),
    ((SELECT animeid FROM anime WHERE name='GTO'),(SELECT genreid FROM genre WHERE label='Seinen'));

CREATE EXTENSION IF NOT EXISTS pgcrypto;
INSERT INTO animeuser (username, password) VALUES
('user', crypt('pass', gen_salt('bf'))),
('user2', crypt('pass', gen_salt('bf'))),
('user3', crypt('pass', gen_salt('bf')));

INSERT INTO favourite VALUES
    ((SELECT animeid FROM anime WHERE name='Evangelion'),(SELECT userid FROM animeuser WHERE username = 'user'));

INSERT INTO usertouser(followerid, followedid) VALUES
((SELECT userid FROM animeuser WHERE username = 'user'), (SELECT userid FROM animeuser WHERE username = 'user2')),
((SELECT userid FROM animeuser WHERE username = 'user'), (SELECT userid FROM animeuser WHERE username = 'user3')),
((SELECT userid FROM animeuser WHERE username = 'user3'), (SELECT userid FROM animeuser WHERE username = 'user2'));

INSERT INTO recomendations(animeid, similaranimeid) VALUES
((SELECT animeid FROM anime WHERE name='Berserk'), (SELECT animeid FROM anime WHERE name='GTO'));

INSERT INTO comments(userid, animeid, comment) VALUES
((SELECT userid FROM animeuser WHERE username = 'user'), (SELECT animeid FROM anime WHERE name='GTO'), 'Es GOD')