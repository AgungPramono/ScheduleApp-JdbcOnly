
# Aplikasi Jadwal menggunakan JDBC Murni

## Konfigurasi Project ##
1. Buat database di MySQL

	* nama database : db_trainingapp
	* username = root	
	* password = (sesuaikan dg yang ada dikomputermu)

2. Edit konfigurasi di atas di package

`````
	com.agung.jadwal.dao di Class KoneksiHelper
``````	

3. Langkah Menjalankan
	* pastika apache maven sudah di install dan di konfigurasi, jika belum link tutorial ada di bawah
	* buka terminal atau Command prompt, kemudian arahkan ke project ini
	* jalankan perintah dibawah untuk membuild project
	````
		mvn clean package
	`````	
	* kemudian jalankan perintah di bawah untuk menjalankan aplikasi
	``````
		mvn exec:java -Dexec.mainClass=com.agung.jadwal.Main
	```````	

4. Fitur Aplikasi

	* Cetak Laporan
	* Tabel Relasi
	
	![alt tag](https://github.com/AgungPramono/ScheduleApp-JdbcOnly/blob/master/skema-erd.png)

5. Referensi
	* [Persiapan Coding Java](http://http://software.endy.muhardin.com/java/persiapan-coding-java/) 	

# Happy Coding :):)

