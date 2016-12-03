create database db_trainingapp;
CREATE TABLE IF NOT EXISTS `pelajaran` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `kode_mapel` VARCHAR(45) NULL,
  `nama_mapel` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `ruang` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `kode_ruang` VARCHAR(45) NULL,
  `ruang` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `guru` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `kode_guru` VARCHAR(45) NULL,
  `nama_guru` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `jadwal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `hari` VARCHAR(45) NULL,
  `jam` INT NULL,
  `id_ruang` INT NOT NULL,
  `id_mapel` INT NOT NULL,
  `id_guru` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_jadwal_pelajaran_idx` (`id_mapel` ASC),
  INDEX `fk_jadwal_ruang1_idx` (`id_ruang` ASC),
  INDEX `fk_jadwal_guru1_idx` (`id_guru` ASC),
  CONSTRAINT `fk_jadwal_pelajaran`
    FOREIGN KEY (`id_mapel`)
    REFERENCES `pelajaran` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_jadwal_ruang1`
    FOREIGN KEY (`id_ruang`)
    REFERENCES `ruang` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_jadwal_guru1`
    FOREIGN KEY (`id_guru`)
    REFERENCES `guru` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;