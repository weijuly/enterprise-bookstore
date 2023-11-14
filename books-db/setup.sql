create database books;

create user 'service'@'localhost' identified by 'password';
create user 'service'@'%' identified by 'password';

grant all privileges on books.* to 'service'@'localhost';
grant all privileges on books.* to 'service'@'%';

flush privileges;

use books;

drop table if exists BOOK;
create table BOOK (
    ID              VARCHAR(64)         PRIMARY KEY,
    ISBN            VARCHAR(64)         NOT NULL UNIQUE,
    TITLE           VARCHAR(256)        NOT NULL,
    SUMMARY         VARCHAR(1024)       NOT NULL,
    PUBLISHED_ON    INT                 NOT NULL,
    PAGES           INT                 NOT NULL
);

drop table if exists AUTHOR;
create table AUTHOR (
    ID              VARCHAR(64)         PRIMARY KEY,
    AUTHOR_NAME     VARCHAR(256)        NOT NULL UNIQUE,
    ABOUT           VARCHAR(1024)       NOT NULL
);  

drop table if exists BIBLIOGRAPHY;
create table BIBLIOGRAPHY (
    ID              VARCHAR(64)         PRIMARY KEY,
    BOOK_ID         VARCHAR(64)         NOT NULL,
    AUTHOR_ID       VARCHAR(64)         NOT NULL
);

drop table if exists GENRE;
create table GENRE (
    ID              VARCHAR(64)         PRIMARY KEY,
    GENRE_NAME      VARCHAR(128)        NOT NULL
);

drop table if exists BOOK_GENRE;
create table BOOK_GENRE (
    ID              VARCHAR(64)         PRIMARY KEY,
    BOOK_ID         VARCHAR(64)         NOT NULL,
    GENRE_ID        VARCHAR(64)         NOT NULL
);

drop table if exists AUTHOR_GENRE;
create table AUTHOR_GENRE (
    ID              VARCHAR(64)         PRIMARY KEY,
    AUTHOR_ID       VARCHAR(64)         NOT NULL,
    GENRE_ID        VARCHAR(64)         NOT NULL
);


insert into BOOK
    (ID, ISBN, TITLE, SUMMARY, PUBLISHED_ON, PAGES)
