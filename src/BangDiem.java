public class BangDiem {
    private SinhVien sinhVien;
    private MonHoc monHoc;
    private float diem;
    public BangDiem(SinhVien sinhVien, MonHoc monHoc, float diem) {
        if(diem < 0 || diem > 10){
            throw new IllegalArgumentException("Điểm phải nằm trong khoảng từ 0 đến 10!!");
        }
        this.sinhVien = sinhVien;
        this.monHoc=monHoc;
        this.diem=diem;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public float getDiem() {
        return diem;
    }

    @Override
    public String toString() {
        return "Tên sinh viên:"+sinhVien.getHoTen()+" -Môn học:"+monHoc.getTenMon()+" diem:"+diem;
    }
}
