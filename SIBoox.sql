PGDMP                          {            SIBoox    15.2    15.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                        1262    74256    SIBoox    DATABASE        CREATE DATABASE "SIBoox" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_Indonesia.1252';
    DROP DATABASE "SIBoox";
                postgres    false            �            1259    74257    buku    TABLE       CREATE TABLE public.buku (
    isbn character varying NOT NULL,
    judul character varying,
    pengarang character varying,
    penerbit character varying,
    tahun character varying,
    jumlah_halaman character varying,
    id_kategori character varying
);
    DROP TABLE public.buku;
       public         heap    postgres    false            �            1259    74285    kategori    TABLE     r   CREATE TABLE public.kategori (
    id_kategori character varying NOT NULL,
    nama character varying NOT NULL
);
    DROP TABLE public.kategori;
       public         heap    postgres    false            �            1259    90669    login    TABLE     �   CREATE TABLE public.login (
    nomerinduk character varying NOT NULL,
    password character varying,
    nama character varying,
    level character varying
);
    DROP TABLE public.login;
       public         heap    postgres    false            �            1259    82477 
   peminjaman    TABLE       CREATE TABLE public.peminjaman (
    id_peminjaman character varying NOT NULL,
    nim character varying,
    nama character varying,
    prodi character varying,
    angkatan character varying,
    isbn character varying,
    tanggal_peminjaman date,
    tanggal_pengembalian date
);
    DROP TABLE public.peminjaman;
       public         heap    postgres    false            �            1259    82489    peminjamanskripsi    TABLE     *  CREATE TABLE public.peminjamanskripsi (
    id_peminjaman character varying NOT NULL,
    nim character varying,
    nama character varying,
    prodi character varying,
    angkatan character varying,
    id_skripsi character varying,
    tanggal_peminjaman date,
    tanggal_pengembalian date
);
 %   DROP TABLE public.peminjamanskripsi;
       public         heap    postgres    false            �            1259    74264    skripsi    TABLE     �   CREATE TABLE public.skripsi (
    id_skripsi character varying NOT NULL,
    judul character varying,
    pengarang character varying,
    tahun character varying,
    jumlah_halaman character varying
);
    DROP TABLE public.skripsi;
       public         heap    postgres    false                      0    74257    buku 
   TABLE DATA           d   COPY public.buku (isbn, judul, pengarang, penerbit, tahun, jumlah_halaman, id_kategori) FROM stdin;
    public          postgres    false    214   �                 0    74285    kategori 
   TABLE DATA           5   COPY public.kategori (id_kategori, nama) FROM stdin;
    public          postgres    false    216   �.                 0    90669    login 
   TABLE DATA           B   COPY public.login (nomerinduk, password, nama, level) FROM stdin;
    public          postgres    false    219   0                 0    82477 
   peminjaman 
   TABLE DATA              COPY public.peminjaman (id_peminjaman, nim, nama, prodi, angkatan, isbn, tanggal_peminjaman, tanggal_pengembalian) FROM stdin;
    public          postgres    false    217   �0                 0    82489    peminjamanskripsi 
   TABLE DATA           �   COPY public.peminjamanskripsi (id_peminjaman, nim, nama, prodi, angkatan, id_skripsi, tanggal_peminjaman, tanggal_pengembalian) FROM stdin;
    public          postgres    false    218   �8                 0    74264    skripsi 
   TABLE DATA           V   COPY public.skripsi (id_skripsi, judul, pengarang, tahun, jumlah_halaman) FROM stdin;
    public          postgres    false    215   6?       y           2606    74263    buku Buku_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.buku
    ADD CONSTRAINT "Buku_pkey" PRIMARY KEY (isbn);
 :   ALTER TABLE ONLY public.buku DROP CONSTRAINT "Buku_pkey";
       public            postgres    false    214            {           2606    74270    skripsi Skripsi_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.skripsi
    ADD CONSTRAINT "Skripsi_pkey" PRIMARY KEY (id_skripsi);
 @   ALTER TABLE ONLY public.skripsi DROP CONSTRAINT "Skripsi_pkey";
       public            postgres    false    215            }           2606    74291    kategori kategori_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.kategori
    ADD CONSTRAINT kategori_pkey PRIMARY KEY (id_kategori);
 @   ALTER TABLE ONLY public.kategori DROP CONSTRAINT kategori_pkey;
       public            postgres    false    216            �           2606    90675    login login_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.login
    ADD CONSTRAINT login_pkey PRIMARY KEY (nomerinduk);
 :   ALTER TABLE ONLY public.login DROP CONSTRAINT login_pkey;
       public            postgres    false    219                       2606    82483    peminjaman peminjaman_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.peminjaman
    ADD CONSTRAINT peminjaman_pkey PRIMARY KEY (id_peminjaman);
 D   ALTER TABLE ONLY public.peminjaman DROP CONSTRAINT peminjaman_pkey;
       public            postgres    false    217            �           2606    82495 (   peminjamanskripsi peminjamanskripsi_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY public.peminjamanskripsi
    ADD CONSTRAINT peminjamanskripsi_pkey PRIMARY KEY (id_peminjaman);
 R   ALTER TABLE ONLY public.peminjamanskripsi DROP CONSTRAINT peminjamanskripsi_pkey;
       public            postgres    false    218            �           2606    82496 !   peminjamanskripsi id_skripsi_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.peminjamanskripsi
    ADD CONSTRAINT id_skripsi_fkey FOREIGN KEY (id_skripsi) REFERENCES public.skripsi(id_skripsi);
 K   ALTER TABLE ONLY public.peminjamanskripsi DROP CONSTRAINT id_skripsi_fkey;
       public          postgres    false    218    215    3195            �           2606    82484    peminjaman isbn_fkey    FK CONSTRAINT     q   ALTER TABLE ONLY public.peminjaman
    ADD CONSTRAINT isbn_fkey FOREIGN KEY (isbn) REFERENCES public.buku(isbn);
 >   ALTER TABLE ONLY public.peminjaman DROP CONSTRAINT isbn_fkey;
       public          postgres    false    214    3193    217            �           2606    74292    buku kategori_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.buku
    ADD CONSTRAINT kategori_fkey FOREIGN KEY (id_kategori) REFERENCES public.kategori(id_kategori) NOT VALID;
 <   ALTER TABLE ONLY public.buku DROP CONSTRAINT kategori_fkey;
       public          postgres    false    216    3197    214                  x��Z�r�F�]���V�Q�I�;�K�^�([���Y"�b ��G�r>`���d�MARGǄöB$���q�Ʉ&�p���3p�p���6y�f'2��(W�D�z}��%��D��N&�/|��d��5_�i&T"����F?���x��*�iʯ�~�6����㏹Y��=�X��.���?M�'ñ;p�`8l������0;v-�YK�ü�8f��J��O�,s�f�$2���̵�܁���`�����?aa�|/d�q�7B8���65�zV+wn��Z&+�0��\E҆�q��-E�&߉$es�DI>W�jc͌�et�]'���9����8pÁ��c)~�#{ȍH���[���t���~�ބ��܈�,�7j��R����"Y�9a��R+	��s����ͼ��Q脈�FH}ft��l�3�ۥ�8��ܥ� ���&�k������5�E�s�p�g��?�2�o��xȆ��"���!Oa�:�=n$�E��_�,]��)_�t��+����F�;������G�p�o�<�/k`�x� U��j`���=��0|��2��Re+��*���Q��әޝ�O��B�}��U�)��<��:$�Q&���)�r��I�"���Y���U�od�)~����V�b�ӵ���ݛ}�O���S�;Rl�_A��9�4B��%g2Ɵ��p.���b��D�඗�'�=e�&�U�}L���E��k�p��p�~ț�u�>��
K�ƨ��e�"�5*X�M���9����0��U�`f<@+�C�f�+�~N�����@	���$�ن��N�F�Kap����Mހw����&��sA]j�J�݇�d�N/P.��؝�2�5�YbK�\��"9�"C���f�6t��xfm�&�~�6��F�qA��者o@A&*OQ�d�Z�m��F'Ȩs�������D����T�]q�v��xwq� ^խ�|�G��Ս^.U�[>����BaL���3�5y|��|�i2叇���T�W�g*�q��^�-���\�;I�gȅ��Ub��gD�VG�B�����^�(��2��<Q|����e� �5�$<�2�@�@:�zw���~F���)��L�7b�@-�##E�ۥ0���;$�(�1`�}��s@�I�t�7Z�6�8��wm^պU~�{b��p�&ĸ>�)r�'5�RI�ɃN"v!^�GX�4hKj���8���t%"�;��b�
:g�>�vY�T6�d���s~�a7r�b\y0�� �m���/�= � ^�g1|��aR�r�P\!���]^��1������K�\�X7��"�<��L����Cv ��WF���R�B�Ȉ]��-��D�y��Xi.#%������]���� A�I�LSbQ��C̈�l\�*����!H��n$p�V!�a��Z�h�Q���/�l�4���m:��_hh! �z�Hgdv��� �&������72V"� :y�\��"T��$�.�k{�s�G:�!(<f�o�2Ld�$_�ƿ�K����Q�ިT~z�E(�&���:&�kW� �+�l7�\��vj�Si�DT�HO��f��]�Z�<��_B0�y���Pa����p5C]%�2ʷT�gD�x���ݨ�ݢ-�6{j
�R6�>J����kbkC��&�AQ�/��	�n��D��b�Ék#6��ƻ��3оW������<8n��Tl��X���3q��@��x���Pa���2=�����%��5��k����L�d �k��hg-x��E$o`�׍��(�s��S�<�3��I5G����[w�\��7���H.�4�*]���m�d���d�=L�6�?H>�^�?���E�Ԫ����%2�F�@]�S�%�@��u�_?�YP/�!.K�B�[�=7y�;��I��!����X�����m�2� 6�v��'�!fy�r *�o�\(\Щ9y�Q8n�Tt���QƉ
��-IƘ\p_�ܣ%����J0$7&�ų�RG0�J�XK^E�s̨y�^ �hCp�O�yYn���޴!�B����u5�;�8��t�	��:��� ~h��j�r������u�	��`��I�b��a���{�Z8�OCk9���D��ޚ�A�с�u��XF���~~�c���]<���?��e����1qX�?��౶�v�(�Z|N�h.�	&�'���i�󓄤|EZ�������~S���)���������2�9T�a����Ƭ�?�Ȩ
�>i��ǘP=����뺘q�)V�*�Y�_��q��́�u�x���&��%4f��늅JwCh�N]��ن�]��,z
��y �c�U�\�أ4ꔶ���$�a��s��F���
4�6�����V�(�[AX�-��R�t3�R�Niz&�"�[���%X֯�
ly_�Шx:�c�OTAF!���yrh5je�#�ٕ��b���Nл;0��g�Hܹ>\���T��H�~�б��>��b#N��J�}��D��,���@\��dZ︆NPK:�4*W�?��΃�뜖kb�U}{���Q��+���S|Ǥ2~>�n`���$1�D2n��3��	��������N�uHm.<jM3|���[�T夃���X�7�{�-�v�T��bǠ۷$9S�� �7�H@e��ni`�g�*Ap�����)��c�x�Y��d^��-��Y������3|"6�H(Ѱ�t�Ҭ\O���
� lz!֩�����-�B��� lD��L"�-HY�[���

1$&�[wq�<m�0nz�.���$q�˗n���T���!��AK�������IѶQGc��J��xe7Tf#t0i�bQ1EB�jɖ��G8u�;'�PO���6ՅPR��UY_p�ʠ�^ca���B�����G�Mo���A���xGcJ=�VU (,*��+�wj��mz�2꫌�g�,�U�A�U����Cڍ��x7�ϡmԟ���:o\d�<ҙMT���@�-�#�}��+\�%�V;��a�h'� �v+6
�r3~�'b�~�+x��q�������YY�5*ț�B�������9��@[�����60��E�`�c�c��Y������ԛ��8�f�� F�&5|V�"3M�}P!�.�H551���4�x� HP���A��6m� 1����}�l$�6�ם]�G��uso�����>-�����7�n���A�#��+�6;�M�tߓx���8
?|Q�B��}�������� z���g4��k�73wك���֎�V�j��=��L��G؉��IL���ւ���/b~\*���A��x�æ��c�k{�@��dd	zH�"����u�H���Ğ�D^)��F��8���B!�+d�?њ(�HU&6��!!lUI��*fu���FF��#�U������R���; jl
\��&'1���`K�Ӌ%A/�n;��㵲`@O?�`֨�{�5������I�o�TE�K=گ���*�BU�G�|���zq���N��W�^����2���}[ [����)��du�Z�׌�Ld�:�su�o*�)D���⑈Ů�I�+T>�`��]�kq:<2L��^V�U��k�����2�f���y%|�SK0���=�!�V�xӶj��寊Kvo��i�(�`����Iꁼ.n�))h�h�b� 6�(��6�K'(�>u��f�ڔˆ���h���)Ň�kT�~�a[z�D+!��L�P8v�~��KDDL?��w�>x7�ٻ��Ac�#���A�&�KŚ��Rr�C�ڊ�t:��wq���
lq�(V���B��ªi�6;M[>��}F����,0��[�;���ۦ�H������I�^)v�������$Z����ǝ|�6:);�ކ�v����˯�vt������& ��m�v�ŝ�n!a��Eǯ��;�w%`���=����vOK��46��`�p~c�[|���S�\)�O[��O��ſ��!5y�`ʆJ�H+�'65���T��[�I�֛�3�8=EF�x
TH+Th��=� �   �Z�T�!�e��=B�����lzY���~������n����<�Ҁd�:�D}J��5E��)�Q�N�5&�l��m���
"���&��٤�n^ƴC^��������jk/���!5�Ze��N�W�[��c���yCj�r3�:�`�|,���w;Ӿ6����.���2�{�n�UF�>������^~��!up��&m�yC�v�ie%����v{p/)�N�� �Ƶ�         h  x�eQ�N1|���?@�!������H�>�esY�U����U��;w��oޝ��̮�6[��IC-9�Z�B#�B����+�'�f}o�r�������8Zc��6�b��l"�\č9J���_��Ab��<bܭ�L��K��W�du���^g�րwo�I��=�{��9�ݕ�<p�S���ͦ��y��8�G}�%A�m��T`����{pQ����yc6J�g��ݚ��M\F�$p�iG��#��yrO��<VKî&,�7/|\l˙�9���b	��]d�N��O����;�#,���%�y���{����K�3��y�	��Smt$�f�Y���}ן*��NЩ'x�orOENb��Ai����b����*         y   x�eʱ
�0����rw���R(:���P�6J�P��f��?�.�IT�D�>ر9�>��0���\���D#���۵���C�+_�kr�m#�%��W�<֜��Z���F,(^v��)���A'P         2  x����R�8�����x���%_aCXH������&��cS����o�j��5��H��G��_����	K�$e��u�*�e��<���M����S�д+�.<a�"W:Nb&b�d*T,��\� ��~����	[$y������eU���v���2��.���w�X�,��d:���"f����H`>��/n�C[�Lt�m�2�ޮ�Mh�,ᱴk�<�s;��|�|�YF�f�30ǟ妩�20G��)��gr�C$	�E{_�&�j֛rTZt���Y̤�,��I�t ���Mtcn����[5�c��錤�䏫�����3mY<�'�}p�V]�:���6��N��h�~�r�z�rmWYs�\>O���d6�e
B��9��P����-����q�:~�ө�)�e*�<o���i���i��ރ��b+%rg�,��a�h��I�=B7�&Մ��N �UƟ�Kv�$�U&&����qCyN�<C�h�u��)FKsN���U��jO���,GYn	�+��U�]�K�$K�lTY��X�=��m~�!a8�4p�8K��/U�T���U�hA,�s�n�bOQ<]�4�K���n�+W
��4���z��,��fz���@<Oc�*,�P\-�V+}4��8�(�@ҥ����}[�QZ/>7�\�
q�<�ى3&�\v+�oSr��d��b4�Q��ߔ<�-�AY(�,�+8F�`��ZÂៀ��a�"���YO�6g�h��^�Ñ!��M�X����uKf{.K���h�D2KdQ��@��S�.*`��p�1�ⅹ�	{��3�͒RQ��Q}�͝i�b�����j�A��LB{d=ٷ�&C0�-���T�8q�ڥ�oY:��̃��ie��Uy�4E�V��y�3�ɼ6b	���E��s��
z� or���&�+��,�_o*�c��)��[y�٪�v��Nly� �+K�6
�x<�x(̓�2j/��BDs{���Z�=r�0���B��|�E���;i��Ƨ7��q����|8�	�3��j���W�N���imn��
�a�Ѓ���H'D�%��-d���+#��MWI�A�{��	����L�`�D�҈%D����&+J�����%��%�C��3�f���"�v�.��� +�>�i� ��.�=��R�M�fU��x�qz��	�ck��Y����J#�O���Y���Gp�����OS�s���Z�@8!�u��k���ħD>!^Zk�g� ��D@m�������`�#81ʉQ��B�l6���b�OpB�����<�)8��	O�xB�2���ng*<����/�C}�{���C7��(�O�]1?�&�����C�xB<]90��$�on�d�>P�禮��:'�½��]�{D��B<�7��k�p��y|*�����.3�f4��"H��СEݽ��4�E=E� ~4�����)��f.E����͌��$u?��A�xe�^֝�k{^Y��.sʺ�4�3y�x�|7����3��(�m�nFMw�4d�v����e�̩�N���gb�A��.�Nq0�������\ϝ��ܧa�x����;1Z=��<C2!B����1�����n�+z�dB<7� ��Zn�X������x�Y�y��@R��	r�Ʉx]�E�<��@1du��.C4!^O��J.���\�hf���0����=B�p�	��/h*f� w�n
��q�6�����M��i�)��{�����<����$�-��L1f?&vW���Am���,Q�z�8�_o��q��G9�%ʵ�Jh@�]��z5���G2��GI�z>gn:�����u�*M-�Oa���%�tQ�g
�P���p���.�ܔ;������
ר:��s�h)w-�ܿ�	;Ÿ���B�E�y���GH���}��C㜧-����m����������L��[,�Sw��&+�)l�/P�Dþp9�t��}��s���x��P���P�#�P��9Ӆ��Y��}jǐ��� /�_}~��}jǏ��ty8�'VM��=�v��;4/��	Tۉo��7J4�>�>�ky ���*~�I���[E�(����m�@��]�Q�e_��������.	%v         P  x��Y�n7|��b���N>��4qlǈ(���hKk�$�ח�����Db���rg�g��mle�n��ݗ�o����p'f�j�-���/øH�^�Vi1{��4|*�
����Lm��������l�,�i�,��CV�Ī���i+�̪�UV���f��t��S�es{�/�Wi�����f��}�?}�����C�hf��9�5[A$]泰��)om�x��}s�Y��������1q��tۧ��"�{�@�c2��+�?e/[���d�Pe���y����zL.&�9 I�|���V��T9���٭J�|���|ټ��d�!��Ȃx""Jqv��t�lѯ�{��D2��Ŗ�y��!-�����gjKAC
i��-Y���]����9=��>���(�Zb�B+����5b6��3#m�j�+R�BC
h�k���O��lyۍ�a���'F-�D)�d�7��f8��1$�(#�D(��4o.Ӹ�ݷ���P�0�a�g����zP��>%}�n�&.��ȭth�`�l)�Σ���MZ���!E$G6�]ﻱƃ�J�������z���e����wd91[��y������kX-HRT�|�Q1�Y��3$��%S�2Ͱ��/�2Ð�-�A^\o��t�4�ż_�{i�*�B������SF�7�y������%��$�Z	�#�j;�*����#x�C*�D-�2��wݸL���{
��9��Dڈ�ѕ_��f����_���uBL���H g��&�w�z}8�dq��G~Ó@#^�U�]�28}�,���ԕ����bH��#��g�mW�tX(��H��x5d�5'����+/Y̎��L������k/14
[�;��dk�����m���3�P6Q̌�9ǪQ��*�Bdnc�\|UZ��B�D�k�8��8
a�l!MY17�.�ƃ�gh�ItMS�f��!�Ŷbb��i��L1���<@NV�f��RP���O�EY˗���N�Ee),�����lQC
���bUi���!E�:,��4[T5�2�Z�f�L�E]�G��6�U1�c�F_m�-�bHYq���\�f��RP�B��4;�aX�BvJ�:͎�-�Ce�q�J]��bH�����N�CY���a�U�١�	*rv�04X}�*cJ2��bUiv��!9�E,��4;TŐ��۝�.�u1$s{)�t8W�٣*�t�����:�e1��x��X�f��RP�=�l��Ð��y {�i��l�*�ߙG���Q�3�O�H�����:�e1%Y�G����QCrvh�D��B�*cX>����S��k�tͺ웷�zX����pc	�F��A�VE�3��u�p�)6a�ꭲ(�bH�	f'7�EP�r�n�<�-���R����(j�en
a���" C
M���E84�=TF��~}y�("�bH��r�w��"�,�d���[]�1$gG}�'yDe��Ѡ��QCrv���U1$oG��je�#�`��?�؏��	��]�ڵi�(�a��,��Q��{Nۢ�/S�W�q�N-�bX����.&�f�\j�#�܌��y>�|?��c�N|s��a�*C_�·V<��I�G��1,�|���߿�����W7�         q  x��Y�v�H]������s@��� ��c��Xx��3�FtPGR7Ӓ̐����Z���A+�P=n�{�������!�"���>p3�$�D��.�W�c�:	ن�"�K.��L�^���pz��g���P�-y�ѹH�`R�������\�*�K��"�Nv�1�R�o�i�'�wY�BNH����M��i�fF��z^����;��>��^��������m&��:yUC��w�P)�[�P�Hm�F���	I7,b�-m	 }��b;�e{�ҍ���LiJ�!=��JYY/)patƂC���!n�Ϡ�g*�����L��-�f�fi��w;�a�t�h�ӚI@�L3(�c2U��^Ge��H\�<=�!y�@��G���L̓T-?g1t�P����(}_Y�ʸ uL��x`I� �"�m�L����*��4]t	�A�R�˟�;D�)�&���-�������3l�ybX�!O!�� �d'�g t�8�^��n�	Spk��MϙΩ�tK�w���Ծ��v�~#�9���:z/ˇ%ҫd�D���p^���ۭ�b2NXK�V}�� @O軅Z�/�_*)R�q^d�[dY�}@'0�� N }dk�>���v�*�FS�?,L`X`4�/f:�3T���!7�^���r�����X�:�~��,
��kd)$��Gδ�(�՛!��CF_�7�j���ðG��=�x�}�A&�� ��*�x�v����w����ϭ�c� aE[���=�?����`�� Ȥaw�)R��˅m��'�w���LzR�B�J�~�/�0uM_Ϡ��E�Jr��v�'�H>	�+lĈZ��J�	��{��b��R�Oʬ|
J�F�3p'����c��ox��d�]t�3��U�dl�؜T{f*�	w8 O���� `��!~b�d�b�!GB�Q�ƽ7E���v׫6	���
��u�C1���
�O�PC�9�X���#��Z�MIU _�OĊ�p�w#.���d�:mHп#pa訚=�6�d�䀳MN���aFG�[q?�⟌�89���g��G<)��V�q\��h���I+��۠��-�,�� <0'�G�n@��H:?��LK�y�'2ق&�,-�`(��� ^�R.<y�k�4z�`�o����lN�+t��!/g�[�������e�ŠO:,Q2��Zx`iJce�ؗ4����{E�K�����9�2�P��3 ����t�E���ay�������S�8�5��S6
��c��]��FdR�>���gȈ��P	���$�4/OE�2���}�3��ОfMB�Q�無�
�1B�I�/�$�S�h���{]�3Ƴ��v�#�Y���H���f�8���U
Hi7R�G���gg`y
&���O�tut�~�3���u�K�D�QA�:G��6�3��u�4�Y��$Ș#�tk�s��$	��Z��,cG����x��P�6��=�ps�b5#l.
����{/����
%��r�:��̜��EW֌�ݽ�o���_s����|�m�a�"*g��Tcq�ݱĒ���B�e]�>,\���4����[_i�����z��33zE0�p���>7h���ՠ%��jT���jВQ�7����[J���|��N���7l��W�s8"���0����eت&G�ir��M-��S�	�_sG���N�v}�Z��}Q�Z����'(,�g�ng{������&����,@�[~�P�_�%N�Z���U�5jɻF�{��Z�r[�.��+�m�Js����+�4��+ͽz��s�����uk`ܾ�[r�q��4�ʚ�-YӸ}k�vZ����{��r��
/���A���t�����ֽ�i�'�|ɊǗ��o�����n������� ��>     