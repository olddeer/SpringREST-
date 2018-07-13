
CREATE TABLE public.password_resets
(
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    token character varying(255) COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp(0) without time zone
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;



CREATE INDEX password_resets_email_index
    ON public.password_resets USING btree
    (email COLLATE pg_catalog."default")
    TABLESPACE pg_default;