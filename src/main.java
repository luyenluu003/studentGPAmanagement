import java.io.*;
import java.util.Scanner;

public class main {

    private static SinhVien[] sinhViens =new SinhVien[100];
    private static int soLuongSinhVien = 0;
    private static MonHoc[] monHocs= new MonHoc[100];
    private static int soLuongMonHoc = 0;
    private static BangDiem[] bangDiems = new BangDiem[100];
    private static int soLuongBangDiem = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("\nTeacher Salary Mangement");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị sinh viên");
            System.out.println("3. Thêm môn học");
            System.out.println("4. Hiển thị môn học");
            System.out.println("5. Lập bảng điểm");
            System.out.println("6. Hiển thị bảng điểm");
            System.out.println("7. Sắp xếp bảng điểm theo họ tên sinh viên");
            System.out.println("8. Sắp xếp theo tên môn học");
            System.out.println("9. Tính điểm tổng kết");
            System.out.println("10. Lưu vào file");
            System.out.println("0. Thoát...");
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    themSinhVien();
                    pause();
                    break;
                case 2:
                    hienThiSinhVien();
                    pause();
                    break;
                case 3:
                    themMonHoc();
                    pause();
                    break;
                case 4:
                    hienThiMonHoc();
                    pause();
                    break;
                case 5:
                    nhapBangDiem();
                    pause();
                    break;
                case 6:
                    hienThiBangDiem();
                    pause();
                    break;
                case 7:
                    sapXepTheoTen();
                    pause();
                    break;
                case 8:
                    sapXepTheoTenMonHoc();
                    pause();
                    break;
                case 9:
                    tinhDiemTongKet();
                    pause();
                    break;
                case 10:
                    luuDanhSachSinhVien();
                    luuDanhSachMonHoc();
                    luuDanhSachBangDiem();
                    pause();
                    break;
                case 0:
                    System.out.println("Thoátttttt...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ vui lòng thử lại.");
            }
        } while (choice != 0);

        sc.close();
    }

    private static void themSinhVien(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên bạn muốn thêm:");
        int n= sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.println("Nhập sinh viên thứ "+(i+1)+":");
            System.out.print("Nhập tên sinh viên:");
            String hoTen = sc.nextLine();
            System.out.print("Nhập địa chỉ:");
            String diaChi = sc.nextLine();
            System.out.print("Nhập số điện thoại:");
            String SDT = sc.nextLine();
            System.out.print("Nhập lớp:");
            String lop = sc.nextLine();

            SinhVien newSinhVien= new SinhVien(hoTen,diaChi,SDT,lop);
            sinhViens[soLuongSinhVien++]=newSinhVien;

        }
    }

    private static void themMonHoc(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng môn học bạn muốn thêm:");
        int n= sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.println("Nhập môn học thứ "+(i+1)+":");
            System.out.print("Nhập tên môn học:");
            String tenMon = sc.nextLine();
            System.out.print("Nhập số đơn vị học trình:");
            int soDVHT = sc.nextInt();
            sc.nextLine();
            System.out.print("Lựa chọn loại môn theo số (1. Đại cương, 2. Cơ sở ngành, 3. Chuyên ngành): ");
            int check =sc.nextInt();
            sc.nextLine();
            String loaiMon="";
            switch (check){
                case 1:
                    loaiMon = "Đại cương";
                    break;
                case 2:
                    loaiMon = "Cơ sở ngành";
                    break;
                case 3:
                    loaiMon = "Chuyên ngành";
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ nên lựa chọn mặc định là 'Đại cương'.");
                    loaiMon = "Đại cương";
            }
            MonHoc newMonHoc= new MonHoc(tenMon,soDVHT,loaiMon);
            monHocs[soLuongMonHoc++]=newMonHoc;
        }
    }

    private static void hienThiSinhVien(){
        System.out.println("Danh sách sinh viên:");
        for(int i=0;i<soLuongSinhVien;i++){
            System.out.println(sinhViens[i]);
        }
    }

    private static void hienThiMonHoc(){
        System.out.println("Danh sách môn học:");
        for(int i=0;i<soLuongMonHoc;i++){
            System.out.println(monHocs[i]);
        }
    }

    private static void nhapBangDiem(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào mã sinh viên:");
        int id = sc.nextInt();
        sc.nextLine();
        SinhVien sinhVien =timKiemSinhVien(id);
        if(sinhVien==null){
            System.out.print("Không tìm thấy sinh viên.");
            return;
        }

        System.out.print("Nhập vào mã môn học:");
        int idMonHoc = sc.nextInt();
        sc.nextLine();
        MonHoc monHoc = timKiemMonHoc(idMonHoc);
        if(monHoc==null){
            System.out.print("Không tìm thấy môn học.");
            return;
        }

        for (int i = 0; i < soLuongBangDiem; i++) {
            if (bangDiems[i].getSinhVien().getMaSV() == sinhVien.getMaSV() && bangDiems[i].getMonHoc().getMaMon() == monHoc.getMaMon()) {
                System.out.println("Sinh viên đã có điểm cho môn học này.");
                return;
            }
        }

        System.out.print("Nhập điểm của môn học:");
        float diem = sc.nextFloat();
        sc.nextLine();

        BangDiem newBangDiem = new BangDiem(sinhVien,monHoc,diem);
        bangDiems[soLuongBangDiem++]=newBangDiem;

    }

    private static void hienThiBangDiem(){
        System.out.println("Dánh sách bảng điểm:");
        for(int i=0;i<soLuongBangDiem;i++){
            System.out.println(bangDiems[i]);
        }
    }

    private static void sapXepTheoTen(){
        if (soLuongBangDiem <= 1) {
            System.out.println("Không có hoặc chỉ có một bản ghi, không cần sắp xếp.");
            return;
        }
        for(int i=0;i<soLuongBangDiem-1;i++){
            for(int j=i+1;j<soLuongBangDiem;j++){

                if(bangDiems[i].getSinhVien().getHoTen().compareTo(bangDiems[j].getSinhVien().getHoTen())>0){
                    BangDiem temp = bangDiems[i];
                    bangDiems[i]=bangDiems[j];
                    bangDiems[j]=temp;
                }
            }

        }
        hienThiBangDiem();

    }

    private static void sapXepTheoTenMonHoc(){
        if (soLuongBangDiem <= 1) {
            System.out.println("Không có hoặc chỉ có một bản ghi, không cần sắp xếp.");
            return;
        }
        for(int i=0;i<soLuongBangDiem-1;i++){
            for(int j=i+1;j<soLuongBangDiem;j++){

                if(bangDiems[i].getMonHoc().getTenMon().compareTo(bangDiems[j].getMonHoc().getTenMon())>0){
                    BangDiem temp = bangDiems[i];
                    bangDiems[i]=bangDiems[j];
                    bangDiems[j]=temp;
                }
            }
        }
        hienThiBangDiem();

    }

    private static void tinhDiemTongKet() {
        for (int i = 0; i < soLuongSinhVien; i++) {
            SinhVien sv = sinhViens[i];
            float tongDiem = 0;
            int tongSoDVHT = 0;
            for (int j = 0; j < soLuongBangDiem; j++) {
                if (bangDiems[j].getSinhVien() == sv) {
                    tongDiem += bangDiems[j].getDiem() * bangDiems[j].getMonHoc().getSoDVHT();
                    tongSoDVHT += bangDiems[j].getMonHoc().getSoDVHT();
                }
            }
            float diemTB = tongSoDVHT == 0 ? 0 : tongDiem / tongSoDVHT;

            System.out.println("Sinh viên:"+sv.getHoTen()+" -Điểm trung bình:"+diemTB);

        }
    }

    private static SinhVien timKiemSinhVien(int findId){
        for(int i=0;i<soLuongSinhVien;i++){
            if(sinhViens[i].getMaSV()==findId){
                return sinhViens[i];
            }
        }
        return null;
    }

    private static MonHoc timKiemMonHoc(int findId){
        for(int i=0;i<soLuongMonHoc;i++){
            if(monHocs[i].getMaMon()==findId){
                return monHocs[i];
            }
        }
        return null;
    }

    private static void luuDanhSachSinhVien(){
        try (FileOutputStream fos = new FileOutputStream("sinhvien.txt");
             OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
             BufferedWriter bw = new BufferedWriter(osw)) {

            for (int i = 0; i < soLuongSinhVien; i++) {
                SinhVien sv = sinhViens[i];
                String line = "Mã sinh viên:"+sv.getMaSV()+" -Họ tên:"+ sv.getHoTen()+" -Địa chỉ:"+sv.getDiaChi()+" -SDT:"+ sv.getSDT()+" -Lớp:"+ sv.getLop();
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Danh sách sinh viên đã được lưu vào file.");

        } catch (IOException e) {
            System.out.println("Lỗi khi lưu danh sách sinh viên: " + e.getMessage());
        }
    }

    private static void luuDanhSachMonHoc(){
        try (FileOutputStream fos = new FileOutputStream("monhoc.txt");
             OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
             BufferedWriter bw = new BufferedWriter(osw)) {

            for (int i = 0; i < soLuongMonHoc; i++) {
                MonHoc mh = monHocs[i];
                String line = "Mã môn học:"+mh.getMaMon()+" -Tên môn:"+ mh.getTenMon()+" -Số đơn vị học trình:"+mh.getSoDVHT()+" -Loại môn:"+ mh.getLoaiMon();
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Danh sách môn học đã được lưu vào file.");

        } catch (IOException e) {
            System.out.println("Lỗi khi lưu danh sách môn học: " + e.getMessage());
        }
    }

    private static void luuDanhSachBangDiem(){
        try (FileOutputStream fos = new FileOutputStream("bangdiem.txt");
             OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
             BufferedWriter bw = new BufferedWriter(osw)) {

            for (int i = 0; i < soLuongBangDiem; i++) {
                BangDiem bd = bangDiems[i];
                String line = "Tên sinh viên:"+bd.getSinhVien().getHoTen()+" -Môn học:"+ bd.getMonHoc().getTenMon()+" -Điểm:"+bd.getDiem();
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Danh sách bảng điểm đã được lưu vào file.");

        } catch (IOException e) {
            System.out.println("Lỗi khi lưu danh sách bảng điểm: " + e.getMessage());
        }
    }



    public static void pause() {
        System.out.println("Nhấn phím Enter để tiếp tục...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
