-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2024 at 04:46 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cnpm61`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbldongmh48`
--

CREATE TABLE `tbldongmh48` (
  `ID` int(10) NOT NULL,
  `DongMH` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `tbldongmh48`
--

INSERT INTO `tbldongmh48` (`ID`, `DongMH`) VALUES
(1, 'Điện thoại'),
(2, 'Máy tính'),
(3, 'Gia dụng'),
(4, 'Đồ điện tử, điện lạnh'),
(5, 'Ô tô'),
(6, 'Bất động sản');

-- --------------------------------------------------------

--
-- Table structure for table `tbldt48`
--

CREATE TABLE `tbldt48` (
  `ID` int(10) NOT NULL,
  `TenDT` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `tbldt48`
--

INSERT INTO `tbldt48` (`ID`, `TenDT`) VALUES
(1, 'Samsung'),
(2, 'DienMayXanh'),
(3, 'Apple'),
(4, 'TheGioiDiDong'),
(5, 'HoangHaMobile'),
(6, 'MediaMart'),
(7, 'Pico'),
(8, 'Toyota'),
(9, 'NhaDatAT');

-- --------------------------------------------------------

--
-- Table structure for table `tblhoadonchodt48`
--

CREATE TABLE `tblhoadonchodt48` (
  `ID` int(10) NOT NULL,
  `NgayThanhToan` date NOT NULL,
  `TongTienThanhToan` float NOT NULL,
  `TrangThai` int(10) NOT NULL,
  `tblDT48ID` int(10) NOT NULL,
  `tblNV48ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `tblhoadonchodt48`
--

INSERT INTO `tblhoadonchodt48` (`ID`, `NgayThanhToan`, `TongTienThanhToan`, `TrangThai`, `tblDT48ID`, `tblNV48ID`) VALUES
(1, '2024-03-01', 10000000, 1, 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblhoadonchokh48`
--

CREATE TABLE `tblhoadonchokh48` (
  `ID` int(10) NOT NULL,
  `NgayPhaiThanhToan` date NOT NULL,
  `TongTienThanhToan` float NOT NULL,
  `TongDuNo` float NOT NULL,
  `TrangThai` int(10) NOT NULL,
  `tblHopDong48ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `tblhoadonchokh48`
--

INSERT INTO `tblhoadonchokh48` (`ID`, `NgayPhaiThanhToan`, `TongTienThanhToan`, `TongDuNo`, `TrangThai`, `tblHopDong48ID`) VALUES
(1, '2023-02-01', 1000000, 9000000, 1, 1),
(2, '2023-03-01', 1000000, 8000000, 1, 1),
(3, '2023-04-01', 1000000, 7000000, 1, 1),
(5, '2023-05-01', 1000000, 6000000, 1, 1),
(6, '2023-06-01', 1000000, 5000000, 1, 1),
(7, '2023-07-01', 1000000, 4000000, 1, 1),
(8, '2023-08-01', 1000000, 3000000, 1, 1),
(9, '2023-09-01', 1000000, 2000000, 1, 1),
(10, '2023-10-01', 1000000, 1000000, 1, 1),
(11, '2023-11-01', 1000000, 0, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblhopdong48`
--

CREATE TABLE `tblhopdong48` (
  `ID` int(10) NOT NULL,
  `NgayKi` date NOT NULL,
  `ThoiHanVay` int(10) NOT NULL,
  `tblDT48ID` int(10) NOT NULL,
  `tblNV48ID` int(10) NOT NULL,
  `tblKH48ID` int(10) NOT NULL,
  `tblHoaDonChoDT48ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `tblhopdong48`
--

INSERT INTO `tblhopdong48` (`ID`, `NgayKi`, `ThoiHanVay`, `tblDT48ID`, `tblNV48ID`, `tblKH48ID`, `tblHoaDonChoDT48ID`) VALUES
(1, '2023-01-01', 12, 5, 1, 1, 1),
(2, '2023-01-01', 12, 5, 1, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblhopdong_mhdt48`
--

CREATE TABLE `tblhopdong_mhdt48` (
  `ID` int(10) NOT NULL,
  `tblMH_DT48ID` int(10) NOT NULL,
  `tblHopDong48ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `tblhopdong_mhdt48`
--

INSERT INTO `tblhopdong_mhdt48` (`ID`, `tblMH_DT48ID`, `tblHopDong48ID`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblkh48`
--

CREATE TABLE `tblkh48` (
  `ID` int(10) NOT NULL,
  `TenKH` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `tblkh48`
--

INSERT INTO `tblkh48` (`ID`, `TenKH`) VALUES
(1, 'Khách Hàng 1'),
(2, 'Khách Hàng 2'),
(3, 'Khách Hàng 3'),
(4, 'Khách Hàng 4'),
(5, 'Khách Hàng 5'),
(6, 'Khách Hàng 6'),
(7, 'Khách Hàng 7'),
(8, 'Khách Hàng 8'),
(9, 'Khách Hàng 9'),
(10, 'Khách Hàng 10');

-- --------------------------------------------------------

--
-- Table structure for table `tblmh48`
--

CREATE TABLE `tblmh48` (
  `ID` int(10) NOT NULL,
  `TenMH` varchar(255) NOT NULL,
  `tblDongMH48ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `tblmh48`
--

INSERT INTO `tblmh48` (`ID`, `TenMH`, `tblDongMH48ID`) VALUES
(1, 'Iphone XS Max 2010', 1),
(2, 'Iphone XS Max 2010', 1),
(3, 'Samsung S22', 1),
(4, 'Bphone X', 1),
(5, 'Oppo Sharno', 1),
(6, 'Vivo Ultra', 1),
(7, 'Dell inspiron 2022', 2),
(8, 'Dell inspiron 2022', 2),
(9, 'MSI Gaming', 2),
(10, 'HP ultrabook', 2),
(11, 'Asus zenbook', 2),
(12, 'Acer TigerH', 2),
(13, 'Bộ bàn ghế gỗ', 3),
(14, 'Bộ gốm sứ triều Thanh', 2),
(15, 'Tủ lạnh Toshiba 2018', 4),
(16, 'Toyota City 6', 5),
(17, 'Căn hộ chung cư EcoPark', 6);

-- --------------------------------------------------------

--
-- Table structure for table `tblmh_dt48`
--

CREATE TABLE `tblmh_dt48` (
  `ID` int(10) NOT NULL,
  `DonGiaMH` float NOT NULL,
  `LaiSuat` float NOT NULL,
  `tblDT48ID` int(10) NOT NULL,
  `tblMH48ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `tblmh_dt48`
--

INSERT INTO `tblmh_dt48` (`ID`, `DonGiaMH`, `LaiSuat`, `tblDT48ID`, `tblMH48ID`) VALUES
(1, 10000000, 10, 5, 12);

-- --------------------------------------------------------

--
-- Table structure for table `tblnv48`
--

CREATE TABLE `tblnv48` (
  `ID` int(10) NOT NULL,
  `TenNV` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `tblnv48`
--

INSERT INTO `tblnv48` (`ID`, `TenNV`) VALUES
(1, 'Nhân Văn Viên 1'),
(2, 'Nhân Văn Viên 2'),
(3, 'Nhân Văn Viên 3'),
(4, 'Quản lý 1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbldongmh48`
--
ALTER TABLE `tbldongmh48`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tbldt48`
--
ALTER TABLE `tbldt48`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tblhoadonchodt48`
--
ALTER TABLE `tblhoadonchodt48`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKtblHoaDonC653007` (`tblDT48ID`),
  ADD KEY `FKtblHoaDonC879910` (`tblNV48ID`);

--
-- Indexes for table `tblhoadonchokh48`
--
ALTER TABLE `tblhoadonchokh48`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKtblHoaDonC684093` (`tblHopDong48ID`);

--
-- Indexes for table `tblhopdong48`
--
ALTER TABLE `tblhopdong48`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKtblHopDong316306` (`tblDT48ID`),
  ADD KEY `FKtblHopDong754978` (`tblNV48ID`),
  ADD KEY `FKtblHopDong835305` (`tblKH48ID`),
  ADD KEY `FKtblHopDong856580` (`tblHoaDonChoDT48ID`);

--
-- Indexes for table `tblhopdong_mhdt48`
--
ALTER TABLE `tblhopdong_mhdt48`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKtblHopDong221238` (`tblMH_DT48ID`),
  ADD KEY `FKtblHopDong907221` (`tblHopDong48ID`);

--
-- Indexes for table `tblkh48`
--
ALTER TABLE `tblkh48`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tblmh48`
--
ALTER TABLE `tblmh48`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKtblMH48891748` (`tblDongMH48ID`);

--
-- Indexes for table `tblmh_dt48`
--
ALTER TABLE `tblmh_dt48`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKtblMH_DT4828685` (`tblDT48ID`),
  ADD KEY `FKtblMH_DT48865625` (`tblMH48ID`);

--
-- Indexes for table `tblnv48`
--
ALTER TABLE `tblnv48`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbldongmh48`
--
ALTER TABLE `tbldongmh48`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbldt48`
--
ALTER TABLE `tbldt48`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tblhoadonchodt48`
--
ALTER TABLE `tblhoadonchodt48`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tblhoadonchokh48`
--
ALTER TABLE `tblhoadonchokh48`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `tblhopdong48`
--
ALTER TABLE `tblhopdong48`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tblhopdong_mhdt48`
--
ALTER TABLE `tblhopdong_mhdt48`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tblkh48`
--
ALTER TABLE `tblkh48`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tblmh48`
--
ALTER TABLE `tblmh48`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `tblmh_dt48`
--
ALTER TABLE `tblmh_dt48`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tblnv48`
--
ALTER TABLE `tblnv48`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tblhoadonchodt48`
--
ALTER TABLE `tblhoadonchodt48`
  ADD CONSTRAINT `FKtblHoaDonC653007` FOREIGN KEY (`tblDT48ID`) REFERENCES `tbldt48` (`ID`),
  ADD CONSTRAINT `FKtblHoaDonC879910` FOREIGN KEY (`tblNV48ID`) REFERENCES `tblnv48` (`ID`);

--
-- Constraints for table `tblhoadonchokh48`
--
ALTER TABLE `tblhoadonchokh48`
  ADD CONSTRAINT `FKtblHoaDonC684093` FOREIGN KEY (`tblHopDong48ID`) REFERENCES `tblhopdong48` (`ID`);

--
-- Constraints for table `tblhopdong48`
--
ALTER TABLE `tblhopdong48`
  ADD CONSTRAINT `FKtblHopDong316306` FOREIGN KEY (`tblDT48ID`) REFERENCES `tbldt48` (`ID`),
  ADD CONSTRAINT `FKtblHopDong754978` FOREIGN KEY (`tblNV48ID`) REFERENCES `tblnv48` (`ID`),
  ADD CONSTRAINT `FKtblHopDong835305` FOREIGN KEY (`tblKH48ID`) REFERENCES `tblkh48` (`ID`),
  ADD CONSTRAINT `FKtblHopDong856580` FOREIGN KEY (`tblHoaDonChoDT48ID`) REFERENCES `tblhoadonchodt48` (`ID`);

--
-- Constraints for table `tblhopdong_mhdt48`
--
ALTER TABLE `tblhopdong_mhdt48`
  ADD CONSTRAINT `FKtblHopDong221238` FOREIGN KEY (`tblMH_DT48ID`) REFERENCES `tblmh_dt48` (`ID`),
  ADD CONSTRAINT `FKtblHopDong907221` FOREIGN KEY (`tblHopDong48ID`) REFERENCES `tblhopdong48` (`ID`);

--
-- Constraints for table `tblmh48`
--
ALTER TABLE `tblmh48`
  ADD CONSTRAINT `FKtblMH48891748` FOREIGN KEY (`tblDongMH48ID`) REFERENCES `tbldongmh48` (`ID`);

--
-- Constraints for table `tblmh_dt48`
--
ALTER TABLE `tblmh_dt48`
  ADD CONSTRAINT `FKtblMH_DT4828685` FOREIGN KEY (`tblDT48ID`) REFERENCES `tbldt48` (`ID`),
  ADD CONSTRAINT `FKtblMH_DT48865625` FOREIGN KEY (`tblMH48ID`) REFERENCES `tblmh48` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