values
    ('057f0f2a-ca86-4280-ad53-9fbc93bd9f21', '1527278930996', 'A Tale of Two Cities', 'A Tale of Two Cities', 1859, 352),
    ('80142dfd-d7e8-4f59-9264-b7b47e8092af', '3045313642213', 'Great Expectations', 'Great Expectations', 1861, 505),
    ('188c9b42-b174-4752-961f-ade8f5efbdd0', '5602229421285', 'Oliver Twist', 'Oliver Twist', 1837, 384),
    ('c5db578a-22b5-4eeb-9ec6-304017930f27', '4551325525649', 'David Copperfield', 'David Copperfield', 1850, 624),
    ('92809dfc-cbfb-4c63-a6eb-a509ad02f8b1', '1247087669056', 'Bleak House', 'Bleak House', 1852, 1019),
    ('0aabd224-ed58-40e1-bd0c-5b6e29284a2a', '1245052270932', 'Little Dorrit', 'Little Dorrit', 1857, 945),
    ('e5823745-42fd-4c08-9c9e-a63de4849f83', '4877104890863', 'Nicholas Nickleby', 'Nicholas Nickleby', 1839, 823),
    ('30823605-ae67-4d74-8457-936cb5aa2031', '1000409365213', 'Hard Times', 'Hard Times', 1854, 352),
    ('9e11bcf2-57ea-452b-989a-acbed822aeeb', '9424674979620', 'The Pickwick Papers', 'The Pickwick Papers', 1836, 609),
    ('3d2437fb-15c4-452a-bfe4-0eb8e77d8964', '6052957359212', 'A Christmas Carol', 'A Christmas Carol', 1843, 104),
    ('d4eb9924-ebf6-4e1f-87cf-6dfd67007594', '2080991703191', 'Twenty Thousand Leagues Under the Sea', 'Twenty Thousand Leagues Under the Sea', 1870, 366),
    ('257702b9-3fee-44b3-b178-4beb2dc13d29', '9031456470297', 'Around the World in Eighty Days', 'Around the World in Eighty Days', 1873, 256),
    ('d948f5f8-c48a-41a5-a058-2f5808146b79', '8092607242777', 'Journey to the Center of the Earth', 'Journey to the Center of the Earth', 1864, 183),
    ('793e6888-9b20-4368-b586-f779d4ac648a', '9610684368253', 'The Mysterious Island', 'The Mysterious Island', 1874, 632),
    ('91ea4596-5dbb-493f-801c-4fd602961beb', '5213485349394', 'From the Earth to the Moon', 'From the Earth to the Moon', 1865, 243),
    ('26fdae9a-0178-42b3-b546-149111c1a90b', '6604815482807', 'The Adventures of Captain Hatteras', 'The Adventures of Captain Hatteras', 1866, 368),
    ('181349b0-ee7b-46cd-b87c-a8019b3f888b', '5634011564966', 'Five Weeks in a Balloon', 'Five Weeks in a Balloon', 1866, 258),
    ('94c300e6-4166-46ff-a10d-75ce14bfec97', '5307585688871', 'The Children of Captain Grant', 'The Children of Captain Grant', 1868, 688),
    ('eebe83d1-8621-47c6-ba2a-e4f0495100fb', '7729615966121', 'Robur the Conqueror', 'Robur the Conqueror', 1886, 288),
    ('fc09ef5d-e494-471b-aa4e-808ce887abe9', '8301013502636', 'Michael Strogoff', 'Michael Strogoff', 1876, 313),
    ('1181f8f5-072e-4175-9ad4-c852038099bc', '6413189978057', '1984', '1984', 1949, 328),
    ('45f796b2-5eb3-4f11-bc80-d67097a8b84c', '6306560446207', 'Animal Farm', 'Animal Farm', 1945, 112),
    ('c09395fe-1a81-4f39-9dd9-93cd4dec7f94', '4861861472074', 'Homage to Catalonia', 'Homage to Catalonia', 1938, 272),
    ('9318c5d6-6b00-4ec1-9d65-ce23c0901b52', '6872591159058', 'Down and Out in Paris and London', 'Down and Out in Paris and London', 1933, 256),
    ('f4cd2ce5-468d-4361-91b6-9f55a62ada68', '8352769750100', 'Burmese Days', 'Burmese Days', 1934, 288),
    ('3aa2cdc3-388a-41de-bc9c-24eeff21b3b9', '7558831658464', 'The Road to Wigan Pier', 'The Road to Wigan Pier', 1937, 264),
    ('42a1eb4d-bb67-4d07-84cf-c37b779c09d6', '2712280750039', 'Keep the Aspidistra Flying', 'Keep the Aspidistra Flying', 1936, 296),
    ('85025b03-427e-45bd-8ce7-814102190cdf', '8682719073578', 'Coming Up for Air', 'Coming Up for Air', 1939, 277),
    ('095cd5b9-3de9-4705-b11d-6c14aae8a8aa', '1734314276960', 'A Clergymans Daughter', 'A Clergymans Daughter', 1935, 288),
    ('9b8f9035-bae2-4863-be7b-9e1b55739fd1', '7188442070972', 'The Lion and the Unicorn', 'The Lion and the Unicorn', 1941, 84);
commit;


insert into AUTHOR
    (ID, AUTHOR_NAME, ABOUT)
values
    ('48b9d512-61d5-4953-a245-ebd1548f8f47', 'Charles Dickens', 'Charles Dickens'),
    ('376f7bf2-4063-4163-9ee1-ee674d44614e', 'Jules Verne', 'Jules Verne'),
    ('aae95654-f927-4bfd-85bf-e416c8dd6956', 'George Orwell', 'George Orwell');
commit;

insert into BIBLIOGRAPHY
    (ID, BOOK_ID, AUTHOR_ID)
