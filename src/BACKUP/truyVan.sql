--Thong ke dong mh theo doanh thu giam dan
WITH unique_values AS (
    SELECT DISTINCT
        tblhoadonchokh48.id AS id_hoaDon,
        tblhoadonchokh48.TongTienThanhToan,
        tbldongmh48.id AS id_dongMH,
        tbldongmh48.DongMH
    FROM
        tblhoadonchokh48
    INNER JOIN
        tblhopdong48 ON tblhoadonchokh48.tblHopDong48ID = tblhopdong48.ID
    INNER JOIN
        tblhopdong_mhdt48 ON tblhopdong48.ID = tblhopdong_mhdt48.tblHopDong48ID
    INNER JOIN
        tblmh_dt48 ON tblhopdong_mhdt48.tblMH_DT48ID = tblmh_dt48.ID
    INNER JOIN
        tblmh48 ON tblmh_dt48.tblMH48ID = tblmh48.ID
    INNER JOIN
        tbldongmh48 ON tblmh48.tblDongMH48ID = tbldongmh48.ID
    WHERE
        tblhoadonchokh48.NgayPhaiThanhToan BETWEEN '2023-01-01' AND '2023-12-12'
)
SELECT
    id_dongMH,
    dongMH,
    COUNT(id_hoaDon) AS tongSoHoaDon,
    SUM(TongTienThanhToan) AS tongDoanhThu
FROM
    unique_values
GROUP BY
    id_dongMH, dongMH
ORDER BY
    tongDoanhThu DESC;

