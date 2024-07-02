import javafx.util.Pair;

import java.util.*;

public class runMain {
    static Stack<MenhDe> THOA = new Stack<>();
    static List<MenhDe> listV;
    static List<MenhDe> listRes;
    static Map<MenhDe, Pair<MenhDe, MenhDe>> map = new HashMap<>();
    static boolean flag = false;
    public static List<MenhDe> createMD(){
        MenhDe md1 = new MenhDe("!E v F");
//        MenhDe md1 = new MenhDe("P");
        MenhDe md2 = new MenhDe("!A v !B v C");
        MenhDe md3 = new MenhDe("!B v D");
        MenhDe md4 = new MenhDe("!C v !D v E");
        MenhDe md5 = new MenhDe("A");
        MenhDe md6 = new MenhDe("B");
        List<MenhDe> list = new ArrayList<>();
        list.add(md1);
        list.add(md2);
        list.add(md3);
        list.add(md4);
        list.add(md5);
        list.add(md6);
        return list;
    }
    public static int findIndexMD(MenhDe u, BieuThuc v){
        for (int i = 0; i < u.getMenhDe().size(); i++) {
            if(u.getMenhDe().get(i).getBt().equals(v.getBt()) && u.getMenhDe().get(i).isPhu()!= v.isPhu() )
                return i;
        }
        return -1;
    }
    public static MenhDe delete(MenhDe u, MenhDe v){
        flag = false;
        for (int i = 0; i< v.getMenhDe().size(); i++){
            BieuThuc b = v.getMenhDe().get(i);
            int index = findIndexMD(u,b);
            if( index > -1){
                flag = true;
                u.deleteBT(index);
            }
            else {
                u.getMenhDe().add(b);
            }

        }
        return u;
    }
    public static boolean res(MenhDe u, MenhDe v){
        Pair<MenhDe, MenhDe> p =  new Pair<>(new MenhDe(u), v);
        MenhDe kq = delete(u,v);
        if(kq.getMenhDe().size() == 0){
            map.put(new MenhDe(), p);
            listV.add(v);
            return true;
        }
        if(flag && map.get(kq) == null) {
            map.put(kq, p);
            THOA.add(kq);
            listV.add(v);
            listRes.add(kq);
        }
        return false;
    }

    public static void main(String[] args) {
        List<MenhDe> listMD = createMD();

        BieuThuc MDCM = new BieuThuc("F", false);


        THOA.add(new MenhDe(new BieuThuc(MDCM.getBt(), !MDCM.isPhu())));

        System.out.printf("%15s%30s%40s%50s\n", "u |", "v |", "res(u,v) |", "THOA |");
        System.out.printf("%15s%30s%40s%50s\n", "|", "|", "|", new BieuThuc(MDCM.getBt(), !MDCM.isPhu())+" |");

        while (!THOA.isEmpty()){

            MenhDe u = THOA.pop();
            listV = new ArrayList<>();
            listRes = new ArrayList<>();

            System.out.printf("%15s", u+"|");
            for(MenhDe md : listMD){
                if(res(new MenhDe(u), md)){
//                    System.out.printf("%30s%40s%50s\n", "|", "|", "|");
                    System.out.printf("%30s%40s%50s\n",printV()+"|",printRes()+ "|", printTHOA()+"|");
                    System.out.println("Mệnh đề "+ MDCM +" là hệ quả của logic");
                    show(u);
                    return;
                }
            }
            System.out.printf("%30s%40s%50s\n",printV()+"|",printRes()+ "|", printTHOA()+"|");
        }
        System.out.println("Mệnh đề "+MDCM+" không là hệ quả của logic");
    }

    private static void show(MenhDe u) {
        System.out.print("("+ map.get(new MenhDe()).getKey() +", " + map.get(new MenhDe()).getValue() + ")");
        u = map.get(new MenhDe()).getKey();
        while (map.get(u) != null){
            System.out.print(" <- ");
            System.out.print("("+ map.get(u).getKey() +", " + map.get(u).getValue() + ")");
            u = map.get(u).getKey();
        }
        System.out.println();
    }

    private static String printV() {
        String s = "";
        for (MenhDe md : listV){
            s += md + ", ";
        }
        return s;
    }
    private static String printRes() {
        String s = "";
        for (MenhDe md : listRes){
            s += md + ", ";
        }
        return s;
    }
    private static String printTHOA(){
        Stack<MenhDe> stack = new Stack<>();
        int i = 0;
        String res = "";
       while (i < THOA.size()){
           i++;
           MenhDe bt = THOA.peek();
           stack.add(THOA.pop());
           res += bt + ", ";
       }
        THOA = stack;
       return res;
    }
}
