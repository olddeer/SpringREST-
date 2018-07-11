
CREATE TABLE public.SR_AUDIO(
SRA_ID serial NOT NULL,
PATH character varying(255),
  CREATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now(),
  UPDATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now()
);




ALTER TABLE ONLY public.SR_AUDIO
    ADD CONSTRAINT audio_pkey PRIMARY KEY (SRA_ID);



ALTER TABLE public.SR_AUDIO OWNER TO postgres;

INSERT INTO SR_AUDIO (path) VALUES ('C:/somewhere');
INSERT INTO SR_AUDIO (path)VALUES ('D:/somewhere');
INSERT INTO SR_AUDIO (path)VALUES ('E:/somewhere');


CREATE TABLE public.SR_RESULT (
   SRR_ID serial NOT NULL,
    SRT_P_ID serial NOT NULL,
    SRA_ID serial NOT NULL,
    COMMENT character varying(255) NOT NULL,
      CREATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now(),
    UPDATE_DATE  timestamp(0) without time zone NOT NULL DEFAULT now()

);



ALTER TABLE public.SR_RESULT OWNER TO postgres;



ALTER TABLE ONLY public.SR_RESULT
    ADD CONSTRAINT result_pkey PRIMARY KEY (SRR_ID);



ALTER TABLE ONLY public.SR_RESULT
    ADD CONSTRAINT result_task_pupil_id_fkey FOREIGN KEY (SRT_P_ID) REFERENCES public.SR_TASK_PUPIL(SRT_P_ID)  ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE ONLY public.SR_RESULT
    ADD CONSTRAINT result_task_pupil_id_fkey2 FOREIGN KEY (SRA_ID) REFERENCES public.SR_AUDIO(SRA_ID)  ON DELETE CASCADE ON UPDATE CASCADE;
