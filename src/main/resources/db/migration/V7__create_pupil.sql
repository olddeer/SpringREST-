
CREATE TABLE public.SR_PUPIL (
    SRP_ID serial NOT NULL,
    SRC_ID serial NOT NULL,
    NAME character varying(255),
    SURNAME character varying(255),
     EMAIL character varying(255),
    COUNT_STARS integer,
   USERNAME character varying(255),
    PASSWORD character varying(255),
    CREATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now(),
    UPDATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now()
);


ALTER TABLE public.SR_PUPIL OWNER TO postgres;


ALTER TABLE ONLY public.SR_PUPIL
    ADD CONSTRAINT pupil_pkey PRIMARY KEY (SRP_ID);
CREATE UNIQUE INDEX pupil_username_uindex ON public.SR_PUPIL USING btree (USERNAME);

ALTER TABLE ONLY public.SR_PUPIL
    ADD CONSTRAINT pupil_class_id_fkey FOREIGN KEY (SRC_ID) REFERENCES public.SR_CLASS(SRC_ID) ON DELETE CASCADE ON UPDATE CASCADE;