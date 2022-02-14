CREATE TABLE IF NOT EXISTS anime (
    animeid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name text,
    description text,
    type text,
    year smallint,
    imageurl text);


CREATE TABLE IF NOT EXISTS author (
    authorid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name text,
    imageurl text);

CREATE TABLE IF NOT EXISTS genre (
    genreid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    label text);

CREATE TABLE IF NOT EXISTS anime_author (
    animeid uuid REFERENCES anime(animeid) ON DELETE CASCADE,
    authorid uuid REFERENCES author(authorid) ON DELETE CASCADE,
    PRIMARY KEY (animeid, authorid));


CREATE TABLE IF NOT EXISTS anime_genre (
    animeid uuid REFERENCES anime(animeid) ON DELETE CASCADE,
    genreid uuid REFERENCES genre(genreid) ON DELETE CASCADE,
    PRIMARY KEY (animeid, genreid));

CREATE TABLE IF NOT EXISTS file (
    fileid UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    contenttype TEXT,
    data bytea);

CREATE TABLE IF NOT EXISTS animeuser (
    userid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    username varchar(24) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    role varchar(10),
    enabled boolean DEFAULT true
  );

CREATE TABLE IF NOT EXISTS favourite (
    animeid uuid REFERENCES anime(animeid) ON DELETE CASCADE,
    userid uuid REFERENCES animeuser(userid) ON DELETE CASCADE,
    PRIMARY KEY (animeid, userid));


CREATE TABLE IF NOT EXISTS usertouser(
     followerid uuid REFERENCES animeuser(userid) ON DELETE CASCADE,
     followedid uuid REFERENCES animeuser(userid) ON DELETE CASCADE,
       PRIMARY KEY (followerid, followedid));


CREATE TABLE IF NOT EXISTS recomendations(
        animeid uuid REFERENCES anime(animeid) ON DELETE CASCADE,
        similaranimeid uuid REFERENCES anime(animeid) ON DELETE CASCADE,
        PRIMARY KEY (animeid, similaranimeid));

CREATE TABLE IF NOT EXISTS comments (
    userid uuid REFERENCES animeuser(userid) ON DELETE CASCADE,
    animeid uuid REFERENCES anime(animeid) ON DELETE CASCADE,
    comment text,
    PRIMARY KEY (userid, animeid));

