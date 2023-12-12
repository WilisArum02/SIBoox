# SIBoox
Aplikasi ini adalah sebuah aplikasi perpustakaan sederhana yang Bernama SIBoox yang dapat digunakan untuk memasukkan data-data buku juga skrispsi yang ada agar mempermudah dalam mengakses history bukunya. Disini seorang mahasiswa dan juga admin dapat login. Mahasiswa dapat login apabila nim dan password yang berisi tanggal lahir mahasiswa tersebut telah terdaftar. Yang bisa mendaftarkan hanya admin melalui databasenya.

Aplikasi ini dapat menambahkan buku dan skripsi. Dapat melakukan peminjaman juga. Dapat melakukan cetak laporan  data buku, data skripsi, data peminjaman skripsi dan buku, cetak laporan jumlah buku yang dipinjam berdasarkan judulnya, jumlah kategori yang dipinjam berdasarkan nama kategori.

## Fitur
1. Fitur [Login](https://github.com/WilisArum02/SIBoox/blob/main/src/projectuas/FrmLogin.java)
2. Dapat menambahkan, mengedit, menghapus [buku](https://github.com/WilisArum02/SIBoox/blob/main/src/projectuas/MenuBuku.java), [skripsi](https://github.com/WilisArum02/SIBoox/blob/main/src/projectuas/MenuSkripsi.java), dan [kategori](https://github.com/WilisArum02/SIBoox/blob/main/src/projectuas/MenuKategori.java)
3. Dapat melakukan transaksi peminjaman [buku](https://github.com/WilisArum02/SIBoox/blob/main/src/projectuas/MenuPeminjamanBuku.java) dan [skripsi](https://github.com/WilisArum02/SIBoox/blob/main/src/projectuas/MenuPeminjamanSkripsi.java)
4. Dapat melakukan cetak laporan data [buku](https://github.com/WilisArum02/SIBoox/blob/main/src/projectuas/ReportBuku.java) dan [skripsi](https://github.com/WilisArum02/SIBoox/blob/main/src/projectuas/ReportSkripsi.java)
5. Dapat melakukan cetak laporan jumlah peminjaman buku, skripsi, dan kategori yang paling sering dipinjam
6. Fitur Logout

## Tech
Menggunakan Apache Netbeans IDE 15 dan PostgreSQL pgAdmin 4

[![forthebadge made-with-ApacheNeatbeans](https://th.bing.com/th?id=OSAAS.67E3675844C1A9B6C86DF097C16A6D3B&w=80&h=80&c=1&o=6&pid=5.1)](https://netbeans.apache.org/) [![forthebadge made-with-PosgreSQL](https://th.bing.com/th?id=OSAAS.C27BAA7112B6F36A360DBBC4ACA18527&w=80&h=80&c=1&o=6&pid=5.1)]([https://netbeans.apache.org/](https://www.postgresql.org/)https://www.postgresql.org/)

## Preview Menu dan Sub menu
Login menggunakan NIM/NIP dan password yang sudah ada di database. Disini saya membuat Data login yang menginputkan adalah pemegang databasenya.

<img width="465" alt="Screenshot 2023-12-05 153811" src="https://github.com/WilisArum02/SIBoox/assets/148854173/1c945f5a-0f95-4535-9740-715781b84aec">

Menu dashboard menampilkan jumlah jumlah data yang tersimpan.

<img width="960" alt="Screenshot 2023-12-05 201711" src="https://github.com/WilisArum02/SIBoox/assets/148854173/83e67681-cbff-4f8f-a4e1-48a4fcb33fee">


<img width="960" alt="Screenshot 2023-12-05 202024" src="https://github.com/WilisArum02/SIBoox/assets/148854173/33e2e183-ba30-48d8-b185-70366205d770">


<img width="960" alt="Screenshot 2023-12-05 202132" src="https://github.com/WilisArum02/SIBoox/assets/148854173/a3f3c456-fa67-4d35-9318-bc3081791a6a">


<img width="960" alt="Screenshot 2023-12-05 202205" src="https://github.com/WilisArum02/SIBoox/assets/148854173/f2b6fd0a-04ee-43fb-85cb-32b6d54d09f5">

Menampilkan peminjaman buku dimana pada combo box judul buku sudah otomatis dapat dipilih dari buku-buku yang sudah tersimpan, apabila buku masih dipinjam makan buku tidak dapat di pinjam karena stoknya hanya 1 buku

<img width="960" alt="Screenshot 2023-12-05 202349" src="https://github.com/WilisArum02/SIBoox/assets/148854173/449d4945-42ce-4013-9f2a-1feb77606eb5">


<img width="960" alt="Screenshot 2023-12-05 202438" src="https://github.com/WilisArum02/SIBoox/assets/148854173/0fdb1cf8-6bb0-426d-a01a-675bf066d9aa">


<img width="960" alt="Screenshot 2023-12-05 202634" src="https://github.com/WilisArum02/SIBoox/assets/148854173/3f20c46c-5b24-442f-a42e-a58e50f68f75">


<img width="960" alt="Screenshot 2023-12-05 202739" src="https://github.com/WilisArum02/SIBoox/assets/148854173/805aab94-9b53-45cd-bcfc-00f084a7c22e">


<img width="960" alt="Screenshot 2023-12-05 203020" src="https://github.com/WilisArum02/SIBoox/assets/148854173/6526e43c-0384-4bd8-adc0-0686f7f8dda8">


<img width="960" alt="Screenshot 2023-12-05 203643" src="https://github.com/WilisArum02/SIBoox/assets/148854173/8701d3ee-41a2-4a67-9ce4-449ea1088ce4">


<img width="960" alt="Screenshot 2023-12-05 203912" src="https://github.com/WilisArum02/SIBoox/assets/148854173/60ce9b17-4cec-45f8-8a31-72956c3a580a">


<img width="960" alt="Screenshot 2023-12-05 204427" src="https://github.com/WilisArum02/SIBoox/assets/148854173/729ada01-487a-4b62-b740-41ad6a484c05">


<img width="960" alt="Screenshot 2023-12-05 204707" src="https://github.com/WilisArum02/SIBoox/assets/148854173/a5e7fc4f-6a42-47c9-9961-27bf1cec12c8">


## Preview Cetak(Laporan)


<img width="951" alt="Screenshot 2023-12-05 203111" src="https://github.com/WilisArum02/SIBoox/assets/148854173/27d5d1b4-b253-4d75-8858-07c8a2e76985">


<img width="951" alt="Screenshot 2023-12-05 203218" src="https://github.com/WilisArum02/SIBoox/assets/148854173/cd282676-913c-44c3-af9b-4af8a4c72fc6">


<img width="960" alt="Screenshot 2023-12-05 203331" src="https://github.com/WilisArum02/SIBoox/assets/148854173/29ee6d9e-adf6-4019-bbf8-913bf401c3c9">


<img width="960" alt="Screenshot 2023-12-05 203421" src="https://github.com/WilisArum02/SIBoox/assets/148854173/6d9a39df-9a03-4ade-9f71-96bd7beb89f3">


<img width="960" alt="Screenshot 2023-12-05 203557" src="https://github.com/WilisArum02/SIBoox/assets/148854173/d8bf2c5f-de60-4eb7-b682-0aed4f8d0b06">


<img width="960" alt="Screenshot 2023-12-05 203759" src="https://github.com/WilisArum02/SIBoox/assets/148854173/6879a50d-ff46-48b9-aef0-6f5a96b4f565">


<img width="960" alt="Screenshot 2023-12-05 203759" src="https://github.com/WilisArum02/SIBoox/assets/148854173/ad5e9320-ff9d-443b-afda-5557e8d0b0f4">


<img width="960" alt="Screenshot 2023-12-05 203837" src="https://github.com/WilisArum02/SIBoox/assets/148854173/d8974436-5cfb-4e45-86ad-4c72f445254b">


<img width="960" alt="Screenshot 2023-12-05 204159" src="https://github.com/WilisArum02/SIBoox/assets/148854173/cd84e9f0-4303-4729-8528-03d6e617098b">


<img width="960" alt="Screenshot 2023-12-05 204531" src="https://github.com/WilisArum02/SIBoox/assets/148854173/c06ecf6d-23ad-48e2-8a6c-4cb58578bb25">