```
--Tke Mat hang cua 1 dong mat hang
--Thay moi doan selecr - add them 2 cot  tblmh48.id AS id_MH,  tblmh48.TenMH va group by theo 2 cot nay
WITH
    TongTienHopDong AS (
        SELECT
            tblhopdong48.id AS id_hopDong,
            SUM(tblmh_dt48.DonGiaMH) AS tongTienHopDong
        FROM
            tblhopdong48
        INNER JOIN
            tblhopdong_mhdt48 ON tblhopdong48.ID = tblhopdong_mhdt48.tblHopDong48ID
        INNER JOIN
            tblmh_dt48 ON tblhopdong_mhdt48.tblMH_DT48ID = tblmh_dt48.ID
        GROUP BY
            id_hopDong
    ),
    BangKq1 AS (
        SELECT
            id_MH,
            TenMH,
            id_hopDong,
            COUNT(id_hoaDon) AS tongSoHoaDon,
            SUM(tongTienThanhToan) AS tongDoanhThu,
            DonGiaMH
        FROM
            (SELECT DISTINCT
                tblhoadonchokh48.id AS id_hoaDon,
                tblhoadonchokh48.TongTienThanhToan,
                tbldongmh48.id AS id_dongMH,
                tbldongmh48.DongMH,
                tblhopdong48.id AS id_hopDong,
                tblmh48.id AS id_MH,
                tblmh48.TenMH,
                tblmh_dt48.DonGiaMH
            FROM
                tblhoadonchokh48
            INNER JOIN
                tblhopdong48 ON tblhoadonchokh48.tblHopDong48ID = tblhopdong48.ID
            INNER JOIN
                tblhopdong_mhdt48 ON tblhopdong48.ID = tblhopdong_mhdt48.tblHopDong48ID
            INNER JOIN
                tblmh_dt48 ON tblhopdong_mhdt48.tblMH_DT48ID = tblmh_dt48.ID
            INNER JOIN
                tblmh48 ON tblmh_dt48.tblMH48ID = tblmh48.ID
            INNER JOIN
                tbldongmh48 ON tblmh48.tblDongMH48ID = tbldongmh48.ID
            WHERE
                tblhoadonchokh48.NgayPhaiThanhToan BETWEEN '2023-01-01' AND '2023-12-12') AS unique_values
        GROUP BY
            id_hopDong, id_MH, TenMH, DonGiaMH
        ORDER BY
            tongDoanhThu DESC
    )

SELECT
    BangKq1.*,
    SUM(tongSoHoaDon) as tongHoaDonMH,
    (DonGiaMH / tongTienHopDong) * tongDoanhThu AS DoanhThuMH_1HD,
    TongTienHopDong.tongTienHopDong,
    SUM((DonGiaMH / tongTienHopDong) * tongDoanhThu) AS doanhThuMH,
    (SUM((DonGiaMH / tongTienHopDong) * tongDoanhThu) * 0.01) AS LaiThuVe
FROM
    BangKq1
LEFT JOIN
    TongTienHopDong ON BangKq1.id_hopDong = TongTienHopDong.id_hopDong
GROUP BY id_MH
ORDER BY doanhThuMH DESC

--Get mh theo category
WITH
    TongTienHopDong AS (
        SELECT
            tblhopdong48.id AS id_hopDong,
            SUM(tblmh_dt48.DonGiaMH) AS tongTienHopDong
        FROM
            tblhopdong48
        INNER JOIN
            tblhopdong_mhdt48 ON tblhopdong48.ID = tblhopdong_mhdt48.tblHopDong48ID
        INNER JOIN
            tblmh_dt48 ON tblhopdong_mhdt48.tblMH_DT48ID = tblmh_dt48.ID
        GROUP BY
            id_hopDong
    ),
    BangKq1 AS (
        SELECT
            id_MH,
            TenMH,
        	id_dongMH,
            id_hopDong,
            COUNT(id_hoaDon) AS tongSoHoaDon,
            SUM(tongTienThanhToan) AS tongDoanhThu,
            DonGiaMH
        FROM
            (SELECT DISTINCT
                tblhoadonchokh48.id AS id_hoaDon,
                tblhoadonchokh48.TongTienThanhToan,
                tbldongmh48.id AS id_dongMH,
                tbldongmh48.DongMH,
                tblhopdong48.id AS id_hopDong,
                tblmh48.id AS id_MH,
                tblmh48.TenMH,
                tblmh_dt48.DonGiaMH
            FROM
                tblhoadonchokh48
            INNER JOIN
                tblhopdong48 ON tblhoadonchokh48.tblHopDong48ID = tblhopdong48.ID
            INNER JOIN
                tblhopdong_mhdt48 ON tblhopdong48.ID = tblhopdong_mhdt48.tblHopDong48ID
            INNER JOIN
                tblmh_dt48 ON tblhopdong_mhdt48.tblMH_DT48ID = tblmh_dt48.ID
            INNER JOIN
                tblmh48 ON tblmh_dt48.tblMH48ID = tblmh48.ID
            INNER JOIN
                tbldongmh48 ON tblmh48.tblDongMH48ID = tbldongmh48.ID
            WHERE
                tblhoadonchokh48.NgayPhaiThanhToan BETWEEN '2023-01-01' AND '2023-12-12') AS unique_values
        GROUP BY
            id_hopDong, id_MH, TenMH, DonGiaMH
        ORDER BY
            tongDoanhThu DESC
    )

SELECT
    BangKq1.*,
    SUM(tongSoHoaDon) as tongHoaDonMH,
    (DonGiaMH / tongTienHopDong) * tongDoanhThu AS DoanhThuMH_1HD,
    TongTienHopDong.tongTienHopDong,
    SUM((DonGiaMH / tongTienHopDong) * tongDoanhThu) AS doanhThuMH,
    (SUM((DonGiaMH / tongTienHopDong) * tongDoanhThu) * 0.01) AS LaiThuVe
FROM
    BangKq1
LEFT JOIN
    TongTienHopDong ON BangKq1.id_hopDong = TongTienHopDong.id_hopDong
WHERE id_dongMH =1
GROUP BY id_MH
ORDER BY doanhThuMH DESC

--Tke HopDong theo MH
WITH
    TongTienHoaDon AS (
        SELECT
            tblhopdong48.NgayKi,
            tblhopdong48.id AS idHopDong,
            SUM(tblhoadonchokh48.TongTienThanhToan) AS tongTienHoaDon
        FROM
            tblhopdong48
        INNER JOIN
            tblhoadonchokh48 ON tblhopdong48.id = tblhoadonchokh48.tblHopDong48ID
        GROUP BY
            idHopDong
    ),
    TongTienHopDong AS (
        SELECT
            tblhopdong48.id AS id_hopDong,
            tblkh48.TenKH,
            SUM(tblmh_dt48.DonGiaMH) AS tongTienHopDong
        FROM
            tblhopdong48
        INNER JOIN
            tblhopdong_mhdt48 ON tblhopdong48.ID = tblhopdong_mhdt48.tblHopDong48ID
        INNER JOIN
            tblmh_dt48 ON tblhopdong_mhdt48.tblMH_DT48ID = tblmh_dt48.ID
        INNER JOIN
        	tblkh48 ON tblkh48.id = tblhopdong48.tblKH48ID
        GROUP BY
            id_hopDong, tblkh48.TenKH
    ),
    MH_HopDong AS (
        SELECT
            tblmh_dt48.tblMH48ID,
            tblhopdong_mhdt48.tblHopDong48ID
        FROM
            tblmh_dt48
        INNER JOIN
            tblhopdong_mhdt48 ON tblmh_dt48.id = tblhopdong_mhdt48.tblMH_DT48ID
    )

SELECT
    TongTienHoaDon.idHopDong,
    TongTienHopDong.TenKH,
    TongTienHopDong.tongTienHopDong,
    (TongTienHoaDon.tongTienHoaDon*0.01) AS tongLaiThuDuoc,
    tongtienhoadon.ngayKi,
    MH_HopDong.tblMH48ID,
    MH_HopDong.tblHopDong48ID
FROM
    TongTienHoaDon
INNER JOIN
    TongTienHopDong ON TongTienHoaDon.idHopDong = TongTienHopDong.id_hopDong
INNER JOIN
    MH_HopDong ON TongTienHopDong.id_hopDong = MH_HopDong.tblHopDong48ID;

--Tke hop dong theo id mat hang
WITH
    TongTienHoaDon AS (
        SELECT
            tblhopdong48.NgayKi,
            tblhopdong48.id AS idHopDong,
            SUM(tblhoadonchokh48.TongTienThanhToan) AS tongTienHoaDon
        FROM
            tblhopdong48
        INNER JOIN
            tblhoadonchokh48 ON tblhopdong48.id = tblhoadonchokh48.tblHopDong48ID
        GROUP BY
            idHopDong
    ),
    TongTienHopDong AS (
        SELECT
            tblhopdong48.id AS id_hopDong,
            tblkh48.TenKH,
            SUM(tblmh_dt48.DonGiaMH) AS tongTienHopDong
        FROM
            tblhopdong48
        INNER JOIN
            tblhopdong_mhdt48 ON tblhopdong48.ID = tblhopdong_mhdt48.tblHopDong48ID
        INNER JOIN
            tblmh_dt48 ON tblhopdong_mhdt48.tblMH_DT48ID = tblmh_dt48.ID
        INNER JOIN
        	tblkh48 ON tblkh48.id = tblhopdong48.tblKH48ID
        GROUP BY
            id_hopDong, tblkh48.TenKH
    ),
    MH_HopDong AS (
        SELECT
            tblmh_dt48.tblMH48ID,
            tblhopdong_mhdt48.tblHopDong48ID
        FROM
            tblmh_dt48
        INNER JOIN
            tblhopdong_mhdt48 ON tblmh_dt48.id = tblhopdong_mhdt48.tblMH_DT48ID
    )

SELECT
    TongTienHoaDon.idHopDong,
    TongTienHopDong.TenKH,
    TongTienHopDong.tongTienHopDong,
    (TongTienHoaDon.tongTienHoaDon*0.01) AS tongLaiThuDuoc,
    tongtienhoadon.ngayKi,
    MH_HopDong.tblMH48ID,
    MH_HopDong.tblHopDong48ID
FROM
    TongTienHoaDon
INNER JOIN
    TongTienHopDong ON TongTienHoaDon.idHopDong = TongTienHopDong.id_hopDong
INNER JOIN
    MH_HopDong ON TongTienHopDong.id_hopDong = MH_HopDong.tblHopDong48ID
WHERE tblmh48id =3;

--chi tiet hop dong theo id hop dong
SELECT tblhopdong48.ID AS IdHopDong,
tblkh48.TenKH,
tbldt48.TenDT,
tblmh48.TenMH,
tblmh_dt48.DonGiaMH,
tblmh_dt48.LaiSuat,
tblmh_dt48.soLuong,
(soLuong*donGiaMH) AS TongTien,
tblhoadonchokh48.*
FROM
tblhopdong48
INNER JOIN tblkh48 ON tblhopdong48.tblKH48ID = tblkh48.id
INNER JOIN tblhopdong_mhdt48 ON tblhopdong48.ID = tblhopdong_mhdt48.tblHopDong48ID
INNER JOIN tblmh_dt48 ON tblhopdong_mhdt48.tblMH_DT48ID = tblmh_dt48.id
INNER JOIN tbldt48 ON tblmh_dt48.tblDT48ID = tbldt48.ID
INNER JOIN tblmh48 ON tblmh_dt48.tblMH48ID = tblmh48.ID
INNER JOIN tblhoadonchokh48 ON tblHopDong48.ID = tblhoadonchokh48.tblHopDong48ID
WHERE tblhopdong48.ID =2;