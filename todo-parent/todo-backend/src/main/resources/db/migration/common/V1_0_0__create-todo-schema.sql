create table todo
(
    id          UUID PRIMARY KEY,
    username    VARCHAR(80) NOT NULL,
    description VARCHAR(120) NOT NULL,
    target_date TIMESTAMP,
    is_done     BOOLEAN
);

SELECT * FROM pg_available_extensions;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

insert into todo(id, username, description, target_date, is_done)
values (uuid_generate_v4(), 'Bernard', 'Learn Microservices', current_timestamp, false);

insert into todo(id, username, description, target_date, is_done)
values (uuid_generate_v4(), 'Bernard', 'Build a Home Raspberry firewall', to_timestamp('05 Dec 2020', 'DD Mon YYYY'), false);

insert into todo(id, username, description, target_date, is_done)
values (uuid_generate_v4(), 'Bernard', 'Fix Up the Telescop', to_timestamp('05 Nov 2021', 'DD Mon YYYY'), false);

insert into todo(id, username, description, target_date, is_done)
values (uuid_generate_v4(), 'Bernard', 'Learn Python', to_timestamp('05 Jan 2021', 'DD Mon YYYY'), false);

insert into todo(id, username, description, target_date, is_done)
values (uuid_generate_v4(), 'Bernard', 'Mow the Lawn', to_timestamp('05 Oct 2020', 'DD Mon YYYY'), false);

insert into todo(id, username, description, target_date, is_done)
values (uuid_generate_v4(), 'Bernard', 'Plant new Flowers in the Garden', to_timestamp('05 Dec 2020', 'DD Mon YYYY'), false);