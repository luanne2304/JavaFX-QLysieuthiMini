-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 06, 2023 lúc 05:08 PM
-- Phiên bản máy phục vụ: 10.4.25-MariaDB
-- Phiên bản PHP: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `sieuthimini`
--

DELIMITER $$
--
-- Thủ tục
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_xacnhanPhieunhap` (IN `id_px` INT)   BEGIN
    DECLARE Qty INT;
    DECLARE IDsp INT;
    DECLARE done INT DEFAULT FALSE;
    DECLARE cs_UpdateQtytrongKho2 CURSOR FOR
        SELECT ID_Sanpham, Soluong FROM chitietphieunhap WHERE ID_Phieunhap = id_px;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    START TRANSACTION;

    SELECT * FROM sanpham FOR UPDATE;

    OPEN cs_UpdateQtytrongKho2;
    FETCH NEXT FROM cs_UpdateQtytrongKho2 INTO IDsp, Qty;
    
    the_loop: LOOP
        UPDATE sanpham SET Sluong = Sluong + Qty WHERE ID_Sp = IDsp;
        FETCH NEXT FROM cs_UpdateQtytrongKho2 INTO IDsp, Qty;
        IF done THEN
            LEAVE the_loop;
        END IF;
    END LOOP the_loop;
    CLOSE cs_UpdateQtytrongKho2;
    COMMIT;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_xacnhanPhieuxuat` (IN `id_px` INT)   BEGIN
    DECLARE Qty INT;
    DECLARE IDsp INT;
    DECLARE error INT DEFAULT 0;
    DECLARE checksl INT DEFAULT -1;
    DECLARE done INT DEFAULT FALSE;
    DECLARE cs_UpdateQtytrongKho CURSOR FOR
        SELECT ID_Sanpham, Soluong FROM chitietphieuxuat WHERE ID_Phieuxuat = id_px;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    START TRANSACTION;

    SELECT * FROM sanpham FOR UPDATE;

    OPEN cs_UpdateQtytrongKho;
    FETCH NEXT FROM cs_UpdateQtytrongKho INTO IDsp, Qty;

    the_loop: LOOP
        SELECT Sluong INTO checksl FROM sanpham WHERE ID_Sp = IDsp;
        IF Qty <= checksl THEN
            UPDATE sanpham SET Sluong = Sluong - Qty WHERE ID_Sp = IDsp;
        ELSE
            SET error = 1;
        END IF;

        FETCH NEXT FROM cs_UpdateQtytrongKho INTO IDsp, Qty;
    IF done THEN
            LEAVE the_loop;
        END IF;
    END LOOP the_loop;

    CLOSE cs_UpdateQtytrongKho;

    IF error != 0 THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'error';
    ELSE
        COMMIT;
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_xacnhanTHANHTOAN` (IN `id_px` INT)   BEGIN
    DECLARE Qty INT;
    DECLARE IDsp INT;
    DECLARE error INT DEFAULT 0;
    DECLARE checksl INT DEFAULT -1;
    DECLARE done INT DEFAULT FALSE;
    DECLARE cs_UpdateQtytrongKho3 CURSOR FOR
        SELECT ID_Sanpham, Sluong FROM chitiethoadon WHERE ID_Hoadon = id_px;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    START TRANSACTION;

    SELECT * FROM sanpham FOR UPDATE;

    OPEN cs_UpdateQtytrongKho3;
    FETCH NEXT FROM cs_UpdateQtytrongKho3 INTO IDsp, Qty;

    the_loop: LOOP
        SELECT Sluong INTO checksl FROM sanpham WHERE ID_Sp = IDsp;
        IF Qty <= checksl THEN
            UPDATE sanpham SET Sluong = Sluong - Qty WHERE ID_Sp = IDsp;
        ELSE
            SET error = 1;
        END IF;

        FETCH NEXT FROM cs_UpdateQtytrongKho3 INTO IDsp, Qty;
    IF done THEN
            LEAVE the_loop;
        END IF;
    END LOOP the_loop;

    CLOSE cs_UpdateQtytrongKho3;

    IF error != 0 THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'error';
    ELSE
        COMMIT;
    END IF;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `ID_Hoadon` int(11) NOT NULL,
  `ID_Sanpham` int(11) NOT NULL,
  `Sluong` int(11) NOT NULL,
  `TongDonGia` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`ID_Hoadon`, `ID_Sanpham`, `Sluong`, `TongDonGia`) VALUES
(7, 1, 1, 20000),
(7, 2, 1, 15000),
(8, 3, 1, 15000),
(8, 4, 1, 15000),
(9, 1, 1, 20000),
(10, 1, 1, 20000),
(10, 2, 1, 15000),
(11, 3, 1, 15000),
(12, 3, 1, 15000),
(13, 4, 1, 15000),
(14, 3, 1, 15000),
(15, 4, 1, 15000),
(16, 3, 1, 15000),
(17, 4, 1, 15000),
(18, 1, 10, 200000),
(18, 2, 5, 75000),
(19, 1, 10, 200000),
(19, 2, 5, 75000),
(20, 1, 10, 200000),
(20, 2, 5, 75000),
(21, 3, 3, 45000),
(22, 3, 10, 150000),
(23, 3, 4, 60000),
(24, 3, 2, 30000),
(25, 3, 1, 15000),
(26, 3, 1, 15000),
(27, 2, 1, 15000),
(28, 2, 1, 15000),
(29, 5, 1, 50000),
(30, 1, 1, 150000),
(31, 1, 18, 2700000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `ID_Phieunhap` int(11) NOT NULL,
  `ID_Sanpham` int(11) NOT NULL,
  `Soluong` int(11) NOT NULL,
  `TongGiaNhap` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`ID_Phieunhap`, `ID_Sanpham`, `Soluong`, `TongGiaNhap`) VALUES
(1, 3, 1, 0),
(2, 3, 1, 200),
(2, 4, 1, 50),
(3, 1, 3, 0),
(3, 2, 5, 0),
(4, 1, 1, 0),
(5, 3, 1, 0),
(6, 5, 1, 0),
(7, 5, 2, 0),
(8, 5, 1, 0),
(9, 5, 1, 0),
(10, 5, 1, 0),
(11, 3, 1, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieuxuat`
--