values
    ('c81a8224-d9f1-473d-a2ae-e1cb48319ce8', '057f0f2a-ca86-4280-ad53-9fbc93bd9f21', '48b9d512-61d5-4953-a245-ebd1548f8f47'),
    ('edc49aa7-b6c0-45aa-b9ca-47469685e52e', '80142dfd-d7e8-4f59-9264-b7b47e8092af', '48b9d512-61d5-4953-a245-ebd1548f8f47'),
    ('5503fc44-d189-452d-8cca-6553ea7e5399', '188c9b42-b174-4752-961f-ade8f5efbdd0', '48b9d512-61d5-4953-a245-ebd1548f8f47'),
    ('cabed639-ebeb-4a7b-81b4-44b03fa2ede2', 'c5db578a-22b5-4eeb-9ec6-304017930f27', '48b9d512-61d5-4953-a245-ebd1548f8f47'),
    ('bc9716eb-48d0-4438-b425-550a8a4f92d2', '92809dfc-cbfb-4c63-a6eb-a509ad02f8b1', '48b9d512-61d5-4953-a245-ebd1548f8f47'),
    ('26036cb5-6b79-4c52-814b-f3fecfdeafad', '0aabd224-ed58-40e1-bd0c-5b6e29284a2a', '48b9d512-61d5-4953-a245-ebd1548f8f47'),
    ('e2fb7fc1-0b96-41b3-8eec-f1136fe06234', 'e5823745-42fd-4c08-9c9e-a63de4849f83', '48b9d512-61d5-4953-a245-ebd1548f8f47'),
    ('9b00a88f-ab4d-442b-b1c1-08c19bdb2d60', '30823605-ae67-4d74-8457-936cb5aa2031', '48b9d512-61d5-4953-a245-ebd1548f8f47'),
    ('86ffaa34-27ae-4b4d-bdb8-f752da428072', '9e11bcf2-57ea-452b-989a-acbed822aeeb', '48b9d512-61d5-4953-a245-ebd1548f8f47'),
    ('baca49fd-b601-4dba-a3af-fc21c37b3a25', '3d2437fb-15c4-452a-bfe4-0eb8e77d8964', '48b9d512-61d5-4953-a245-ebd1548f8f47'),
    ('48a67204-3d23-406f-9f07-073effe16227', 'd4eb9924-ebf6-4e1f-87cf-6dfd67007594', '376f7bf2-4063-4163-9ee1-ee674d44614e'),
    ('da4e8562-7fe3-48bf-80af-c17d1a0f2e22', '257702b9-3fee-44b3-b178-4beb2dc13d29', '376f7bf2-4063-4163-9ee1-ee674d44614e'),
    ('489548ee-c10a-4202-bf75-a47e029af324', 'd948f5f8-c48a-41a5-a058-2f5808146b79', '376f7bf2-4063-4163-9ee1-ee674d44614e'),
    ('a1a86225-753e-4911-aab0-ac4d1643c063', '793e6888-9b20-4368-b586-f779d4ac648a', '376f7bf2-4063-4163-9ee1-ee674d44614e'),
    ('39527ac5-77da-440d-aa7d-6f4cb5506131', '91ea4596-5dbb-493f-801c-4fd602961beb', '376f7bf2-4063-4163-9ee1-ee674d44614e'),
    ('eb9e8d6b-6c33-4cdf-8aeb-9c7935f452ff', '26fdae9a-0178-42b3-b546-149111c1a90b', '376f7bf2-4063-4163-9ee1-ee674d44614e'),
    ('858a4e49-11a3-407a-b064-513e8be03f4c', '181349b0-ee7b-46cd-b87c-a8019b3f888b', '376f7bf2-4063-4163-9ee1-ee674d44614e'),
    ('a13c74ec-72eb-4d7d-b540-ed07702a6d0d', '94c300e6-4166-46ff-a10d-75ce14bfec97', '376f7bf2-4063-4163-9ee1-ee674d44614e'),
    ('0f305065-cc85-4796-aecb-fbdbcf0c5909', 'eebe83d1-8621-47c6-ba2a-e4f0495100fb', '376f7bf2-4063-4163-9ee1-ee674d44614e'),
    ('fa17b2d5-3a39-4eb6-a31a-29a007014408', 'fc09ef5d-e494-471b-aa4e-808ce887abe9', '376f7bf2-4063-4163-9ee1-ee674d44614e'),
    ('963ca4ef-1cf8-40bc-b9dd-bd0aa7eb9e0f', '1181f8f5-072e-4175-9ad4-c852038099bc', 'aae95654-f927-4bfd-85bf-e416c8dd6956'),
    ('346adecf-4bd7-445f-be02-9c8cee527f99', '45f796b2-5eb3-4f11-bc80-d67097a8b84c', 'aae95654-f927-4bfd-85bf-e416c8dd6956'),
    ('81946409-b3b2-415f-b7d5-0f0e710e4c09', 'c09395fe-1a81-4f39-9dd9-93cd4dec7f94', 'aae95654-f927-4bfd-85bf-e416c8dd6956'),
    ('9e459ea7-01e9-40d5-9988-ade9105e530e', '9318c5d6-6b00-4ec1-9d65-ce23c0901b52', 'aae95654-f927-4bfd-85bf-e416c8dd6956'),
    ('43f66f70-3db2-420a-9f6a-dcba0da4b5ef', 'f4cd2ce5-468d-4361-91b6-9f55a62ada68', 'aae95654-f927-4bfd-85bf-e416c8dd6956'),
    ('259fe0aa-3018-4f19-8ddc-ed5e4e4f66bf', '3aa2cdc3-388a-41de-bc9c-24eeff21b3b9', 'aae95654-f927-4bfd-85bf-e416c8dd6956'),
    ('162fbc9a-9c03-460e-ab2c-a4c02c9b50da', '42a1eb4d-bb67-4d07-84cf-c37b779c09d6', 'aae95654-f927-4bfd-85bf-e416c8dd6956'),
    ('da2b9d76-99c0-46a2-a56c-5dd01e913ec7', '85025b03-427e-45bd-8ce7-814102190cdf', 'aae95654-f927-4bfd-85bf-e416c8dd6956'),
    ('ae5373da-4f02-4b84-b870-fa2ec75d517f', '095cd5b9-3de9-4705-b11d-6c14aae8a8aa', 'aae95654-f927-4bfd-85bf-e416c8dd6956'),
    ('d8544963-5bae-4d3e-8764-28168d026629', '9b8f9035-bae2-4863-be7b-9e1b55739fd1', 'aae95654-f927-4bfd-85bf-e416c8dd6956');
