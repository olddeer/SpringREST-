
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


CREATE TABLE public.SR_TASK (
    SRTA_ID serial NOT NULL,
    TITLE character varying,
    LOCATION character varying,
     CREATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now(),
    UPDATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now()
);


ALTER TABLE public.SR_TASK OWNER TO postgres;


ALTER TABLE ONLY public.SR_TASK
    ADD CONSTRAINT task_pkey PRIMARY KEY (SRTA_ID);

