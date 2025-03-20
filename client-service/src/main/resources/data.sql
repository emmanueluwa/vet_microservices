-- Ensure the 'client' table exists
CREATE TABLE IF NOT EXISTS client
(
    id              UUID PRIMARY KEY,
    name            VARCHAR(255)        NOT NULL,
    email           VARCHAR(255) UNIQUE NOT NULL,
    address         VARCHAR(255)        NOT NULL,
    date_of_birth   DATE                NOT NULL,
    registered_date DATE                NOT NULL
    );

-- Insert well-known UUIDs for specific clients
INSERT INTO client (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174000',
       'Max Barker',
       'max.barker@pawmail.com',
       '123 Dogwood Lane, Pawville',
       '2018-06-15',
       '2024-01-10'
    WHERE NOT EXISTS (SELECT 1
                  FROM client
                  WHERE id = '123e4567-e89b-12d3-a456-426614174000');

INSERT INTO client (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174001',
       'Luna Whiskers',
       'luna.whiskers@meowmail.com',
       '456 Catnip Avenue, Feline Falls',
       '2020-09-23',
       '2023-12-01'
    WHERE NOT EXISTS (SELECT 1
                  FROM client
                  WHERE id = '123e4567-e89b-12d3-a456-426614174001');

INSERT INTO client (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174002',
       'Buddy Goodboy',
       'buddy.goodboy@barkmail.com',
       '789 Fetch Street, Wagtown',
       '2019-03-12',
       '2022-06-20'
    WHERE NOT EXISTS (SELECT 1
                  FROM client
                  WHERE id = '123e4567-e89b-12d3-a456-426614174002');

INSERT INTO client (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174003',
       'Mittens Purrington',
       'mittens.purrington@catmail.com',
       '321 Yarn Lane, Whiskerburg',
       '2021-11-30',
       '2023-05-14'
    WHERE NOT EXISTS (SELECT 1
                  FROM client
                  WHERE id = '123e4567-e89b-12d3-a456-426614174003');

INSERT INTO client (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174004',
       'Rocky Woof',
       'rocky.woof@dogmail.com',
       '654 Bone Street, Barkville',
       '2022-02-05',
       '2024-03-01'
    WHERE NOT EXISTS (SELECT 1
                  FROM client
                  WHERE id = '123e4567-e89b-12d3-a456-426614174004');

INSERT INTO client (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174005',
       'Whiskers McFluff',
       'whiskers.mcfluff@purr.com',
       '987 Tuna Avenue, Catropolis',
       '2019-07-25',
       '2024-02-15'
    WHERE NOT EXISTS (SELECT 1 FROM client WHERE id = '223e4567-e89b-12d3-a456-426614174005');

INSERT INTO client (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174006',
       'Fido Fetchington',
       'fido.fetchington@woofmail.com',
       '123 Squirrel Chase, Dogtown',
       '2020-04-18',
       '2023-08-25'
    WHERE NOT EXISTS (SELECT 1 FROM client WHERE id = '223e4567-e89b-12d3-a456-426614174006');

INSERT INTO client (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174007',
       'Hammy Wheel',
       'hammy.wheel@rodentmail.com',
       '456 Sunflower Seed Lane, Hamsterdam',
       '2023-01-11',
       '2022-10-10'
    WHERE NOT EXISTS (SELECT 1 FROM client WHERE id = '223e4567-e89b-12d3-a456-426614174007');

INSERT INTO client (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174008',
       'Polly Cracker',
       'polly.cracker@squawkmail.com',
       '789 Perch Street, Beaktown',
       '2021-09-02',
       '2024-04-20'
    WHERE NOT EXISTS (SELECT 1 FROM client WHERE id = '223e4567-e89b-12d3-a456-426614174008');

INSERT INTO client (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174009',
       'Fluffy Pawsome',
       'fluffy.pawsome@furmail.com',
       '321 Scratch Post Road, Meowburg',
       '2022-11-15',
       '2023-06-30'
    WHERE NOT EXISTS (SELECT 1 FROM client WHERE id = '223e4567-e89b-12d3-a456-426614174009');

INSERT INTO client (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174010',
       'Rex Barkington',
       'rex.barkington@k9mail.com',
       '654 Hydrant Circle, Pawville',
       '2018-08-09',
       '2023-01-22'
    WHERE NOT EXISTS (SELECT 1 FROM client WHERE id = '223e4567-e89b-12d3-a456-426614174010');

INSERT INTO client (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174011',
       'Nibbles Carrot',
       'nibbles.carrot@bunnymail.com',
       '987 Lettuce Lane, Hopstown',
       '2022-05-03',
       '2024-05-12'
    WHERE NOT EXISTS (SELECT 1 FROM client WHERE id = '223e4567-e89b-12d3-a456-426614174011');

INSERT INTO client (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174012',
       'Scales Slither',
       'scales.slither@reptilemail.com',
       '123 Basking Rock, Lizardville',
       '2021-12-25',
       '2022-11-11'
    WHERE NOT EXISTS (SELECT 1 FROM client WHERE id = '223e4567-e89b-12d3-a456-426614174012');

INSERT INTO client (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174013',
       'Goldie Fins',
       'goldie.fins@fishmail.com',
       '456 Bubble Stream, Aquaville',
       '2023-06-08',
       '2023-09-19'
    WHERE NOT EXISTS (SELECT 1 FROM client WHERE id = '223e4567-e89b-12d3-a456-426614174013');

INSERT INTO client (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174014',
       'Hopper Longears',
       'hopper.longears@rabbitmail.com',
       '789 Carrot Patch, Burrowtown',
       '2020-10-17',
       '2024-03-29'
    WHERE NOT EXISTS (SELECT 1 FROM client WHERE id = '223e4567-e89b-12d3-a456-426614174014');

