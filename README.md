
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

```
Copyright 2016 Agung Pramono.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements. See the NOTICE file distributed with this work for
additional information regarding copyright ownership. The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.
```