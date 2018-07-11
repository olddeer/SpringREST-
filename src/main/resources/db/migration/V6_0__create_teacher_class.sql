
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


CREATE TABLE public.SR_TEACHER_CLASS (
    SRT_C_ID serial NOT NULL,
    SRT_ID serial NOT NULL,
    SRC_ID serial NOT NULL,
    CREATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now(),
    UPDATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now()
);
ALTER TABLE public.SR_TEACHER_CLASS OWNER TO postgres;




ALTER TABLE ONLY public.SR_TEACHER_CLASS
    ADD CONSTRAINT teacher_class_pkey PRIMARY KEY (SRT_C_ID);


ALTER TABLE ONLY public.SR_TEACHER_CLASS
    ADD CONSTRAINT teacher_class_fkey FOREIGN KEY (SRT_ID) REFERENCES public.SR_TEACHER(SRT_ID) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE ONLY public.SR_TEACHER_CLASS
    ADD CONSTRAINT teacher_class_fkey2 FOREIGN KEY (SRC_ID) REFERENCES public.SR_CLASS(SRC_ID) ON DELETE CASCADE ON UPDATE CASCADE;