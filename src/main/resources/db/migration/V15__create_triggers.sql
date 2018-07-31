CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;



COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';

CREATE FUNCTION public.add_star() RETURNS trigger
    LANGUAGE plpgsql
    AS $$BEGIN
	IF OLD.STATUS != 'Done' THEN
		IF NEW.STATUS = 'Done' THEN
			UPDATE SR_PUPIL SET COUNT_STARS = COUNT_STARS + 1
			WHERE SRP_ID = NEW.SRP_ID;
		END IF;
	END IF;
	RETURN NEW;
END;
$$;


ALTER FUNCTION public.add_star() OWNER TO postgres;


CREATE FUNCTION public.control_count_audios() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE
	current_num integer;
	required_num integer;
	current_task_status varchar(20);
BEGIN
	SELECT COUNT_OF_REPEATS INTO required_num
	FROM SR_TASK_PUPIL
	WHERE SRT_P_ID = NEW.SRT_P_ID;
	SELECT COUNT(*) INTO current_num
	FROM SR_RESULT
	WHERE SRT_P_ID = NEW.SRT_P_ID;

	SELECT STATUS INTO current_task_status
	FROM  SR_TASK_PUPIL
	WHERE SRT_P_ID = NEW.SRT_P_ID;

	IF current_task_status = 'In_checking' OR current_task_status = 'Done' THEN
		RAISE EXCEPTION 'All records were done';
	ELSE
		IF required_num - current_num = 1 THEN
			UPDATE SR_TASK_PUPIL SET STATUS = 'In_checking'
			WHERE SRT_P_ID = NEW.SRT_P_ID;
		END IF;
	END IF;
	UPDATE sr_task_pupil SET COUNT_OF_SOLVED_REPEATS = current_num + 1 WHERE srt_p_id =  NEW.SRT_P_ID;
	RETURN NEW;

END;
$$;


ALTER FUNCTION public.control_count_audios() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

CREATE TRIGGER update_count_stars AFTER UPDATE ON public.SR_TASK_PUPIL FOR EACH ROW EXECUTE PROCEDURE public.add_star();
CREATE TRIGGER update_task_status BEFORE INSERT ON public.SR_RESULT FOR EACH ROW EXECUTE PROCEDURE public.control_count_audios();