public class MonHoc {
    private static int nextId =100;
    private int maMon;
    private String tenMon;
    private int soDVHT;
    private String loaiMon;

    public MonHoc( String tenMon, int soDVHT, String loaiMon) {
        this.maMon=nextId++;
        this.tenMon = tenMon;
        this.soDVHT = soDVHT;
        this.loaiMon = loaiMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getSoDVHT() {
        return soDVHT;
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public void setSoDVHT(int soDVHT) {
        this.soDVHT = soDVHT;
    }

    public String getLoaiMon() {
        return loaiMon;
    }

    public void setLoaiMon(String loaiMon) {
        this.loaiMon = loaiMon;
    }

    @Override
    public String toString() {
        return "Mã môn học:" + maMon+ " -Tên môn:"+tenMon+" -Số đơn vị học trình:"+soDVHT+" -Loại môn:"+loaiMon;
    }
}
