
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


CREATE TYPE public.status_task AS ENUM (
  'New',
  'In_progress',
    'Done',
    'In_checking'
);

ALTER TYPE public.status_task OWNER TO postgres;

CREATE TABLE public.SR_TASK_PUPIL (
         SRT_P_ID serial NOT NULL,
        SRP_ID serial NOT NULL,
         SRTA_ID serial NOT NULL,
         COUNT_OF_REPEATS integer NOT NULL,
         COUNT_OF_SOLVED_REPEATS integer NOT NULL,
        STATUS public.status_task DEFAULT 'New'::public.status_task,
          CATEGORY char varying,
     CREATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now(),
    UPDATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now()
);


ALTER TABLE public.SR_TASK_PUPIL OWNER TO postgres;

ALTER TABLE ONLY public.SR_TASK_PUPIL
    ADD CONSTRAINT task_pupil_pkey PRIMARY KEY (SRT_P_ID);

ALTER TABLE ONLY public.SR_TASK_PUPIL
    ADD CONSTRAINT task_pupil_pupil_id_fkey FOREIGN KEY (SRP_ID) REFERENCES public.SR_PUPIL(SRP_ID) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE ONLY public.SR_TASK_PUPIL
    ADD CONSTRAINT task_pupil_task_id_fkey FOREIGN KEY (SRTA_ID) REFERENCES public.SR_TASK(SRTA_ID) ON DELETE CASCADE ON UPDATE CASCADE;

