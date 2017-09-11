create table if not exists pos_crust(
    name            varchar(30)                 not null,
    description     varchar(100)                not null,
    constraint      pos_crust_name_pk           primary key(name)
);

insert into pos_crust values('PAN', 'A thick crust is baked to golden perfection, crispy on the outside, soft & fluffy on the inside.');
insert into pos_crust values('STUFFED CRUST - VEG KEBAB', 'Meet the Crust of your dreams :The phenomenal Epic Crust that’s stuffed abundantly with a juicy, flavorful veggie kebab & a spicy chili garlic sauce.');
insert into pos_crust values('STUFFED CRUST - CHEESE MAXX', 'Cheese Lovers heaven!With a unique stuffed crust oozing with 100% Mozzarella & a base filled with Peruvian cream cheese.');
insert into pos_crust values('BIG PIZZA', 'Only for lovers of the big and thin, this range comes with lot of choices yet being light on the wallet.');

create table if not exists pos_images(
    iid             int                         auto_increment,
    url             varchar(255)                not null,
    constraint      pos_images_iid_pk           primary key(iid)
);



create table if not exists pos_items(
    pid             int                         auto_increment,
    name            varchar(255)                not null,
    toppings        varchar(255)                not null,
    crust           varchar(30)                 not null,
    size            varchar(10)                 not null,
    quantity        int                         not null                default     0,
    price           double(10, 2)               not null,
    category        varchar(10)                 not null,
    menu            varchar(20)                 not null,
    constraint      pos_items_pid_pk            primary key(pid),
    constraint      pos_items_crust_fk          foreign key(crust)      references  pos_crust(name),
    constraint      pos_items_size_chk          check(size in ('MEDIUM', 'LARGE', 'SMALL')),
    constraint      pos_items_category_chk      check(category in ('VEG', 'NONVEG')),
    constraint      pos_items_menu_chk          check(menu in ('SUPREME', 'SIGNATURE', 'FAVOURITE', 'CLASSIC', 'OVERLOADED'))
);

create table if not exists pos_items_images(
    pid             int,
    iid             int,
    constraint      pos_items_images_pid_fk     foreign key(pid)        references  pos_items(pid),
    constraint      pos_items_images_iid_fk     foreign key(iid)        references  pos_images(iid)
);



create table if not exists pos_sides(
    sid             int                         auto_increment,
    name            varchar(255)                not null,
    toppings        varchar(255)                not null,
    quantity        int                         not null                default     0,
    price           double(10, 2)               not null,
    category        varchar(10)                 not null,
    constraint      pos_sides_sid_pk            primary key(sid),
    constraint      pos_sides_category_chk      check(category in ('VEG', 'NONVEG'))
);

create table if not exists pos_sides_images(
    sid             int,
    iid             int,
    constraint      pos_sides_sid_fk            foreign key(sid)        references  pos_sides(sid),
    constraint      pos_sides_iid_fk            foreign key(iid)        references  pos_images(iid)
);



create table if not exists pos_drinks(
    did             int                         auto_increment,
    name            varchar(255)                not null,
    description     varchar(255)                not null,
    quantity        int                         not null                default     0,
    price           double(10, 2)               not null,
    category        varchar(10)                 not null,
    constraint      pos_drinks_did_pk           primary key(did),
    constraint      pos_drinks_category_chk     check(category in ('VEG', 'NONVEG'))
);

create table if not exists pos_drinks_images(
    did             int,
    iid             int,
    constraint      pos_drinks_did_fk           foreign key(did)        references  pos_drinks(did),
    constraint      pos_drinks_iid_fk           foreign key(iid)        references  pos_images(iid)
);



create table if not exists pos_desserts(
    did             int                         auto_increment,
    name            varchar(255)                not null,
    description     varchar(255)                not null,
    quantity        int                         not null                default     0,
    price           double(10, 2)               not null,
    category        varchar(10)                 not null,
    constraint      pos_desserts_did_pk         primary key(did),
    constraint      pos_desserts_category_chk   check(category in ('VEG', 'NONVEG'))
);

create table if not exists pos_desserts_images(
    did             int,
    iid             int,
    constraint      pos_desserts_did_fk         foreign key(did)        references  pos_desserts(did),
    constraint      pos_desserts_iid_fk         foreign key(iid)        references  pos_images(iid)
);



create table if not exists pos_magicpan(
    mid             int                         auto_increment,
    name            varchar(255)                not null,
    toppings        varchar(255)                not null,
    quantity        int                         not null                default     0,
    price           double(10, 2)               not null,
    category        varchar(10)                 not null,
    constraint      pos_magicpan_mid_pk         primary key(mid),
    constraint      pos_magicpan_category_chk   check(category in ('VEG', 'NONVEG'))
);

create table if not exists pos_magicpan_images(
    mid             int,
    iid             int,
    constraint      pos_magicpan_mid_fk         foreign key(mid)        references  pos_magicpan(mid),
    constraint      pos_magicpan_iid_fk         foreign key(iid)        references  pos_images(iid)
);


create table if not exists pos_user_credential(
    email_id        varchar(255)                not null,
    password        varchar(255)                not null,
    auth_key        varchar(30)                 not null                default     '',
    status          int                         not null                default     0,
    constraint      pos_user_credential_email_id_pk         primary key(email_id)
);


-- Completed User Credential

create table if not exists pos_user_profile(
    prof_id         int                         auto_increment,
    email_id        varchar(255)                not null,
    first_name      varchar(100)                not null,
    last_name       varchar(100)                not null                default     '',
    mobile          varchar(50)                 not null,
    house_no        varchar(100)                not null,
    street_name     varchar(100)                not null,
    location        varchar(100)                not null,
    city            varchar(100)                not null,
    pincode         int                         not null,
    constraint      pos_user_profile_prof_id_pk     primary key(prof_id),
    constraint      pos_user_profile_email_id_fk    foreign key(email_id)   references  pos_user_credential(email_id),
    constraint      pos_user_profile_mobile_unq     unique(mobile)
);

create table if not exists pos_table_gen(
    name            varchar(255),
    value           bigint(20),
    constraint      pos_table_gen_name_pk       primary key(name)
);

