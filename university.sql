PGDMP                         z        
   university    14.5    14.5     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    24586 
   university    DATABASE     f   CREATE DATABASE university WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Polish_Poland.1250';
    DROP DATABASE university;
                postgres    false                        2615    24587    students    SCHEMA        CREATE SCHEMA students;
    DROP SCHEMA students;
                postgres    false            ?            1259    24667    students    TABLE     ?   CREATE TABLE public.students (
    id integer NOT NULL,
    name character varying(100),
    email character varying(100),
    phone_number character varying(100)
);
    DROP TABLE public.students;
       public         heap    postgres    false            ?            1259    24666    students_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.students_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.students_id_seq;
       public          postgres    false    211            ?           0    0    students_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.students_id_seq OWNED BY public.students.id;
          public          postgres    false    210            ]           2604    24670    students id    DEFAULT     j   ALTER TABLE ONLY public.students ALTER COLUMN id SET DEFAULT nextval('public.students_id_seq'::regclass);
 :   ALTER TABLE public.students ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    211    211            ?          0    24667    students 
   TABLE DATA           A   COPY public.students (id, name, email, phone_number) FROM stdin;
    public          postgres    false    211   M       ?           0    0    students_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.students_id_seq', 1, false);
          public          postgres    false    210            _           2606    24672    students students_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.students
    ADD CONSTRAINT students_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.students DROP CONSTRAINT students_pkey;
       public            postgres    false    211            ?      x?????? ? ?     