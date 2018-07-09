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

--
-- TOC entry 196 (class 1259 OID 16555)
-- Name: class; Type: TABLE; Schema: public; Owner: postgres
--


CREATE TABLE public.SR_CLASS (
    SRC_ID serial NOT NULL,
    TITLE character varying(255),
     CREATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now(),
    UPDATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now()
);


ALTER TABLE public.SR_CLASS OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16558)
-- Name: class_class_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--




ALTER TABLE ONLY public.SR_CLASS
    ADD CONSTRAINT class_pkey PRIMARY KEY (SRC_ID);

