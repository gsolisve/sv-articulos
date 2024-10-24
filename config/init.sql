--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: Status; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."status" (
    id smallint NOT NULL,
    name character varying(100),
    status boolean DEFAULT true NOT NULL
);


--
-- Name: Status_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public."status_id_seq"
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: Status_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public."status_id_seq" OWNED BY public."status".id;


--
-- Name: category; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.category (
    id smallint NOT NULL,
    name character varying(100),
    status boolean,
    color character varying(12)
);


--
-- Name: category_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.category_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.category_id_seq OWNED BY public.category.id;


--
-- Name: item; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.item (
    id integer NOT NULL,
    name character varying(1000) NOT NULL,
    quantity integer,
    price decimal(12,2),
    expiry_date time without time zone,
    id_status smallint NOT NULL,
    id_category smallint NOT NULL,
    image text
);


--
-- Name: item_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.item_id_seq OWNED BY public.item.id;


--
-- Name: Status id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."status" ALTER COLUMN id SET DEFAULT nextval('public."status_id_seq"'::regclass);


--
-- Name: category id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.category ALTER COLUMN id SET DEFAULT nextval('public.category_id_seq'::regclass);


--
-- Name: item id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.item ALTER COLUMN id SET DEFAULT nextval('public.item_id_seq'::regclass);


--
-- Name: Status Status_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."status"
    ADD CONSTRAINT "status_pkey" PRIMARY KEY (id);


--
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- Name: item item_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (id);


--
-- Name: item fk_category_item; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT fk_category_item FOREIGN KEY (id_category) REFERENCES public.category(id);


--
-- Name: item fk_status_item; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT fk_status_item FOREIGN KEY (id_status) REFERENCES public."status"(id);


--
-- PostgreSQL database dump complete
--
commit;
INSERT INTO status (id, name, status) VALUES (1, 'Por comprar', true);
INSERT INTO status (id, name, status) VALUES (2, 'Comprado', true);
commit;
INSERT INTO public.category (id, name, status, color) VALUES (1, 'General', true, '#cfd8dc');

commit;
INSERT INTO public.item (id, name, quantity, price, id_status, id_category, image) VALUES (1, 'Lavadora', 10, '1500.00', 5, 1, '');
commit;