CREATE TABLE `chitietphieuxuat` (
  `ID_Phieuxuat` int(11) NOT NULL,
  `ID_Sanpham` int(11) NOT NULL,
  `Soluong` int(11) NOT NULL,
  `TongGiaXuat` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieuxuat`
--

INSERT INTO `chitietphieuxuat` (`ID_Phieuxuat`, `ID_Sanpham`, `Soluong`, `TongGiaXuat`) VALUES
(13, 1, 20, 300000),
(14, 3, 1, 100),
(14, 2, 10, 1000),
(18, 1, 1, 0),
(19, 1, 1, 0),
(20, 1, 1, 0),
(20, 3, 1, 0),
(21, 3, 1, 0),
(22, 2, 1, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donvitinh`
--

CREATE TABLE `donvitinh` (
  `ID_Donvitinh` int(11) NOT NULL,
  `DonviTinh` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `donvitinh`
--

INSERT INTO `donvitinh` (`ID_Donvitinh`, `DonviTinh`) VALUES
(1, 'Ly'),
(2, 'Hộp'),
(3, 'Cái'),
(4, 'Kg'),
(5, 'Gói');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `ID_Hoadon` int(11) NOT NULL,
  `ID_Nhansu` int(11) NOT NULL,
  `ID_KH` int(11) NOT NULL,
  `ID_Magiam` int(11) NOT NULL,
  `ID_Phuongthucthanhtoan` int(11) NOT NULL,
  `Ngaylap` date NOT NULL,
  `Tongtien` double NOT NULL,
  `Thanhtien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`ID_Hoadon`, `ID_Nhansu`, `ID_KH`, `ID_Magiam`, `ID_Phuongthucthanhtoan`, `Ngaylap`, `Tongtien`, `Thanhtien`) VALUES
(2, 1, 1, 1, 1, '2023-07-07', 0, 0),
(3, 1, 1, 1, 1, '2023-07-07', 0, 0),
(4, 1, 1, 1, 1, '2023-07-07', 0, 0),
(5, 1, 1, 1, 1, '2023-07-07', 0, 0),
(6, 1, 1, 1, 1, '2023-07-07', 0, 0),
(7, 1, 1, 1, 1, '2023-07-07', 0, 0),
(8, 1, 1, 1, 1, '2023-07-07', 0, 0),
(9, 1, 1, 1, 1, '2023-07-07', 0, 0),
(10, 1, 1, 1, 1, '2023-07-07', 0, 0),
(11, 1, 1, 1, 1, '2023-07-07', 0, 0),
(12, 1, 1, 1, 1, '2023-07-09', 0, 0),
(13, 1, 1, 1, 1, '2023-07-09', 0, 0),
(14, 1, 1, 1, 1, '2023-07-09', 0, 0),
(15, 1, 1, 1, 1, '2023-07-09', 0, 0),
(16, 1, 1, 1, 1, '2023-07-09', 0, 0),
(17, 1, 1, 1, 1, '2023-07-09', 15000, 15000),
(18, 1, 1, 1, 2, '2023-07-13', 275000, 220000),
(19, 1, 1, 1, 2, '2023-07-21', 275000, 220000),
(20, 1, 1, 1, 2, '2023-07-21', 275000, 220000),
(21, 1, 1, 1, 2, '2023-07-21', 45000, 36000),
(22, 1, 1, 1, 2, '2023-07-21', 150000, 120000),
(23, 1, 1, 1, 2, '2023-07-22', 60000, 48000),
(24, 1, 1, 2, 2, '2023-07-24', 30000, 21900),
(25, 3, 0, 1, 2, '2023-08-06', 15000, 15000),
(26, 3, 0, 1, 2, '2023-08-06', 15000, 15000),
(27, 3, 0, 1, 1, '2023-08-06', 15000, 15000),
(28, 3, 0, 1, 2, '2023-08-06', 15000, 15000),
(29, 3, 0, 1, 1, '2023-08-06', 50000, 50000),
(30, 3, 0, 1, 1, '2023-08-06', 150000, 150000),
(31, 3, 0, 1, 1, '2023-08-06', 2700000, 2700000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `ID_KH` int(11) NOT NULL,
  `Ten_KH` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `SDT` char(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `Tichluy` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`ID_KH`, `Ten_KH`, `SDT`, `Tichluy`) VALUES
(0, 'Rỗng', '0', 3149900),
(2, 'Nguyễn Văn B', '0987654321', 0),
(3, 'Nguyễn Văn E', '0123456700', 0),
(4, 'Nguyễn Văn F', '0987654555', 0),
(5, 'Nguyễn Văn K', '0987654444', 0),
(6, 'Nguyễn Văn Y', '0987654222', 0),
(7, 'Võ Minh Luân', '0123456789', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai`
--

CREATE TABLE `loai` (
  `ID_Loai` int(11) NOT NULL,
  `Ten_Loai` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `loai`
--

INSERT INTO `loai` (`ID_Loai`, `Ten_Loai`) VALUES
(1, 'Nước'),
(2, 'Thức ăn nhanh'),
(3, 'Thực phẩm tươi sống'),
(4, 'Gia vị'),
(5, 'Đóng hộp/ bao bì'),
(6, 'Dụng cụ cá nhân'),
(7, 'Dụng cụ gia dụng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `magiam`
--

CREATE TABLE `magiam` (
  `ID_Magiam` int(11) NOT NULL,
  `Ten_Magiam` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `Chietkhau` float NOT NULL,
  `Trangthai` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `magiam`
--

INSERT INTO `magiam` (`ID_Magiam`, `Ten_Magiam`, `Chietkhau`, `Trangthai`) VALUES
(1, 'Không có', 0, 1),
(2, 'Khai trương', 27, 1),
(3, 'Chúc mừng sinh nhật', 20, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhansu`
--

CREATE TABLE `nhansu` (
  `ID_Nhansu` int(11) NOT NULL,
  `Ten_Nhansu` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `SDT` char(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `Mail` varchar(200) COLLATE utf8_vietnamese_ci NOT NULL,
  `CCCD` char(12) COLLATE utf8_vietnamese_ci NOT NULL,
  `Ngayvaolam` date NOT NULL,
  `Ngaysinh` date NOT NULL,
  `TenChucvu` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `Trangthai` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `nhansu`
--

INSERT INTO `nhansu` (`ID_Nhansu`, `Ten_Nhansu`, `SDT`, `Mail`, `CCCD`, `Ngayvaolam`, `Ngaysinh`, `TenChucvu`, `Trangthai`) VALUES
(1, 'MeanNuan', '0666688880', 'Mean@Nuan', '079202000123', '2023-07-12', '2000-01-01', 'Quản lý', 1),
(2, 'MinhLuan', '0123456789', 'luan@123', '079202000456', '2023-07-12', '2000-01-01', 'Nhân viên', 0),
(3, 'MinhLuan', '0123456782', '', '079202000452', '2023-07-12', '2000-01-01', 'Nhân viên', 0),
(4, 'AAAA', '0123456781', 'luan@123', '079202000422', '2023-07-12', '2000-01-01', 'Nhân viên', 0),
(5, 'AAAA', '0123456722', 'luan@123', '079202000444', '2023-07-12', '2000-01-01', 'Nhân viên', 0),
(6, 'AAAA', '0123456444', 'luan@123', '079202000222', '2023-07-12', '2000-01-01', 'Nhân viên', 0),
(7, 'AAAA', '0123456111', 'luan@123', '079202000111', '2023-07-12', '2000-01-01', 'Nhân viên', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `ID_Phieunhap` int(11) NOT NULL,
  `ID_Nhansu` int(11) NOT NULL,
  `Ngaynhap` date NOT NULL,
  `TongChi` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`ID_Phieunhap`, `ID_Nhansu`, `Ngaynhap`, `TongChi`) VALUES
(1, 1, '2023-07-10', 0),
(2, 1, '2023-07-10', 250),
(3, 1, '2023-07-21', 0),
(4, 1, '2023-07-24', 0),
(5, 3, '2023-08-05', 0),
(6, 3, '2023-08-06', 0),
(7, 3, '2023-08-06', 0),
(8, 3, '2023-08-06', 0),
(9, 3, '2023-08-06', 0),
(10, 3, '2023-08-06', 0),
(11, 3, '2023-08-06', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `ID_Phieuxuat` int(11) NOT NULL,
  `ID_Nhansu` int(11) NOT NULL,
  `Ngayxuat` date NOT NULL,
  `TongThu` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuxuat`
--

INSERT INTO `phieuxuat` (`ID_Phieuxuat`, `ID_Nhansu`, `Ngayxuat`, `TongThu`) VALUES
(13, 1, '2023-07-10', 300000),
(14, 1, '2023-07-10', 1100),
(18, 1, '2023-08-05', 0),
(19, 1, '2023-08-05', 0),
(20, 1, '2023-08-05', 0),
(21, 1, '2023-08-05', 0),
(22, 1, '2023-08-06', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phuongthucthanhtoan`
--

CREATE TABLE `phuongthucthanhtoan` (
  `ID_Phuongthucthanhtoan` int(11) NOT NULL,
  `Ten_Phuongthucthanhtoan` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `phuongthucthanhtoan`
--

INSERT INTO `phuongthucthanhtoan` (`ID_Phuongthucthanhtoan`, `Ten_Phuongthucthanhtoan`) VALUES
(1, 'Tiền mặt'),
(2, 'Chuyển khoản');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `ID_Sp` int(11) NOT NULL,
  `Ten_Sp` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `ID_Loai` int(11) NOT NULL,
  `Gia` double NOT NULL,
  `Sluong` int(11) NOT NULL,
  `ID_Donvitinh` int(11) NOT NULL,
  `Trangthai` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`ID_Sp`, `Ten_Sp`, `ID_Loai`, `Gia`, `Sluong`, `ID_Donvitinh`, `Trangthai`) VALUES
(1, 'Bếp', 7, 150000, 0, 3, 1),
(2, 'Trà tắc', 1, 15000, 27, 1, 1),
(3, 'Bánh mỳ chà bông', 2, 15000, 39, 3, 1),
(4, 'Pate ch2', 2, 15000, 40, 3, 1),
(5, 'Chảo', 7, 50000, 0, 2, 1),
(6, 'AAAA', 7, 50000, 0, 2, 1),
(7, 'Muối', 4, 15000, 0, 5, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `ID_Taikhoan` int(11) NOT NULL,
  `Ten_Taikhoan` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `Matkhau` varchar(200) COLLATE utf8_vietnamese_ci NOT NULL,
  `ID_Nhansu` int(11) NOT NULL,
  `Quyen` tinyint(1) NOT NULL,
  `Trangthai` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`ID_Taikhoan`, `Ten_Taikhoan`, `Matkhau`, `ID_Nhansu`, `Quyen`, `Trangthai`) VALUES
(1, 'Admin', '1', 3, 1, 1),
(2, 'Admin222', 'Admin222', 0, 1, 1),
(3, 'Admin22222', '122222222', 0, 1, 1),
(4, 'Admin21312', '13213123123', 0, 1, 1),
(5, 'Admin2222', '12222222', 4, 1, 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`ID_Hoadon`,`ID_Sanpham`);

--
-- Chỉ mục cho bảng `donvitinh`
--
ALTER TABLE `donvitinh`
  ADD PRIMARY KEY (`ID_Donvitinh`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`ID_Hoadon`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`ID_KH`);

--
-- Chỉ mục cho bảng `loai`
--
ALTER TABLE `loai`
  ADD PRIMARY KEY (`ID_Loai`);

--
-- Chỉ mục cho bảng `magiam`
--
ALTER TABLE `magiam`
  ADD PRIMARY KEY (`ID_Magiam`);

--
-- Chỉ mục cho bảng `nhansu`
--
ALTER TABLE `nhansu`
  ADD PRIMARY KEY (`ID_Nhansu`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`ID_Phieunhap`);

--
-- Chỉ mục cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`ID_Phieuxuat`);

--
-- Chỉ mục cho bảng `phuongthucthanhtoan`
--
ALTER TABLE `phuongthucthanhtoan`
  ADD PRIMARY KEY (`ID_Phuongthucthanhtoan`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`ID_Sp`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`ID_Taikhoan`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `donvitinh`
--
ALTER TABLE `donvitinh`
  MODIFY `ID_Donvitinh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `ID_Hoadon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `ID_KH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `loai`
--
ALTER TABLE `loai`
  MODIFY `ID_Loai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `magiam`
--
ALTER TABLE `magiam`
  MODIFY `ID_Magiam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `nhansu`
--
ALTER TABLE `nhansu`
  MODIFY `ID_Nhansu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `ID_Phieunhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  MODIFY `ID_Phieuxuat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT cho bảng `phuongthucthanhtoan`
--
ALTER TABLE `phuongthucthanhtoan`
  MODIFY `ID_Phuongthucthanhtoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `ID_Sp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `ID_Taikhoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
