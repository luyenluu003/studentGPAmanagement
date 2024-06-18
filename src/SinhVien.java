public class SinhVien {
    private static int nextId =10000;
    private int maSV;
    private String hoTen;
    private String diaChi;
    private String SDT;
    private String lop;

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public SinhVien(String hoTen, String diaChi, String SDT, String lop) {
        this.maSV=nextId++;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.lop = lop;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    @Override
    public String toString() {
        return "Mã sinh viên:"+ maSV+" -Họ tên:"+hoTen+" -Địa chỉ:"+diaChi+" -Số điện thoại:"+SDT+" -Lớp:"+lop;
    }
}
