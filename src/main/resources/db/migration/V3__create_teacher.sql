
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;


CREATE TABLE public.SR_TEACHER (
    SRT_ID serial NOT NULL,
    NAME character varying(255) NOT NULL,
    SURNAME character varying(255) NOT NULL,
    EMAIL character varying(255) NOT NULL,
    PHONE character varying(15) NOT NULL,
    CREATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now(),
    UPDATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now(),
    USERNAME character varying(255) NOT NULL ,
    PASSWORD character varying(255) NOT NULL
);


ALTER TABLE public.SR_TEACHER OWNER TO postgres;








ALTER TABLE ONLY public.SR_TEACHER
    ADD CONSTRAINT teacher_pkey2 PRIMARY KEY (SRT_ID);



