SELECT tbldongmh48.DongMH as dongMH,
COUNT(select tblhoadonchokh48.ID where tblhoadonchokh48.ID = tbldongmh48.ID) as soLuong