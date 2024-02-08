-- create a database user for the account service
create user account identified by "Welcome1234##";

-- add roles and quota
grant connect to account;
grant resource to account;
alter user account default role connect, resource;
alter user account quota unlimited on users;

-- create accounts table
create table account.accounts (
  account_id            number generated always as identity (start with 1 cache 20),
  account_name          varchar2(40) not null,
  account_type          varchar2(8) check (account_type in ('CHECKING', 'SAVINGS', 'CREDIT', 'LOAN')),
  customer_id           varchar2 (20),
  account_opened_date   date default sysdate not null,
  account_other_details varchar2(4000),
  account_balance       number
) logging;

alter table account.accounts add constraint accounts_pk primary key (account_id) using index logging;

comment on table account.accounts is 'Oracle CloudBank accounts table';

-- create journal table
create table account.journal (
  journal_id      number generated always as identity (start with 1 cache 20),
  journal_type    varchar2(20),
  account_id      number,
  lra_id          varchar2(1024) not null,
  lra_state       varchar2(40),
  journal_amount  number
) logging;

alter table account.journal add constraint journal_pk primary key (journal_id) using index logging;

comment on table account.journal is 'CloudBank accounts journal table';