commit;

insert into GENRE
    (ID, GENRE_NAME)
values
    ('c842da37-cbb5-4ee4-8df8-d410683cf589', 'FICTION');
commit;

insert into BOOK_GENRE
    (ID, BOOK_ID, GENRE_ID)
values
    ('cb72e19c-1271-426f-951a-b7470a89cb2b', '057f0f2a-ca86-4280-ad53-9fbc93bd9f21', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('9fa276ea-4b82-453c-b1eb-2f805292d5fc', '80142dfd-d7e8-4f59-9264-b7b47e8092af', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('cb7f0be5-23c3-47a3-a0cb-9ce23d48318f', '188c9b42-b174-4752-961f-ade8f5efbdd0', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('d691a6f3-c4ec-4f70-9d31-9365da87d889', 'c5db578a-22b5-4eeb-9ec6-304017930f27', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('c4d17ddb-b130-47f2-9eb0-492672a28bd2', '92809dfc-cbfb-4c63-a6eb-a509ad02f8b1', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('7c308e3e-9448-4cf3-aeca-e6fb40f53a5b', '0aabd224-ed58-40e1-bd0c-5b6e29284a2a', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('ec5b1427-6193-4e83-aaae-495ab56f13af', 'e5823745-42fd-4c08-9c9e-a63de4849f83', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('3cedbe2d-be39-400c-81ea-0cc98275f82c', '30823605-ae67-4d74-8457-936cb5aa2031', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('ccb4118e-75c1-493d-99d5-94bad0584b03', '9e11bcf2-57ea-452b-989a-acbed822aeeb', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('be86595c-77a6-4d33-abe6-96d129f845b7', '3d2437fb-15c4-452a-bfe4-0eb8e77d8964', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('e5a69e59-62c4-482c-81b7-0725e2ad3902', 'd4eb9924-ebf6-4e1f-87cf-6dfd67007594', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('8880eaf7-55ba-4c96-8b20-8472ad27d333', '257702b9-3fee-44b3-b178-4beb2dc13d29', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('3481e436-6391-4793-9e65-4dfc2714a209', 'd948f5f8-c48a-41a5-a058-2f5808146b79', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('2cb750b2-cc81-4405-b8fd-f2dc573a6b57', '793e6888-9b20-4368-b586-f779d4ac648a', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('a547ff3a-1176-4509-bd53-8246fb2d89ba', '91ea4596-5dbb-493f-801c-4fd602961beb', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('b2814f74-8f44-41db-9b33-a97d62195f7c', '26fdae9a-0178-42b3-b546-149111c1a90b', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('6df353f4-1dab-413c-871b-35dc3b7f1ad6', '181349b0-ee7b-46cd-b87c-a8019b3f888b', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('84790028-4f83-4765-9fef-f079b746d149', '94c300e6-4166-46ff-a10d-75ce14bfec97', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('662ed515-6e2a-48ab-8e71-9f71b85cd7a0', 'eebe83d1-8621-47c6-ba2a-e4f0495100fb', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('1e0c80fa-5ad9-4769-afa1-fce702b88231', 'fc09ef5d-e494-471b-aa4e-808ce887abe9', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('b8449cf2-79d5-4f5b-a7e2-0581ba6d9bf8', '1181f8f5-072e-4175-9ad4-c852038099bc', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('0708a623-204b-4161-ae49-ce8660293358', '45f796b2-5eb3-4f11-bc80-d67097a8b84c', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('25248fff-7745-44c6-a936-66880be36e4c', 'c09395fe-1a81-4f39-9dd9-93cd4dec7f94', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('8963909c-e709-4ce0-8c68-d8b0284eb8be', '9318c5d6-6b00-4ec1-9d65-ce23c0901b52', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('25b0d0c1-8586-4e74-8a38-caed91dadadb', 'f4cd2ce5-468d-4361-91b6-9f55a62ada68', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('607480cb-7d01-437f-b4f4-e3de3eced2da', '3aa2cdc3-388a-41de-bc9c-24eeff21b3b9', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('ba491c07-8ca1-4c32-8c96-bcc26286066b', '42a1eb4d-bb67-4d07-84cf-c37b779c09d6', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('36de416d-93e5-4e9c-8c73-673260dd0d83', '85025b03-427e-45bd-8ce7-814102190cdf', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('35010a67-cde8-4e31-bd14-79d951c41732', '095cd5b9-3de9-4705-b11d-6c14aae8a8aa', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('1d87563e-b1f6-4318-a32f-65fec6ee299c', '9b8f9035-bae2-4863-be7b-9e1b55739fd1', 'c842da37-cbb5-4ee4-8df8-d410683cf589');
commit;

insert into AUTHOR_GENRE
    (ID, AUTHOR_ID, GENRE_ID)
values
    ('edcb6035-f665-44de-8002-318171e0cf29', '48b9d512-61d5-4953-a245-ebd1548f8f47', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('eea057ec-ca07-456a-8977-09b54165ec3e', '376f7bf2-4063-4163-9ee1-ee674d44614e', 'c842da37-cbb5-4ee4-8df8-d410683cf589'),
    ('a56eaf77-6d23-4c0e-ae1c-c78fe7c0e65a', 'aae95654-f927-4bfd-85bf-e416c8dd6956', 'c842da37-cbb5-4ee4-8df8-d410683cf589');
commit;
